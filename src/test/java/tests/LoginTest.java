package tests;

import helpers.Pages;
import helpers.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static pageObjects.LoginPage.loginUser;

public class LoginTest extends BaseTest{
    @Test
    public void loginTeamAdmin() {
        Pages.loginPage.loginTeamAdmin();}
    @Test
    public void loginTeamMember() {
        Pages.loginPage.loginTeamMember();}

}
