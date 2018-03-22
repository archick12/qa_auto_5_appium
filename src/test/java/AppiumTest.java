import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AppiumTest extends AndroidSetup {


  @BeforeClass
  public void setUp() throws Exception {
    prepareAndroidForAppium();
  }

  @AfterClass
  public void tearDown() throws Exception {
    driver.quit();
  }

  @Test
  public void showTest() {

    String app_package_name = "com.splendapps.splendo:id/";
    WebDriverWait wait = new WebDriverWait(driver, 30);

    // Home Screen
    By addTaskButton = By.id(app_package_name + "imgFirstTask");
    By taskInput = By.id(app_package_name + "edtTaskName");
    By dueDate = By.id(app_package_name + "edtDueD");
    By saveTask = By.id(app_package_name + "action_save_task");
    By doneButton = By.id("android:id/button1");

    // Task List Screen
    By taskName = By.id(app_package_name + "task_name");
    By taskCheckBox = By.id(app_package_name + "checkDone");
    By toolBar = By.id(app_package_name + "spinnerToolbar");
    By finishedMenuItem = By.xpath("//android.widget.TextView[@text='Finished']");
//    By finishedMenuItem = By.name("Finished");

    By quickTask = By.id("com.splendapps.splendo:id/etQuickTask");
    By doneButtonForQuickTask = By.id("com.splendapps.splendo:id/ivAddQuickTask");
    By allListsMenuItem = By.xpath("//android.widget.TextView[@text='All Lists']");

    // Add new TODO task
    driver.findElement(addTaskButton).click();
    driver.findElement(taskInput).sendKeys("test task");
    driver.findElement(dueDate).click();
    driver.findElement(doneButton).click();

    wait.until(ExpectedConditions.presenceOfElementLocated(saveTask));

    driver.findElement(saveTask).click();
    assert driver.findElement(taskName).isDisplayed();

    // Complete task
    driver.findElement(taskCheckBox).click();

    wait.until(ExpectedConditions.presenceOfElementLocated(toolBar));

    driver.findElement(toolBar).click();
    driver.findElement(finishedMenuItem).click();
    assert driver.findElement(taskName).isDisplayed();

    driver.findElement(toolBar).click();
    driver.findElement(allListsMenuItem).click();
    driver.findElement(quickTask).click();
    driver.findElement(quickTask).sendKeys("test task");
    driver.findElement(doneButtonForQuickTask).click();
    assert driver.findElement(taskName).isDisplayed();

  }

  @Test
  public void addTaskToPersonalListTest() throws InterruptedException {

    String app_package_name = "com.splendapps.splendo:id/";
    WebDriverWait wait = new WebDriverWait(driver, 30);

    By allListsMenuItem = By.xpath("//android.widget.TextView[@text='All Lists']");
    By PersonalMenuItem = By.xpath("//android.widget.TextView[@text='Personal']");
    By addTaskButton = By.id(app_package_name + "imgFirstTask");
    By taskInputPersonal = By.id(app_package_name + "edtTaskName");
    By dueDate = By.id(app_package_name + "edtDueD");
    By doneButton = By.id("android:id/button1");
    By saveTask = By.id(app_package_name + "action_save_task");
    By taskName = By.id(app_package_name + "task_name");
//    By quickTask = By.id(app_package_name + "etQuickTask");
//    By quickTaskAddButton = By.id(app_package_name + "ivAddQuickTask");
//    By secondTaskName = By.xpath("android.widget.TextView[@text = Second Task]");
    By taskCheckBox = By.id(app_package_name + "checkDone");
    By toolBar = By.id(app_package_name + "spinnerToolbar");
    By finishedMenuItem = By.xpath("//android.widget.TextView[@text='Finished']");


    driver.findElement(allListsMenuItem).click();
    driver.findElement(PersonalMenuItem).click();
    driver.findElement(addTaskButton).click();
    driver.findElement(taskInputPersonal).sendKeys("Do massage");
    driver.findElement(dueDate).click();
    driver.findElement(doneButton).click();

    Thread.sleep(5000);
//  wait.until(ExpectedConditions.presenceOfElementLocated(doneButton));
    driver.findElement(saveTask).click();
    assert driver.findElement(taskName).isDisplayed();

    driver.findElement(taskCheckBox).click();

    wait.until(ExpectedConditions.presenceOfElementLocated(toolBar));

    driver.findElement(toolBar).click();
    driver.findElement(finishedMenuItem).click();
    assert driver.findElement(taskName).isDisplayed();
  }
}