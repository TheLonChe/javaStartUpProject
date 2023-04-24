package pageObjects;

import helpers.BasePage;
import helpers.Pages;
import helpers.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public static WebElement getUsernameField() {
        return Utils.waitForElementPresence(getDriver(), By.id("signInName"),5);
    }
    public static WebElement getPasswordField() {
        return Utils.waitForElementPresence(getDriver(), By.id("password"),5);
    }

    public static WebElement getSignInButton() {
        return Utils.waitToBeClickable(getDriver(), By.cssSelector("#next"),5);
    }

    public static WebElement getRememberMeCheckbox() {
        return Utils.waitToBeClickable(getDriver(), By.cssSelector("#rememberMe"),5);
    }

    public static void loginUser(String username, String password) {
        getUsernameField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getRememberMeCheckbox().click();
        getSignInButton().click();
    }
    @Test
    public void loginTeamAdmin() {
        loginUser("yourUsername", "yourPassword");
        Assertions.assertTrue(Pages.sideBarPage.getCompanyNewsTab().isDisplayed());
    }
  
 
}
