import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSession {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "nexus_5");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        //for windows users
        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
        // "/Users/fieldemployee/IdeaProjects/FirstAppiumProject/src/main/resources/ApiDemos-debug.apk";
        caps.setCapability(MobileCapabilityType.APP, appUrl);

        //need to use localhost or 127.0.0.1, not 0.0.0.0 to fix "no session" error
        URL url = new URL("http://localhost:4723/wd/hub");

        AppiumDriver driver = new AndroidDriver(url, caps);
    }


}

