package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class US14 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
    }

    @Test
    public void nonSelectDropdown(){

        WebElement username = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));//   //*[@id="login-popup"]/form/div[1]/div[1]/input
        username.sendKeys("hr70@cydeo.com");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("UserUser");

        WebElement logInButton = driver.findElement(By.xpath("//input[@type='submit']"));
        logInButton.click();

       WebElement desktopClient = driver.findElement(By.xpath("//div[.='Desktop client']"));

       Assert.assertTrue(desktopClient.isDisplayed());


        List<WebElement> items = driver.findElements(By.xpath("(//div[@class='b24-app-block-content'])[1]"));

        for (WebElement each : items) {
            if(each.isDisplayed()){
                System.out.println(each.getText());
                Assert.assertTrue(each.isDisplayed());
            }
        }







    }
}
