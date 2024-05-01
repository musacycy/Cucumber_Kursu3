package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends Parent{

    public LeftNav(){
        PageFactory.initElements(GWD.getDriver(),this);
    }
    @FindBy(xpath = "//span[text()='Setup']")
    public WebElement setupOne;
    @FindBy(xpath = "//span[text()='Parameters']")
    public  WebElement parameters;
    @FindBy(xpath = "//span[text()='Countries']")
    public  WebElement Countries;
    @FindBy(xpath = "//span[text()='Citizenships']")
    public  WebElement Citizenship;
    @FindBy(xpath = "//span[text()='Nationalities']")
    public  WebElement nationality;
    @FindBy(xpath = "//span[text()='Fees']")
    public  WebElement Fees;
    @FindBy(xpath = "(//span[text()='Setup'])[2]")
    public  WebElement setupTwo;
    @FindBy(xpath = "(//span[text()='Entrance Exams'])[1]")
    public WebElement entranceExam;
    @FindBy(xpath = "(//span[text()='Entrance Exams'])[2]")
    public WebElement entranceExam2;





    WebElement myElement;
    public void findAndClick(String strElement) {
        switch (strElement) {


            case "setupOne":myElement=setupOne;break;
            case "parameters":myElement=parameters;break;
            case "Countries":myElement=Countries;break;
            case "Citizenship":myElement=Citizenship;break;
            case "nationality":myElement=nationality;break;
            case "Fees":myElement=Fees;break;
            case "entranceExam":myElement=entranceExam;break;
            case "setupTwo":myElement=setupTwo;break;
            case "entranceExam2":myElement=entranceExam2;break;



        }
        clickFunction(myElement);

    }


}
