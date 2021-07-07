package com.facebook.test;

import Pages.Login;
import Pages.Logout;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.DataDriven;

public class TestDataDriven extends BaseProgram{
    @Test(dataProvider = "LoginDetails", dataProviderClass = DataDriven.class)

    public void LoginApplication(String Username, String Password) throws InterruptedException {
        Login login = new Login(driver);
        String actualTitle = login.Login(Username, Password);
        String expectedTitle = "Facebook";
        Assert.assertEquals(actualTitle,expectedTitle);

        Logout logout = new Logout (driver);
        logout.logout();
    }
}
