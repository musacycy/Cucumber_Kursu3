package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DialogContent extends Parent {

    public DialogContent(){

        PageFactory.initElements(GWD.getDriver(),this);
    }
    @FindBy(id="mat-input-0")
    private WebElement username;

    @FindBy(id="mat-input-1")
    private WebElement password;

    @FindBy(css="button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(css="a[class='nav-link ng-star-inserted']>span")
    public WebElement dashboard;
    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
            public WebElement createCountry;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    public WebElement nameInput;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    public WebElement Code;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']//input")
    public WebElement intCode;
    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']//input")
    public WebElement priority;
    @FindBy(xpath = "//label[contains(text(),'Active')]")
    public WebElement activateButton;



    @FindBy(xpath = "//ms-save-button[@class='ng-star-inserted']//button")
    public WebElement SaveButton;

    @FindBy(xpath="//div[contains(text(),'successfully')]")
            public WebElement successMessage;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
            public WebElement citizenName;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    public WebElement citizenShortName;
    @FindBy(xpath = "//button[@aria-label='Close dialog']")
    public WebElement closeDialog;
    @FindBy(xpath="//div[contains(text(),'already')]")
    public WebElement alreadyMessage;
    @FindBy(xpath="//ms-text-field[contains(@placeholder,'GENERAL.FIELD.NAME')]/input")
    public WebElement searchInput;

    @FindBy(xpath="//ms-search-button//button")
    public WebElement searchButton;

    @FindBy(xpath="//ms-delete-button//button")
    public WebElement deleteButton;

    @FindBy(xpath="//span[contains(text(),'Delete')]")
    public WebElement deleteButton2;

    WebElement myElement;
    public void findAndSend(String strElement,String value) {
        switch (strElement) {

            case "username":
                myElement = username;
                break;
            case "password":
                myElement = password;
                break;
            case "nameInput":myElement=nameInput;break;
            case "Code":myElement=Code;break;
            case "citizenNameInput":myElement=citizenName;break;
            case "citizenShortNameInput":myElement=citizenShortName;break;
            case "searchInput":myElement=searchInput;break;
            case "intCode":myElement=intCode;break;
            case "priority":myElement=priority;break;



        }
        sendKeysFunction(myElement, value);

    }
    public void findAndClick(String strElement) {
        switch (strElement) {

            case "loginButton":
                myElement = loginButton;

                break;
            case "createCountry":myElement=createCountry;break;
            case "SaveButton":myElement=SaveButton;break;

            case "createCitizenship":myElement=createCountry;break;
            case "closeButton":myElement=closeDialog;break;
            case "searchButton":myElement=searchButton;break;
            case "deleteButton":myElement=deleteButton;break;
            case "deleteButton2":myElement=deleteButton2;break;
            case "activateButton":myElement=activateButton;break;

        }
        clickFunction(myElement);

    }
    public void findAndContainsText(String strElement,String value){
        switch (strElement){
            case "dashboard":myElement=dashboard;break;
            case "successMessage":myElement=successMessage;break;
            case "alreadyExist":myElement=alreadyMessage;break;
        }
        confirmationFunction(myElement,value);
    }
    public void searchAndDelete(String searchText){
        //arama kutucuğuna kelimeyi yaz
        //arama butonuna bas
        //silme butonuna bas
        //dialogtaki silme butonuna bas

        findAndSend("searchInput",searchText);
        findAndClick("searchButton");
     //   Duration de=Duration.ofSeconds(10);
       // WebDriverWait wait=new WebDriverWait(GWD.getDriver(),Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.stalenessOf(deleteButton));
        //GWD.Bekle(3);
        waitUntilLoading();
        findAndClick("deleteButton");
        findAndClick("deleteButton2");
    }

}
