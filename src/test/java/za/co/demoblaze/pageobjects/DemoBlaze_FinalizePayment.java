package za.co.demoblaze.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import stepdefinitions.DemoBlaze_BaseClass;

public class DemoBlaze_FinalizePayment extends DemoBlaze_BaseClass {

    public DemoBlaze_FinalizePayment(WebDriver driver)
    {super(driver);}


    @FindBy(id = "name")
    @CacheLookup
    WebElement nameofclient;

    @FindBy(id = "country")
    @CacheLookup
    WebElement country;

    @FindBy(id = "city")
    @CacheLookup
    WebElement city;

    @FindBy(id = "card")
    @CacheLookup
    WebElement card;

    @FindBy(id = "month")
    @CacheLookup
    WebElement month;

    @FindBy(id = "year")
    @CacheLookup
    WebElement year;

    @FindBy(xpath = "//button[@onClick=\"purchaseOrder()\"]")
    @CacheLookup
    WebElement purchase;

    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    @CacheLookup
    WebElement confirmationofpurchase;

    @FindBy(css = ".lead")
    @CacheLookup
    WebElement getorderid;

    @FindBy(xpath = "//button[text()='OK']")
    @CacheLookup
    WebElement selectOKbtn;

    @FindBy(xpath = "//button[text()='Close']")
    @CacheLookup
    WebElement selectclose;

    @FindBy(id = "logout2")
    @CacheLookup
    WebElement logout2;




    public WebElement getNameofclient() {
        return nameofclient;
    }

    public WebElement getCountry() {
        return country;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getCard() {
        return card;
    }

    public WebElement getMonth() {
        return month;
    }

    public WebElement getYear() {
        return year;
    }

    public WebElement getPurchase() {
        return purchase;
    }

    public WebElement getConfirmationofpurchase() {
        return confirmationofpurchase;
    }

    public WebElement getGetorderid() {
        return getorderid;
    }


    public WebElement getSelectOKbtn() {
        return selectOKbtn;
    }

    public WebElement getSelectclose() {
        return selectclose; }

    public WebElement getLogout2() { return logout2; }

    public void UserCapturesDetails(String nameofclient, String country, String city, String card, String month, String year)
    {

        demoBlazeWaitforelement(getNameofclient());
        getNameofclient().click();
        getNameofclient().sendKeys(nameofclient);

        getCountry().click();
        getCountry().sendKeys(country);

        getCity().click();
        getCity().sendKeys(city);

        getCard().click();
        getCard().sendKeys(card);

        getMonth().click();
        getMonth().sendKeys(month);

        getYear().click();
        getYear().sendKeys(year);
    }

    public void UserSelectspurchase() throws InterruptedException {
        getPurchase().click();
        pauseApplication(3);

    }

    public void UserValidatesSuccessMessage()
    {
        demoblazeimplicitwait();
        demoBlazeWaitforelement(getConfirmationofpurchase());
        Assert.assertTrue( getConfirmationofpurchase().isDisplayed());

    }


    public String UserExtractsOrderid()
    {

        String orderid = getGetorderid().getText();
        String processedid = UserExtractsOrdreid(orderid);
        getSelectOKbtn().click();
        demoBlazeWaitforelement(getLogout2());
        getLogout2().click();
        return processedid;


    }

}
