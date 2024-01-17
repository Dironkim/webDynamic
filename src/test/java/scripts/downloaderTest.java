package scripts;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

class downloaderTest {
    ChromeDriver driver;
    downloaderTest(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
    }
    @Test
    void downloadImages() throws InterruptedException {
        downloader irc = new downloader(driver);
        irc.downloadImages("james gosling",20);
    }
}