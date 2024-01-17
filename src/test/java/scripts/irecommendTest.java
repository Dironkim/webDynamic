package scripts;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

class irecommendTest {
    ChromeDriver driver;
    irecommendTest(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
    }
    @Test
    void register() throws InterruptedException {
        irecommend irc = new irecommend(driver);
        irc.register("Kremlebot_01010","1g#gd#=DGHs35","existent-email45@gmail.com");
    }
}