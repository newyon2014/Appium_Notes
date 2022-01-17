package SECTION_013.HybridApp_Web_View.iOS;

import SECTION_013.CreateDriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebViewiOSSimAutomate {
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
     *            - caps.setCapability("webviewConnectTimeout", "90000");
     *         - The following capability type should be set to see all contexts in safari browser
     *            - caps.setCapability("includeSafariInWebviews", true);
     *         - Code below:
     *            - Get Context handles - native and WebView
     *            - Switch driver to the web context
     *  *****************************************************************************************/
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Dimension size = driver.manage().window().getSize();

        for(int i=0;i<1;i++){
            TouchAction t = new TouchAction(driver);
            t.press(PointOption.point(size.width / 2, (int) (size.height * 0.8)))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(PointOption.point(size.width / 2, (int) (size.height * 0.2)))
                    .release()
                    .perform();
        }
        driver.findElement(MobileBy.AccessibilityId("Web View")).click();

        //Getting all the list of applicable contexts - Natives and WebView
        Set<String> contextHandles = driver.getContextHandles();
        for(String contextHandle : contextHandles){
            System.out.println(contextHandle);
        }
        Thread.sleep(5000);

        // Switching to the WebView Context
            // Using a static name
               driver.context("WEBVIEW");
            // Using context generated at runtime - preferred
               driver.context(contextHandles.toArray()[1].toString());

        // By option is used because we are working on WebView element
        System.out.println(driver.findElement(By.cssSelector("body > h1")).getText());
        System.out.println(driver.findElement(By.xpath("//h1")).getText());
        System.out.println(driver.findElement(By.tagName("h1")).getText());

        // Switching back to native context from web context
        // In most cases , the value for the native context won't change
        driver.context("NATIVE_APP");
        driver.findElement(MobileBy.xpath("//XCUIElementTypeButton[@name=\"UIKitCatalog\"]")).click();
        driver.quit(); // Quits the driver immediately instead of waiting for default 60 sec
    }
}
