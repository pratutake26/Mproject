package com.MicrositeLandingPage;

import com.Microsite.Base.MicrositeScreenBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EducatorLoginpage extends MicrositeScreenBase {


    @FindBy(xpath = "//a[contains(text(),'Educator')]")
    WebElement Educator;

    @FindBy(xpath = "//a[@id='teacher-login-trigger']")
    WebElement educatorloginbutn;

    @FindBy(id = "tc_email")
    WebElement username;

    @FindBy(id = "tc_otp_mobile_email")
    WebElement otpusername;

    @FindBy(id = "tc_password")
    WebElement password;

    @FindBy(id = "tc-login-btn")
    WebElement loginbtn;

    @FindBy(id = "tc_get_otp_btn")
    WebElement getOTP;

    @FindBy(xpath = "//input[@id='fgpass_get_otp_btn']")
    WebElement fpgetOTPbtn;


    @FindBy(xpath = "//ancestor::div[@class='enter-otp form-content pop-show']//input[@name='otp-0']")

    WebElement otpfield;

    @FindBy(xpath ="//form[@id='st_otp']//input[@name='otp-0']" )
    WebElement FOtpfiled1;

    @FindBy(id = "tc_fg_password")
    WebElement forgetpass;

    @FindBy(id ="tc_fp_mob_email")
    WebElement forgotepassfiled;

    @FindBy(xpath = "//input[@id='tc_fs_pass']")
    WebElement Newpassfield;

    @FindBy(xpath = "//input[@id='tc_fs_con_pass']")
    WebElement repassfield;

    @FindBy(xpath ="//input[@id ='tc_otp_final_proceed_btn']")
    WebElement fpassproccedclick;

    @FindBy(xpath = "//input[@id='teacher_fgpass_opt_proceed']")
    WebElement fpotpproceed;




    public EducatorLoginpage(){
        PageFactory.initElements(driver ,this);

    }
    public void SwitchToEducator(){
        Educator.click();

    }

    public void EducatorLoginbutton() throws InterruptedException {
        educatorloginbutn.click();
        Thread.sleep(4000);

    }
    public void EducatorLoginbutton1(){
        loginbtn.click();
    }


    public void login(String un,String pwd) {
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginbtn.click();
    }

    public void loginOTP1(String un)
    {
        otpusername.sendKeys(un);
    }

    public void GetOTP(){
        getOTP.click();
    }

    public void LoginOTP() throws InterruptedException {
        otpfield.click();

        int last = 6;
        String value1 = "//ancestor::div[@class='enter-otp form-content pop-show']//input[@name='otp-";
        String value2 = "']";
        for (int i = 0; i < last; i++) {
            int j = last - i;
            driver.findElement(By.xpath(value1 + i + value2)).sendKeys(Integer.toString(j));

        }

        driver.findElement(By.xpath("//input[@id='tc_pass_otp_proceedbtn']")).click();
        Thread.sleep(10000);
        System.out.println("Login with OTP successfully!");


    }

    public void Forgotepassclick(){

        forgetpass.click();

    }




    private WebElement waitForElement(By locator) {
        Duration timeoutDuration = Duration.ofSeconds(20); // Change 20 to your desired timeout in seconds
        // Create WebDriverWait instance with the timeout duration
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void ForPassField(String un)
    {
        forgotepassfiled.sendKeys(un);
    }
    public void FPGetOTP(){
        fpgetOTPbtn.click();

    }
    public void ForgetpassOtpProceed(){
        fpotpproceed.click();
    }

    public void FPEnterOTP() {
        FOtpfiled1.click();
        int last = 6;
        String value1 = "//form[@id='st_otp']//input[@name='otp-";
        String value2 = "']";
        for (int i = 0; i < last; i++) {
            int j = last - i;
            driver.findElement(By.xpath(value1 + i + value2)).sendKeys(Integer.toString(j));

        }

    }


    public void EnterNewPassFields(String pw1,String pw2)
    {
        Newpassfield.sendKeys(pw1);
        repassfield.sendKeys(pw2);
    }

    public void FpasswordProceedClick(){

        fpassproccedclick.click();
    }





}





