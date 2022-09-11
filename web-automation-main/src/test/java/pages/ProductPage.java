package pages;

import enitities.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

public class ProductPage {

    By section_color_filter = By.xpath("//div[text()='Renk']");
    By btn_color_option = By.xpath("//label[@for='attributes_integration_colourSİYAH']");
    By img_product = By.className("product-list-general");
    By code_product  = By.xpath("//div[@class='product-code']");
    By price_product = By.xpath("//div[@class='price single']");
    By add_to_basket = By.xpath("//*[@class='add-to-basket button green block with-icon js-add-basket']");
    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Actions action;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.action = new Actions(driver);
    }

    public void scrollToElementColor() {
        elementHelper.scrollToElement(elementHelper.findElement(section_color_filter));
    }
    public void selectColor(String colorName) {
        if(elementHelper.findElementEnable(btn_color_option).isDisplayed()){
            elementHelper.checkElementWithText(btn_color_option,colorName);
            elementHelper.clickElementWithText(btn_color_option,colorName);
        }
    }

    public void productsListed() {
        elementHelper.checkElementVisible(img_product);
    }

    public void clickProduct() {
        elementHelper.findFirstElement(img_product).click();
    }

    public Product getProductInformation(Product product) {
        elementHelper.exist(code_product);
        product.setProductCode(elementHelper.findFirstElement(code_product).getText());
        if(elementHelper.exist(price_product)){
            product.setProductPrice(elementHelper.findElementEnable(price_product).getText());
        }
        else{
            String error_Message="Have any problem!";
            throw new Error(error_Message);
        }
        return product;
    }
    public void clickAddToBasket() {
        elementHelper.checkElementVisible(add_to_basket);
        elementHelper.click(add_to_basket);
    }
}