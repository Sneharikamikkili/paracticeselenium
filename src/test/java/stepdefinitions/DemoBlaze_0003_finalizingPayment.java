package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import za.co.demoblaze.pageobjects.DemoBlaze_AddItemsToCart;
import za.co.demoblaze.pageobjects.DemoBlaze_FinalizePayment;

public class DemoBlaze_0003_finalizingPayment extends DemoBlaze_BaseClass {

    DemoBlaze_AddItemsToCart demoBlaze_addItemsToCart;
    DemoBlaze_FinalizePayment demoBlaze_finalizePayment;

    @Given("^i have selected placed order$")
    public void i_have_selected_placed_order() throws Throwable {

        demoBlaze_addItemsToCart = new DemoBlaze_AddItemsToCart(wdriver);
        demoBlaze_finalizePayment = new DemoBlaze_FinalizePayment(wdriver);
        demoBlaze_addItemsToCart.UserSelectPlaceOrder();
    }

    @Given("^i have captured \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void i_have_captured(String name, String coutnry, String city, String card, String month, String year) throws Throwable {

        demoBlaze_finalizePayment.UserCapturesDetails(name,coutnry,city,card,month,year);
    }

    @When("^i click on purchase$")
    public void i_click_on_purchase() throws Throwable {

        demoBlaze_finalizePayment.UserSelectspurchase();

    }

    @Then("^i should see order id getting displayed successfully$")
    public void i_should_see_order_id_getting_displayed_successfully() throws Throwable {
        demoBlaze_finalizePayment.UserValidatesSuccessMessage();
        String getorderid = demoBlaze_finalizePayment.UserExtractsOrderid();
        System.out.println(getorderid);

    }
}
