package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriverService;
import org.slf4j.simple.SimpleLogger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {
    public static WebDriver driver;
    private static final ThreadLocal<WebDriver> threadDriver=new ThreadLocal<WebDriver>();//webdriver 1 web driver 2
    public static ThreadLocal<String> threadBrowserName=new ThreadLocal<>();// chrome firefox

    //threadDriver.get()---> ilgili threaddeki driveri verecek
    //threadDriver.set(driver)--> ilgili threade driver set ediliyor
    public static WebDriver getDriver()
    {
        //Bana ne lazım: 1  browser tipi lazım burada ona gre oluşturacam
        //her bir paralel çalışan süreç için sadece o sürece özel static bir değişken lazım
        //çünkü runner classdaki işaret edilen tüm senaryolarda aynısı çalışması lazım
        //demekki her pipeline için Local ve de ona özel static bir drivera ihtiyacı var
        //donanımdaki adı pipeline yazılımdaki adı thread

        Logger.getLogger("").setLevel(Level.SEVERE);
        System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY,"Error");

        if(threadBrowserName.get()==null) //paralel çalışmayan yani xml den parametreyle gelmeyen her çağıran
            threadBrowserName.set("chrome"); //basic arayanlar için

        if(threadDriver.get()==null) {

            String browserName=threadBrowserName.get();//bu threaddeki browsernamei verdi

            switch (browserName){

                case "chrome":System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
                    WebDriverManager.chromedriver().setup();
                threadDriver.set(new ChromeDriver());break;
               case "firefox":System.setProperty(GeckoDriverService.GECKO_DRIVER_LOG_PROPERTY,"/dev/null");
                WebDriverManager.firefoxdriver().setup();
                threadDriver.set(new FirefoxDriver());
                case "safari": WebDriverManager.safaridriver().setup();
                threadDriver.set(new SafariDriver());

                case "edge":WebDriverManager.edgedriver().setup();
                threadDriver.set(new EdgeDriver());
            }


            driver = new ChromeDriver();
           // WebDriverManager.firefoxdriver().setup();
           // driver=new FirefoxDriver();
        }
        return threadDriver.get();
    }
    public static void quitDriver()
    {
       Bekle(5);
        if(threadDriver.get()!=null){
            threadDriver.get().quit();
            WebDriver driver=threadDriver.get();
            driver=null;
            threadDriver.set(driver);
        }
    }
    public static void Bekle(int saniye)
    {
        try {
            Thread.sleep(saniye* 1000L);
        }
        catch (InterruptedException e){
            throw new RuntimeException();
        }
    }

}