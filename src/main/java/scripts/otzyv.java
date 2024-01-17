package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class otzyv extends Script{
    public otzyv(WebDriver driver) {
        super(driver);
    }

    public void findTopics() {
        driver.get("https://otzyv.ru/");
        //set dynamic response wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        //go to forums
        driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/div[2]/a[1]")).click();
        //search for "Россия"
        driver.findElement(By.xpath("//*[@id=\"s\"]")).sendKeys("Россия");
        //choose "Новый год" subforums
        new Select(driver.findElement(By.name("f"))).selectByVisibleText("Новый Год");
        //check to search for topics only
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/form/div[5]/div/label/input"))
                .click();
        //click "search"
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/form/div[8]/input")).click();

    }
}
