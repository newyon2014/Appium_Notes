package SECTION_011.TAP;

import SECTION_011.CreateDriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

class GesturesTap_PointOptions {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By accessibility = MobileBy.AccessibilityId("Accessibility");

        TouchAction t = new TouchAction(driver);

        // Without the use of TapOption.tapOption() --> Check GesturesTap_TapOptions.java for TapOption usage
       t.tap(PointOption.point(538, 416))
               .perform();

    }
}
//TAP, PRESS, LONGPRESS, WAITACTION, RELEASE, PERFORM, MOVETO
