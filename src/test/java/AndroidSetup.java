import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.io.File;
import java.net.URL;


public class AndroidSetup {

  protected AndroidDriver driver;

  protected void prepareAndroidForAppium() throws MalformedURLException {
    File appDir = new File("app");
    File app = new File(appDir, "splendo.apk");

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("device", "Android");
    capabilities.setCapability("deviceName", "emulator-5554");
    capabilities.setCapability("appActivity", "com.splendapps.splendo.MainActivity");
    capabilities.setCapability("appPackage", "com.splendapps.splendo");
    capabilities.setCapability("app", app.getAbsolutePath());

    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
  }

}
