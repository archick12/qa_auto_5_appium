package todoist;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.List;

public class ToDoistTests  extends AndroidSetupToDoist {
    String app_package_name = "com.todoist:id/";
    By continueLogin = By.id(app_package_name + "btn_welcome_continue_with_email");
    By otherButton = By.id("com.google.android.gms:id/cancel");
    By emailInput = By.id(app_package_name + "email_exists_input");
    By continueWithEmailButton = By.id(app_package_name + "btn_continue_with_email");
    By passwordInput = By.id(app_package_name + "log_in_password");
    By loginButton = By.id(app_package_name +  "btn_log_in");
    By emptyIcon = By.id(app_package_name + "empty_icon");
    By searchButton = By.id(app_package_name + "menu_content_search");
    By searchEditText = By.id(app_package_name + "search_edit_text");
    By foundItemsLocator = By.xpath("//*[@resource-id='com.todoist:id/global_search_results']" +
            "/descendant::android.widget.TextView[@resource-id='com.todoist:id/text']");
    By searchTabTASKS = By.xpath("//*[@resource-id='com.todoist:id/global_search_tabs']//*[@text='TASKS']");
    By addButton = By.id(app_package_name + "fab");
    By backButton = By.id(app_package_name + "action_mode_close_button");



    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void LoginTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(continueLogin).click();
//TODO replace sleep with wait.until
        Thread.sleep(5000);

        driver.findElement(otherButton).click();
        driver.findElement(emailInput).sendKeys("hillelqaauto5@gmail.com");
        driver.findElement(continueWithEmailButton).click();
        driver.findElement(passwordInput).sendKeys("123123");
        driver.findElement(loginButton).click();
//TODO replace sleep with wait.until
        Thread.sleep(5000);
//        driver.findElement(emptyIcon).isDisplayed(); //test fails if there are any tasks created
        driver.findElement(addButton).isDisplayed();
    }

    @Test(dependsOnMethods = {"LoginTest"})
    public void searchTest() throws InterruptedException {
        String searchString = "hello";
        int counter = 0;
        try { //TODO replace with wait until is displayed or move on by timeout
            driver.findElement(emptyIcon);
            addTasksBulk("HelloWorld", "Hello", "hello", "hell", "byehellobye", "notMatch", "HELLOAGAIN"); // 5 matches
        } catch (NoSuchElementException e){}

        driver.findElement(searchButton).click();
        driver.findElement(searchEditText).sendKeys(searchString, "\n");
        driver.findElement(searchTabTASKS).click();
        Thread.sleep(5000); //TODO replace with wait until roller disappears
        List<MobileElement> foundItems = driver.findElements(foundItemsLocator);

        for (MobileElement item : foundItems) {
            assertTrue(item.getAttribute("text").toLowerCase().contains(searchString));
            counter++;
        }
        System.out.println("Found results counter = " + counter);
        deleteAllTasks();
    }

    public void addTasksBulk(String... taskList) {
        if (0 == taskList.length) return;
        driver.findElement(addButton).click();
        for (String task : taskList) {
            driver.findElementById("android:id/message").sendKeys(task, "\n");
            System.out.println("New task '" + task + "' is created");
        }
        driver.findElement(backButton).click();
        System.out.println(taskList.length + " tasks have been created");
    }
    public void deleteAllTasks(){
//        TODO implement deletion of all tasks
    }
}
