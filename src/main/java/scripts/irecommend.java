package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class irecommend extends Script{
    public irecommend(WebDriver driver) {
        super(driver);
    }
    public void register(String name, String password, String email) throws InterruptedException {
        driver.get("https://irecommend.ru/");
            Thread.sleep(500);
            driver.findElement(By.linkText("Войти")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
            driver.findElement(By.linkText("Регистрация")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
            driver.findElement(By.name("name")).sendKeys(name);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
            driver.findElement(By.name("mail")).sendKeys(email);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
            driver.findElement(By.id("edit-pass-pass1")).sendKeys(password);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
            driver.findElement(By.id("edit-pass-pass2")).sendKeys(password);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
            driver.findElement(By.xpath("//*[@id=\"edit-reg-policy\"]")).click();
            Thread.sleep(500);
            //CAPTCHA
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
//driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();
            driver.findElement(By.xpath("//*[@id=\"edit-submit\"]")).click();

    }
}
