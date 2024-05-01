package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Parent {
    public void sendKeysFunction(WebElement element, String value){
        waitUntilVisible(element);//gözükene kadar bekle

        scrollToElement(element);//elemente scroll yap
        element.clear();//temizle
        element.sendKeys(value);//değeri gönder

    }
    public void waitUntilVisible(WebElement element){
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitUntilClickable(WebElement element){
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void scrollToElement(WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    public void clickFunction(WebElement element){
        waitUntilLoading();
        waitUntilVisible(element);
        waitUntilClickable(element);
        scrollToElement(element);
        element.click();



    }
    public void confirmationFunction(WebElement element,String value){
        waitUntilVisible(element);
        Assert.assertTrue(element.getText().contains(value));
    }
    public void waitUntilLoading(){

        WebDriverWait wait= new WebDriverWait(GWD.driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"),0));

    }
    public void waitUntilRefresh(WebElement element){
        WebDriverWait wait=new WebDriverWait(GWD.driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
    }


}
