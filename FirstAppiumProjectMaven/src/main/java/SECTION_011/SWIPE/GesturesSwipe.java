package SECTION_011.SWIPE;

import SECTION_011.CreateDriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

class GesturesSwipe {
    // Swipe by coordinate is not recommended as screen resolution affects
    // the coordinate selection from one device to another

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By views = MobileBy.AccessibilityId("Views");
        By grid = MobileBy.AccessibilityId("Grid");
        By animation = MobileBy.AccessibilityId("Animation");
        driver.findElement(views).click();

        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int endX = startX;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        //Swipe by coordinates
        TouchAction t = new TouchAction(driver);
        t.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(endX, endY))
              //  .moveTo(new PointOption().withCoordinates(endX,endY)) // Another coding
                .release()
                .perform();

        //Swipe by Elements
        By steppers = MobileBy.AccessibilityId("Steppers");
        By activityIndicators = MobileBy.AccessibilityId("Activity Indicators");

        TouchAction t2 = new TouchAction(driver);
        t.press(ElementOption.element(driver.findElement(steppers))) // Start element
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(ElementOption.element(driver.findElement(activityIndicators))) // End element
                .release()
                .perform();

/*      int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);

        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

        new TouchAction(driver)
                .press(point(startX,startY))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(endX, endY))
                .release().perform();*/
    }
}
//TAP, PRESS, LONGPRESS, WAITACTION, RELEASE, PERFORM, MOVETO