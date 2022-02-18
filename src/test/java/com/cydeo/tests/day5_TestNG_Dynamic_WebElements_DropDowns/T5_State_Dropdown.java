package com.cydeo.tests.day5_TestNG_Dynamic_WebElements_DropDowns;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_State_Dropdown {

     WebDriver driver;


     @BeforeMethod
     public void setupMethod(){
         driver= WebDriverFactory.getDriver("Chrome");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.get("http://practice.cybertekschool.com/dropdown");
     }


     @Test
    public void stateDropdown(){

         Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

         stateDropdown.selectByValue("IL");
         stateDropdown.selectByVisibleText("Virginia");
         stateDropdown.selectByVisibleText("California");

         WebElement lastSelectedOption = stateDropdown.getFirstSelectedOption();
         String getLastSelectedOption = lastSelectedOption.getText();
         String expectedLastSelectedOption = "California";

         Assert.assertEquals(getLastSelectedOption,expectedLastSelectedOption);
         System.out.println(getLastSelectedOption);

     }

}
/*
TC #5: Selecting state from State dropdown and verifying result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
 */
