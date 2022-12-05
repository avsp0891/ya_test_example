package steps;


import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Когда;
import org.openqa.selenium.Keys;
import page.YandexPage;
import runners.RunnerTest;

import static com.codeborne.selenide.Selenide.open;


public class YandexSteps {
    private final YandexPage thisPage = new YandexPage();

   @Когда("Пользователь открывает страницу 'ya.ru'$")
   public void открываетСтраницуЯндекс() {
      open(RunnerTest.URL);
   }

    @Когда("Система отображает поле ввода поискового запроса$")
    public void отображаетПолеВводаПоисковогоЗапроса() {
        thisPage.inputSearch.shouldBe(Condition.exist);
    }

    @Когда("Пользователь вводит в поле ввода поискового запроса значение \"([^\"]*)\"$")
    public void вводитВПолеВВодаПоисковогоЗапросаЗначение(String value) {
       thisPage.inputSearch.sendKeys(value);
       thisPage.inputSearch.shouldHave(Condition.value(value));
    }

   @Когда("Пользователь нажимает в поле ввода поискового запроса клавишу 'Enter'$")
   public void нажимаетВПолеВВодаПоисковогоЗапросаКлавишуEnter() {
      thisPage.inputSearch.sendKeys(Keys.ENTER);
   }

   @Когда("Система отображает элемент с текстом \"([^\"]*)\"$")
   public void отображаетЭлементСТекстом(String text) {
      thisPage.elementText(text).shouldBe(Condition.appear);
   }
}
