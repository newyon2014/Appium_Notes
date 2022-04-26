package SECTION_013.HybridApp_Web_View.Android;

import io.appium.java_client.AppiumDriver;

import java.util.concurrent.TimeUnit;

public class AndroidAutomateBrowserChrome {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateBrowserSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://tesla.com");
    }
}
