package SECTION_013.Browser;

import SECTION_013.HybridApp_Web_View.Android.CreateBrowserSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AndroidAutomateBrowser {
    /*  ************************************************************************************************
     *  **************************   WHAT IS INCLUDED AND NOTES   **************************************
     *  ************************************************************************************************
     *         - Use browser name capability with value Chrome or Chromium
     *         - ID / ClassName locators issue
     *              - locators won't work for chrome because it uses W3C standards by default
     *              - It will throw "Invalid Locator" Error
     *              - Appium doesn't convert locators internally due to limitations
     *              - This issue doesn't happen with selenium for desktop Chrome browser.Selenium internally
     *                converts locators to css
     *              - Workaround - converts all locators to CSS or XPath
     *         - The following capabilities are added to run chrome on Android real device
     *             -  caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
     *             -  caps.setCapability("chromedriverExecutable", "/Users/Om/Downloads/chromedriver");
     *                  - Use this capability if the chrome driver that comes with Appium is not compatible.
     *  ****************************************************************************************************/

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateBrowserSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://tesla.com");
        driver.findElement(By.xpath("//*[@id=\"tds-menu-header-main\"]/div[2]/div/label/span")).click();
        driver.findElement(By.xpath("//*[@id=\"tds-menu-header-main\"]/div[2]/div/nav/nav[2]/ol/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"tesla-hero-showcase-1838\"]/div/div[1]/div/div[2]/div/div[6]/a")).click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Select Your Car')]")));

        Dimension size = driver.manage().window().getSize();
        for(int i=0;i<2;i++){
            TouchAction t = new TouchAction(driver);
            t.press(PointOption.point(size.width / 2, (int) (size.height * 0.8)))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(PointOption.point(size.width / 2, (int) (size.height * 0.2)))
                    .release()
                    .perform();
        }
//        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[@class='tds-btn tds-btn tds-btn--blue tds-btn--large']")
        )).click();
    //    driver.findElement(By.xpath("//button[@class='tds-btn tds-btn tds-btn--blue tds-btn--large']")).click();

        WebElement element = driver.findElement(By.xpath("//*[@id=\"FIRST_NAME\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.sendKeys("Omprakash");
    }
}
