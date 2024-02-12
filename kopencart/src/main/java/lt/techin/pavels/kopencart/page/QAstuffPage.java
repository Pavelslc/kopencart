package lt.techin.pavels.kopencart.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QAstuffPage extends BasePage{
    @FindBy (css = "#button-list")
    private WebElement buttonList;
    public QAstuffPage(WebDriver driver) {
        super(driver);
    }
    public void clickButtonList(){
        buttonList.click();
    }
}
