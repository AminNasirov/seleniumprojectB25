package com.cydeo.tests.Day2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoPracticeToolVerifications {
   public static void main(String[] args) {


     WebDriverManager.chromedriver().setup();

       WebDriver driver = new ChromeDriver();

       driver.manage().window().maximize();

       driver.get("https://practice.cydeo.com ");

      String currentURL =driver.getCurrentUrl();

      String expectedURL ="Cydeo";

       if (expectedURL.equals(currentURL)) {
           System.out.println("current URL: " + currentURL);
       }else{
           throw new RuntimeException("Invalid URL");
       }

       String expectedTitle = "Practice";

       String currentTitle = driver.getTitle();

       if(currentTitle.contains(expectedTitle)){
           System.out.println(currentTitle);
       }else{
           throw new RuntimeException("Invalid Title");
       }


       driver.close();






   }
}
/*
TC #1: Cydeo practice tool verifications
1. Open Chrome browser
2. Go to https://practice.cydeo.com
3. Verify URL contains
Expected: cydeo
4. Verify title:
       Expected: Practice

 */