package stepdefinitions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DemoBlaze_BaseClass {

    public static WebDriver wdriver;
    public static String endpoint ;
    public static String qaendpoint;
    public static String eteendpoint;
    public String localext;
    public static String strProjectLoc = null;
    public String env = null;
    private Properties prop = new Properties();
    public static String certpassword = null;
    public static String certname = null;
    private static String browser = null;
    private static String getopertingsytem =null;

    public DemoBlaze_BaseClass(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public DemoBlaze_BaseClass() {

    }

    public String executionproperties() throws IOException {

        strProjectLoc = System.getProperty("user.dir");
        getopertingsytem = System.getProperty("os.name");
        FileInputStream fis = null;

        fis = new FileInputStream(strProjectLoc + File.separator+"src" + File.separator+ "test" +  File.separator + "resources"+File.separator +"properties"+ File.separator+ "execution.properties");
        prop.load(fis);

        /**
         * read the properties from the global properties method
         */
        env = prop.getProperty("env");
        qaendpoint = prop.getProperty("qaendpoint");
        eteendpoint = prop.getProperty("eteendpoint");
        browser = prop.getProperty("browser");



        /**
         * Description: The below logic is to ensure that to execute the code locally or through mvn commnd
         * please ensure that before pushing your code to bitbucket we need to set the local exectuion variable to No
         */

            env =prop.getProperty("env");

            if (env.equalsIgnoreCase("qa"))
            {
                endpoint = qaendpoint;
            }
            else
            {
                endpoint = eteendpoint;
            }



        return endpoint;
    }

    /**
     * @Description: The below method is used to launch the browser
     * @param url
     */

    public void userLaunchesDemoBlazeSite(String url)
    {

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "webdriver" + File.separator + "chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("useAutomationExtension", false);
            wdriver = new ChromeDriver(options);
            wdriver.get(url);
            wdriver.manage().window().maximize();
        }

        else if(browser.equalsIgnoreCase("ie"))
        {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
            cap.setCapability("requireWindowFocus", true);
            cap.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
            cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
            cap.setCapability("ignoreProtectedModeSettings", true);
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + File.separator + "src"+File.separator+"test"+File.separator+"resources"+File.separator+"webdriver"+File.separator+"IEDriverServer.exe");
            InternetExplorerOptions options = new InternetExplorerOptions();
            options.merge(cap);
            wdriver = new InternetExplorerDriver(options);
            wdriver.get(url);
            wdriver.manage().window().maximize();
        }

        else if(browser.equalsIgnoreCase("edge"))
        {
            if (!getopertingsytem.equalsIgnoreCase("Windows 10"))
            {
                System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "webdriver" + File.separator + "msedgedriver.exe");
            }
            else
            {
                System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "webdriver" + File.separator + "msedgedriver.exe");
            }

            wdriver = new EdgeDriver();
            wdriver.get(url);
            wdriver.manage().window().maximize();
            wdriver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);

        }
    }



    /**
     * Description: The below webdriver waits for a max of 60 seconds for an object to be in clickable state.
     * @param demoblazeelement
     */
    public static void demoBlazeWaitforelement(WebElement demoblazeelement)  {

        WebDriverWait waitdemoblaze = new WebDriverWait(wdriver, Duration.ofSeconds(60));
        waitdemoblaze.until(ExpectedConditions.visibilityOf(demoblazeelement));
        waitdemoblaze.until(ExpectedConditions.elementToBeClickable(demoblazeelement));
    }


    public static void waitForalert()
    {
        new WebDriverWait(wdriver, Duration.ofSeconds(10))
                .ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());
    }

    public static String AcceptAlert()
    {
        String gettexvalue;
        Alert alertw = wdriver.switchTo().alert();
        gettexvalue = alertw.getText();
        alertw.accept();

        return  gettexvalue;
    }

   public static void pauseApplication(int val) throws InterruptedException {
       TimeUnit.SECONDS.sleep(val);
   }


   public static void demoblazeimplicitwait()
   {
       wdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
   }


    public static void captureDemolazeScreenShot(WebDriver webdriver, String screename) throws Exception{
        String logFilename = new SimpleDateFormat("yyyyMMddHHmmsss").format(new Date());
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(strProjectLoc + File.separator+"src" +  File.separator+ "test" + File.separator + "resources" + File.separator +"demoblaze_ScreenShots"+File.separator +screename+"_"+logFilename+".png");
        FileUtils.copyFile(SrcFile, DestFile);

    }

    public static String removesepcialcharacters(String amount)
    {

        String processedamount = amount;
        processedamount = processedamount.replaceAll("[^a-zA-Z0-9]\\W", "");
        return processedamount;

    }

    public static String UserExtractsOrdreid(String message)
    {

        String str = message;
        int start = str.indexOf("Id:")+"Id:".length();
        int end = str.lastIndexOf("Amount:");
        String outStr = str.substring(start, end);
        return outStr;
    }


}
