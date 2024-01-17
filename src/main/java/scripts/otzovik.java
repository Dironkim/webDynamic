package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class otzovik extends Script{
    otzovik(ChromeDriver driver){
        super(driver);
    }
    public void writeReview(String subject, String title, String review, String pros, String cons) {
        driver.get("https://otzovik.ru/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2500));

        //search by title
        driver.findElement(By.xpath("//*[@id=\"header-search-input\"]")).sendKeys(subject);
        //choose 1st popup suggestion
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div[1]/form/div[2]/a[1]")).click();
        //click "add a review"
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div[1]/div[2]/div[5]/a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
        //click 5th star
        //WebElement temp = driver.findElement(By.xpath("//*[@id='review_post']/div[1]/div[1]/div[2]/div[2]"));
        List<WebElement> temp2= driver.findElements(By.xpath("//*[@id='review_post']/div[1]/div[1]/div[2]/div[2]//*"));
        //driver.findElement(By.xpath("//*[@id=\"review_post\"]/div[1]/div[1]/div[2]/div[2]/svg[5]")).click();
        List<String> elementTags = new ArrayList<>();
        for (WebElement element : temp2) {
            if (Objects.equals(element.getAttribute("data-value"), "5"))
            element.click();
        }



        //write review title
        driver.findElement(By.xpath("//*[@id=\"content_title\"]")).sendKeys(title);
        //write review
        driver.findElement(By.xpath("//*[@id=\"content_body_main\"]/div[2]/div[2]/div/textarea[2]")).sendKeys(review);
        //write pros
        driver.findElement(By.xpath("//*[@id=\"review_post\"]/div[4]/div[2]/textarea")).sendKeys(pros);
        //write cons
        driver.findElement(By.xpath("//*[@id=\"review_post\"]/div[5]/div[2]/textarea")).sendKeys(cons);
        //recommend
        driver.findElement(By.xpath("//*[@id=\"review_post\"]/div[6]/div[1]/div[2]/label[1]/span")).click();

        driver.findElement(By.xpath("//*[@id=\"previewbtn\"]")).click();

    }
}