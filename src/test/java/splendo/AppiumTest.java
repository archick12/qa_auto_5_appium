package splendo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ResourceBundle;


public class AppiumTest extends AndroidSetup {

    ResourceBundle locators = ResourceBundle.getBundle("en_US.properties");

    String app_package_name = "com.splendapps.splendo:id/";
    String TextView = "//android.widget.TextView";
    // Home Screen
    By addFirstTaskButton = By.id(app_package_name + "imgFirstTask");
    By addNewTaskButton = By.id(app_package_name + "ivFAB_AddTask");
    By taskInput = By.id(app_package_name + "edtTaskName");
    By dueDate = By.id(app_package_name + "edtDueD");
    By dueTime = By.id(app_package_name + "edtDueT");
    By saveTask = By.id(app_package_name + "action_save_task");
    By doneButton = By.id("android:id/button1");
    By repeatButton = By.id(app_package_name + "spinnerRepeat");
    By repeatButtonOnceAWeek = By.xpath(TextView + "[@text='Once a Week']");
    By addToListButton = By.id(app_package_name + "spinnerLists");
    By addToListButtonPersonal = By.xpath(TextView + "[@text='Personal']");
    By popUpReapeatTaskNo = By.id("android:id/button2");

    // Task List Screen
    By taskName = By.id(app_package_name + "task_name");
    By taskCheckBox = By.id(app_package_name + "checkDone");
    By toolBar = By.id(app_package_name + "spinnerToolbar");
    By finishedMenuItem = By.xpath(locators.getString("finishedMenuItem"));

    By quickTask = By.id(app_package_name + "etQuickTask");
    By doneButtonForQuickTask = By.id(app_package_name + "ivAddQuickTask");
    By allListsMenuItem = By.xpath(TextView + "[@text='All Lists']");
    By listMain = By.id(app_package_name + "listMain");

    //Add in Batch Mode
    By moreOptions = By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]");
    By addInBatchMode = By.xpath(TextView + "[@text='Add in Batch Mode']");
    By whatIsToBeDone = By.id(app_package_name + "edtTaskName");

    //PersonalList
    By PersonalMenuItem = By.xpath(TextView + "[@text='Personal']");
    By taskInputPersonal = By.id(app_package_name + "edtTaskName");

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test(priority = 1)
    public void showTest() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(addFirstTaskButton).click();
        driver.findElement(taskInput).sendKeys("test task");
        driver.findElement(dueDate).click();
        driver.findElement(doneButton).click();
        driver.findElement(dueTime).click();
        driver.findElement(doneButton).click();
        driver.findElement(repeatButton).click();
        driver.findElement(repeatButtonOnceAWeek).click();
        driver.findElement(addToListButton).click();
        driver.findElement(addToListButtonPersonal).click();
        driver.findElement(saveTask).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(taskName));

        assert driver.findElement(taskName).isDisplayed();
    }

    // Complete task
    @Test(priority = 2)
    public void completeTask() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(taskCheckBox).click();
        driver.findElement(popUpReapeatTaskNo).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(toolBar));

        driver.findElement(toolBar).click();
        driver.findElement(finishedMenuItem).click();
        assert driver.findElement(taskName).isDisplayed();
    }

    @Test(priority = 3)
    public void addQuickTask() {
        driver.findElement(toolBar).click();
        driver.findElement(allListsMenuItem).click();
        driver.findElement(quickTask).click();
        driver.findElement(quickTask).sendKeys("test task");
        driver.findElement(doneButtonForQuickTask).click();
        assert driver.findElement(taskName).isDisplayed();
    }

    @Test(priority = 4)
    public void addInBatchMode() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(moreOptions).click();
        driver.findElement(addInBatchMode).click();
        driver.findElement(whatIsToBeDone).sendKeys("test task done");
        driver.findElement(dueDate).click();
        driver.findElement(doneButton).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(saveTask));

        driver.findElement(saveTask).click();
        assert driver.findElement(taskName).isDisplayed();

        driver.findElement(taskCheckBox).click();
        assert driver.findElement(listMain).isDisplayed();
    }

    @Test(priority = 5)
    public void addTaskToPersonalListTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(allListsMenuItem).click();
        driver.findElement(PersonalMenuItem).click();
        driver.findElement(addNewTaskButton).click();
        driver.findElement(taskInputPersonal).sendKeys("Do massage");
        driver.findElement(dueDate).click();
        driver.findElement(doneButton).click();

        //Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(saveTask));
        driver.findElement(saveTask).click();
        assert driver.findElement(taskName).isDisplayed();

        driver.findElement(taskCheckBox).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(toolBar));

        driver.findElement(toolBar).click();
        driver.findElement(finishedMenuItem).click();
        assert driver.findElement(taskName).isDisplayed();
    }
}