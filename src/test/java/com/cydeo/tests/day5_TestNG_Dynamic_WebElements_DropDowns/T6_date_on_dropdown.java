package com.cydeo.tests.day5_TestNG_Dynamic_WebElements_DropDowns;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T6_date_on_dropdown {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
    driver= WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void dateDropdown(){

        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        yearDropdown.selectByVisibleText("1923");
        monthDropdown.selectByValue("11");
        dayDropdown.selectByIndex(0);

        // WebElement getCurrentYear = yearDropdown.getFirstSelectedOption();
        // WebElement getCurrentMonth = monthDropdown.getFirstSelectedOption();
        // WebElement getCurrentDay =dayDropdown.getFirstSelectedOption();

        String expectedYear ="1923";
        String expectedMonth = "December";
        String expectedDay = "1";

        String currentYearDropdown = yearDropdown.getFirstSelectedOption().getText();
        String currentMonthDropdown = monthDropdown.getFirstSelectedOption().getText();
        String currentDayDropdown = dayDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(currentYearDropdown,expectedYear);
        Assert.assertEquals(currentMonthDropdown,expectedMonth);
        Assert.assertEquals(currentDayDropdown,expectedDay);


    }

}
/*
TC #6: Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select “December 1st, 1923” and verify it is selected.
Select year using  : visible text
Select month using   : value attribute
Select day using : index number
 */