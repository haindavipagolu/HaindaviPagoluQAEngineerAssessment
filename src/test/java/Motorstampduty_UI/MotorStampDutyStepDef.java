package Motorstampduty_UI;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.time.Duration;

public class MotorStampDutyStepDef {
    @Given("User clicks onto motor stamp duty URL {string}")
    public void iGoOntoMotorStampDuty(String URL) {
        System.setProperty("webdriver.edge.driver", "C:/Users/PAGOLUH/.cache/selenium/msedgedriver/win64/141.0.3537.99/msedgedriver.exe");
        open(URL);
    }

    @When("User clicked on Check online button")
    public void iClickCheckOnline() {
        $(byXpath("//a[normalize-space()='Check online']")).click();
    }

    @When("Validate if Motor vehicle registration duty calculator page appears")
    public void validateMotorVehicleRegistrationPage() {
        $(byXpath("//button[normalize-space()='Calculate']")).should(Condition.visible, Duration.ofSeconds(15));
    }

    @When("User clicked on Radio button Yes for the question Is this registration for a passenger vehicle?")
    public void iClickYes() {
        $(byXpath("//label[normalize-space()='Yes']")).click();
    }

    @When("User entered the Purchase price or value as {string}")
    public void iEnterPurchasePrice(String price) {
        $(byXpath("//input[@id='purchasePrice']")).setValue(price);
    }

    @When("User clicked on Calculate button")
    public void iClickCalculate() {
        $(byXpath("//button[normalize-space()='Calculate']")).pressEnter();
    }

    @Then("Validate the {string} and {int} in the calculation page")
    public void validateCalculationPage(String isPassengerVehicle, int price) {
        $(".modal.show").should(Condition.visible, Duration.ofSeconds(15));
        $(byXpath("//td[normalize-space()='Details entered:']")).should(Condition.visible, Duration.ofSeconds(15));
        String isPassengerVehicleEntered = $(byXpath("//td[normalize-space()='Yes']")).getText();
        Assert.assertEquals(isPassengerVehicle, isPassengerVehicleEntered);
        String priceEntered = $(byXpath("//td[normalize-space()='$45,000.00']")).getText();
        int priceEnteredConvert = (int) Double.parseDouble(priceEntered.replaceAll("[$,]", ""));
        Assert.assertEquals(price, priceEnteredConvert);
    }

    @Then("User clicked on Close button")
    public void iClickClose() {
        $(byXpath("//button[normalize-space()='Close']")).click();
        switchTo().window(0);
        $(byXpath("//td[normalize-space()='Details entered:']")).should(Condition.visible, Duration.ofSeconds(15));
    }
}
