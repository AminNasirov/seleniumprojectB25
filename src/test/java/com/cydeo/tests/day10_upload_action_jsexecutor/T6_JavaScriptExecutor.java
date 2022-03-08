package com.cydeo.tests.day10_upload_action_jsexecutor;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class T6_JavaScriptExecutor {

    @Test
    public void test_1() {
        WebDriver driver = Driver.getDriver();

        driver.get("https://practice.cydeo.com/infinite_scroll");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i <10 ; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,750)");
        }

        for (int i = 0; i <10 ; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,-750)");
        }





    }
}
/*
TC #6: Scroll using JavascriptExecutor
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/infinite_scroll
3- Use below JavaScript method and scroll
a.  750 pixels down 10 times.
b.  750 pixels up 10 times

JavaScript method to use : window.scrollBy(0,0)
 */