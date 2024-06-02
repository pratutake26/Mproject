package com.MicrositeLandingPage;

import com.Microsite.Base.MicrositeScreenBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class EducatorSchoolDetailsPage extends MicrositeScreenBase {
    SoftAssert softAssert = new SoftAssert();


    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/h1[1]")
    WebElement Tile1;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/p[1]")
    WebElement Tile2;

    @FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/p[1]")
    WebElement Title3;

    @FindBy(name = "UDISE code")
    WebElement UdiscCode;

    @FindBy(xpath = "//a[@id='find_udise_link_btn']")
    WebElement Udisecode1;

    @FindBy(xpath = "//div[@id='list_of_udise_codes']")
    WebElement ListUdiscCode;


    @FindBy(xpath = "//b[contains(text(),'Step-by-step Guide')]")
    WebElement DownloadPDF;

    @FindBy(xpath = "//a[contains(text(),'Educator')]")
    WebElement Educator;

    @FindBy(xpath = "//a[contains(text(),'Educator Registration')]")
    WebElement Regbutton;

    @FindBy(xpath = "//h4[contains(text(),'Jawahar Navodaya Vidyalaya, Pusa')]")
    WebElement Schoolname;
    @FindBy(id = "UDISE_code")
    private WebElement udiseCodeTextBox;

    @FindBy(xpath = "//li[@class='udiseList']")
    private List<WebElement> listOfSchoolOnTheBasisOfUDISECode;

    @FindBy(id = "change_the_udise_code")
    private WebElement thisIsNotMySchoolLink;

    @FindBy(xpath = "//span[@class='fa fa-times clear_udise_search']")
    private WebElement udiseCodeSearchBoxClearButton;

    @FindBy(id = "myschool_next_btn")
    private WebElement nextButtonCreateYourEducatorAccountPage;

    @FindBy(xpath = "//span[@id='select2-school_board-container']")
    private WebElement selectYourBoardDropdown;

    @FindBy(xpath = "//li[@role='option']")
    private List<WebElement> optionsSelectYourBoardDropdown;

    @FindBy(id = "goto_screen_btn")
    WebElement PreviousClick;

    @FindBy(id = "find_udise_link_btn")
    WebElement FindYourUDISECodeLink;

    @FindBy(id="close close_findpopup")
    WebElement FindYourUDISECodePopupCloseButton;

    @FindBy(id = "download-data")
    private WebElement findYourUDISECodePopupDownloadButton;

    @FindBy(id="jiovplay")
    WebElement findYourUDISECodePopupWatchVideo;

    @FindBy(xpath = "//img[@alt='close']")
    private WebElement videoPlayerClosebutton;

    @FindBy(xpath = "//img[@alt='gear-icon']")
    private WebElement videoPlayerSettingButton;

    @FindBy(xpath = "//img[@class='fullscreen-active']")
    private WebElement videoPlayerResizeButton;

    @FindBy(id= "pause")
    private WebElement videoPlayerPauseButton;


    @FindBy(xpath = "//img[@alt='play icon']")
    private WebElement videoPlayerPlayButton;

    @FindBy(xpath = "//img[@alt='rewind']")
    private WebElement videoPlayerRewindButton;

    @FindBy(xpath = "//img[@alt='forward']")
    private WebElement videoPlayerForwarbutton;

    @FindBy(xpath = "//button[@class='close-btn play-player']")
    private WebElement settingPopupDoneButton;

    @FindBy(xpath = "//div[@class='radio-btn-wrapper']")
    private List<WebElement> allRadioButtonSettingPopup;

    @FindBy(xpath = "//img[@src='https://indicmicrosites-assets.embibe.com/madhyapradesh/wp-content/uploads/2023/03/31105246/close.webp']")
    private WebElement videoPlayerCloseButton;

    @FindBy(xpath = "/html[1]/body[1]/div[8]/div[1]/div[1]/button[2]")
    private WebElement VideoplayerResumeClick;

    @FindBy(xpath = "/html[1]/body[1]/div[8]/div[1]/div[1]/button[1]x")
    private WebElement VideoplayerCloseClick;


    public EducatorSchoolDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    public String validatepagetitle1() {
        return Tile1.getText();
    }

    public String validatepagetitle2() {
        return Tile2.getText();

    }

    public String validatepagetitle3() {

        return Title3.getText();

    }

    public void FindUdiscode() {
        Udisecode1.click();
    }

    public void udiseCodeTextBox(String Ud) throws InterruptedException {
        UdiscCode.sendKeys(Ud);
        ListUdiscCode.click();
    }


    public void SchoolDropdownClick() throws InterruptedException {
        Thread.sleep(4000);
        Schoolname.click();
    }

    public void switchtoeducator() {

        Educator.click();
    }

    public void EducatorRegclick() {
        Regbutton.click();
    }

    public void downloadPDF() {
        DownloadPDF.click();

    }

    public void enterUDISECode() throws InterruptedException {
        waitForElementToBeVisible(udiseCodeTextBox);
        udiseCodeTextBox(prop.getProperty("Udisecode"));
    }

    public void clickFirstOptionOnListOfSchool() {

        jsClick(listOfSchoolOnTheBasisOfUDISECode.get(0));
    }

    public void verifyThisIsMyNotMySchoolLink() {
        softAssert.assertTrue(thisIsNotMySchoolLink.isDisplayed(), "this is not my school link is not displayed");
        softAssert.assertAll();
    }

    public void clickOnThisIsNotMySchoolLink() {
        waitForElementToBeVisible(thisIsNotMySchoolLink);
        verifyThisIsMyNotMySchoolLink();
        jsClick(thisIsNotMySchoolLink);
    }


    public void verifyClearButtonUDISECodeTextbox() {
        softAssert.assertTrue(udiseCodeSearchBoxClearButton.isDisplayed(), "UDISE code clear button is not there");
        softAssert.assertAll();
    }

    public void clickOnClearButtonUDISETextBox() {
        waitForElementToBeVisible(udiseCodeSearchBoxClearButton);
        verifyClearButtonUDISECodeTextbox();
        jsClick(udiseCodeSearchBoxClearButton);
    }

    public void verifyselectYourBoardDropdown() {
        softAssert.assertTrue(selectYourBoardDropdown.isDisplayed(), "select your board dropdown is not displayed");
        softAssert.assertAll();
    }

    public void VerifyNextButtonClick() {
        nextButtonCreateYourEducatorAccountPage.click();
    }

    public void clickOnSelectYourBoardDropdown() throws InterruptedException {
        if (nextButtonCreateYourEducatorAccountPage.isEnabled() == false) {
            waitForElementToBeVisible(selectYourBoardDropdown);
            wait(5000);
            verifyselectYourBoardDropdown();
            selectYourBoardDropdown.click();
            wait(3000);
            for (int i = 0; i < optionsSelectYourBoardDropdown.size(); i++) {
                softAssert.assertTrue(optionsSelectYourBoardDropdown.get(i).isDisplayed(), "options of dropdown is not displayed");
            }
            optionsSelectYourBoardDropdown.get(1).click();
            jsClick(nextButtonCreateYourEducatorAccountPage);
            softAssert.assertAll();
        } else if (nextButtonCreateYourEducatorAccountPage.isEnabled() == true) {
            jsClick(nextButtonCreateYourEducatorAccountPage);
        }
    }

    public void PreviousButtonClick() {
        PreviousClick.click();

    }


    public void VerifyUIDECodeLink(){
        softAssert.assertTrue(FindYourUDISECodeLink.isDisplayed(),"Find Your UDISE Code is not Displyaed");
        softAssert.assertAll();
    }

    public void FindYourUDISECodeClick(){
        VerifyUIDECodeLink();
        waitForElementToBeVisible(FindYourUDISECodeLink);
        jsClick(FindYourUDISECodeLink);

//        waitForElementToBeVisible(FindYourUDISECodePopupCloseButton);
//        FindYourUDISECodePopupCloseButton.click();

    }
    protected void waitForElementToBeVisible(WebElement element) {
        // Use Duration.ofSeconds() to create a Duration object
        Duration timeoutDuration = Duration.ofSeconds(40);

        // Create WebDriverWait with the Duration object
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);

        // Use visibilityOfElementLocated() with the Duration object
        wait.until(ExpectedConditions.visibilityOf(element));
    }



    public void clickOnfindYourUDISECodePopupDownloadButton() {
        waitForElementToBeVisible(findYourUDISECodePopupDownloadButton);
        findYourUDISECodePopupDownloadButton.click();
    }

    public void clickOnfindYourUDISECodekWatchVideo(){
        waitForElementToBeVisible((findYourUDISECodePopupWatchVideo));;
        findYourUDISECodePopupWatchVideo.click();


    }

    public void verifyAllElementsOfVideoPlayer() throws InterruptedException {
        Thread.sleep(4000);
        softAssert.assertTrue(videoPlayerClosebutton.isDisplayed(),"close button is not there in video player");
        softAssert.assertTrue(videoPlayerResizeButton.isDisplayed(),"resize button is not there in video player");
        softAssert.assertTrue(videoPlayerPlayButton.isDisplayed(),"play pause button is not there video player");
        softAssert.assertTrue(videoPlayerRewindButton.isDisplayed(),"rewind button is not there in video player");
        softAssert.assertTrue(videoPlayerForwarbutton.isDisplayed(),"forward button is not there in video player");
        softAssert.assertAll();
    }

    public void clickOnPlayPauseForwardRewindCloseButton() throws InterruptedException {
        waitForElementToBeVisible(videoPlayerPlayButton);
        videoPlayerPlayButton.click();
        Thread.sleep(4000);
        videoPlayerRewindButton.click();
        Thread.sleep(4000);
        videoPlayerForwarbutton.click();
        Thread.sleep(4000);
        videoPlayerPauseButton.click();

    }

    public void CloseButtonClick() throws InterruptedException {
        videoPlayerCloseButton.click();
        Thread.sleep(4000);
        waitForElementToBeVisible(VideoplayerResumeClick);
        VideoplayerResumeClick.click();
        Thread.sleep(4000);
        videoPlayerCloseButton.click();
        waitForElementToBeVisible(VideoplayerCloseClick);
        VideoplayerCloseClick.click();
    }



}




