package SECTION_013.HybridApp_Web_View.Android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class CreateBrowserSession {

    public static AppiumDriver initializeDriver(String platformName) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
   //     caps.setCapability("newCommandTimeout", 300);

        URL url = new URL("http://0.0.0.0:4723/wd/hub");

        switch(platformName){
            case "Android":
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
                //       caps.setCapability("avd", "Pixel_3");
                //       caps.setCapability("avdLaunchTimeout", 180000);
                caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

                caps.setCapability("chromedriverExecutable", "/Users/Om/Downloads/chromedriver"); // non-default directory setting for chrome driver executable download

//                caps.setCapability("chromedriverExecutableDir", "/Users/Om/Downloads/ChromeDriverDir");
                return new AndroidDriver(url, caps);
            case "iOS":
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                caps.setCapability(MobileCapabilityType.UDID, "9527463259a2c083dfc8062535b699a52b9b3cf9");
                caps.setCapability("simulatorStartupTimeout", 180000);
                caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
                return new IOSDriver(url, caps);
            default:
                throw new Exception("invalid platform");
        }
    }
}
