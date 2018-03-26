package todoist;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ToDoistTests  extends AndroidSetupToDoist {
    String app_package_name = "com.todoist:id/";
    String TextView = "android.widget.TextView";

    By continueLogin = By.id(app_package_name + "btn_welcome_continue_with_email");
    By otherButton = By.id("com.google.android.gms:id/cancel");
    By emailInput = By.id(app_package_name + "email_exists_input");
    By continueWithEmailButton = By.id(app_package_name + "btn_continue_with_email");
    By passwordInput = By.id(app_package_name + "log_in_password");
    By loginButton = By.id(app_package_name + "btn_log_in");
    By emptyIcon = By.id(app_package_name + "empty_icon");
    By projectsDropdown = By.xpath("(//android.widget.ImageView[@content-desc=\"Expand/collapse\"])[1]");
    By personalButton = By.xpath(TextView + "[@text='Personal']");
    By addButton = By.id("com.todoist:id/fab");
    By profile = By.id("com.todoist:id/profile_view_avatar");
    By addProject = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.TextView[1]");
    //By addProject = By.xpath(TextView + "[@text='Add project']");
    By nameProject = By.id("com.todoist:id/name");
    By createButton = By.id("com.todoist:id/menu_form_submit");
    By selectFavorite = By.id("com.todoist:id/favorite");
    By projectName = By.id(app_package_name + "text");


    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test(priority = 1)
    public void LoginTest() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(continueLogin).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(otherButton));

        driver.findElement(otherButton).click();
        driver.findElement(emailInput).sendKeys("hillelqaauto52@gmail.com");
        driver.findElement(continueWithEmailButton).click();
        driver.findElement(passwordInput).sendKeys("welcome2hillel");
        driver.findElement(loginButton).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(emptyIcon));

        assert driver.findElement(emptyIcon).isDisplayed();
    }

     @Test(priority = 2)
      public void NewProject() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(projectsDropdown).click();

         wait.until(ExpectedConditions.presenceOfElementLocated(addProject));
         driver.findElement(addProject).click();
         driver.findElement(nameProject).sendKeys("Test project creation");
         driver.findElement(selectFavorite).click();
         driver.findElement(createButton).click();

         wait.until(ExpectedConditions.presenceOfElementLocated(nameProject));

          assert driver.findElement(nameProject).isDisplayed();


        }
    }


