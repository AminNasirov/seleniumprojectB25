package com.cydeo.tests.day5_TestNG_Dynamic_WebElements_DropDowns;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T2_Radiobutton_handling {
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/radio_buttons");

        WebElement hockeyButton = driver.findElement(By.xpath("//input[@id='hockey']"));
        hockeyButton.click();

        if(hockeyButton.isSelected()){
            System.out.println("hockey button is selected");
        }else{
            System.out.println("hockey button is NOT selected");
        }



    }
}
/*
TC #2: Radiobutton handling
1. Open Chrome browser
2. Go to https://practice.cydeo.com/radio_buttons
3. Click to “Hockey” radio button
4. Verify “Hockey” radio button is selected after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 */