package qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import qa.base.BaseTest;
import qa.base.DriverManager;
import qa.pages.LoginPage;
import qa.pages.ProductDetailsPage;
import qa.pages.ProductsPage;
import qa.ui.DeepLink;

public class ProductTests extends BaseTest {
    /*  ****************************************************************************************
     *  **************************   WHAT IS INCLUDED AND NOTES   ******************************
     *  ****************************************************************************************
     *         - Definitions
     *            -  deep linking consists of using a uniform resource identifier (URI) that links to a specific
     *               location within a mobile app rather than simply launching the app.
     *         - Deep link need to be implemented by the developer
     *         - Each screen can be opened directly with a deep link
     *             - Example : "swaglabs://swag-overview/0,5" ; PREFIX - swaglabs:// ; DEEPLINK - swag-overview/0,5
     *         - Can be done manually as well from the command prompt. see screen shot sample
     *         - OPTION I -
     *           - Implementation without application of deep links by Closing and opening app for each test method
     *           - This will slow down the automation effort specially if you have multiple test cases.
     *  *****************************************************************************************/

    //OPTION I
    @BeforeMethod
    public void beforeMethod(){
        DriverManager.getDriver().closeApp();
        DriverManager.getDriver().launchApp();
    }
    @Test
    public void validateProductOnProductsPage() {
        SoftAssert sa = new SoftAssert();
/*        ProductsPage productsPage = new LoginPage().login(loginUsers.getJSONObject("validUser").getString("username")
                , loginUsers.getJSONObject("validUser").getString("password"));*/
        DeepLink.OpenAppWith("swaglabs://swag-overview/0,5");
        ProductsPage productsPage = new ProductsPage();
        sa.assertEquals(productsPage.getSLBTitle(), strings.get("products_page_slb_title"));
        sa.assertEquals(productsPage.getSLBPrice(), strings.get("products_page_slb_price"));
        sa.assertAll();
    }

    @Test
    public void validateProductOnProductDetailsPage() {
/*        ProductsPage productsPage = new LoginPage().login(loginUsers.getJSONObject("validUser").getString("username")
                , loginUsers.getJSONObject("validUser").getString("password"));*/
        DeepLink.OpenAppWith("swaglabs://swag-overview/0,5");
        ProductsPage productsPage = new ProductsPage();
        ProductDetailsPage productDetailsPage = productsPage.pressSLBTitle();
        Assert.assertEquals(productDetailsPage.getSLBTitle(), strings.get("product_details_page_slb_title"));
    }
}
