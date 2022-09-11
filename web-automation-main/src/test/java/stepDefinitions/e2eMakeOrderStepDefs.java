package stepDefinitions;

import enitities.Product;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang.RandomStringUtils;
import pages.*;
import util.DriverFactory;

public class e2eMakeOrderStepDefs {
    Product product = new Product();
    HomePage homePage = new HomePage(DriverFactory.getDriver());
    ProductPage productPage = new ProductPage(DriverFactory.getDriver());
    CartPage cartPage = new CartPage(DriverFactory.getDriver());
    PaymentPage paymentPage = new PaymentPage(DriverFactory.getDriver());


    @When("focus {string} category")
    public void focusCategory(String categoryName) {
        homePage.checkHomePage();
        homePage.focusCategory(categoryName);
    }

    @And("click {string} branch")
    public void clickBranch(String branchName) {
        homePage.clickBranch(branchName);
    }

    @Then("user see products")
    public void userSeeProducts() {
        productPage.productsListed();
    }

    @When("click a product")
    public void clickAProduct() {
        productPage.clickProduct();
        product = productPage.getProductInformation(product);
    }

    @And("click add to basket")
    public void clickAddToBasket() {
        productPage.clickAddToBasket();
    }



    @And("filter {string} color")
    public void filterColor(String colorName) {
        productPage.scrollToElementColor();
        productPage.selectColor(colorName);
    }

    @And("go to cart")
    public void goToCart() {
        homePage.goToCart();
    }

    @When("go to payment phase")
    public void goToPaymentPhase() {
        cartPage.goToPayment();
    }

    @Then("click continue without a member")
    public void clickToContinueWMButton() {
        cartPage.clickContinueWMButton();
    }

    @And("write {string}")
    public void writeEmail(String email) {
        cartPage.writeEmail(email);
    }

    @And("click continue button")
    public void clickContinueButton() {
        cartPage.clickContinueButton();
    }

    @And("click create new Address")
    public void createNewAddress() {
        paymentPage.clickCreateNewAddress();
    }

    @And("fill {string},{string},{string},{string},{string},{string},{string} informations")
    public void fillAddressInformations(String adressheader, String name, String surname, String phone, String city, String town, String neighbourhood) {
        String address = RandomStringUtils.randomAlphabetic(20).toUpperCase();
        paymentPage.fillNewAddress(adressheader, name, surname, phone, city, town, neighbourhood, address);
    }

    @And("select cargo option")
    public void selectCargoOption() {
        paymentPage.selectCargo();
    }

    @Then("click save&continue button")
    public void clickSaveContinueButton() {
        paymentPage.clickSaveAndContinue();
    }

    @Then("user should see payment screen")
    public void userShouldSeePaymentScreen() {
        paymentPage.assertPaymemtUrl();
        paymentPage.clickCompleteOrderButton();
    }

    @Given("user is opened A101 Website")
    public void userIsOpenedA101Website() {
        homePage.checkHomePage();
        homePage.acceptCookies();
    }

    @Then("user verifies  product information that price,product code,{string},{string}, is correct on cart")
    public void userVerifiesProductInformationThatPriceProductCodeIsCorrectOnCart(String color, String count) {
        product.setProductCount(count);
        product.setProductColor(color);
        cartPage.checkProductInformations(product);
    }
}
