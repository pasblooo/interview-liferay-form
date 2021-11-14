import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class LaunchForm {

    public void set_browser_driver(){

    }

    @Given("Open \"<browser>\" browser")
    public void open_browser(String browser){

    }


    public static void main(String[] args){

        // System properties for Chrome Driver
        String driver_path = "./src/test/resources/drivers/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", FilenameUtils.separatorsToSystem(driver_path));

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

    }
}
