package SECTION_009;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class iOSFindElements {
    /*  ****************************************************************************************
     *  **************************   WHAT IS INCLUDED AND NOTES   ******************************
     *  ****************************************************************************************
     *         - Element ID - not used
     *         - Accessibility ID is most preferred,reliable and fast locator strategy. It's not set by default.
     *         - Value attribute is the same as the static text
     *         - Class attribute is begins with XCUIElementType and marked as Type attribute in Appium
     *         - Both ID and Name attribute uses the name attribute
     *         - Name attribute is the same as the label attribute if accessibility ID is not set
     *         - Name attribute is the same as the accessibility attribute if accessibility ID is set
     *         - Label attribute is the same as the static text
     *         - iOS Predicate String - uses native framework in JavaScript
     *         - Other attribute - Visible,enabled etc.
     *         - Invalid ways of defining elements - TagName, LinkedText/PartialLinkedText and CssSelector
     *         - Valid Ways Of Defining Elements
     *               - ByAccessibilityId,
     *               - ClassName,
     *               - ByName,
     *               - ById,
     *               - ByXPath,
     *               - ByTagName
     *  *****************************************************************************************/

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");

        MobileElement myElement = (MobileElement) driver.findElementByAccessibilityId("Activity Indicators");
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementsByClassName("XCUIElementTypeStaticText").get(1);
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementByName("Activity Indicators");
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementById("Activity Indicators");
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Activity Indicators\"]");
        System.out.println(myElement.getText());

        // Invalid
        myElement = (MobileElement) driver.findElementByTagName("Activity Indicators");
        System.out.println(myElement.getText());

    }
}
