package SECTION_009;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AndroidFindElements {
    /*  ****************************************************************************************
     *  **************************   WHAT IS INCLUDED AND NOTES   ******************************
     *  ****************************************************************************************
     *           - Linked Test , name , tag name are not applicable for Mobile automation
     *           - Most of the xPaths created by Appium are not optimized
     *           - XPath is much less reliable among the rest of the Android locators
     *           - findElementBy Options
     *               - By AccessibilityId - "new UiSelector().text(\"Accessibility\")"
     *               - By Id -  "new UiSelector().textStartsWith(\"A\")"
     *               - By Class Name - "new UiSelector().className(\"android.widget.TextView\")"
     *               - By XPath - "new UiSelector().description(\"Accessibility\")"
     *  *****************************************************************************************/

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        MobileElement myElement = (MobileElement) driver.findElementByAccessibilityId("Accessibility");
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementsById("android:id/text1").get(1);
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementsByClassName("android.widget.TextView").get(2);
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Accessibility\"]");
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementByXPath("//*[@text=\"Accessibility\"]");
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementByTagName("Accessibility");
        System.out.println(myElement.getText());

    }
}
