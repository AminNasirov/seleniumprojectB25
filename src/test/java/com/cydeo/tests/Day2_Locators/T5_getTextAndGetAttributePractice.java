package com.cydeo.tests.Day2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_getTextAndGetAttributePractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/registration_form");

        // Verify header text is as expected:
        WebElement headerText = driver.findElement(By.tagName("h2"));
        //  Expected: Registration form
        String expectedHeader = "Registration form";
        String actualHeaderText = headerText.getText();

        if (actualHeaderText.equals(expectedHeader)) {
            System.out.println("Header text verification PASSED!");
        }else{
            System.out.println("Header text verification FAILED!!!");
        }

        // Locate “First name” input box
        WebElement firstNameInput = driver.findElement(By.name("firstname"));

        // Verify placeholder attribute’s value is as expected:
        //  Expected: first name
        String expectedPlaceHolder = "first name";
        String actualPlaceHolder = firstNameInput.getAttribute("placeholder");

        if(actualPlaceHolder.equals(expectedPlaceHolder)){
            System.out.println("Place Holder verification PASSED!");
        }else{
            System.out.println("Place Holder verification FAILED!!!");
        }

        driver.close();












    }
}
/*
TC #5: getText() and getAttribute() method practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/registration_form
3- Verify header text is as expected:
  Expected: Registration form
4- Locate “First name” input box
5- Verify placeholder attribute’s value is as expected:
  Expected: first name
 */