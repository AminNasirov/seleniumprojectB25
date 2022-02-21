package com.cydeo.tests.day_6_alerts_iframes_windows;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_Windows_Practice {
    WebDriver driver;


    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/windows");
    }



    @Test
    public void multiple_windows_test(){

        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);

        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

        System.out.println("Title before click: "+actualTitle);

        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));

        clickHereLink.click();

        //Set<String> allWindowHandles = driver.getWindowHandles();


        for (String each : driver.getWindowHandles()) {
            driver.switchTo().window(each);
            System.out.println("current title while switching windows: "+driver.getTitle());
        }

        String expectedTitleAfterClick = "New Window";
        actualTitle=driver.getTitle();



        Assert.assertEquals(actualTitle,expectedTitleAfterClick);


        System.out.println("Title after click: " +actualTitle);

        //If we want to go back to main page, we can use already stored main handle
        //driver.switchTo().window(mainHandle);



    }
}
/*
TC #5: Window Handle practice

1. Create a new class called: T5_WindowsPractice
2. Create new test and make set ups
3. Go to : https://practice.cydeo.com/windows
4. Assert: Title is “Windows”
5. Click to: “Click Here” link
6. Switch to new Window.
7. Assert: Title is “New Window”
 */