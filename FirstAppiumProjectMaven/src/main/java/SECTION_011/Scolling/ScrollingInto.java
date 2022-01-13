package SECTION_011.Scolling;

import SECTION_009.CreateDriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class ScrollingInto {
    /*  ****************************************************************************************
     *  **************************   WHAT IS INCLUDED AND NOTES   ******************************
     *  ****************************************************************************************
     *         - Component of the UIScrollable
     *            - Identifier for the scrollable container (this is common across all the
     *              methods, as this is the list in which the code would scroll to find the element
     *            - need to provide only one property of the element where you want to scroll
     *  *****************************************************************************************/
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");

        //Identify Elememt using Text
        String containerElement = "'com.android.vending:id/data_view'";
        String UiSelectorContainer = "new UiSelector().resourceId(" + containerElement + ")";
        String targetElementToScroll = "'Unblock Me FREE'";
        String UiSelectorTarget = "new UiSelector().text("+ targetElementToScroll + ")";
        System.out.println(UiSelectorContainer);
        System.out.println(UiSelectorTarget);

        //OPTION I
        MobileElement elementOptimized = (MobileElement) driver.
                findElement(MobileBy.AndroidUIAutomator("new UiScrollable("+ UiSelectorContainer + ")" +
                ". scrollIntoView("+ UiSelectorTarget + ")"));

        // OPTION II
        MobileElement element = (MobileElement) driver.
                findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId " +
                        "(\"com.android. vending:id/data_ view\")). scrollIntoView("+ "new UiSelector().text(\"Unblock Me FREE\"))"));

        //OR

        //Identify Element using Content Description
        MobileElement elementByContentDescription = (MobileElement) driver.
                findElement(MobileBy.AndroidUIAutomator("new UiScrollable (new UiSelector().resourceId(\"com.android.vending:id/data_view\"))" +
                        ".scrollIntoView("+ "new UiSelector().description(\"App: Unblock Me FREE\"))"));

       // Perform the action on the element
        System.out.println(element.getLocation());


    }
}
