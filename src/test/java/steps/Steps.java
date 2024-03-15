package steps;

import com.codeborne.selenide.*;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.То;
import org.junit.Assert;
import page.Page;
import runners.RunnerTest;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class Steps {

    private final Map<String, String> pages = new HashMap<String, String>() {{
        put("Add Customer", "manager/addCust");
        put("Open Account", "manager/openAccount");
        put("Customers", "manager/list");
    }};

    private final Page thisPage = new Page();

    @Когда("^Пользователь открывает стартовую страницу приложения 'XYZ Bank'$")
    public void открываетСтартовуюСтраницуБанка() {
        open(RunnerTest.URL + "login");
    }

    @И("^Пользователь на странице  нажимает кнопку \"([^\"]*)\"$")
    public void пользовательНаСтраницеНажимаетКнопку(String btn) {
        thisPage.btn(btn).click();
    }

    @То("^Система открывает страницу приложения \"([^\"]*)\"$")
    public void системаОткрываетСтраницуПриложения(String page) {
        webdriver().shouldHave(WebDriverConditions.urlContaining(pages.get(page)));
    }

    @Когда("^Пользователь на странице заполняет параметр \"([^\"]*)\" типа \"([^\"]*)\" значением \"([^\"]*)\"$")
    public void пользовательНаСтраницеЗаполняетПараметрТипаЗначением(String name, String type, String value) {
        if (type.equals("поле ввода")) {
            thisPage.fieldByPlaceholder(name).setValue(value).shouldHave(Condition.value(value));
        } else {
            throw new RuntimeException("Unexpected type : " + type);
        }
    }

    @И("Пользователь в стандартном браузерном окне 'Подтвердите действие' нажимает кнопку 'ОК'")
    public void пользовательВСтандартномБраузерномОкнеПодтвердитеДействиеНажимаетКнопкуОК() {
        switchTo().alert().accept();
    }

    @И("^Пользователь на странице нажимает подтверждающую кнопку \"([^\"]*)\"$")
    public void пользовательНаСтраницеНажимаетПодтверждающуюКнопку(String btn) {
        thisPage.submitBtn(btn).click();
    }

    @И("Система в таблице отображает строку со значением \"([^\"]*)\" в столбце \"([^\"]*)\"$")
    public void системаВТаблицеОтображаетСтрокуСоЗначениемВСтолбце(String expectedValue, String columnName) {
        int column = getColumnIndex(columnName);
        int size = thisPage.rows().size();
        for (int i = 1; i <= size; i++) {
            String value = thisPage.cell(i, column).getText();
            if (value.equals(expectedValue)) {
                return;
            }
        }
        throw new RuntimeException("В таблице в столбце '" + columnName + "' отсутствует значение '" + expectedValue + "'");
    }

    private int getColumnIndex(String column) {
        ElementsCollection collection = thisPage.columns();
        for (SelenideElement element : collection) {
            if (element.getText().equals(column)) {
                return collection.indexOf(element) + 1;
            }
        }
        throw new RuntimeException("В таблице отсутствует столбец : " + column);
    }
}
