package lt.techin.pavels.kopencart.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy ( xpath = "//a[text()='QA']")
    private WebElement linkQA;
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void clickLinkQA (){
        linkQA.click();
    }
}
