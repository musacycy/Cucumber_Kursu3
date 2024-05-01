package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

public class _02_CountrySteps {
    LeftNav ln= new LeftNav();
    DialogContent dc=new DialogContent();
    @And("Navigate to country page")
    public void navigateToCountryPage() {
        ln.findAndClick("setupOne");
        ln.findAndClick("parameters");
        ln.findAndClick("Countries");

    }

    @When("Create a country")
    public void createACountry() {
        String randomGenerateName= RandomStringUtils.randomAlphabetic(8);
        String randomGenerateCode= RandomStringUtils.randomNumeric(4);

        dc.findAndClick("createCountry");
        dc.findAndSend("nameInput",randomGenerateName);
        dc.findAndSend("Code",randomGenerateCode);
        dc.findAndClick("SaveButton");

    }

    @Then("Success Message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.findAndContainsText("successMessage","successfully");

    }

    @When("Create a country name as {string} code as {string}")
    public void createACountryNameAsCodeAs(String name, String code) {
        dc.findAndClick("createCountry");
        dc.findAndSend("nameInput",name);
        dc.findAndSend("Code",code);
        dc.findAndClick("SaveButton");


    }
}
