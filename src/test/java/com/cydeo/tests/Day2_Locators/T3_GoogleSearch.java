package com.cydeo.tests.Day2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");

        //Write “apple” in search box
        // press enter using Keys.ENTER
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        googleSearchBox.sendKeys("apple" + Keys.ENTER);

        String expectedInTitle = "apple";
        String actualTittle = driver.getTitle();

        if(actualTittle.startsWith(expectedInTitle)){
            System.out.println("Tittle verification Passed!");
        }else{
            System.out.println("Tittle verification Failed!!!");
        }

        driver.close();







    }
}
/*
TC#3: Google search
1- Open a chrome browser
2- Go to: https://google.com
3- Write “apple” in search box
4- Click google search button
5- Verify title:
Expected: Title should start with “apple” word
 */