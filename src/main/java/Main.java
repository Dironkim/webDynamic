import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import scripts.cdsVyatka;
import scripts.otzyv;


import java.time.Duration;
public class Main {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        WebDriver driver = new ChromeDriver(options);


        otzyv otz = new otzyv(driver);
        otz.findTopics();



        System.exit(0);
    }
}
