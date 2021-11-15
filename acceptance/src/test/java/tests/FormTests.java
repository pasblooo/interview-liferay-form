package tests;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.form.steps.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class FormTests {

    private WebDriver driver;
    static Properties config = new Properties();
    static InputStream configInput = null;
    static List<WebElement> inputsElements = new ArrayList<WebElement>();

    public static void loadConfig() {
        try {
            configInput = new FileInputStream("src/test/resources/settings/params.properties");
            config.load(configInput);
        } catch (Exception e) {
            System.out.println("Error loading configuration\n");
        }
    }

    @Test
    public void openFormTest() {
        loadConfig();

        driver = InitBrowser.setBrowser("chrome");
        ManageBrowser.loadURL(driver, config.getProperty("liferay_form_url_us"));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(config.getProperty("name_input_field"))));

        inputsElements.add(driver.findElement(By.cssSelector(config.getProperty("name_input_field"))));
        inputsElements.add(driver.findElement(By.cssSelector(config.getProperty("bDate_input_field"))));
        inputsElements.add(driver.findElement(By.cssSelector(config.getProperty("textArea_input_field"))));

    }

    @Test
    public void fillFormTest() {

        openFormTest();

        String[] user = config.get("user_correct").toString().split("#");
        int index = 0;

        WebDriverWait wait = new WebDriverWait(driver, 10);

        for (WebElement element : inputsElements) {
            element.clear();
            element.sendKeys(user[index++]);
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }

        ManageBrowser.submitForm(driver, config);
        ManageBrowser.checkInformationSent(driver, config);

    }

    @After
    public void tearDown() {

        driver.quit();
    }

}
