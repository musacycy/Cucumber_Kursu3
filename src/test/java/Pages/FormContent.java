package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormContent extends Parent {

    public FormContent(){
        PageFactory.initElements(GWD.getDriver(),this);
    }
    @FindBy(xpath="//mat-label[contains(text(),'Academic Period')]")
    private WebElement academicPeriod;

    @FindBy(xpath="//mat-option[contains(@id,'mat-option')][1]")
    private WebElement academicPeriod1;
    @FindBy(xpath="//mat-form-field[2]")
    private WebElement gradeLevel;
    @FindBy(xpath="//mat-option[contains(@id,'mat-option')][5]")
    private WebElement gradeLevel2;
    @FindBy(xpath="//span[(text()='Save')]")
    private WebElement saveButton;


    WebElement myElement;

    public void findAndClick(String strElement) {
        switch (strElement) {

            case "academicPeriod"->
                myElement = academicPeriod;

            case "academicPeriod1"->
                myElement = academicPeriod1;

            case "gradeLevel"->
                myElement = gradeLevel;

            case "gradeLevel2"->
                myElement = gradeLevel2;

            case "saveButton"->
                myElement = saveButton;

        }
        clickFunction(myElement);


    }

}

