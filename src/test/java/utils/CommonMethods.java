package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.PageInitializers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializers {

    public static WebDriver driver;

    public void openBrowserAndLunchApplication(){

        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")){
            case "chrome":
                ChromeOptions chromeOptions =new ChromeOptions();
                chromeOptions.setHeadless(true);
                WebDriverManager.chromedriver().setup();
                driver =new ChromeDriver(chromeOptions);


                /* WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();

                 */
            break;


            case "firefox":
              WebDriverManager.firefoxdriver().setup();
              driver=new FirefoxDriver();
                break;
            default:

                throw new RuntimeException("Invalid browser name");

        }
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        initializePageObject();
    }

    public static void sendText(WebElement element, String textToSend) {
        element.sendKeys(textToSend);
       // element.clear();

    }
       public static WebDriverWait getWait(){
           WebDriverWait wait= new WebDriverWait(driver,Constants.EXPLICIT_WAIT);
        return wait;
    }
 public static void  waitForClickability(WebElement element){
       getWait().until(ExpectedConditions.elementToBeClickable(element));

 }
 public static void click(WebElement element){
 waitForClickability(element);
 element.click();
 }
  public static JavascriptExecutor getJSExecuter(){
      JavascriptExecutor js=(JavascriptExecutor) driver;
      return js;

  }
  public static void jsClick(WebElement element){
        getJSExecuter().executeScript("arguments[0].click();",element);
  }

public static byte[]  takeScreenshot(String filename){
    TakesScreenshot ts=(TakesScreenshot) driver;

    byte[]picsBytes= ts.getScreenshotAs(OutputType.BYTES);
    File sourceFile=ts.getScreenshotAs(OutputType.FILE);

    try {
        FileUtils.copyFile(sourceFile,new File(Constants.SCREENSHOT_FILEPATH + filename
        + "  " + getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
    } catch (IOException e) {
      e.printStackTrace();

    }
    return picsBytes;

}

public static String getTimeStamp(String pattern){
        Date date=new Date();
       //to format the date according to our we want to implement in this function
        SimpleDateFormat sdf =new SimpleDateFormat(pattern);
        return sdf.format(date);


}

  public void tearDown(){
        driver.quit();



    }
}
