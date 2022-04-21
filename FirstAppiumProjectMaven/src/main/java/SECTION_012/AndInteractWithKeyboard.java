package SECTION_012;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AndInteractWithKeyboard {
    /*  ****************************************************************************************
     *  **************************   WHAT IS INCLUDED AND NOTES   ******************************
     *  ****************************************************************************************
     *         - Android application examples
     *         - Key Event is a native android
     *         - Why we need to test keyboard? To check if keyboard is shown/displayed or not and also keyboard is interactable
     *         - Some Key events
     *             - Check if keyboard is present or not
     *             - Sending 'CAB' character sequence
     *             - Hiding keyboard
     *             - To put application in background
     *             - Open inbuilt in application.Example:- calendar
     *             - Selenium Option - Not used to send character sequences
     *  *****************************************************************************************/

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By views = MobileBy.AccessibilityId("Views");
        By textFields = MobileBy.AccessibilityId("TextFields");
        By editText = MobileBy.id("io.appium.android.apis:id/edit");

        driver.findElement(views).click();

        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int endX = startX;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        for(int i=0;i<3;i++){
            TouchAction t = new TouchAction(driver);
            t.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(PointOption.point(endX, endY))
                    .release()
                    .perform();
        }

        driver.findElement(textFields).click();
        driver.findElement(editText).click();
        Thread.sleep(3000);

        //Check if keyboard is present or not
        System.out.println(((AndroidDriver) driver).isKeyboardShown());

        //Sending 'CAB' character sequence
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.C));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.A));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.B));
        Thread.sleep(3000);

        //Hiding keyboard
        driver.hideKeyboard();

        // To put application in background
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.HOME));

        // Open inbuilt in application.Example:- calendar
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.CALENDAR));

        // Selenium Option - Not used to send character sequences
        driver.getKeyboard().pressKey(Keys.PAGE_DOWN);
        driver.getKeyboard().pressKey(Keys.HOME);
        driver.getKeyboard().pressKey(Keys.ARROW_DOWN);
    }
}

