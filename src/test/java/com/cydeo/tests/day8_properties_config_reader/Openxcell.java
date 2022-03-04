package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.tests.utilities.ConfigurationReader;
import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Openxcell {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("urlOpenxcell"));
    }

    @Test
    public void test_number_of_links() {

        List<WebElement> list = driver.findElements(By.xpath("//a"));

        int actualSize = list.size();
        int expectedSize=325;

        Assert.assertEquals(actualSize,expectedSize);

    }

    @Test
    public void test_texts_of_links() {
        List<WebElement> list = driver.findElements(By.xpath("//a"));


        for (WebElement each : list) {
            try {
                System.out.println(each.getText());
            }catch (StaleElementReferenceException e){
                System.out.println(e.getMessage());
            }
        }
    }


    @Test
    public void test_texts_of_links_numbers() {
        List<WebElement> list = driver.findElements(By.xpath("//a"));

        int expectedSize =228;
        int actualSize = 0;
        for (WebElement each : list) {
            try {
                if (each.getText().isEmpty()){
                   actualSize++;
                }
            }catch (StaleElementReferenceException e){
                System.out.println(e.getMessage());
            }
        }

       Assert.assertEquals(actualSize,expectedSize);
    }





}
