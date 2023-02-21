import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSession {
    public static AppiumDriver initializeDriver(String platformName) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "nexus_5");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability("newCommandTimeout", 300);
        //launch avd automatically and close it automatically
        caps.setCapability("avd", "Nexus_5_API_29");
        //had to increase timeout from 180000 to 280000 to prevent 500 error
        caps.setCapability("avdLaunchTimeout", 280000);
        //for Windows users
        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
        //open previously installed app at a specific activity:
        //caps.setCapability("appPackage", "io.appium.android.apis");
        //caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
        //caps.setCapability("appActivity", "io.appium.android.apis.accessibility.CustomViewAccessibilityActivity");
        // "/Users/fieldemployee/IdeaProjects/FirstAppiumProject/src/main/resources/ApiDemos-debug.apk";
       //Install and lunch app:
        caps.setCapability(MobileCapabilityType.APP, appUrl);

        //need to use localhost or 127.0.0.1, not 0.0.0.0 to fix "no session" error
        URL url = new URL("http://localhost:4723/wd/hub");

        return new AndroidDriver(url, caps);
        // System.out.println("session id: " + driver.getSessionId());
       // return driver;
    }

    
}
