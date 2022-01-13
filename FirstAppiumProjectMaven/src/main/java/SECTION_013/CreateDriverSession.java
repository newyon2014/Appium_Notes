package SECTION_013;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class CreateDriverSession {

    public static AppiumDriver initializeDriver(String platformName) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        //     caps.setCapability("newCommandTimeout", 300);

        URL url = new URL("http://0.0.0.0:4723/wd/hub");

        switch (platformName) {
            case "Android":
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
                //               caps.setCapability(MobileCapabilityType.UDID, "803KPTM1660769");
                //       caps.setCapability("avd", "Pixel_3");
                //       caps.setCapability("avdLaunchTimeout", 180000);
                String andAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                        + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
                caps.setCapability("appPackage", "io.appium.android.apis");
                caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
                caps.setCapability(MobileCapabilityType.APP, andAppUrl);
//                caps.setCapability("chromedriverExecutableDir", "/Users/Om/Downloads/chromedriver");
//                caps.setCapability("unlockType", "pattern");
//                caps.setCapability("unlockKey", "125478963");
                return new AndroidDriver(url, caps);
            case "iOS":
//                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11");
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
//                caps.setCapability(MobileCapabilityType.UDID, "77F6B8F0-8877-4EDF-8C8C-99DBE64A93FF");
//                caps.setCapability(MobileCapabilityType.UDID, "913C24AE-C3B8-461E-B87D-30093CEAA006");
                caps.setCapability(MobileCapabilityType.UDID, "9527463259a2c083dfc8062535b699a52b9b3cf9");

                caps.setCapability("xcodeOrgId", "L8T9J4R323");
                caps.setCapability("xcodeSigningId", "iPhone Developer");
                String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                        + File.separator + "resources" + File.separator + "UIKitCatalog-iphonesimulator.app";
//                  caps.setCapability(MobileCapabilityType.APP, iOSAppUrl);
                caps.setCapability("simulatorStartupTimeout", 180000);
//                caps.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");
                caps.setCapability("bundleId", "com.ubercab.UberClient");
                caps.setCapability("includeSafariInWebviews", true);
                caps.setCapability("webviewConnectTimeout", "90000");
//                caps.setCapability("safariLogAllCommunication", true);
//                caps.setCapability("fullContextList", true);
//                caps.setCapability("additionalWebviewBundleIds", "process-SafariViewService");
                return new IOSDriver(url, caps);
            default:
                throw new Exception("invalid platform");
        }
    }
}
