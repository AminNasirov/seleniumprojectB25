package com.cydeo.tests.day5_TestNG_Dynamic_WebElements_DropDowns;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T8_Multiple_Select_Dropdown {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");
    }



    @Test
    public void multipleSelectDropdown(){

        Select languages = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));


        List<WebElement> allOptions = languages.getOptions();

        for (WebElement allOption : allOptions) {
            languages.selectByVisibleText(allOption.getText());
        }

        for (WebElement allOption : allOptions) {
            if(allOption.isSelected()){
                System.out.println(allOption.getText());
            }
        }

        languages.deselectAll();

        System.out.println(languages.getAllSelectedOptions().isEmpty());



    }

}
/*
TC #8: Selecting value from multiple select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select all the options from multiple select dropdown.
4. Print out all selected values.
5. Deselect all values.
 */