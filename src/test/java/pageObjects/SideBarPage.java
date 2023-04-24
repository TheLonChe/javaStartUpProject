package pageObjects;

import helpers.BasePage;
import helpers.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SideBarPage extends BasePage {

    public WebElement getCompanyNewsTab() {
        return Utils.waitForElementPresence(getDriver(), By.xpath("//span[normalize-space()='Company News']"),5);
    }
    public WebElement getMyNewsTab() {
        return Utils.waitForElementPresence(getDriver(), By.xpath("//span[normalize-space()='My News']"),5);
    }
    public WebElement getReadLaterNewsTab() {
        return Utils.waitForElementPresence(getDriver(), By.xpath("//span[normalize-space()='Read Later']"),5);
    }
    public WebElement getFirstInsightsTab() {
        return Utils.waitForElementPresence(getDriver(), By.xpath("//span[normalize-space()='First Insights']"),5);
    }
}
