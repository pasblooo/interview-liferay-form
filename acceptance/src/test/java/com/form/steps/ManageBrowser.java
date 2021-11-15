package com.form.steps;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ManageBrowser {

    Properties config = new Properties();
    InputStream configInput = null;

    public void loadConfig(){
        try{
            configInput = new FileInputStream("config.properties");
            config.load(configInput);
        } catch(Exception e){
            System.out.println("Error loading configuration\n");
        }
    }

    @When("Load liferay form application")
    public void loadLiferayFormApplication(WebDriver webDriver) {
        loadConfig();
        webDriver.get(config.getProperty("liferay_form_url"));
    }
}
