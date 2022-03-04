package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.tests.utilities.ConfigurationReader;
import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Herokuapp {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browserType = ConfigurationReader.getProperty("browser");
        driver= WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void test1() {
        WebElement iframe = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[44]/a"));
        iframe.click();
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));



        WebElement writeText = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
   String actualText =  writeText.getText();
   String expectedText = "Your content goes here.";

        Assert.assertEquals(actualText,expectedText);

        driver.switchTo().parentFrame();

        WebElement header = driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']"));

        String actualHeader = header.getText();

        String expectedHeader ="An iFrame containing the TinyMCE WYSIWYG Editor";

        Assert.assertEquals(actualHeader,expectedHeader);



    }
}
/*
TC 1: As a User I should be able to see ‘Your content goes here.’ And ‘An iFrame
containing the TinyMCE WYSIWYG Editor’
1- Open a chrome browser
2- Go to https://the-internet.herokuapp.com/
3- Click iFrame
4- Verify the ‘Your content goes here.’ label
5- Verify the header ‘An iFrame containing the TinyMCE WYSIWYG Editor’
TC 2: As a User I should be able to see BOTTOM label
1- Open a chrome browser
2- Go to https://the-internet.herokuapp.com/
3- Click Nested Frames
4- Verify the BOTTOM label
TC 3: As a User I should be able to see MIDDLE label
1- Open a chrome browser
2- Go to https://the-internet.herokuapp.com/
3- Click Nested Frames
4- Verify the MIDDLE label
TC 4: As a User I should be able to see RİGHT label and LEFT label
1- Open a chrome browser
2- Go to https://the-internet.herokuapp.com/
3- Click Nested Frames
4- Verify the RİGHT label
5- Verify the LEFT label
 */