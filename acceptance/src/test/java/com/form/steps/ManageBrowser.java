package com.form.steps;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ManageBrowser {

    public static void loadURL(WebDriver webDriver, String url) {
        webDriver.get(url);
    }
}
