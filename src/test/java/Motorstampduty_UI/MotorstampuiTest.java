package Motorstampduty_UI;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Motorstampduty_UI",
        glue =  "Motorstampduty_UI",
        tags = "@MotorstampdutyFeature",
        monochrome = true,
        plugin = {"rerun:target/rerun.txt"})
public class MotorstampuiTest {}
