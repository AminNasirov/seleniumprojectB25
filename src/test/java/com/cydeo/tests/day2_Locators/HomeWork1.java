package com.cydeo.tests.day2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.etsy.com");

        WebElement etsySearchBox = driver.findElement(By.id("global-enhancements-search-query"));

        Thread.sleep(3000);

        etsySearchBox.sendKeys("wooden spoon"+ Keys.ENTER);


        String expectedTitle = "Wooden spoon | Etsy";

        String currentTitle = driver.getTitle();

        if (currentTitle.equals(expectedTitle)){
            System.out.println("TITTLE VERIFICATION PASSED!");
        }else{
            System.out.println("TITTLE VERIFICATION FAILED!!!");
        }

        driver.close();





    }
}
/*
TC #1: Etsy Title Verification
1. Open Chrome browser
2. Go to https://www.etsy.com
3. Search for “wooden spoon”
4. Verify title:
Expected: “Wooden spoon | Etsy”
 */