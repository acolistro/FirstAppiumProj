import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidGestures {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        longClickGesture(driver);
    }

    public static void longClickGesture(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        //accessibilityId would not work for dot, unable to locate
        WebElement element = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.view.View[1]"));

        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
           "elementId", ((RemoteWebElement) element).getId(),
//                use coordinates instead of center click:
//                "x",217,
//                "y",659,
                "duration", 1000
        ));
    }
}