package lt.techin.pavels.kopencart.test;

import lt.techin.pavels.kopencart.utils.Utils;
import lt.techin.pavels.kopencart.page.HomePage;
import lt.techin.pavels.kopencart.page.QAstuffPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class QAstuffTest extends BaseTest {
    private HomePage homePage;
    private QAstuffPage qAstuffPage;

    @BeforeEach
    void setupQAstuffTest() {
        homePage = new HomePage(driver);
        qAstuffPage = new QAstuffPage(driver);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
//    @Test
    void productIsDisplayed(String productName) {
//    void productIsDisplayed() {
//        String productName = "Code Confusion Raccoon";
        homePage.clickLinkQA();
        qAstuffPage.clickButtonList();
        assertTrue(qAstuffPage.productIsDisplayed(productName), productName + " does not exits in the shop");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    void productAddAlertIsDisplayed(String productName) {
        homePage.clickLinkQA();
        qAstuffPage.clickButtonList();
        qAstuffPage.clickProduct(productName);
        qAstuffPage.enterQuantity(Utils.generateRandomNrFrom1To20());

        qAstuffPage.clickButtonAddToCart();
        String expectedAlertText = "You have added " + productName + " to your shopping cart!";
        assertTrue(qAstuffPage.isAlertContainingTextDisplayed(expectedAlertText), "Expected visible alert with text : " + expectedAlertText);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    void addProductDisplayedChangeInCartDropdown(String productName) {
        homePage.clickLinkQA();
        qAstuffPage.clickButtonList();
        qAstuffPage.clickProduct(productName);
        int randomNumber =Utils.generateRandomNrFrom1To20();
        qAstuffPage.enterQuantity(randomNumber);
        qAstuffPage.clickButtonAddToCart();
        qAstuffPage.clickButtonCloseAlert();
        double expectedCartSum = qAstuffPage.getItemPrice() * randomNumber;
        System.out.println("item price: "+qAstuffPage.getItemPrice());
        System.out.println("item quantity: "+randomNumber);
        System.out.println("expected cart sum: "+expectedCartSum);
        qAstuffPage.clickDropDownCart();
        double actualCartSum = qAstuffPage.getCartItemTotalPrice();
        assertEquals(expectedCartSum, actualCartSum,0.01);

//        String cartTextBefore = qAstuffPage.getCartDropdownButtonText();
//        qAstuffPage.clickButtonAddToCart();
//        String cartTextAfter = qAstuffPage.getCartDropdownButtonText();
//
//        assertNotEquals(cartTextBefore, cartTextAfter, "Expected cart button text to change");

    }
//    void addToCart(){
//
//    }

}
