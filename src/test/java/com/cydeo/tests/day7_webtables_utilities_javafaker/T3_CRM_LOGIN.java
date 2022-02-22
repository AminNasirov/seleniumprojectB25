package com.cydeo.tests.day7_webtables_utilities_javafaker;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.CRM_Utilities;
import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_CRM_LOGIN {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Test
    public void test_crm_login() {
        driver.get("https://login1.nextbasecrm.com/");

//3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("helpdesk1@cybertekschool.com");

        //helpdesk1@cybertekschool.com  UserUser
        //Helpdesk2@cybertekschool.com  UserUser

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        //5. Click to Log In button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.verifyTitle(driver, "Portal");



    }

    @Test
    public void test_crm_login2() {
        driver.get("https://login1.nextbasecrm.com/");


        CRM_Utilities.crm_login(driver);



        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.verifyTitle(driver, "Portal");



    }


    @Test
    public void test_crm_login3() {
        driver.get("https://login1.nextbasecrm.com/");


        CRM_Utilities.crm_login(driver,"helpdesk2@cybertekschool.com","UserUser");



        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.verifyTitle(driver, "(2) Portal");



    }





}
