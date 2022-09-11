package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ElementHelper;

public class PaymentPage {
    By create_new_address_Button= By.xpath("//*[@class='new-address js-new-address']");
    By address_header=By.xpath("//input[@name='title']");
    By name=By.xpath("//input[@name='first_name']");
    By surname=By.xpath("//input[@name='last_name']");
    By phone= By.xpath("//input[@name='phone_number']");
    By cities=By.xpath("//select[@class='js-cities']");
    By towns = By.xpath("//select[@class='js-township']");
    By neighbourhood = By.xpath("//select[@class='js-district']");
    By adress= By.xpath("//textarea[@class='js-address-textarea']");
    By save_button = By.xpath("//*[@class='button green js-set-country js-prevent-emoji']");
    By cargo_list = By.xpath("//*[@class='js-checkout-cargo-item']");
    By saveandcontinue_button=By.xpath("//*[@class='button block green js-proceed-button']");
    String payment_url="https://www.a101.com.tr/orders/checkout/";
    By completeorder_button=By.xpath("//div[@class='js-complete-with-masterpass']//button[@class='button block green continue-button']");
    By errorMessage=By.xpath("//div[@class='installment-area']//span[@class='error']");

    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Actions action;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.action = new Actions(driver);
    }
    public void assertPaymemtUrl() {
        elementHelper.assertUrl(payment_url);
    }
    public void clickCreateNewAddress(){
        elementHelper.findElementEnable(create_new_address_Button).click();
    }
    public void fillNewAddress(String addressheader,String Name,String Surname,String Phone,String City,String Town,String Neighbourhood,String Address){
        elementHelper.findElementEnable(address_header).click();
        elementHelper.sendKey(address_header,addressheader);
        elementHelper.findElementEnable(name).click();
        elementHelper.sendKey(name,Name);
        elementHelper.findElementEnable(surname).click();
        elementHelper.sendKey(surname,Surname);
        elementHelper.findElementEnable(phone).click();
        elementHelper.sendKey(phone,Phone);
        Select city=new Select(driver.findElement(cities));
        city.selectByVisibleText(City);
        Select town= new Select(driver.findElement(towns));
        town.selectByVisibleText(Town);
        new Select(driver.findElement(neighbourhood)).selectByValue(Neighbourhood);
        elementHelper.findElementEnable(adress).click();
        elementHelper.sendKey(adress,Address);
        elementHelper.findElementEnable(save_button).click();
    }
    public void selectCargo(){
        elementHelper.findFirstElement(cargo_list).click();
    }
    public void clickSaveAndContinue(){
        elementHelper.findElementEnable(saveandcontinue_button).click();
    }
    public void clickCompleteOrderButton(){
        elementHelper.findElementEnable(completeorder_button).click();
        Assert.assertTrue(elementHelper.getText(errorMessage).contains("Lütfen kart seçin veya kart bilgisi girin."));


    }
}
