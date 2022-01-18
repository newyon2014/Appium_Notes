package SECTION_013.Browser;

import SECTION_013.CreateBrowserSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class iOSAutomateBrowser {
    /*  ************************************************************************************************
     *  **************************   WHAT IS INCLUDED AND NOTES   **************************************
     *  ************************************************************************************************
     *         - Developer mode is turned on be default for simulator
     *         - Verify for a real device Developer mode is turned on in your Safari preferences
     *           so that the remote debugger port is open
     *         - Turn on web inspector on iOS device(setting > safari > advance)
     *         - The following capabilities are added to run safari on iOS real device
     *             -  caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
     *             -  caps.setCapability("simulatorStartupTimeout", 180000);
     *  ****************************************************************************************************/

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateBrowserSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://tesla.com");
        driver.findElement(By.className("tds-menu-header-main--trigger_icon")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"tds-menu-header-main\"]/div[2]/div/nav/nav[2]/ol/li[3]/a")).click();
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//*[@id=\"tesla-hero-showcase-1838\"]/div/div[1]/div/div[2]/div/div[6]/a"))).click();
  //      driver.findElement(By.xpath("//*[@id=\"tesla-hero-showcase-1838\"]/div/div[1]/div/div[2]/div/div[6]")).click();
        Thread.sleep(3000);
        Dimension size = driver.manage().window().getSize();

        for(int i=0;i<1;i++){
            TouchAction t = new TouchAction(driver);
            t.press(PointOption.point(size.width / 2, (int) (size.height * 0.8)))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(PointOption.point(size.width / 2, (int) (size.height * 0.2)))
                    .release()
                    .perform();
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div/div[3]/button")).click();

        Thread.sleep(3000);
        WebElement element = driver.findElement(By.id("FIRST_NAME"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        Thread.sleep(3000);
        element.sendKeys("Omprakash");


    }
}
