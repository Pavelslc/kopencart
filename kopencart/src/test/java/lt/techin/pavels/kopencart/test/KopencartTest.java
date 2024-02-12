package lt.techin.pavels.kopencart.test;

import lt.techin.pavels.kopencart.page.HomePage;
import lt.techin.pavels.kopencart.page.QAstuffPage;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KopencartTest {
    private WebDriver driver;
    private HomePage homePage;
    private QAstuffPage qAstuffPage;

    @BeforeEach
    void setup() {
        driver= new ChromeDriver();
        homePage = new HomePage(driver);
        qAstuffPage = new QAstuffPage(driver);
        driver.get("http://192.168.88.86/");
        driver.manage().window().maximize();

    }
}
