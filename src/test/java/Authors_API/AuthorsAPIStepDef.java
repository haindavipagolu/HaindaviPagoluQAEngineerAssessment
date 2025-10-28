package Authors_API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import Authors_API.AuthorsAPIPojo;
import org.junit.Assert;
import java.util.concurrent.TimeUnit;



public class AuthorsAPIStepDef {


    protected Response authorsResponse;
    protected AuthorsAPIPojo authorsAPIPojo;

    @Given("Invoked Get Authors operation from {string}")
    public void invokeGetAuthors(String uri) {

        // Get Authors restAssured Call
        RestAssured.baseURI = uri;
        RestAssured.useRelaxedHTTPSValidation();
        RequestSpecification request =
                RestAssured.given()
                        .log()
                        .all()
                        .header("Content-Type", "application/json")
                        .header("User-Agent", "PostmanRuntime/7.32.3")
                        .header("Accept", "*/*")
                        .header("Accept-Encoding", "gzip, deflate, br")
                        .header("Connection", "keep-alive");

        authorsResponse = request.get();
        System.out.println(authorsResponse.asString());
    }

    @When("Deserialise the API response to a pojo")
    public void deserialiseResponseToAPojo() {
        authorsAPIPojo = authorsResponse.getBody().as(new TypeRef<AuthorsAPIPojo>() {});
        System.out.println(
                    "Author Details: ");
        System.out.println("Personal_name: "
                            + authorsAPIPojo.getPersonal_name());
        System.out.println("Alternate_names: "
                            + authorsAPIPojo.getAlternate_names());

    }

    @Then("Validate api content")
    public void validateApiContent() {
        // Validate the Response Code
        System.out.println("Validate response code started");
        Assert.assertEquals("Validating Response Code", 200, authorsResponse.getStatusCode());
        System.out.println("Validate response code ended");

        // Validate the Response Time
        System.out.println("Validate response time started");
        if (authorsResponse.getTime() > TimeUnit.SECONDS.toMillis(8)) {
            Assert.fail("Validating response time is greater than 8 seconds");
        }
        System.out.println("Validate response time ended");

        // Content Validation
        System.out.println("Validate Personal name started");
        Assert.assertEquals("Validating Author's Personal Name", "Sachi Rautroy", authorsAPIPojo.getPersonal_name());
        System.out.println("Validate Personal name ended");
        System.out.println("Validate Alternate names started");

        Assert.assertTrue(
                "Author's alternate names should include 'Yugashrashta Sachi Routray'",
                authorsAPIPojo.getAlternate_names().contains("Yugashrashta Sachi Routray"));
        System.out.println("Validate Alternate names ended");

    }

}
