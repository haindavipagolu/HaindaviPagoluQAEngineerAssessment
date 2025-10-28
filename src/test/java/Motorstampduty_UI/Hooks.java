package Motorstampduty_UI;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.TestConfig;
import static com.codeborne.selenide.Selenide.*;

public class Hooks {

    @Before("@MotorstampdutyFeature")
    public void setUp() {
        TestConfig.setup();
    }

    @After("@MotorstampdutyFeature")
    public void tearDown() {
        closeWebDriver();
    }
}
