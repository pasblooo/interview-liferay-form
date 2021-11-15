package com.form.steps;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.en.*;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class BrowserLauncher {

    public static void main(String[] args) {
        openBrowser("chrome");
    }

    @Given("Open {String} browser")
    public static void openBrowser(String browser) {
        WebDriver driver;
        driver = setBrowser(browser);

        try {
            driver.manage().window().maximize();
            driver.quit();
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }

    }

    public static WebDriver setBrowser(String browser) {
        WebDriver driver = null;
        String driver_path = String.format("./src/test/resources/drivers/%sDriver.exe", browser);
        String property = String.format("webdriver.%s.driver", browser);
        System.setProperty(property, FilenameUtils.separatorsToSystem(driver_path));

        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            case "opera":
                driver = new OperaDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
        }

        return driver;
    }

}
