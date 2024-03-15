package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class Page {

    public SelenideElement btn(String btn){
//        return $x("//button[text()='" + btn + "']");
        return $x("//button[contains(text(),'" + btn + "')]");
    }

    public SelenideElement fieldByPlaceholder(String name){
        return $x("//input[@placeholder='" + name + "']");
    }

    public SelenideElement submitBtn(String btn){
        return $x("//button[contains(text(),'" + btn + "') and @type='submit']");
    }

    public ElementsCollection columns() {
        return $$x("//thead/tr/td");
    }

    public ElementsCollection rows() {
        return $$x("//tbody/tr");
    }

    public SelenideElement cell(int row, int column){
        return $x("//tbody/tr[" + row + "]/td[" + column + "]");
    }


}
