package com.cydeo.tests.day9_javaFaker_testbase_driverUtil;

import com.cydeo.tests.utilities.ConfigurationReader;
import com.cydeo.tests.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class RegistrationFormConfirmation {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= Driver.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test1() {
        driver.get(ConfigurationReader.getProperty("urlRegistration"));

        Faker faker = new Faker();

        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys(faker.name().username().replace(".",""));

        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys(faker.internet().emailAddress());

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(faker.internet().password());

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys(faker.numerify("###-###-####"));

        WebElement maleButton = driver.findElement(By.xpath("//input[@value='male']"));
        maleButton.click();

        WebElement birthday = driver.findElement(By.xpath("//input[@name='birthday']"));

        String date= faker.date().birthday().toInstant().atOffset(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        birthday.sendKeys(date);

        Select departments = new Select(driver.findElement(By.xpath("//select[@name='department']")));

        departments.selectByValue("DE");

        Select jobTitle = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));

        jobTitle.selectByVisibleText("SDET");

        WebElement programingLanguage = driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
        programingLanguage.click();

        WebElement signUpButton = driver.findElement(By.xpath("//div[@class='col-sm-9 col-sm-offset-3']//button"));

        signUpButton.click();


        WebElement verifyMessage = driver.findElement(By.xpath("//p"));

        String expectedResult = "You've successfully completed registration!";
        String actualResult = verifyMessage.getText();

        Assert.assertEquals(actualResult,expectedResult,"Invalid result");


    }
}
/*
TC#1: Registration form confirmation
Note: Use JavaFaker OR read from configuration.properties file when possible.
1. Open browser
2. Go to website: https://practice.cydeo.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10. Enter date of birth
11. Select Department/Office
12. Select Job Title
13. Select programming language from checkboxes
14. Click to sign up button
15. Verify success message “You’ve successfully completed registration.” is
displayed.


Note:
1. Use new Driver utility class and method
2. User JavaFaker when possible
3. User ConfigurationReader when it makes sense
 */