package lt.techin.pavels.kopencart.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class QAstuffPage extends BasePage{
    @FindBy (css = "#button-list")
    private WebElement buttonList;
    @FindBy (css = ".description")
    private List<WebElement> products;
    @FindBy (css = "#input-quantity")
    private WebElement inputQuantity;
    @FindBy (css = "#button-cart")
    private WebElement buttonAddToCart;
    @FindBy (css = "#alert")
    private WebElement alert;
    @FindBy (css = ".btn.btn-lg.btn-inverse.btn-block.dropdown-toggle")
    private WebElement buttonDropDownCart;
    public QAstuffPage(WebDriver driver) {
        super(driver);
    }
    public void clickButtonList(){
        buttonList.click();
    }

    public boolean productIsDisplayed(String productName) {
         return products.stream().anyMatch(e -> e.getText().contains(productName));
    }
    public void clickProduct(String productName){
        driver.findElement(By.xpath("//*[contains(text(),'" + productName + "')]")).click();
    }
    public void enterQuantity(int quantity){
        inputQuantity.clear();
        inputQuantity.sendKeys(String.valueOf(quantity));
    }
    public void clickButtonAddToCart (){
        buttonAddToCart.click();
    }
    public boolean isAlertContainingTextDisplayed(String expectedAlertText) {
       return alert.getText().contains(expectedAlertText);
    }
    public String getCartDropdownButtonText(){
        return buttonDropDownCart.getText();
    }
}
