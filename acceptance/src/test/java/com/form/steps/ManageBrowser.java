package com.form.steps;

import org.openqa.selenium.WebDriver;

public class ManageBrowser {

    public static void loadURL(WebDriver driver, String url) {

        driver.get(url);
    }
}
