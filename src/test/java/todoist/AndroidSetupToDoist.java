package todoist;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidSetupToDoist {
    protected AndroidDriver driver;

    protected void prepareAndroidForAppium() throws MalformedURLException {
        File appDir = new File("app");
        File app = new File(appDir, "com.todoist.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "pixel (Google)");
        capabilities.setCapability("deviceName", "Nexus_S_API_27");
        capabilities.setCapability("appActivity", "com.todoist.activity.HomeActivity");
        capabilities.setCapability("appPackage", "com.todoist");
        capabilities.setCapability("app", app.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
