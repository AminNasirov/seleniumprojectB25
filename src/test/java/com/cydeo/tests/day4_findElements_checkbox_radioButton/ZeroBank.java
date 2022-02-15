package com.cydeo.tests.day4_findElements_checkbox_radioButton;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ZeroBank {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/login.html");

        WebElement zeroBank = driver.findElement(By.xpath("//a[@class='brand']"));

        String expectedLinkText = "Zero Bank";

        String actualLinkText =zeroBank.getText();

        String link = zeroBank.getAttribute("href");




        if(actualLinkText.equals(expectedLinkText)){
            System.out.println("passed");
            System.out.println(actualLinkText);
        }else{
            System.out.println("failed");
            System.out.println(actualLinkText);
            System.out.println(expectedLinkText);
        }

        if(link.contains("index.htm")){
            System.out.println("correct");
        }else{
            System.out.println("not correct");
        }

    }
}
// verify the link href from inspected page and make sure it contains "index.htm