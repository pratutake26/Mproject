package MicrositeLandingPageTestcases;

import com.Microsite.Base.MicrositeScreenBase;
import com.MicrositeLandingPage.EducatorSchoolDetailsPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class EducatorLandingPageTest extends MicrositeScreenBase {
    EducatorSchoolDetailsPage schooldeatilspa;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;


    private Object wait;

    public  EducatorLandingPageTest() {
        super();  //super class const will inharit the property of parent class (base class)
    }


    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        schooldeatilspa = new EducatorSchoolDetailsPage();
    }


    @Test(priority = 1)
    public void LandingPageTitle1Test() {
        schooldeatilspa.switchtoeducator();
        schooldeatilspa.EducatorRegclick();
        String title = schooldeatilspa.validatepagetitle1();
        Assert.assertEquals(title, "Create Your Educator Account");
    }

    @Test(priority = 2)
    public void LandingPageTitle2Test() {
        schooldeatilspa.switchtoeducator();
        schooldeatilspa.EducatorRegclick();
        String title = schooldeatilspa.validatepagetitle2();
        Assert.assertEquals(title, "Verify your School Details to get Started with Embibe");
    }

    @Test(priority = 3)
    public void LandingPageTitle3Test() {
        schooldeatilspa.switchtoeducator();
        schooldeatilspa.EducatorRegclick();
        String title = schooldeatilspa.validatepagetitle3();
        Assert.assertEquals(title, "To ensure that only Educator can access our platform, we need to verify your School’s details." +
                "Please enter your School UDISE Code below");
    }

    @Test(priority = 4)
    public void FindUdiseCodeLinkTest() {
        schooldeatilspa.switchtoeducator();
        schooldeatilspa.EducatorRegclick();
        schooldeatilspa.FindUdiscode();
        Assert.assertTrue(true);
    }

    @Test(priority = 5)
    public void ConfirmeUdiseCodeTest() throws InterruptedException {
        schooldeatilspa.switchtoeducator();
        schooldeatilspa.EducatorRegclick();
        Thread.sleep(5000);
        schooldeatilspa.enterUDISECode();
        Thread.sleep(4000);
        // Replace Thread.sleep with WebDriverWait to wait for the element to be clickable
        schooldeatilspa.clickFirstOptionOnListOfSchool();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

// Scroll to the 'myschool-btn' element before clicking
        WebElement mySchoolBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myschool-btn")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mySchoolBtn);

// Click the 'myschool-btn' button
        mySchoolBtn.click();
    }


    @Test(priority = 5)
    public void VerifyThisNotMYSchoolButton() throws InterruptedException {
        schooldeatilspa.switchtoeducator();
        schooldeatilspa.EducatorRegclick();
        Thread.sleep(5000);
        schooldeatilspa.enterUDISECode();
        Thread.sleep(4000);
        // Replace Thread.sleep with WebDriverWait to wait for the element to be clickable
        schooldeatilspa.clickFirstOptionOnListOfSchool();
        schooldeatilspa.clickOnThisIsNotMySchoolLink();
        schooldeatilspa.enterUDISECode();
        schooldeatilspa.clickOnClearButtonUDISETextBox();
        schooldeatilspa.enterUDISECode();
        schooldeatilspa.clickFirstOptionOnListOfSchool();
        Duration timeoutDuration = Duration.ofSeconds(20); // Change 20 to your desired timeout in seconds

        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);
        WebElement mySchoolBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myschool-btn")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mySchoolBtn);

        // Click the 'myschool-btn' button
        mySchoolBtn.click();

    }

    @Test(priority = 5)
    public void VerifyBoardDropdown() throws InterruptedException {
        schooldeatilspa.switchtoeducator();
        schooldeatilspa.EducatorRegclick();
        Thread.sleep(5000);
        schooldeatilspa.enterUDISECode();
        Thread.sleep(4000);
        // Replace Thread.sleep with WebDriverWait to wait for the element to be clickable
        schooldeatilspa.clickFirstOptionOnListOfSchool();
        Duration timeoutDuration = Duration.ofSeconds(20); // Change 20 to your desired timeout in seconds

        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);
        // Scroll to the 'myschool-btn' element before clicking
        WebElement mySchoolBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myschool-btn")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mySchoolBtn);

        // Click the 'myschool-btn' button
        mySchoolBtn.click();
        schooldeatilspa.PreviousButtonClick();
        schooldeatilspa.enterUDISECode();
        Thread.sleep(4000);
        // Replace Thread.sleep with WebDriverWait to wait for the element to be clickable
        schooldeatilspa.clickFirstOptionOnListOfSchool();
        WebDriverWait wait1 = new WebDriverWait(driver, timeoutDuration);
        // Scroll to the 'myschool-btn' element before clicking
        WebElement mySchoolBtn1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("myschool-btn")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mySchoolBtn1);
        mySchoolBtn1.click();
        schooldeatilspa.VerifyNextButtonClick();


    }
    @Test(priority = 5)
    public void VerifyFindYourUDISEcodePopup() throws InterruptedException {
        schooldeatilspa.switchtoeducator();
        schooldeatilspa.EducatorRegclick();
        schooldeatilspa.FindYourUDISECodeClick();
        schooldeatilspa.clickOnfindYourUDISECodePopupDownloadButton();
        schooldeatilspa.clickOnfindYourUDISECodekWatchVideo();
        schooldeatilspa.verifyAllElementsOfVideoPlayer();
        schooldeatilspa.clickOnPlayPauseForwardRewindCloseButton();
        schooldeatilspa.CloseButtonClick();

    }











}










