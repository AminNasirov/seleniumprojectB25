package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US_1_Login {

    WebDriver driver;


    @Test
    public void SuccessfulLogin(){


        List<String> logins = new ArrayList<>();
        logins.addAll(Arrays.asList("hr70@cydeo.com","hr71@cydeo.com","hr72@cydeo.com"
                ,"helpdesk70@cydeo.com","helpdesk71@cydeo.com","helpdesk72@cydeo.com"
                ,"marketing70@cydeo.com","marketing71@cydeo.com","marketing72@cydeo.com"));

        for (String login : logins) {
            driver= WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://login2.nextbasecrm.com/");
            String expectedTitle = "Authorization";
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle,expectedTitle);
            WebElement userLogin = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
            userLogin.sendKeys(login);
            WebElement userPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
            userPassword.sendKeys("UserUser");
            WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
            loginButton.click();
             expectedTitle = "Portal";
             actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle,expectedTitle);
            driver.close();

        }
    }



    @Test
    public void testInvalidCredentials() {

        List<String> logins = new ArrayList<>();
        logins.addAll(Arrays.asList("hr70@cydeo.com","invalid@cydeo.com",""));

        List<String> passwords = new ArrayList<>();
        passwords.addAll(Arrays.asList("UserUser","invalid123",""));

        for (int i = 0; i < logins.size(); i++) {
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


            for (int i1 = 0; i1 < passwords.size(); i1++) {

                String  str = passwords.get(i1);

                driver.get("https://login2.nextbasecrm.com/");
                WebElement userLogin = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
                userLogin.sendKeys(logins.get(i));
                WebElement userPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
                userPassword.sendKeys(str);
                if (logins.get(i).equals("hr70@cydeo.com") && str.equals("UserUser")) {
                    continue;
                }
                WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
                loginButton.click();

                WebElement errorText = driver.findElement(By.xpath("//div[.='Incorrect login or password']"));

                String expectedErrorText = "Incorrect login or password";
                String actualErrorText = errorText.getText();

                Assert.assertEquals(actualErrorText, expectedErrorText);



            }
            driver.close();
        }


    }


}
/*
Test cases #1
Description:  Successful login
Environment:  https://login2.nextbasecrm.com/
Steps:: Users go to the login page
            Verify the title is “Authorization”
            Enter valid emails and passwords
            Click the Login In button
            Verify users log in successfully and launch the homepage

Test cases #2
Description:  User login with invalid credentials
Environment:  https://login2.nextbasecrm.com/
Steps::  Users go to the login page
             Enter invalid email or password
             Click the Login In button
             Verify users see “Incorrect username or password” on the page

 */