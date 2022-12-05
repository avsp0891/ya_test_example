package runners;

import com.codeborne.selenide.Configuration;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "junit:target/junit.xml",
                "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
                "html:cucumber-report/report"
        },
        features = {"src/test/java/feature/"},
        glue = {"steps"},
        tags = "@test_1 and not @skip",
        stepNotifications = true
)

public class RunnerTest {
    public static final String URL = "https://ya.ru/";
    public static final int TIMEOUT = 4;

    @BeforeClass
    static public void setup() {
        Configuration.timeout = TIMEOUT * 1000;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "Chrome";
    }



}

