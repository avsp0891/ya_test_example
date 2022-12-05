package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class YandexPage {

    public SelenideElement inputSearch = $(By.id("text"));

    public SelenideElement elementText(String text) {
        return $x("//*[text()='" + text + "']");
    }
}
