package com.Microsite.Base;

import com.Microsite.Utils.MicrositeScreenUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MicrositeScreenBase {
    public static Properties prop;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;

    public static EventFiringWebDriver e_driver;
    public static WebDriver driver;

    public void createFolderExtendReport() {
        try {
            File file = new File(System.getProperty("user.dir") + "/ExtendReport");
            file.mkdir();
            boolean flag = file.mkdir();
            System.out.print("Directory created? " + flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//     protected void waitForElementToBeVisible(WebElement element) {
//        WebDriverWait wait = new WebDriverWait(driver, 60);
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }

    protected void jsClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() throws Exception {
        createFolderExtendReport();
        htmlReporter = new ExtentHtmlReporter(
                System.getProperty("user.dir") + "/ExtendReport/" + "TestReport" + ".html");
        htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

        extent = new ExtentReports();

        extent.attachReporter(htmlReporter);

        htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
        htmlReporter.config().setReportName("Automation suite for Student web"); // name of the report
        htmlReporter.config().setTheme(Theme.STANDARD);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestResult result, Method methodname) throws Exception {
        String msg = String.format("Opening %s on thread %d for the test %s in <%s> test tag",
                System.getProperty("browser"), Thread.currentThread().getId(), result.getMethod().getMethodName(),
                Reporter.getCurrentTestResult().getTestContext().getName());
        System.out.println(msg);
    }

    public MicrositeScreenBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("/Users/pratiksha/Downloads/microsite/MyProject/Demo1/MicrositeProject/src/main/java/com/Microsite/Config/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initialization() throws IOException {
        String browsername = prop.getProperty("browser");
        if (browsername.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/pratiksha/Downloads/microsite/MyProject/Demo1/MicrositeProject/chromedriver");
            driver = new ChromeDriver();
        } else if (browsername.equals("FF")) {
            System.setProperty("webdriver.chrome.driver", "/Users/pratiksha/Downloads/microsite/MyProject/Demo1/MicrositeProject/chromedriver");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(MicrositeScreenUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(MicrositeScreenUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("Surl"));




    }


    @AfterMethod(alwaysRun = true)
    public void captureScreenShot(ITestResult result, java.lang.reflect.Method methodname, ITestContext context){
        if (result.getStatus() == ITestResult.FAILURE) {
            getScreenshot(driver,result.getMethod().getMethodName() );
        }
    }
    public static String getScreenshot(WebDriver driver, String screenshotName) {
        String destination = null;
        try {
            String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            // after execution, you could see a folder "FailedTestsScreenshots" under src folder
            destination = System.getProperty("user.dir") + "/target/Screenshots/" + screenshotName+"_"+dateName + ".png";
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, finalDestination);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            return destination;
        }
    }


    @AfterSuite
    public void tearDownExtentReport() {
        extent.flush();
    }
    public static LocalDateTime getLocalDateByEpoch(Long epochDate) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(epochDate, 0), ZoneId.systemDefault());
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if (null != driver) {

            driver.quit();
            driver = null;
        }
    }
    @AfterMethod(alwaysRun = true)
    public void updateTestResults(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            getScreenshot(driver, result.getMethod().getMethodName());
            extent.createTest(result.getMethod().getMethodName()).fail("Test failed");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extent.createTest(result.getMethod().getMethodName()).pass("Test passed");
        } else {
            extent.createTest(result.getMethod().getMethodName()).skip("Test skipped");
        }

    }
}









