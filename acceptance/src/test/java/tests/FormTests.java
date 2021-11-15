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

public class FormTests {

    private WebDriver driver;

    @Test
    public void openFormTest(){

        driver = InitBrowser.setBrowser("chrome");
        ManageBrowser.loadLiferayFormApplication(driver);

        WebElement name = driver.findElement(By.id());
        WebElement bDate = driver.findElement(By.id());
        WebElement textArea = driver.findElement(By.id());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
