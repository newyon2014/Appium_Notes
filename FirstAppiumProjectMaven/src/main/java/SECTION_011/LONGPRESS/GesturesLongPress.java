package SECTION_011.LONGPRESS;

import SECTION_011.CreateDriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

class GesturesLongPress {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By accessibility = MobileBy.AccessibilityId("Activity Indicators");

        TouchAction t = new TouchAction(driver);

        t.longPress(ElementOption.element(driver.findElement(accessibility)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000)))
                .release()
                .perform();

        // Using LongPressOptions class
        t.longPress(LongPressOptions.longPressOptions().
                withElement(ElementOption.element(driver.findElement(accessibility))))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000)))
                .release()
                .perform();

        // OPTION II - Importing Element Option and waitOption statically
/*        t.longPress(element(driver.findElement(accessibility)))
                .waitAction(waitOptions(Duration.ofMillis(5000)))
                .release()
                .perform();*/
    }
}
//TAP, PRESS, LONGPRESS, WAITACTION, RELEASE, PERFORM, MOVETO
