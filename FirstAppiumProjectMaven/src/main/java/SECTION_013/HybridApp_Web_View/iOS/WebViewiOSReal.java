package SECTION_013.HybridApp_Web_View.iOS;

import SECTION_013.CreateDriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebViewiOSReal {
    /*  ****************************************************************************************
     *  **************************   WHAT IS INCLUDED AND NOTES   ******************************
     *  ****************************************************************************************
     *         - How to check a page or portion of the page is web view?
     *             - check in appium if the element selected has a class android.webkit.WebView name
     *               or in case of iOS WKWebView/XCUIElementTypeWebView
     *             - Debug flag for this page has to be set to true
     *         - iOS - Native locator strategy
     *         - The iOS web inspector is a better option than Native strategy
     *         - The following capability can be set for Appium to wait for WebView to load
     *           - caps.setCapability("webviewConnectTimeout", "90000");
     *         - The following capability type should be set to see all contexts in safari browser
     *            - caps.setCapability("includeSafariInWebviews", true);
     *         - Code below:
     *            - Get Context handles - native and WebView
     *            - Switch driver to the web context
     *  *****************************************************************************************/

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(MobileBy.AccessibilityId("Or connect using a social account.")).click();
        driver.findElement(MobileBy.AccessibilityId("Google")).click();
        Thread.sleep(5000); // Not needed as we are using the webviewConnectTimeout capability.

        //Getting all the list of applicable contexts - Natives and WebView
        Set<String> contextHandles = driver.getContextHandles();
        for(Object contextHandle: contextHandles){
            System.out.println(contextHandle.toString());
        }

        // Switching to the WebView Context
        // Using context generated at runtime - preferred
        driver.context(contextHandles.toArray()[1].toString());
        System.out.println(driver.findElement(By.cssSelector("#headingText > span")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"headingText\"]/span")).getText());

        // Switching back to native context from web context
        // In most cases , the value for the native context won't change
        driver.context("NATIVE_APP");
        driver.quit();
    }
}
