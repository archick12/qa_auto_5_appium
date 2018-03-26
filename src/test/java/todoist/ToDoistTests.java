package todoist;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ToDoistTests  extends AndroidSetupToDoist {

    String app_package_name = "com.todoist:id/";
    String TextView = "//android.widget.TextView";

    By continueLogin = By.id(app_package_name + "btn_welcome_continue_with_email");
    By otherButton = By.id("com.google.android.gms:id/cancel");
    By emailInput = By.id(app_package_name + "email_exists_input");
    By continueWithEmailButton = By.id(app_package_name + "btn_continue_with_email");
    By passwordInput = By.id(app_package_name + "log_in_password");
    By projectsDropdown = By.xpath("(//android.widget.ImageView[@content-desc=\"Expand/collapse\"])[1]");
    By nameProject = By.id("com.todoist:id/name");
    By createButton = By.id("com.todoist:id/menu_form_submit");
    By selectFavorite = By.id("com.todoist:id/favorite");
    By loginButton = By.id(app_package_name +  "btn_log_in");
    By emptyIcon = By.id(app_package_name + "empty_icon");
    By addNewTaskButton = By.id(app_package_name + "fab");
    By taskSummary = By.id("android:id/message");
    By saveTask = By.id("android:id/button1");
    By taskName = By.id(app_package_name + "text");
    By addTaskDate = By.id(app_package_name + "schedule");
    By selectDate = By.id(app_package_name + "scheduler_tomorrow");
    By addProject = By.xpath(TextView + "[@text='Add project']");
    By taskInbox = By.id(app_package_name + "name");
    By testTaskField = By.id("com.todoist:id/text");
    By editDropDownMenu = By.xpath("//android.widget.ImageView[@content-desc=\"More options\"])[2]");

    By deleteButtonFromDropDownMenu = By.xpath(TextView + "[@text='Delete']");
    By deletePopUpConfirmation = By.xpath("//android.widget.Button[@text='Yes']");
    By noTaskForInbox = By.id("com.todoist:id/empty_icon");


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
         assert driver.findElement(addProject).isDisplayed();

         driver.findElement(addProject).click();
         driver.findElement(nameProject).sendKeys("Test project creation");
         driver.findElement(selectFavorite).click();
         driver.findElement(createButton).click();

         wait.until(ExpectedConditions.presenceOfElementLocated(nameProject));

         assert driver.findElement(nameProject).isDisplayed();


        }

    @Test(priority = 3)
    public void NewTask() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(addNewTaskButton).click();
        driver.findElement(taskSummary).sendKeys("test task");
        driver.findElement(addTaskDate).click();
        driver.findElement(selectDate).click();
        driver.findElement(saveTask).click();
        driver.findElement(taskInbox).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(taskName));

        assert driver.findElement(taskName).isDisplayed();

//        driver.findElement(testTaskField).click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(editDropDownMenu));
//        driver.findElement(editDropDownMenu).click();
//        driver.findElement(deleteButtonFromDropDownMenu).click();
//        driver.findElement(deletePopUpConfirmation).click();
//
//        assert driver.findElement(noTaskForInbox).isDisplayed();

    }

}



