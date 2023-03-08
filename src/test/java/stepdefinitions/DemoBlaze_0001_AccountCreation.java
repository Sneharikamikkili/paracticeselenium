package stepdefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import za.co.demoblaze.pageobjects.DemoBlaze_SignUp_Objects;


public class DemoBlaze_0001_AccountCreation extends DemoBlaze_BaseClass{

    public DemoBlaze_0001_AccountCreation() {
        super(wdriver);
    }
    DemoBlaze_SignUp_Objects demoBlaze_signUp_objects;

    @Given("^i have navaigated to stores site$")
    public void i_have_navaigated_to_stores_site() {

        userLaunchesDemoBlazeSite(endpoint);
        demoBlaze_signUp_objects = new DemoBlaze_SignUp_Objects(wdriver);


    }

    @When("^i click on Signup menu and capture \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_click_on_Signup_menu_and_capture_and(String newusername, String newuserpassword){
        demoBlaze_signUp_objects.userSelectsSignUp_OnDemoBlaze();
        demoBlaze_signUp_objects.userCapturesDemoBlazeUsername(newusername);
        demoBlaze_signUp_objects.userCapturesDemoBlazePassword(newuserpassword);
        demoBlaze_signUp_objects.userSelectsSignUpButton();

    }

    @Then("^i should see successful confirmation message sign up successful \"([^\"]*)\"$")
    public void i_should_see_successful_confirmation_message_sign_up_successful(String message) throws Throwable {

        Assert.assertEquals(demoBlaze_signUp_objects.userValidatesSing(),message);

    }


    @Then("^register user logins successfully with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void register_user_logins_successfully_with_and(String username, String password) throws InterruptedException {

        demoBlaze_signUp_objects.UserSelectsLoginButton();
        demoBlaze_signUp_objects.UserCapturesUsernamePassword(username,password);

    }



    @After
    public static void tearDown(Scenario scenario) throws Exception {

        if(scenario.isFailed()) {
             captureDemolazeScreenShot(wdriver, scenario.getName()+"_failedScenario");
             wdriver.close();
        }
        else
        {
            captureDemolazeScreenShot(wdriver, scenario.getName()+"_successcenario");
        }

    }

}
