package com.form.steps;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ManageBrowser {

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

    @When("Load liferay form application")
    public static void loadLiferayFormApplication(WebDriver webDriver) {
        loadConfig();
        webDriver.get(config.getProperty("liferay_form_url"));
    }
}
