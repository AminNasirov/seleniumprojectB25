package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.tests.utilities.ConfigurationReader;
import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Facebook {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browserType = ConfigurationReader.getProperty("browser");

        driver= WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void test_Title_Verification() {

        String expectedTitle = "Facebook – log in or sign up";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @Test
    public void test_login_function_verify() {

        WebElement username = driver.findElement(By.xpath("//input[@id='email']"));
        username.sendKeys("skldkdjskdjs");
        WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
        password.sendKeys("hello"+ Keys.ENTER);

        String expectedTitle = "Log into Facebook";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);


    }
}
