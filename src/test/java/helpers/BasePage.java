package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;
import java.time.Duration;

public class BasePage {

    protected static WebDriver getDriver() {
        return BaseTest.getDriver();
    }

    protected WebDriverWait getWaiter() {
        return BaseTest.getWebDriverWait();
    }
    protected Actions getActions() {
        return BaseTest.getActions();
    }

    public By dataTestId(String id) {
        return By.cssSelector("[data-testid='" + id + "']");
    }

    public WebElement getByTestId(String id) {
        return Utils.waitForElementPresence(getDriver(), dataTestId(id), 10);
    }

    public WebElement getElementByDataTestId(String dataTestId, String tagName) {
        WebElement getByDataTestId = getByTestId(dataTestId);
        return getByDataTestId.findElement(By.tagName(tagName));
    }
    
    public Select getSelectByDataTestId(String dataTestId) {
        return new Select(getElementByDataTestId(dataTestId, "select"));
    }

    public WebElement assertTableRowText(String message){
        String assertTableRowText = String.format("//span[text()=\"%s\"]", message);
        String selector = String.format(assertTableRowText);
        return Utils.waitForElementPresence(getDriver(), By.xpath(selector), 5);
    }

    public WebElement clickableByTestId(String id) {
        return Utils.waitToBeClickable(getDriver(), dataTestId(id), 10);
    }

    public WebElement waitForElementVisible(String id) {
        return Utils.waitForElementVisibility(getDriver(), dataTestId(id), 10);
    }

    public static Select waitForDropDownElementsToBePresent(WebDriver driver, By selector, int waitinterval) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitinterval));
        WebElement myDynamicElement = wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        return new Select(myDynamicElement);
    }

    public void toBeClickable (WebElement element) {
        getWaiter().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void setValue(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void clear(WebElement element) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public static void customWaiter() throws InterruptedException {
        Thread.sleep(1000);
    }

}