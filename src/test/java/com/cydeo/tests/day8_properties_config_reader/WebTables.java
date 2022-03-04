package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.tests.utilities.ConfigurationReader;
import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTables {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browserType = ConfigurationReader.getProperty("browser");
        driver= WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");
    }

    @Test
    public void test1() {

        ArrayList<String> actualResult = new ArrayList<>();


        List<WebElement> list = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[contains(text(),'art')]//following-sibling::td[6]"));

        for (WebElement each : list) {
            actualResult.add(each.getText());
        }

        ArrayList<String> expectedResult = new ArrayList<>(Arrays.asList("Canada","US","US"));

        Assert.assertEquals(actualResult,expectedResult);






    }
}
/*
TC 1:
1- go to https://practice.cydeo.com/web-tables
2- verify cities contains ‘art’ in their names
Expected Result:[“Canada”,”US”,”US”]
 */