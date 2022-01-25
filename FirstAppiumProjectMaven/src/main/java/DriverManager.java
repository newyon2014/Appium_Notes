import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverManager {
    static AppiumDriver driver;

    public static void initializeDriver(){
        DesiredCapabilities caps = new DesiredCapabilities();
        driver = new AppiumDriver(caps);
    }

    public static AppiumDriver getDriver(){
        return driver;
    }
}
