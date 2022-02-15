package com.cydeo.tests.day5_TestNG_Dynamic_WebElements_DropDowns;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T1_StaleElementReferenceException {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/add_remove_elements/");

        WebElement addElementButton = driver.findElement(By.xpath("//button[.='Add Element']"));
        addElementButton.click();
        Thread.sleep(2000);

        WebElement deleteButton = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));

        if (deleteButton.isDisplayed()){
            System.out.println("Delete button is displayed");
        }else{
            System.out.println("Delete button is NOT displayed");
        }

        deleteButton.click();


        try{
            deleteButton.isDisplayed();
        }catch (RuntimeException e){
            System.out.println("Delete button is NOT displayed");
            System.out.println(e.getMessage());
            e.printStackTrace();

        }

driver.close();








    }
}
/*
TC #1: StaleElementReferenceException handling
1. Open Chrome browser
2. Go to https://practice.cydeo.com/add_remove_elements/
3. Click to “Add Element” button
4. Verify “Delete” button is displayed after clicking.
5. Click to “Delete” button.
6. Verify “Delete” button is NOT displayed after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 */