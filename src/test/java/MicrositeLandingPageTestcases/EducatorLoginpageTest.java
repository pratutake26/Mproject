package MicrositeLandingPageTestcases;

import com.Microsite.Base.MicrositeScreenBase;
import com.MicrositeLandingPage.EducatorLoginpage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class EducatorLoginpageTest extends MicrositeScreenBase {

    EducatorLoginpage loginpage;

    //Create the login page const
    public EducatorLoginpageTest() {
        super();  //super class const will inharit the property of parent class (base class)
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginpage = new EducatorLoginpage();
    }

    @Test(priority = 1)
    public void SwitchToEducatorPage() {
        loginpage.SwitchToEducator();
    }

    @Test(priority = 2)
    public void EducatorLoginWithPasswordTest() throws InterruptedException {
        try {
            loginpage.SwitchToEducator();
            Thread.sleep(4000);
            loginpage.EducatorLoginbutton();
            loginpage.login(prop.getProperty("Username"), prop.getProperty("password"));
            loginpage.EducatorLoginbutton1();

            // Assert that the user has logged in successfully
            Assert.assertFalse(isLoggedInSuccessfully(), "Login failed. User not logged in successfully.");

            // If the assertion passes, log success message
            System.out.println("User logged in successfully!");
        } catch (TimeoutException e) {
            // Handle the exception as needed, e.g., logging, taking a screenshot, etc.
            System.out.println("TimeoutException: Validation error on login. Checking for error message.");

            // Look for the error message element
            WebElement errorMessageElement = findErrorMessageElement();
            if (errorMessageElement != null) {
                String errorMessage = errorMessageElement.getText();
                System.out.println("Error Message: " + errorMessage);
                // You can further handle the error message as needed, e.g., logging, assertion, etc.
            } else {
                System.out.println("Error message element not found.");
                // Handle the situation when the error message element is not found.
            }
        }
    }

    private boolean isLoggedInSuccessfully() { // Custom method to logged in successfully
        // Replace the following condition with the actual condition to check if the user is logged in
        return driver.getTitle().equals("https://school.embibe.co.in/track/principal");
    }

    private WebElement findErrorMessageElement() { //  Method  find the error message element
        try {
            Duration timeoutDuration = Duration.ofSeconds(20); // Change 20 to your desired timeout in seconds

            WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);

            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tc_mobile_error_block error']")));
        } catch (TimeoutException e) {
            return null; // Return null if the error message element is not found within the specified time
        }
    }

    @Test(priority = 3)
    public void EducatorLoginWithOTPTest() {
        try {
            loginpage.SwitchToEducator();
            Thread.sleep(4000);
            loginpage.EducatorLoginbutton();
            driver.findElement(By.xpath("//a[@id='teacher_signin_with_otp_btn']")).click();
            loginpage.loginOTP1(prop.getProperty("Username"));
            loginpage.GetOTP();
            loginpage.LoginOTP();


        } catch (TimeoutException | InterruptedException e) {
            // Handle the exception as needed, e.g., logging, taking a screenshot, etc.
            System.out.println("TimeoutException: Validation error on login. Checking for error message.");

            // Look for the error message element
            WebElement errorMessageElement = findErrorMessageElement();
            if (errorMessageElement != null) {
                String errorMessage = errorMessageElement.getText();
                System.out.println("Error Message: " + errorMessage);
                // You can further handle the error message as needed, e.g., logging, assertion, etc.
            } else {
                System.out.println("Error message element not found.");
                // Handle the situation when the error message element is not found.
            }
        }
    }

    @Test(priority = 4)
    public void ResetPasswordTest() throws InterruptedException {
        loginpage.SwitchToEducator();
        Thread.sleep(4000);
        loginpage.EducatorLoginbutton();
//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        WebElement resetPasswordLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='tc_fg_password']")));
//        resetPasswordLink.click();
        Thread.sleep(4000);
        loginpage.Forgotepassclick();
        Thread.sleep(4000);
        loginpage.ForPassField(prop.getProperty("Username"));
        loginpage.FPGetOTP();

        loginpage.FPEnterOTP();
        Thread.sleep(10000);

        loginpage.ForgetpassOtpProceed();

        loginpage.EnterNewPassFields(prop.getProperty("Username"), prop.getProperty("Username"));
        loginpage.FpasswordProceedClick();



    }

}




