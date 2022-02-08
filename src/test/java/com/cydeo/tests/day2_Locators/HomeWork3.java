package com.cydeo.tests.day2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");

        Thread.sleep(3000);

        WebElement clickGmailButton = driver.findElement(By.className("gb_d"));
        clickGmailButton.click();

        String expectedTitle = "Gmail";
        String actualTittle = driver.getTitle();

        if (actualTittle.contains(expectedTitle)) {
            System.out.println("TITTLE VERIFICATION PASSED!");
        }else{
            System.out.println("TITTLE VERIFICATION FAILED!!!");
        }

        Thread.sleep(3000);

        driver.navigate().back();

        expectedTitle = "Google";
        actualTittle = driver.getTitle();

        if(actualTittle.equals(expectedTitle)){
            System.out.println("TITTLE VERIFICATION PASSED!");
        }else{
            System.out.println("TITTLE VERIFICATION FAILED!!!");
        }

        Thread.sleep(300);
        driver.close();



    }
}
/*
TC #3: Back and forth navigation
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
  Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
  Expected: Google
 */