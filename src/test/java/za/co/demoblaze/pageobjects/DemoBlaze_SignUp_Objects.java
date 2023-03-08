package za.co.demoblaze.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import stepdefinitions.DemoBlaze_BaseClass;


public class DemoBlaze_SignUp_Objects extends DemoBlaze_BaseClass {

    public DemoBlaze_SignUp_Objects(WebDriver driver)
    {super(driver);}



    @FindBy(id = "signin2")
    @CacheLookup
    WebElement signup;

    @FindBy(id = "sign-username")
    @CacheLookup
    WebElement username;

    @FindBy(id = "sign-password")
    @CacheLookup
    WebElement password;

    @FindBy(xpath = "//button[@onclick=\"register()\"]")
    @CacheLookup
    WebElement SingupBtn;

    @FindBy(id = "login2")
    @CacheLookup
    WebElement loginbtn;

    @FindBy(id = "loginusername")
    @CacheLookup
    WebElement registerdusername;

    @FindBy(id = "loginpassword")
    @CacheLookup
    WebElement registerdpassword;

    @FindBy(xpath = "//button[@onclick='logIn()']")
    @CacheLookup
    WebElement signbuton;





    public WebElement getSignup() {
        return signup;
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getSingupBtn() {
        return SingupBtn;
    }

    public WebElement getLoginbtn() { return loginbtn;}

    public WebElement getRegisterdusername() { return registerdusername; }

    public WebElement getRegisterdpassword() { return registerdpassword; }

    public WebElement getSignbuton() { return signbuton; }





    public void userSelectsSignUp_OnDemoBlaze()
    {
       demoBlazeWaitforelement(getSignup());
        getSignup().click();
    }


    public void userCapturesDemoBlazeUsername(String newuser)
    {
        demoBlazeWaitforelement(getUsername());
        getUsername().sendKeys(newuser);
    }


    public void userCapturesDemoBlazePassword(String password)
    {
        demoBlazeWaitforelement(getPassword());
        getPassword().sendKeys(password);
    }


    public void userSelectsSignUpButton()
    {
        demoBlazeWaitforelement(getSignup());
        getSingupBtn().click();
    }

    public String userValidatesSing() throws Exception {
        String gettexvalue;
        DemoBlaze_BaseClass.waitForalert();
        gettexvalue = AcceptAlert();

        return  gettexvalue;
    }

    public void UserSelectsLoginButton() {
        demoBlazeWaitforelement(getLoginbtn());
        getLoginbtn().click();
    }

    public void UserCapturesUsernamePassword(String registerdusrname, String registerdpwd)
    {
        demoBlazeWaitforelement(getRegisterdusername());
        getRegisterdusername().click();
        getRegisterdusername().sendKeys(registerdusrname);
        getRegisterdpassword().click();
        getRegisterdpassword().sendKeys(registerdpwd);
        getSignbuton().click();
    }




}
