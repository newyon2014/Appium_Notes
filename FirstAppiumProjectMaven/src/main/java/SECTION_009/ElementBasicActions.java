package SECTION_009;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.time.Duration;

public class ElementBasicActions {
    /*  ****************************************************************************************
     *  **************************   WHAT IS INCLUDED AND NOTES   ******************************
     *  ****************************************************************************************
     *         - Basic Actions
     *               - Click,
     *               - SendKeys,
     *               - Clear,
     *  *****************************************************************************************/
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        By views = MobileBy.AccessibilityId("Views");
        By textFields = MobileBy.AccessibilityId("TextFields");
        By editText = MobileBy.id("io.appium.android.apis:id/edit");

        driver.findElement(views).click();

        // Performing the scroll method three times. Below code is not optimized

        (new TouchAction(driver))
                .press(new PointOption().withCoordinates(507, 1679))
                //.press(PointOption.point(507,1679))
                //.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                  .moveTo(new PointOption().withCoordinates(520, 625))
                //.moveTo(PointOption.point(520,625))
                .release()
                .perform();

        (new TouchAction(driver))
                .press(new PointOption().withCoordinates(494, 1713))
                .moveTo(new PointOption().withCoordinates(499, 560))
                .release()
                .perform();

        (new TouchAction(driver))
                .press(new PointOption().withCoordinates(503, 1713))
                .moveTo(new PointOption().withCoordinates(494, 525))
                .release()
                .perform();

        driver.findElement(textFields).click();
        driver.findElement(editText).sendKeys("my text");
        Thread.sleep(3000);
        driver.findElement(editText).clear();
    }
}


