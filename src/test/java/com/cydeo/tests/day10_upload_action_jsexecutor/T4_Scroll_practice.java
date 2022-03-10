package com.cydeo.tests.day10_upload_action_jsexecutor;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T4_Scroll_practice {

    @Test
    public void test1() {
        WebDriver driver = Driver.getDriver();

        driver.get("https://practice.cydeo.com/");

        WebElement poweredByCydeo = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));

        Actions actions = new Actions(driver);

        BrowserUtils.sleep(2);
        actions.moveToElement(poweredByCydeo).perform();

        BrowserUtils.sleep(2);
        actions.moveToElement(homeLink).perform();






    }
}
/*
TC #4: Scroll practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/
3- Scroll down to “Powered by CYDEO”
4- Scroll using Actions class “moveTo(element)” method

TC #5: Scroll practice 2
1- Continue from where the Task 4 is left in the same test.
2- Scroll back up to “Home” link using PageUP button


 */