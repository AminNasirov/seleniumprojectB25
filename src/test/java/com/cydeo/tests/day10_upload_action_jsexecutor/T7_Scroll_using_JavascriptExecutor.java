package com.cydeo.tests.day10_upload_action_jsexecutor;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T7_Scroll_using_JavascriptExecutor {


    @Test
    public  void test1(){
        WebDriver driver = Driver.getDriver();

        driver.get("https://practice.cydeo.com/large");
        WebElement cydeoLink = driver.findElement(By.xpath("//a[text()='CYDEO']"));
        WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;


            BrowserUtils.sleep(1);
            js.executeScript("arguments[0].scrollIntoView(true);",cydeoLink);
        BrowserUtils.sleep(1);
        js.executeScript("arguments[0].scrollIntoView(true);",homeLink);






    }


}
/*
TC #7: Scroll using JavascriptExecutor
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/large
3- Scroll down to “Cydeo” link
4- Scroll up to “Home” link
5- Use below provided JS method only

JavaScript method to use : arguments[0].scrollIntoView(true)

Note: You need to locate the links as web elements and pass them as
arguments into executeScript() method

 */