package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _04_CitizenshipSteps {
    LeftNav ln= new LeftNav();
    DialogContent dc =new DialogContent();
    @And("Navigate to Citizenship")
    public void navigateToCitizenship() {
        ln.findAndClick("setupOne");
        ln.findAndClick("parameters");
        ln.findAndClick("Citizenship");
    }



    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dc.findAndContainsText("alreadyExist","already exist");

    }

    @And("Click on close button")
    public void clickOnCloseButton() {
        dc.findAndClick("closeButton");
    }

    @When("User a Citizenship name as {string} shortname as {string}")
    public void userACitizenshipNameAsShortnameAs(String name, String shortname) {
        dc.findAndClick("createCitizenship");
        dc.findAndSend("citizenNameInput",name);
        dc.findAndSend("citizenShortNameInput",shortname);
        dc.findAndClick("SaveButton");

    }

    @When("User delete the {string}")
    public void userDeleteThe(String arananKelime) {
        dc.searchAndDelete(arananKelime);
    }
}
