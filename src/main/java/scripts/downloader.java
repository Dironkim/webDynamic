package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class downloader extends Script{
    Pattern pattern;
    public downloader(WebDriver driver) {
        super(driver);
        String regex = "[\\\\/:*?\"<>|]";
        pattern = Pattern.compile(regex);

    }
    public void downloadImages(String query, int maxImagesAmount) throws InterruptedException{
        driver.get("https://yandex.ru/images/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[1]/form/div[1]/span/span/input")).sendKeys(query);
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[1]/form/div[2]/button")).click();

        for (int i=0;i<2;i++) {
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15000));
            Thread.sleep(1500);
            ((JavascriptExecutor) driver)
                    .executeScript("window.scrollTo(0, document.body.scrollHeight)");
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(25000));
        }
        List<WebElement> imgEls=driver.findElements(By.cssSelector("img.SimpleImage-Image.SimpleImage-Image_clickable"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(12000));
        int count = 0;
        while(count < maxImagesAmount) {
            for (WebElement image : imgEls) {
                try {
                    downloadImage(new URI(image.getAttribute("src")).toURL(), Path.of("src/test/resources"));
                    count++;
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
     void downloadImage(URL imageURL, Path path) throws IOException {
        String urlString = imageURL.toString();
        Matcher matcher = pattern.matcher(urlString.substring(urlString.lastIndexOf("/")));
        // Замените запрещенные символы на пустую строку
        String result = matcher.replaceAll("");
        InputStream in = imageURL.openConnection().getInputStream();
        Files.copy(in, Paths.get(path + result), StandardCopyOption.REPLACE_EXISTING);
    }
}
