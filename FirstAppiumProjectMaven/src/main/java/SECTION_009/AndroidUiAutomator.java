package SECTION_009;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;

public class AndroidUiAutomator {
    /*  ****************************************************************************************
     *  **************************   WHAT IS INCLUDED AND NOTES   ******************************
     *  *****************************************************************************************
     *         - findElementByAndroidUIAutomator Options - Native Techniques
     *               - By Text - "new UiSelector().text(\"Accessibility\")"
     *               - By Text StartsWith -  "new UiSelector().textStartsWith(\"A\")"
     *               - By Text Contains - "new UiSelector().textContains(\"Accessibility\")"
     *               - By Text Matches - "new UiSelector().textMatches(\"\\w+\\s{1}\\w+\\\")"
     *               - By Class Name - "new UiSelector().className(\"android.widget.TextView\")"
     *               - By Description - "new UiSelector().description(\"Accessibility\")"
     *               - By Resource ID - "new UiSelector().resourceId(\"android:id/text1\")"
     *  *****************************************************************************************/

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        MobileElement myElementText = (MobileElement) ((FindsByAndroidUIAutomator) driver)
                .findElementByAndroidUIAutomator("new UiSelector().text(\"Accessibility\")");
        System.out.println(myElementText.getText());

        MobileElement myElementTextStartsWith = (MobileElement) ((FindsByAndroidUIAutomator) driver)
                .findElementByAndroidUIAutomator("new UiSelector().textStartsWith(\"A\")");
        System.out.println(myElementTextStartsWith.getText());

        MobileElement myElementTextContains = (MobileElement) ((FindsByAndroidUIAutomator) driver)
                .findElementByAndroidUIAutomator("new UiSelector().textContains(\"Accessibility\")");
        System.out.println(myElementTextContains.getText());

        // The below example searches for all the elements where the visible text contains any two words
        // (with a single space between them)
        MobileElement myElementTextMatches = (MobileElement) ((FindsByAndroidUIAutomator) driver)
                .findElementByAndroidUIAutomator("new UiSelector().textMatches(\"\\w+\\s{1}\\w+\\\")");
        System.out.println(myElementTextMatches.getText());

        MobileElement myElementClassName = (MobileElement) ((FindsByAndroidUIAutomator) driver)
                .findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\")").get(2);
        System.out.println(myElementClassName.getText());

        MobileElement myElementDescription = (MobileElement) ((FindsByAndroidUIAutomator) driver)
                .findElementByAndroidUIAutomator("new UiSelector().description(\"Accessibility\")");
        System.out.println(myElementDescription.getText());

        MobileElement myElementResourceID = (MobileElement) ((FindsByAndroidUIAutomator) driver)
                .findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")").get(1);
        System.out.println(myElementResourceID.getText());
    }
}
