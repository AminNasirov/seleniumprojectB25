package com.cydeo.tests.day4_findElements_checkbox_radioButton;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T2_xpath_locator_practice {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/multiple_buttons");

        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        Thread.sleep(2000);
        button1.click();



        WebElement actualDisplay = driver.findElement(By.xpath("//p[@id='result']"));
        String actualDisplayText = actualDisplay.getText();

        String expectedDisplay ="Clicked on button one!";


        if (actualDisplayText.equals(expectedDisplay)) {
            System.out.println("display verifying is PASSED!");
        }else{
            System.out.println("display verifying is FAILED!!!");
        }





    }
}
/*
XPATH Practice
DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
TC #6:  XPATH LOCATOR practice
1. Open Chrome browser
2. Go to http://practice.cydeo.com/multiple_buttons
3. Click on Button 1
4. Verify text displayed is as expected:
Expected: “Clicked on button one!”

USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 */