package scripts;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

public class cdsVyatka extends Script{
    public cdsVyatka(WebDriver driver) {
        super(driver);
    }

    public void printBusStopNames() {
        driver.get("https://m.cdsvyatka.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement marshList = driver.findElement(By.name("marshlist"));
        Select select = new Select(marshList);
        select.selectByVisibleText(choiceResult(select));

        WebElement findButton = driver.findElement(By.xpath("/html/body/font/font/font/font/font/form/font/div[5]/form/input"));
        findButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        driver.findElements(By.tagName("a")).forEach(elem -> System.out.println(elem.getText()));
    }
    private String choiceResult(Select select){
        List<WebElement> optionList = select.getOptions();
        System.out.println("Список опций в выпадающем списке:");
        for (WebElement option : optionList) {
            System.out.println(option.getText());
        }
        String searchString="";
        boolean success=false;
        while (!success){
            System.out.print("Введите название маршрута из списка: ");
            Scanner scanner = new Scanner(System.in);
            searchString = scanner.nextLine();
            for (WebElement option : optionList) {
                if (option.getText().equalsIgnoreCase(searchString)) {
                    success = true;
                    break;
                }
            }
        }
        return searchString;
    }
}