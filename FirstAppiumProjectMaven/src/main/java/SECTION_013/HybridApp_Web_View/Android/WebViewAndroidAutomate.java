package SECTION_013.HybridApp_Web_View.Android;

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

public class WebViewAndroidAutomate {
    /*  ****************************************************************************************
     *  **************************   WHAT IS INCLUDED AND NOTES   ******************************
     *  ****************************************************************************************
     *         - Chrome remote debugger is a better option than Native android strategy
     *         - See screenshot for Chrome remote debugger steps ( Emulator and real device)
     *         - No difference between Emulator and real device when using the chrome debugger
     *         - Debug mode setWebContentsDebuggingEnabled property should be set to True for the
     *           hybrid application.
     *         - Code below:
     *            - Get Context handles - native and WebView
     *            - Switch driver to the web context
     *
     *  *****************************************************************************************/

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(MobileBy.AccessibilityId("Views")).click();

        Dimension size = driver.manage().window().getSize();

        for(int i=0;i<4;i++){
            TouchAction t = new TouchAction(driver);
            t.press(PointOption.point(size.width / 2, (int) (size.height * 0.8)))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(PointOption.point(size.width / 2, (int) (size.height * 0.2)))
                    .release()
                    .perform();
        }

        driver.findElement(MobileBy.AccessibilityId("WebView")).click();

        //Getting all the list of applicable contexts - Natives and WebView
        Set<String> contextHandles = driver.getContextHandles();
        for(String contextHandle : contextHandles){
            System.out.println(contextHandle);
        }
        // Switching to the WebView Context
            // Using a static name
               driver.context("WEBVIEW");
            // Using context generated at runtime - preferred
               driver.context(contextHandles.toArray()[1].toString()); // Zeroth Position - Native context and First position - Web View context

        System.out.println(driver.findElement(By.cssSelector("body > h1")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"i_am_a_textbox\"]")).getText());

        // Switching back to native context from web context
        driver.context("NATIVE_APP");
    }
}
