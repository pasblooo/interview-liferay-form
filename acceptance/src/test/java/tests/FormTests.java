package tests;

import io.cucumber.java.bs.A;
import io.cucumber.java.nl.Stel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;
import com.form.steps.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class FormTests {

    private WebDriver driver;
    static Properties config = new Properties();
    static InputStream configInput = null;

    public static void loadConfig(){
        try{
            configInput = new FileInputStream("src/test/resources/settings/params.properties");
            config.load(configInput);
        } catch(Exception e){
            System.out.println("Error loading configuration\n");
        }
    }

    @Test
    public void openFormTest(){
        loadConfig();

        driver = InitBrowser.setBrowser("chrome");
        ManageBrowser.loadURL(driver, config.getProperty("liferay_form_url_us"));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(config.getProperty("name_input_field"))));

        WebElement name = driver.findElement(By.cssSelector(config.getProperty("name_input_field")));
        WebElement bDate = driver.findElement(By.cssSelector(config.getProperty("bDate_input_field")));
        WebElement textArea = driver.findElement(By.cssSelector(config.getProperty("textArea_input_field")));

        assert name.isDisplayed();
        textArea.sendKeys("Hola a todos");

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
