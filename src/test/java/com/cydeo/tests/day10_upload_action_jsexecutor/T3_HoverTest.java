package com.cydeo.tests.day10_upload_action_jsexecutor;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_HoverTest {

    @Test
    public void test_hovering() {

        WebDriver driver = Driver.getDriver();
        driver.get("https://practice.cydeo.com/hovers ");


        WebElement img1= driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2= driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3= driver.findElement(By.xpath("(//img)[3]"));

        WebElement user1= driver.findElement(By.xpath("//h5[text()='name: user1']"));
        WebElement user2= driver.findElement(By.xpath("//h5[text()='name: user2']"));
        WebElement user3= driver.findElement(By.xpath("//h5[text()='name: user3']"));

        Actions actions = new Actions(driver);

        BrowserUtils.sleep(2);
        actions.moveToElement(img1).perform();
        Assert.assertTrue(user1.isDisplayed());

        BrowserUtils.sleep(2);
        actions.moveToElement(img2).perform();
        Assert.assertTrue(user2.isDisplayed());


        BrowserUtils.sleep(2);
        actions.moveToElement(img3).perform();
        Assert.assertTrue(user3.isDisplayed());











    }
}
/*
TC #3: Hover Test
1. Go to https://practice.cydeo.com/hovers
2. Hover over to first image
3. Assert:
a. “name: user1” is displayed
b. “view profile” is displayed
4. Hover over to second image
5. Assert:
a. “name: user2” is displayed
b. “view profile” is displayed
6. Hover over to third image
7. Confirm:
a. “name: user3” is displayed
b. “view profile” is displayed
 */