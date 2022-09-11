package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import util.ElementHelper;

public class HomePage {

    By main_logo= By.xpath("//div[@class='container']//a[@class='logo']");
    By section_category =  By.xpath("//*[@title='GİYİM & AKSESUAR']");
    By section_branch =  By.xpath("//*[@title='Dizaltı Çorap']");
    By btn_cart= By.xpath("//*[@class='go-to-shop']");
    By btn_accept_cookies= By.xpath("//*[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']");


    WebDriver driver;
    ElementHelper elementHelper;
    Actions action;
    FluentWait wait ;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait(driver);
        this.elementHelper = new ElementHelper(driver);
        this.action = new Actions(driver);
    }

    public void checkHomePage() {
        elementHelper.checkElementVisible(main_logo);
    }
    public void focusCategory(String categoryName) {
        elementHelper.checkElementWithText(section_category,categoryName);
        elementHelper.focusElementWithText(section_category,categoryName);
    }

    public void clickBranch(String branchName) {
        elementHelper.checkElementWithText(section_branch,branchName);
        elementHelper.clickElementWithText(section_branch,branchName);
    }

    public void goToCart() {
        elementHelper.findElementEnable(btn_cart);
        elementHelper.click(btn_cart);
    }

    public void acceptCookies(){
        elementHelper.findElementEnable(btn_accept_cookies);
        elementHelper.click(btn_accept_cookies);

    }
}
