package com.cydeo.tests.day_6_alerts_iframes_windows;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class dropdowns {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
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


    @Test
    public void nonSelectDropdown(){

        WebElement nonSelectDropdown = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));

        nonSelectDropdown.click();

        WebElement selectFacebook = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/']"));

        selectFacebook.click();

        String expectedTitle = "Facebook - Log In or Sign Up";

        String currentTittle = driver.getTitle();

        Assert.assertEquals(currentTittle,expectedTitle);

    }





}
