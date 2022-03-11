package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.tests.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POMPractices {
    LibraryLoginPage libraryLoginPage;


    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get("https://library1.cydeo.com/");
       libraryLoginPage = new LibraryLoginPage();
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void test_Required_field_error_message() {

        libraryLoginPage.signInButton.click();

        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());

    }

    @Test
    public void test2() {

        libraryLoginPage.inputUsername.sendKeys("somethingwrong");

        libraryLoginPage.signInButton.click();

        Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());
    }

    @Test
    public void test3() {

        libraryLoginPage.inputUsername.sendKeys("wrong@username.com");
        libraryLoginPage.inputPassword.sendKeys("wrong12345");

        libraryLoginPage.signInButton.click();

        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());

    }
}
/*
C #1: Required field error message test
1- Open a chrome browser
2- Go to: https://library1.cydeo.com/
3- Do not enter any information
4- Click to “Sign in” button
5- Verify expected error is displayed:
Expected: This field is required.

NOTE: FOLLOW POM DESIGN PATTERN
 */