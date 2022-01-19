package SECTION_009;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByIosNSPredicate;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class iOSPredicateString {
    /*  ****************************************************************************************
     *  **************************   WHAT IS INCLUDED AND NOTES   ******************************
     *  ****************************************************************************************
     *         - https://developer.apple.com/library/archive/documentation/Cocoa/Conceptual/Predicates/Articles/pSyntax.html
     *         - https://github.com/facebookarchive/WebDriverAgent/wiki/Predicate-Queries-Construction-Rules
     *         - https://appiumpro.com/editions/8-how-to-find-elements-in-ios-not-by-xpath
     *         - Native framework locator
     *         - Faster than Xpath
     *         - Appium don't have to build XmL and traversing through XML to find element(s)
     *         - Appium sends the predicate string to the apple XCUI framework and framework find
     *           element respond back to Appium
     *         - Valid Ways Of Defining Elements
     *               - Using CONTAINS,
     *               - Using ==,
     *               - Using AND ==,
     *               - Using OR == (Single element)
     *               - Using OR == (Multiple elements)
     *               - Using BEGINSWITH
     *               - Using in Page Object FRAMEWORK
     *  *****************************************************************************************/

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");

        //Option I
        MobileElement myElement1 = (MobileElement) ((FindsByIosNSPredicate) driver)
                .findElementByIosNsPredicate("label CONTAINS \"Activity Indicators\"");
        System.out.println(myElement1.getText());

        //OR using the By class instead of the MobileElement
        By myElement3 = MobileBy.iOSNsPredicateString("label CONTAINS \"Activity Indicators\"");

        //Option II
        // using name in predicate string
        MobileElement myElement2WithName = (MobileElement) ((FindsByIosNSPredicate) driver)
                .findElementByIosNsPredicate("name == \"Activity Indicators\"");
        System.out.println(myElement2WithName.getText());

        // using name in Xpath
        MobileElement myElementWithXpath = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Activity Indicators\"]");
        System.out.println(myElementWithXpath.getText());

        //Option III
        MobileElement myElement4 = (MobileElement) ((FindsByIosNSPredicate) driver)
                .findElementByIosNsPredicate("type == \"XCUIElementTypeStaticText\" AND name == \"Activity Indicators\"");
        System.out.println(myElement4.getText());

        //Option IV
        MobileElement myElement5 = (MobileElement) ((FindsByIosNSPredicate) driver)
                .findElementByIosNsPredicate("type == \"XCUIElementTypeStaticText\" OR name == \"Activity Indicators\"");
        System.out.println(myElement5.getText());

        //Option V
        MobileElement myElement6 = (MobileElement) ((FindsByIosNSPredicate) driver)
                .findElementsByIosNsPredicate("name == \"Alert View\" OR name == \"Activity Indicators\"").get(0);
        System.out.println(myElement6.getText());

        //Option VI
        By myElement7 = MobileBy.iOSNsPredicateString("label BEGINSWITH \"Activity Indicators\"");

        //Option VII
    /*    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name CONTAINS[c] 'Activity Indicators'")
        public WebElement myElementUsingiOSNsPredicate;

        public void clickOnMyiOSText(){
            myElementUsingiOSNsPredicate.click();
        }*/






    }
}
