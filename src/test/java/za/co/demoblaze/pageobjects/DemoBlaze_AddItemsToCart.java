package za.co.demoblaze.pageobjects;


import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import stepdefinitions.DemoBlaze_BaseClass;

import java.sql.Time;
import java.time.Duration;


public class DemoBlaze_AddItemsToCart extends DemoBlaze_BaseClass {

    public DemoBlaze_AddItemsToCart(WebDriver driver)
    {
       super(driver);
    }



    @FindBy(xpath = "//a[normalize-space()='Nexus 6']")
    @CacheLookup
    WebElement nexussixmobile;

    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    @CacheLookup
    WebElement addtocart;

    @FindBy(xpath = "//a[@onclick='addToCart(14)']")
    @CacheLookup
    WebElement addtocartmonitor;


    @FindBy(xpath = "//li[@class='nav-item active']//a[@class='nav-link']")
    @CacheLookup
    WebElement selectHome;

    @FindBy(xpath = "(//a[normalize-space()='Monitors'])[1]")
    @CacheLookup
    WebElement selectMonitors;

    @FindBy(xpath = "//a[text()='ASUS Full HD']")
    @CacheLookup
    WebElement asusfullhd;

    @FindBy(xpath = "//div[@id='tbodyid']/h3")
    @CacheLookup
    WebElement getprice;

    @FindBy(xpath = "//div[@id='tbodyid']/div[2]/div/div/h5")
    @CacheLookup
    WebElement getMonitorPrice;

    @FindBy(id = "cartur")
    @CacheLookup
    WebElement cart;

    @FindBy(id = "totalp")
    @CacheLookup
    WebElement totalamount;

    @FindBy(xpath = "//button[text()=\"Place Order\"]")
    @CacheLookup
    WebElement getplaceorder;






    public WebElement getNexussixmobile() {
        return nexussixmobile;
    }

    public WebElement getAddtocart() { return addtocart; }

    public WebElement getSelectHome() {
        return selectHome;
    }

    public WebElement getSelectMonitors() {
        return selectMonitors;
    }

    public WebElement getAsusfullhd() { return asusfullhd;}

    public WebElement getGetprice() { return getprice;}

    public WebElement getGetMonitorPrice() { return getMonitorPrice; }

    public WebElement getAddtocartmonitor() { return addtocartmonitor; }

    public WebElement getCart() { return cart;}

    public WebElement getTotalamount() { return totalamount; }

    public WebElement getGetplaceorder() { return getplaceorder; }



    public void UserSelectsNexusMobile() throws InterruptedException {
        pauseApplication(5);
        for(int i =0;i<5;i++) {
            try{
                getNexussixmobile().click();
            } catch (StaleElementReferenceException e){}
        }
    }

    public void UserSelectsAddToCart(String unit)
    {
        wdriver.navigate().refresh();
        DemoBlaze_BaseClass.demoBlazeWaitforelement(getAddtocart());
        for(int i = 0; i<Integer.parseInt(unit); i++) {
            getAddtocart().click();
            DemoBlaze_BaseClass.waitForalert();
            DemoBlaze_BaseClass.AcceptAlert();
        }

    }

    public void UserSelectHome()
    {
        getSelectHome().click();
    }


    public void UserSelectsMonitor()
    {
        DemoBlaze_BaseClass.demoBlazeWaitforelement(getSelectMonitors());
        getSelectMonitors().click();
    }


    public void UserSelectsASusMonitor()
    {
        DemoBlaze_BaseClass.demoBlazeWaitforelement(getAsusfullhd());
        getAsusfullhd().click();
    }

    public String userGetsPrice() throws InterruptedException {
        String getprice=null;
        getprice = getGetprice().getText();
        String processedprice =  removesepcialcharacters(getprice);
        return processedprice;
    }

    public String UserSelectsMonitorPrice() throws InterruptedException {
        pauseApplication(3);
        demoblazeimplicitwait();
        DemoBlaze_BaseClass.demoBlazeWaitforelement(getGetMonitorPrice());
        String getmotrprice = getGetMonitorPrice().getText();
        String processedprice =  removesepcialcharacters(getmotrprice);
        return processedprice;
    }


    public void UserSelectsAddToCartMonitor() {
        demoblazeimplicitwait();
        getAddtocartmonitor().click();
        DemoBlaze_BaseClass.waitForalert();
        DemoBlaze_BaseClass.AcceptAlert();

    }


    public void UserSelectsandValidatesCart()
    {
        demoBlazeWaitforelement(getCart());
        getCart().click();
    }
    public void UserSelectPlaceOrder()
    {
        getGetplaceorder().click();
    }

    public String UserValidatesTotal()
    {
        demoBlazeWaitforelement(getTotalamount());
        String getamount = getTotalamount().getText();
        String processedprice =  removesepcialcharacters(getamount);
        return processedprice;

    }

    public String UserSelectsNexusMobileFlowJourney(String units) throws InterruptedException {
        UserSelectsNexusMobile();
        UserSelectsAddToCart(units);
        String getprice = userGetsPrice();
        UserSelectHome();
        return getprice;
    }


    public String UserSelectcMonitorFlowJourney() throws InterruptedException {
        UserSelectsMonitor();
        String getmonitorprice = UserSelectsMonitorPrice();
        UserSelectsASusMonitor();
        UserSelectsAddToCartMonitor();

        return getmonitorprice;
    }


}



