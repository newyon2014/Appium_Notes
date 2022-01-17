package SECTION_013.HybridApp_Web_View.Android;

import SECTION_013.CreateDriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebViewInspectUsingAI {
    /*  ****************************************************************************************
     *  **************************   WHAT IS INCLUDED AND NOTES   ******************************
     *  ****************************************************************************************
     *         - How to check a page or portion of the page is web view?
     *             - check in appium if the element selected has a class android.webkit.WebView name
     *               or in case of iOS WKWebView/XCUIElementTypeWebView
     *             - Debug flag for this page has to be set to true
     *         - Android - using native locator strategy
     *         - iOS - Native locator strategy
     *         - Chrome remote debugger or the iOS web inspector is a better option than Native strategy
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

        //Android - Native locator strategy
        driver.findElement(MobileBy.AccessibilityId("WebView2")).click();
        Thread.sleep(3000);
        driver.findElement(MobileBy.xpath("//android.webkit.WebView/android.view.View[1]")).getText();

        //iOS - Native locator strategy
        driver.findElement(MobileBy.AccessibilityId("Web View")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(MobileBy.AccessibilityId("This is HTML content inside a WKWebView ."))
                .getAttribute("label"));

    }
}
