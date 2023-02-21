import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AndroidUiAutomator {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        WebElement myElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/list\")"));

        List<WebElement> childElements = myElement.findElements(By.className("android.widget.TextView"));
        WebElement mainElement = childElements.get(1);
        System.out.println(mainElement.getText());

        childElements = myElement.findElements(By.id("android:id/text1"));
        mainElement = childElements.get(1);
        System.out.println(mainElement.getText());

        myElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
        System.out.println(myElement.getText());


        myElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Accessibility\")"));
        //myElement1 = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\")");
        System.out.println(myElement.getText());

//        WebElement myElement = (WebElement) driver.findElement(AppiumBy.accessibilityId("Accessibility"));
//        System.out.println(myElement.getText());
//
//        myElement = (WebElement) driver.findElement(AppiumBy.id("android:id/text1"));
//        System.out.println(myElement.getText());
//
//        myElement = (WebElement) driver.findElement(AppiumBy.className("android.widget.TextView"));
//        System.out.println(myElement.getText());
//
//        myElement = (WebElement) driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]"));
//        System.out.println(myElement.getText());
//
//        myElement = (WebElement) driver.findElement(AppiumBy.xpath("//*[@text=\"Accessibility\"]"));
//        System.out.println(myElement.getText());

        // error: Exception in thread "main" org.openqa.selenium.InvalidSelectorException: Locator Strategy 'name' is not supported for this session
//        myElement = (WebElement) driver.findElement(AppiumBy.name("Accessibility"));
//        System.out.println(myElement.getText());


    }

}
