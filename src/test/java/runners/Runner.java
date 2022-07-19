package runners;

import com.codeborne.selenide.Configuration;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import java.util.HashMap;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "junit:target/junit.xml",
                "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
                "html:cucumber-report/report"
        },
        features = {"src/test/java/feature/"},
        glue = {"steps"},
        tags = "@auth and not @skip",
        stepNotifications = true
)

public class Runner {
    public static final String url = "http://stage.dkre.ocrv.com.rzd/";
    public static final int TIMEOUT = 4;
    public static final String testDataPath = "res/docs/";

    public static final HashMap<String, String> credentials = new HashMap<String, String>() {
        {
            put("ppp1", "ppp1");
        }
    };


    @BeforeClass
    static public void setup() {
        Configuration.timeout = TIMEOUT * 1000;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "Chrome";
    }



}

