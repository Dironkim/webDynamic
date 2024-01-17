package scripts;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

class otzovikTest {
    ChromeDriver driver;
    otzovikTest(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
    }
    @Test
    void writeReview() {

        otzovik otk = new otzovik(driver);
        String subject = "Фильм \"Драйв\" (2011)";
        String title= "Драйв (2011): Погружение в эстетику и напряжение на максимуме";
        String contents = "Фильм \"Драйв\" – настоящий шедевр в мире кинематографа. Он не просто рассказывает историю, а влечет зрителя в захватывающий мир ночных гонок, криминальных интриг и страстных отношений. Режиссер Николас Виндинг Рефн смог создать уникальное произведение, в котором каждый кадр – настоящее произведение искусства.";
        String pros = "Эстетика и стиль: \"Драйв\" поражает своей стилизацией и визуальным насыщением. Каждый кадр кажется выдержанным в духе нуара, что придает фильму неповторимый характер.\n" +
                "Музыкальное сопровождение: Саундтрек фильма подчеркивает его атмосферу и эмоции. Композиции Cliff Martinez создают неповторимое настроение и дополняют визуальный опыт.\n" +
                "Актерская игра: Райан Гослинг великолепен в роли молчаливого водителя. Его харизматичная и многогранная игра придает главному герою особый шарм и загадочность.";
        String cons = "Медленное темпо: Некоторые зрители могут почувствовать, что фильм движется медленнее, чем они привыкли. Однако именно это медленное течение событий придает фильму глубину и атмосферность.\n" +
                "Насилие: Фильм содержит интенсивные сцены насилия, которые могут быть шокирующими для некоторых зрителей. Однако они необходимы для передачи криминальной сюжетной линии.";
        otk.writeReview(subject,title, contents, pros, cons);

    }
}