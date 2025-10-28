package Authors_API;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Authors_API",
        glue =  "Authors_API",
        tags = "@RunAuthorsAPI",
        monochrome = true)
public class AuthorsAPITest {}
