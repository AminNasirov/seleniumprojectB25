package com.cydeo.tests.day_6_alerts_iframes_windows;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NextBaseCRM_login {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }





    @Test
    public void test1_TittleVerify(){

        String expectedTitle = "Authorization";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
    }



    @Test
    public void test2_CheckboxLabelVerify(){

        WebElement checkboxLabel = driver.findElement(By.xpath("//label[.='Remember me on this computer']"));

        String expectedCheckboxLabel = "Remember me on this computer";
        String actualCheckboxLabel = checkboxLabel.getText();

        Assert.assertEquals(actualCheckboxLabel,expectedCheckboxLabel);
    }

    @Test
    public void test3_HR_user_login(){

        WebElement userLogin = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userLogin.sendKeys("hr70@cydeo.com");
        WebElement userPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        userPassword.sendKeys("UserUser");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();



        WebElement userName = driver.findElement(By.xpath("//span[.='Hr70 Cydeo']"));
        Assert.assertTrue(userName.isEnabled());


    }

    @Test
    public void test4_Marketing_user_login(){

        WebElement userLogin = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userLogin.sendKeys("marketing70@cydeo.com");
        WebElement userPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        userPassword.sendKeys("UserUser");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();


        WebElement userName = driver.findElement(By.xpath("//span[.='Marketing70 Cydeo']"));
        Assert.assertTrue(userName.isEnabled());


    }

    @Test
    public void test5_HelpDesk_user_login(){

        WebElement userLogin = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userLogin.sendKeys("helpdesk70@cydeo.com");
        WebElement userPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        userPassword.sendKeys("UserUser");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();



        WebElement userName = driver.findElement(By.xpath("//span[.='Helpdesk70 Cydeo']"));
        Assert.assertTrue(userName.isEnabled());


    }

    @Test
    public void test6_Invalid_user_login()  {

        WebElement userLogin = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userLogin.sendKeys("Amin70@cydeo.com");
        WebElement userPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        userPassword.sendKeys("Amin");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        WebElement errorText = driver.findElement(By.xpath("//div[.='Incorrect login or password']"));
        System.out.println("errorText is displayed with incorrect login = " + errorText.isDisplayed());


        String actualErrorText = errorText.getText();
        String expectedErrorText = "Incorrect username or password";

        Assert.assertEquals(actualErrorText,expectedErrorText);



    }






}
/*
TestCase1-Title Verification
1.Open Chrome Browser
2.log in https://login2.nextbasecrm.com/
3.verify the title
expected title "Authorization"

TestCase2 - Checkbox label verification
1.Open Chrome Browser
2.log in https://login2.nextbasecrm.com/
3.verify checkbox label
expected checkbox label  is  “Remember me on this computer”

TestCase3 - Verify Users as HR
1.Open Chrome Browser
2.log in https://login2.nextbasecrm.com/
3. As HR user log in
enter login:"hr70@cydeo.com" password: UserUser
4. verify log in successfully

TestCase4 - Verify Users as Marketing
1.Open Chrome Browser
2.log in https://login2.nextbasecrm.com/
3. As Marketing user log in
enter login: marketing70@cydeo.com  password: UserUser
4. verify login successfully

TestCase5 - Verify Users as HelpDesk
1.Open Chrome Browser
2.log in https://login2.nextbasecrm.com/
3. As HelpDesk user log in
enter login: helpdesk70@cydeo.com password: UserUser
4. verify login successfully

TestCase6 - Verify invalid login attempt
1.Open Chrome Browser
2.log in https://login2.nextbasecrm.com/
3. enter Incorrect login  and  password
enter login:    Amin70@cydeo.com
      password: Amin
4. verify  error Text
 expectedErrorText "Incorrect username or password"





 */