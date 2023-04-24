package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseTest {

    // ""Sic Parvis Magna""
    public static String baseUrl = "https://yourTargetURL.com/";
    private static WebDriver DRIVER;
    private static WebDriverWait WEB_DRIVER_WAIT;
    private static Actions ACTIONS;

    public static WebDriver getDriver() {
        return DRIVER;
    }
    public static WebDriverWait getWebDriverWait() {
        return WEB_DRIVER_WAIT;
    }
    public static Actions getActions() {
        return ACTIONS;
    }

    private static void setUpPage() {
        DRIVER.manage().window().maximize();
        DRIVER.navigate().to(baseUrl);
        DRIVER.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @BeforeEach
    public void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "..\\BlueprintStartUpProject\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DRIVER = new ChromeDriver(options);
        WEB_DRIVER_WAIT = new WebDriverWait(DRIVER, Duration.ofSeconds(5));
        ACTIONS = new Actions(DRIVER);
        setUpPage();
    }
    @AfterEach
    public void quitDriver() {
        DRIVER.quit();
    }

}

