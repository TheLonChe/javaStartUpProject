package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import static helpers.BasePage.getDriver;

public class Utils {



    public static WebElement waitToBeClickable(WebDriver driver, By selector, int waitInterval) {
        return new WebDriverWait(driver, Duration.ofSeconds(waitInterval))
                .until(ExpectedConditions.elementToBeClickable(selector));
    }

    public static WebElement waitForElementPresence(WebDriver driver, By selector, int waitInterval) {
        return new WebDriverWait(driver, Duration.ofSeconds(waitInterval))
                .until(ExpectedConditions.presenceOfElementLocated(selector));
    }

    public static WebElement waitForElementVisibility(WebDriver driver, By selector, int waitInterval) {
        return new WebDriverWait(driver, Duration.ofSeconds(waitInterval))
                .until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public static String setRandomString(int n) {
        Random r = new Random();
        StringBuilder outputBuffer = new StringBuilder(n);
        String alphabet = "123456789qwertyuiopasdfghjklzxcvbnm";
        for (int i = 0; i < n; i++) {
            outputBuffer.append(alphabet.charAt(r.nextInt(alphabet.length())));
        }
        outputBuffer.append(".by.TheLonChe");
        return outputBuffer.toString();
    }

    public static String setRandomEmail(int n) {
        Random r = new Random();
        StringBuilder outputBuffer = new StringBuilder(n);
        String alphabet = "123456789qwertyuiopasdfghjklzxcvbnm";
        for (int i = 0; i < n; i++) {
            outputBuffer.append(alphabet.charAt(r.nextInt(alphabet.length())));
        }
        outputBuffer.append("@itengine.rs");
        return outputBuffer.toString();
    }

    public static String setRandomEmailAndPass(int n, boolean isEmail) {
        Random r = new Random();
        StringBuilder outputBuffer = new StringBuilder(n);
        String alphabet = "123456789qwertyuiopasdfghjklzxcvbnm";
        for (int i = 0; i < n; i++) {
            outputBuffer.append(alphabet.charAt(r.nextInt(alphabet.length())));
        }
        if (isEmail) {
            outputBuffer.append("@itengine.rs");
        }

        return outputBuffer.toString();
    }

    public static boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public String getDate () {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dtf.format(LocalDateTime.now());
    }

    public void customWaiter() throws InterruptedException {
        Thread.sleep(500);
    }

    public static void scrollDown() {
        var jsExec = (JavascriptExecutor) getDriver();
        jsExec.executeScript("window.scrollBy(0,1000)");
    }
    public static void scrollIntoView (WebElement element) {
        var jsExec = (JavascriptExecutor) getDriver();
        jsExec.executeScript("arguments[0].scrollIntoView();", element);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
