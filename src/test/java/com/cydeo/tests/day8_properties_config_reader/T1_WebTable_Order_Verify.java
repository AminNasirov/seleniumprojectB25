package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.tests.utilities.WebDriverFactory;
import com.cydeo.tests.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Order_Verify {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test_order_name_verify() {

        WebElement bobMartinCell =
                driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));

        System.out.println("bobMartinCell.getText() = " + bobMartinCell.getText());

        Assert.assertTrue(bobMartinCell.getText().equals("Bob Martin"));

        WebElement bobMartinOrderDate =
                driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));
  //        //td[.='Bob Martin']/../td[5]

        String expectedBobDate = "12/31/2021";
        String actualBobDate = bobMartinOrderDate.getText();

        Assert.assertEquals(actualBobDate,expectedBobDate);
    }

    @Test
    public void test2() {
       String customerOrderDate1 = WebTableUtils.returnOrderDate(driver,"Alexandra Gray");
        System.out.println("customerOrderDate1 = " + customerOrderDate1);
    }

    @Test
    public void test3() {

        WebTableUtils.orderVerify(driver,"Bob Martin","12/31/2021");
    }
}
/*
TC #1: Web table practice
 1. Go to: https://practice.cydeo.com/web-tables
2. Verify Bob’s name is listed as expected.
Expected: “Bob Martin”
3. Verify Bob Martin’s order date is as expected
Expected: 12/31/2021
 */