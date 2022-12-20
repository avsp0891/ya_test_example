import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Test {



//    public static void main(String[] args) {
//        test();
//    }

@org.junit.Test
    void test(){
        Selenide.open("https://ya.ru/");//открыть браузер и перейти по ссылке

        Selenide.$(By.id("text")).shouldBe(Condition.visible);// проверка того, что поле ввода видимое

        Selenide.$(By.id("text")).sendKeys("ОЦРВ"); //ввод текста "ОЦРВ" в поле ввода

        Selenide.$(By.id("text")).sendKeys(Keys.ENTER); //ввод в поле ввода клавиши enter

        Selenide.$x("//*[text()='ОЦРВ']").shouldBe(Condition.exist);// проверка того, что на странице присутствует элемент с текстом "ОЦРВ"

        Selenide.closeWebDriver();//закрытие веб драйвера

    }



}
