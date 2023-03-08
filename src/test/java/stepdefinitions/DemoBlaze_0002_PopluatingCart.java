package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import za.co.demoblaze.pageobjects.DemoBlaze_AddItemsToCart;

public class DemoBlaze_0002_PopluatingCart extends DemoBlaze_BaseClass {

    DemoBlaze_AddItemsToCart demoBlaze_addItemsToCart;
    private static String getmobileprice;
    private static String getmonitorprice;

    @Given("^registerd user adds nexusmobile$")
    public void registerd_user_adds_nexusmobile() throws InterruptedException {

        demoBlaze_addItemsToCart = new DemoBlaze_AddItemsToCart(wdriver);
        getmobileprice = demoBlaze_addItemsToCart.UserSelectsNexusMobileFlowJourney();
        System.out.println(getmobileprice);
    }
    @Given("^Asus devices to cart successfully$")
    public void asus_devices_to_cart_successfully() throws InterruptedException {
        getmonitorprice= demoBlaze_addItemsToCart.UserSelectcMonitorFlowJourney();
        System.out.println(getmonitorprice);
        demoBlaze_addItemsToCart.UserSelectsandValidatesCart();
    }


    @Then("^registered user validates total amount successfull \"([^\"]*)\"$")
    public void registered_user_validates_total_amount_successfull(String totalamount) throws Throwable {
        String gettotalprice =  demoBlaze_addItemsToCart.UserValidatesTotal();
        System.out.println(gettotalprice);
        Assert.assertEquals(totalamount,gettotalprice);

    }

}
