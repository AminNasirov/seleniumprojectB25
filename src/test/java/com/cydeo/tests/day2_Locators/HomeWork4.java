package com.cydeo.tests.day2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork4 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/inputs");

        Thread.sleep(3000);

        WebElement homeLink = driver.findElement(By.linkText("Home"));
        homeLink.click();

        String expectedTitle = "Practice";
        String currentTittle = driver.getTitle();

        if(currentTittle.equals(expectedTitle)){
            System.out.println("TITTLE VERIFICATION PASSED!");
        }else{
            System.out.println("TITTLE VERIFICATION FAILED!!!");
        }

        driver.close();




    }
}
/*
TC #4: Practice Cydeo – Class locator practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/inputs
3- Click to “Home” link
4- Verify title is as expected:
Expected: Practice

PS: Locate “Home” link using “className” locator
 */