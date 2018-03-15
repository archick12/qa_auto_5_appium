import org.openqa.selenium.By;
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

    // Home Screen
    By addTaskButton = By.id(app_package_name + "imgFirstTask");
    By taskInput = By.id(app_package_name + "edtTaskName");
    By dueDate = By.id(app_package_name + "edtDueD");
    By saveTask = By.id(app_package_name + "action_save_task");

    // Task List Screen
    By taskName = By.id(app_package_name + "task_name");
    By taskCheckBox = By.id(app_package_name + "checkDone");
    By toolBar = By.id(app_package_name + "spinnerToolbar");
    By finishedMenuItem = By.linkText("Finished");

    // Add new TODO task
    driver.findElement(addTaskButton).click();
    driver.findElement(taskInput).sendKeys("test task");
    driver.findElement(dueDate).sendKeys("Today");
    driver.findElement(saveTask).click();
    assert driver.findElement(taskName).isDisplayed();

    // Complete task
    driver.findElement(taskCheckBox).click();
    assert !driver.findElement(taskName).isDisplayed();

    driver.findElement(toolBar).click();
    driver.findElement(finishedMenuItem).click();
    assert driver.findElement(taskName).isDisplayed();
  }
}