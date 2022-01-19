package SECTION_009;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class FetchElementAttributes {
    /*  ****************************************************************************************
     *  **************************   WHAT IS INCLUDED AND NOTES   ******************************
     *  ****************************************************************************************
     *         - getAttribute("text")
     *             - is the same as getText() for Android
     *             - not applicable for iOS.Instead,use getAttribute("label")
     *         - getAttribute("checked")
     *             - not applicable for iOS. No attribute is available for iOS.
     *         - getAttribute("value")
     *             - not applicable for Android. No attribute is available for Android.
     *             - Example: Switch buttons on app. 1 for on and 0 for off.
     *         - getAttribute("enabled")
     *             - is the same as isEnabled() for Android
     *             - applicable for iOS.
     *         - getAttribute("selected")
     *             - is the same as  isSelected() for Android.
     *             - applicable for iOS.
     *         - getAttribute("displayed")
     *             - is not applicable for iOS.Instead,use getAttribute("visible")
     *         - isSelected()
     *             - applicable for both iOS and Android
     *         - isEnabled()
     *             - applicable for both iOS and Android
     *         - isDisplayed()
     *             - applicable for both iOS and Android
     *  *****************************************************************************************/

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");

        By accessibility = MobileBy.AccessibilityId("Activity Indicators");

        System.out.println("label:" + driver.findElement(accessibility).getText());
        System.out.println("label:" + driver.findElement(accessibility).getAttribute("label"));
        System.out.println("value:" + driver.findElement(accessibility).getAttribute("value"));
        System.out.println("enabled:" + driver.findElement(accessibility).getAttribute("enabled"));
        System.out.println("selected:" + driver.findElement(accessibility).getAttribute("selected"));
        System.out.println("visible:" + driver.findElement(accessibility).getAttribute("visible"));

        System.out.println("selected:" + driver.findElement(accessibility).isSelected());
        System.out.println("enabled:" + driver.findElement(accessibility).isEnabled());
        System.out.println("displayed:" + driver.findElement(accessibility).isDisplayed());
    }
}
// How to fetch element attributes?