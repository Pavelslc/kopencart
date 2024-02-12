package lt.techin.pavels.kopencart.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class QAstuffPage extends BasePage {
    @FindBy(css = "#button-list")
    private WebElement buttonList;
    @FindBy(css = ".description")
    private List<WebElement> products;
    @FindBy(css = "#input-quantity")
    private WebElement inputQuantity;
    @FindBy(css = "#button-cart")
    private WebElement buttonAddToCart;
    @FindBy(css = "#alert")
    private WebElement alert;
    @FindBy (css = ".btn-close")
    private WebElement buttonCloseAlert;
    @FindBy(css = ".btn.btn-lg.btn-inverse.btn-block.dropdown-toggle")
    private WebElement dropDownCart;
    @FindBy(css = ".price-new")
    private WebElement itemPrice;
    @FindBy(css = ".text-end:nth-of-type(4)")
    private WebElement cartItemTotalPrice;
    @FindBy(css = ".text-end:nth-of-type(3)")
    private WebElement cartItemTotalQuantity;
    @FindBy(css = ".text-start")
    private WebElement cartItemName;

    public QAstuffPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonList() {
        buttonList.click();
    }

    public boolean productIsDisplayed(String productName) {
        return products.stream().anyMatch(e -> e.getText().contains(productName));
    }

    public void clickProduct(String productName) {
//        wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(By.linkText(productName))));
        actions.moveToElement(driver.findElement(By.linkText(productName))).click().perform();
    }

    public void enterQuantity(int quantity) {
        inputQuantity.clear();
        inputQuantity.sendKeys(String.valueOf(quantity));


    }

    public void clickButtonAddToCart() {
        buttonAddToCart.click();
    }

    public boolean isAlertContainingTextDisplayed(String expectedAlertText) {
        wait.until(ExpectedConditions.elementToBeClickable(alert));
        return alert.getText().contains(expectedAlertText);
    }
    public void clickButtonCloseAlert(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonCloseAlert));
        buttonCloseAlert.click();
    }

    public String getCartDropdownButtonText() {
        return dropDownCart.getText();
    }

    public void clickDropDownCart() {
        wait.until(ExpectedConditions.elementToBeClickable(dropDownCart));
        dropDownCart.click();
    }

    public double getItemPrice() {
        return Double.parseDouble(itemPrice.getText().replace("$", ""));
    }

    public double getCartItemTotalPrice() {
        return Double.parseDouble(cartItemTotalPrice.getText().replace("$", ""));
    }
}
