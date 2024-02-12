package lt.techin.pavels.kopencart.test;

import lt.techin.pavels.kopencart.page.HomePage;
import lt.techin.pavels.kopencart.page.QAstuffPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QAstuffTest extends BaseTest {
    private WebDriver driver;
    private HomePage homePage;
    private QAstuffPage qAstuffPage;

    @BeforeEach
    void setup() {
        homePage = new HomePage(driver);
        qAstuffPage = new QAstuffPage(driver);
        homePage.clickLinkQA();
        qAstuffPage.clickButtonList();
    }
    @ParameterizedTest
    void 

}
