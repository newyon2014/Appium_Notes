import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class BasePage {
    AppiumDriver driver;

    public BasePage (){
        this.driver = DriverManager.getDriver();
    }

    public void click(By e){
        driver.findElement(e).click();
    }
}
