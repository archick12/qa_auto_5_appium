package todoist;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ToDoistTests  extends AndroidSetupToDoist {

    String app_package_name = "com.todoist:id/";
    String android = "android:id/";
    String TextView = "//android.widget.TextView";
    String WidgetButton = "//android.widget.Button";

    By continueLogin = By.id(app_package_name + "btn_welcome_continue_with_email");
    By otherButton = By.id("com.google.android.gms:id/cancel");
    By emailInput = By.id(app_package_name + "email_exists_input");
    By continueWithEmailButton = By.id(app_package_name + "btn_continue_with_email");
    By passwordInput = By.id(app_package_name + "log_in_password");
    By projectsDropdown = By.id("com.todoist:id/collapse");
    By nameProject = By.id(app_package_name +"name");
    By createButton = By.id(app_package_name +"menu_form_submit");
    By selectFavorite = By.id(app_package_name +"favorite");
    By loginButton = By.id(app_package_name + "btn_log_in");
    By emptyIcon = By.id(app_package_name + "empty_icon");
    By addNewTaskButton = By.id(app_package_name + "fab");
    By taskSummary = By.id(android + "message");
    By saveTask = By.id(android + "button1");
    By taskName = By.id(app_package_name + "text");
    By addTaskDate = By.id(app_package_name + "schedule");
    By selectDate = By.id(app_package_name + "scheduler_tomorrow");
    By addProject = By.xpath(TextView + "[@text='Add project']");
    By taskInbox = By.id(app_package_name + "name");
    By testTaskField = By.xpath(TextView + "[@text= 'test task']");
    By deleteButtonFromDropDownMenu = By.xpath(TextView + "[@text='Delete']");
    By deletePopUpConfirmation = By.xpath(WidgetButton +"[@text='Yes']");
    By manageProject = By.xpath(TextView + "[@text='Manage projects']");
    By deleteProjectButton = By.xpath(WidgetButton +"[@text='Delete']");
    By deleteProjectByProjectName = By.xpath(TextView + "[@text='Test project creation']");
    By emptyTitle = By.id(app_package_name +"empty_title");

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

        //wait.until(ExpectedConditions.presenceOfElementLocated(emptyIcon));

        //assert driver.findElement(emptyIcon).isDisplayed();
    }

    @Test(priority = 2)
    public void NewProject() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        driver.findElement(MobileBy.AccessibilityId("Expand/collapse")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(addProject));
        assert driver.findElement(addProject).isDisplayed();

        driver.findElement(addProject).click();
        driver.findElement(nameProject).sendKeys("Test project creation");
        driver.findElement(selectFavorite).click();
        driver.findElement(createButton).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(nameProject));

        assert driver.findElement(nameProject).isDisplayed();

        driver.findElement(manageProject).click();
        driver.findElement(deleteProjectByProjectName).click();
        driver.findElement(MobileBy.AccessibilityId("More options")).click();
        driver.findElement(deleteButtonFromDropDownMenu).click();
        driver.findElement(deleteProjectButton).click();

        assert driver.findElement(nameProject).isEnabled();


    }

    @Test(priority = 3)
        public void NewTask () {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            driver.findElement(MobileBy.AccessibilityId("Navigate up")).click();
            driver.findElement(projectsDropdown).click();
            driver.findElement(addNewTaskButton).click();
            driver.findElement(taskSummary).sendKeys("test task");
            driver.findElement(addTaskDate).click();
            driver.findElement(selectDate).click();
            driver.findElement(saveTask).click();
            driver.findElement(taskInbox).click();

        assert driver.findElement(taskName).isDisplayed();

            driver.findElement(testTaskField).click();
            driver.findElement(MobileBy.AccessibilityId("More options")).click();
            driver.findElement(deleteButtonFromDropDownMenu).click();
            driver.findElement(deletePopUpConfirmation).click();

        //дassert driver.findElement(emptyTitle).isDisplayed();

        }

    }




