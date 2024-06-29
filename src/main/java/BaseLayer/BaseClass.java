package BaseLayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    public static WebDriver driver;
    public static Properties p;

    public BaseClass() {
        p = new Properties();
        try {
            FileInputStream f = new FileInputStream("./src/main/java/ConfigueLayer/Config.Properties");
            p.load(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initialization() throws IOException {
        // Setup WebDriver based on the browser type passed from Jenkins
        String browser = System.getProperty("browser", "firefox"); // Default to chrome if not provided
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    public static void closeBrowser() throws IOException {
        driver.quit();
    }
}
