package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.tests.utilities.ConfigurationReader;
import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GasMileageCalculatorTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("gasMileage"));
    }

    @Test
    public void test1() {
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='calcSearchTerm']"));
        searchBox.sendKeys("gas mileage"+ Keys.ENTER);

        WebElement linkCalculator = driver.findElement(By.xpath("//a[.='Gas Mileage Calculator']"));
        linkCalculator.click();

        String expectedTitle ="Gas Mileage Calculator";
       String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle,"invalid Title");

        WebElement label = driver.findElement(By.xpath("//h1[.='Gas Mileage Calculator']"));

        Assert.assertTrue(label.isDisplayed());

        WebElement currentOdom = driver.findElement(By.xpath("//input[@id='uscodreading']"));
        currentOdom.clear();
        currentOdom.sendKeys("7925");

        WebElement previousOdom = driver.findElement(By.xpath("//input[@id='uspodreading']"));
        previousOdom.clear();
        previousOdom.sendKeys("7550");

        WebElement gasAdded = driver.findElement(By.xpath("//input[@id='usgasputin']"));
        gasAdded.clear();
        gasAdded.sendKeys("16");


        WebElement gasPrice = driver.findElement(By.xpath("//input[@id='usgasprice']"));
        gasPrice.clear();
        gasPrice.sendKeys("3.55");

        WebElement clickButton = driver.findElement(By.xpath("//*[@id=\"standard\"]/tbody/tr[5]/td/input"));
        clickButton.click();

        WebElement actualValue = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b"));

        String actualResult = actualValue.getText();
        String expectedResult = "23.44 mpg";

        Assert.assertEquals(actualResult,expectedResult);

    }
}
