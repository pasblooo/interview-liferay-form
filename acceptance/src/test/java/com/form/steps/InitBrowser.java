package com.form.steps;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InitBrowser {

    public static WebDriver setBrowser(String browser) {

        if (browser == "firefox") {
            browser = "gecko";
        }

        WebDriver driver = null;
        String driver_path = String.format("./src/test/resources/drivers/%sDriver.exe", browser);
        String property = String.format("webdriver.%s.driver", browser);
        System.setProperty(property, FilenameUtils.separatorsToSystem(driver_path));

        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "gecko":
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
