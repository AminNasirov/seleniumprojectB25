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

public class TestCase9 {

    WebDriver driver;


    @Test
    public void activityStream_HR_users() {

        List<String> logins = new ArrayList<>();
        logins.addAll(Arrays.asList("hr70@cydeo.com","hr71@cydeo.com","hr72@cydeo.com"));

        for (String login : logins) {
            driver = WebDriverFactory.getDriver("chrome");
            driver.get("https://login1.nextbasecrm.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            WebElement username = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));////*[@id="login-popup"]/form/div[1]/div[1]/input
            username.sendKeys(login);

            WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
            password.sendKeys("UserUser");

            WebElement logInButton = driver.findElement(By.xpath("//input[@type='submit']"));
            logInButton.click();

            WebElement activityStream = driver.findElement(By.xpath("//*[@id='bx_left_menu_menu_live_feed']/a/span[1]"));
            activityStream.click();
            String activityStreamTitle = driver.getTitle();
            String expectedActivityStreamTitle = "Portal";
            Assert.assertEquals(activityStreamTitle,expectedActivityStreamTitle);


            driver.close();






        }
    }


    @Test
    public void tasksModule_HR_users() {

        List<String> logins = new ArrayList<>();
        logins.addAll(Arrays.asList("hr70@cydeo.com","hr71@cydeo.com","hr72@cydeo.com"));

        for (String login : logins) {
            driver = WebDriverFactory.getDriver("chrome");
            driver.get("https://login2.nextbasecrm.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            WebElement username = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));////*[@id="login-popup"]/form/div[1]/div[1]/input
            username.sendKeys(login);

            WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
            password.sendKeys("UserUser");

            WebElement logInButton = driver.findElement(By.xpath("//input[@type='submit']"));
            logInButton.click();

            WebElement tasksModule = driver.findElement(By.xpath("//*[@id='bx_left_menu_menu_tasks']"));
            tasksModule.click();
            String expectedTaskModuleTitle = "Site map";
            String actualTaskTitle = driver.getTitle();
            Assert.assertEquals(actualTaskTitle,expectedTaskModuleTitle);


            driver.close();






        }
    }






}


