package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Driver {

    //Driver.getDriver(); -->driver
    private static WebDriver driver;//Driver.getDriver()

    public static WebDriver getDriver(){
        if(driver==null){
           switch(ConfigReader.getProperty("browser")){
               case "chrome":
               driver= WebDriverManager.chromedriver().create(); //Selenium 4.5 ==> create()
                   break;
               case "firefox":
                   driver=WebDriverManager.firefoxdriver().create();
                   break;
               case "chrome-headless":
                   WebDriverManager.chromedriver().setup();
                   driver =new ChromeDriver(new ChromeOptions().setHeadless(true));
                   break;
               case "edge":
                   driver = WebDriverManager.edgedriver().create();
                   break;
           }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//for special element
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));//for whole page loading
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver(){
        if(driver!=null){// if it is being used
            driver.quit();
            driver=null;//make it null to e able to create new one when we are calling getDriver()
        }
    }
}
