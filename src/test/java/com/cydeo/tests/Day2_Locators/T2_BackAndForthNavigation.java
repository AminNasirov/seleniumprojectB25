package com.cydeo.tests.Day2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_BackAndForthNavigation {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com ");


        //3- Click to A/B Testing from top of the list.
     //  driver.findElement(By.linkText("A/B Testing")).click();
        WebElement abTestLink = driver.findElement(By.linkText("A/B Testing"));
        abTestLink.click();

        String expectedTitle = "No A/B Test";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Tittle verification PASS!");
        }else{
            System.out.println("Tittle verification FAILED!");
        }

        driver.navigate().back();

         expectedTitle = "Practice";
        actualTitle= driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Tittle verification PASS!");
        }else{
            System.out.println("Tittle verification FAILED!");
        }

        driver.close();






    }
}
/*
TC #3: Back and forth navigation
1- Open a chrome browser
2- Go to: https://practice.cydeo.com
3- Click to A/B Testing from top of the list.
4- Verify title is:
  Expected: No A/B Test
5- Go back to home page by using the .back();
6- Verify title equals:
  Expected: Practice
 */