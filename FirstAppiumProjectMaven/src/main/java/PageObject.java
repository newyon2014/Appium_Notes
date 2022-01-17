import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class PageObject extends BasePage {
   By e = MobileBy.AccessibilityId("accessibility");

    public void navigateToNextPage(){
        click(e);
    }
}
