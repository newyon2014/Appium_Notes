package SECTION_012;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class iOSInteractsWithApps {
    /*  ****************************************************************************************
     *  **************************   WHAT IS INCLUDED AND NOTES   ******************************
     *  ****************************************************************************************
     *         - Terminate Apps
     *         - Install Apps
     *         - Running application in background
     *         - Activate new apps after terminating current apps
     *         - Query application state
     *         - JavaScript options to interact with apps
     *  *****************************************************************************************/

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By activityIndicators = MobileBy.AccessibilityId("Activity Indicators");
        driver.findElement(activityIndicators).click();

        Thread.sleep(5000);

        //Terminate Apps
        driver.terminateApp("com.example.apple-samplecode.UICatalog");

        //Install Apps - ( for upgrade scenario - reinstall app)
        String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "UIKitCatalog-iphonesimulator.app";
        driver.installApp(iOSAppUrl);

        //Running application in background - maintains the application state
        driver.runAppInBackground(Duration.ofMillis(5000));

        //Activate new apps after terminating current apps - switching
        driver.terminateApp("com.example.apple-samplecode.UICatalog");
        driver.activateApp("com.apple.Preferences"); // setting application bundle ID
        Thread.sleep(5000);
        driver.activateApp("com.example.apple-samplecode.UICatalog");

        //Query application state
            //Gives application state as "RUNNING_IN_FOREGROUND"
               System.out.println(driver.queryAppState("com.example.apple-samplecode.UICatalog"));
               Thread.sleep(5000);
                driver.terminateApp("com.example.apple-samplecode.UICatalog");
            //Gives application state as "NOT_RUNNING"
               System.out.println(driver.queryAppState("com.example.apple-samplecode.UICatalog"));

        // JavaScript options to interact with apps
        Map<String, Object> params = new HashMap<>();
        params.put("bundleId", "com.example.apple-samplecode.UICatalog");

        final boolean isInstalled = (Boolean)driver.executeScript("mobile: isAppInstalled", params);
        System.out.println(isInstalled);
    }
}
