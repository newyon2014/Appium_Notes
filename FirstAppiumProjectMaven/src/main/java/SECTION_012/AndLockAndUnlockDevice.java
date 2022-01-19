package SECTION_012;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AndLockAndUnlockDevice {
    /*  ****************************************************************************************
     *  **************************   WHAT IS INCLUDED AND NOTES   ******************************
     *  ****************************************************************************************
     *         - Interruption scenarios - ONLY available for Android
     *             - Lock device - forever or with Duration
     *             - Check if device is locked or not
     *             - Unlocked device
     *         -  Unlock using pin
     *         -  Unlock using Pattern
     *  *****************************************************************************************/

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Lock Device
        ((AndroidDriver) driver).lockDevice(); // forever until unlocked manually
        ((AndroidDriver) driver).lockDevice(Duration.ofMillis(5)); // for specified time

        //Check if device is locked or not
        System.out.println(((AndroidDriver) driver).isDeviceLocked());

        //Unlocked device
        ((AndroidDriver) driver).unlockDevice();

        //Pin
        //unlockType and unlockKey capability needed when drivers are initialized
        //caps.setCapability("unlockType", "pin");
        //caps.setCapability("unlockKey", "1111");
        ((AndroidDriver) driver).lockDevice();
        System.out.println(((AndroidDriver) driver).isDeviceLocked());
        ((AndroidDriver) driver).unlockDevice();

        //Pattern
        //unlockType and unlockKey capability needed when drivers are initialized
        //caps.setCapability("unlockType", "pattern");
        //caps.setCapability("unlockKey", "125478963");
        ((AndroidDriver) driver).lockDevice();
        System.out.println(((AndroidDriver) driver).isDeviceLocked());
        ((AndroidDriver) driver).unlockDevice();

    }
}

// lock, unlock, isDeviceLocked
