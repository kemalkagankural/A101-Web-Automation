package pages;

import enitities.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ElementHelper;

public class CartPage {

    By count_product = By.xpath("//div[@class='product-quantity js-counter-quantity']//input[@value]");
    By continue_WM_Button = By.xpath("//*[@class='auth__form__proceed js-proceed-to-checkout-btn']");
    By color_product = By.xpath("//span[text()='SİYAH']");
    By go_to_payment = By.xpath("//*[@class='button green checkout-button block js-checkout-button']");
    By email_Area= By.xpath("//*[@name='user_email']");
    By continue_Button = By.xpath("//*[@class='button block green']");

    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Actions action;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.action = new Actions(driver);
    }

    public void checkProductInformations(Product product) {
        Assert.assertTrue(elementHelper.getText(color_product).contains(product.getProductColor()));
        Assert.assertTrue(product.getProductCount().contains(elementHelper.getAttribute(count_product, "value")));
    }

    public void goToPayment() {
        elementHelper.findElementEnable(go_to_payment).click();
    }

    public void clickContinueWMButton() {
        elementHelper.findElementEnable(continue_WM_Button).click();
    }

    public void writeEmail(String email){
        elementHelper.sendKey(email_Area,email);
    }

    public void clickContinueButton(){
        elementHelper.findElementEnable(continue_Button).click();
    }
}

