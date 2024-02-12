package lt.techin.pavels.kopencart.test;
import lt.techin.pavels.kopencart.utils.Utils;
import lt.techin.pavels.kopencart.page.HomePage;
import lt.techin.pavels.kopencart.page.QAstuffPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QAstuffTest extends BaseTest {
    private HomePage homePage;
    private QAstuffPage qAstuffPage;

    @BeforeEach
    void setupQAstuffTest() {
        homePage = new HomePage(driver);
        qAstuffPage = new QAstuffPage(driver);
    }

//    @ParameterizedTest
//    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    @Test
//    void productIsDisplayed(String productName) {
        void productIsDisplayed() {
        String productName = "Code Confusion Raccoon";
        homePage.clickLinkQA();
        qAstuffPage.clickButtonList();
        assertTrue(qAstuffPage.productIsDisplayed(productName),productName+" does not exits in the shop");
        qAstuffPage.clickProduct(productName);
        qAstuffPage.enterQuantity(Utils.generateRandomNrFrom1To20());
        String cartTextBefore = qAstuffPage.getCartDropdownButtonText();
        qAstuffPage.clickButtonAddToCart();
        String expectedAlertText = "You have added " + productName + " to your shopping cart!";
        assertTrue(qAstuffPage.isAlertContainingTextDisplayed(expectedAlertText),"Expected visible alert with text : "+expectedAlertText);
        String cartTextAfter = qAstuffPage.getCartDropdownButtonText();
        assertNotEquals(cartTextBefore,cartTextAfter,"Expected cart button text to change");

    }
//    void addToCart(){
//
//    }

}
