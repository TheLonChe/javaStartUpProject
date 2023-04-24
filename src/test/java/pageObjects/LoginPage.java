package pageObjects;

import helpers.BasePage;
import helpers.Pages;
import helpers.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public WebElement getSignInTitle() {
        return Utils.waitForElementPresence(getDriver(), By.cssSelector("header[class='signin-signup-form__title'] h2[class='imprint imprint-en']"),5);
    }

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
        loginUser("nikola.loncar@argusdatainsights.ch", "Eb194pDF1");
        Assertions.assertTrue(Pages.sideBarPage.getCompanyNewsTab().isDisplayed());
    }
    public void loginTeamMember() {
        loginUser("nikola.loncar@itengine.rs", "Eb194pDF1");
        Assertions.assertTrue(Pages.sideBarPage.getCompanyNewsTab().isDisplayed());
    }
}
