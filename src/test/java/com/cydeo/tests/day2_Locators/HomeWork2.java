package com.cydeo.tests.day2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork2 {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");

        WebElement headerText = driver.findElement(By.className("page-header"));

        String expectedHeaderText = "Log in to ZeroBank";
        String actualHeaderText = headerText.getText();

        if(actualHeaderText.equals(expectedHeaderText)){
            System.out.println("HEADER TEXT VERIFICATION PASSED!");
        }else{
            System.out.println("HEADER TEXT VERIFICATION FAILED!!!");
        }

        driver.close();





    }
}
/*
TC #2: Zero Bank header verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify header text
Expected: “Log in to ZeroBank”
 */