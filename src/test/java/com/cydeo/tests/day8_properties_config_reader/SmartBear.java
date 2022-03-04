package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.tests.utilities.ConfigurationReader;
import com.cydeo.tests.utilities.SmartBearUtils;
import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBear {
WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env1"));
    }

    @Test
    public void test_link_verification() {

        SmartBearUtils.login(driver);

        List<WebElement> list = driver.findElements(By.xpath("//a"));

        System.out.println(list.size());

        for (WebElement each : list) {
            System.out.println(each.getText());
        }


    }

    @Test
    public void test_order_verification() {
        SmartBearUtils.login(driver);

        WebElement order = driver.findElement(By.xpath("//td[.='Susan McLaren']//following-sibling::td[.='01/05/2010']"));
        String actualOrder = order.getText();
        String expectedOrder = "01/05/2010";
        Assert.assertEquals(actualOrder,expectedOrder);
    }
}
