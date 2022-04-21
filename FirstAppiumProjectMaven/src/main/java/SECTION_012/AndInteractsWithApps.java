package SECTION_012;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import io.appium.java_client.android.appmanagement.AndroidTerminateApplicationOptions;
import org.openqa.selenium.By;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AndInteractsWithApps {
    /*  ****************************************************************************************
     *  **************************   WHAT IS INCLUDED AND NOTES   ******************************
     *  ****************************************************************************************
     *         - Terminate app - OPTION I & Option II
     *         - Install app
     *             - Allow upgrade
     *             - Don't allow upgrade
     *             - Grant all required permission after installation
     *             - Don't Grant all required permission after installation
     *         - Check if application is installed or not
     *         - Put application in background
     *         - How to switch between apps
     *  *****************************************************************************************/

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By views = MobileBy.AccessibilityId("Views");
        driver.findElement(views).click();

        //Terminate
        //Option I - Moves the application to Background processes
        driver.terminateApp("io.appium.android.apis"); // App package - Android or Bundle ID - iOS

        //Option II - Moves the application to Background processes
        driver.terminateApp("io.appium.android.apis",
                            new AndroidTerminateApplicationOptions().withTimeout(Duration.ofSeconds(500)));

        //Install
        String andAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
        driver.installApp(andAppUrl,new AndroidInstallApplicationOptions().withReplaceEnabled());

        // Is installed ?
        driver.isAppInstalled("io.appium.android.apis");

        //Allow Upgrade
        driver.installApp(andAppUrl, new AndroidInstallApplicationOptions().withReplaceEnabled());

        // Put App to background
        driver.runAppInBackground(Duration.ofMillis(5000)); // should return the user state

        //No upgrade allowed
        driver.installApp(andAppUrl, new AndroidInstallApplicationOptions().withReplaceDisabled());

        //Grant all required permission after installation
        driver.installApp(andAppUrl, new AndroidInstallApplicationOptions().withGrantPermissionsEnabled());

        //Don't Grant all required permission after installation
        driver.installApp(andAppUrl, new AndroidInstallApplicationOptions().withGrantPermissionsDisabled());

        //Check application installed or not -
        // returns true if app is installed.Otherwise, false.
        System.out.println(driver.isAppInstalled("io.appium.android.apis"));

        //Put application in background
        driver.runAppInBackground(Duration.ofMillis(5000));

        // HOW TO SWITCH BETWEEN APPS
        //Terminate current application
        driver.terminateApp("io.appium.android.apis");
        Thread.sleep(5000);

        //Activate another application
        driver.activateApp("com.android.settings");
        Thread.sleep(5000);

        //Switch back to the original application
        driver.activateApp("io.appium.android.apis");
        Thread.sleep(5000);

        //Application state
        System.out.println(driver.queryAppState("io.appium.android.apis"));
    }
}
