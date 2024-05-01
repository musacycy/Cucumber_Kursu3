package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.simple.SimpleLogger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GWDBasic {
    public static WebDriver driver;


    public static WebDriver getDriver()
    {

        if(driver==null) {
            Logger.getLogger("").setLevel(Level.SEVERE);
            System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY,"Error");
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            // WebDriverManager.firefoxdriver().setup();
            // driver=new FirefoxDriver();
        }
        return driver;
    }
    public static void quitDriver()
    {
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            throw new RuntimeException();
        }
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
    public static void Bekle(int saniye)
    {
        try {
            Thread.sleep(saniye*1000);
        }
        catch (InterruptedException e){
            throw new RuntimeException();
        }
    }

}