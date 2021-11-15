package com.form.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ManageBrowser {

    public static void loadURL(WebDriver driver, String url) {

        driver.get(url);
    }

    public static void submitForm(WebDriver driver, Properties config) {

        WebElement submit_btn = driver.findElement(By.id(config.getProperty("submit_btn_id")));
        submit_btn.click();
    }

    public static void checkInformationSent(WebDriver driver, Properties config) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement pop_up = driver.findElement(By.xpath(
                config.getProperty("pop_up")));

        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(pop_up)));
        WebElement successfully_msg = driver.findElement(By.cssSelector(
                config.getProperty("information_sent_successfully_css")));

        assert successfully_msg.isDisplayed() : "Form has not been sent successfully";
        assert (successfully_msg.getText().contentEquals(config.getProperty("information_sent_successfully_message")))
                : "The successfully text is not the expected one";
    }
}
