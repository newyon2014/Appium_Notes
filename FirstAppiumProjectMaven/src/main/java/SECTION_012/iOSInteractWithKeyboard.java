package SECTION_012;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class iOSInteractWithKeyboard {
    /*  ****************************************************************************************
     *  **************************   WHAT IS INCLUDED AND NOTES   ******************************
     *  ****************************************************************************************
     *         - Sending character sequences using iOS keyboard
     *         - Hide Keyboard
     *         - Using selenium method
     *         - Closing Keyboard
     *  *****************************************************************************************/

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int endX = startX;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        for(int i=0;i<1;i++){
            TouchAction t = new TouchAction(driver);
            t.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(PointOption.point(endX, endY))
                    .release()
                    .perform();
        }

        driver.findElement(MobileBy.AccessibilityId("Text Fields")).click();
        driver.findElement(MobileBy.xpath("//XCUIElementTypeCell [1]/XCUIElementTypeTextField")).click();
        Thread.sleep(3000);

        // Sending character sequences using iOS keyboard
        driver.findElement(MobileBy.AccessibilityId("q")).click();
        driver.findElement(MobileBy.AccessibilityId("w")).click();
        driver.findElement(MobileBy.AccessibilityId("e")).click();
        Thread.sleep(3000);

        //Hide Keyboard
        //Works for simulator. For real device , might be unstable.
        driver.hideKeyboard();

        //Using selenium method
        driver.getKeyboard().pressKey(Keys.HOME);

        //Closing Keyboard
        driver.getKeyboard().pressKey(Keys.RETURN); // this one don't work as there is no return option on the iOS apps
        driver.findElement(MobileBy.AccessibilityId("Done")).click(); // this one will work


    }
}

