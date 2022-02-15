package com.cydeo.tests.day4_findElements_checkbox_radioButton;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class LocateElementByCssSelector_FormTask {
    public static void main(String[] args) throws InterruptedException {

        WebDriver  driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/registration_form");

        Thread.sleep(2000);

        WebElement firstnameField = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstnameField.sendKeys("Amin");
        Thread.sleep(2000);

        WebElement lastnameField = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastnameField.sendKeys("Nasirov");
        Thread.sleep(2000);

        WebElement usernameField = driver.findElement(By.cssSelector("input[name='username']"));
        usernameField.sendKeys("AminNasirov");
        Thread.sleep(2000);

        WebElement emailField = driver.findElement(By.cssSelector("input[name='email']"));
        emailField.sendKeys("amin_nasirov@yahoo.com");
        Thread.sleep(2000);


        WebElement passwordFiled = driver.findElement(By.cssSelector("input[name='password']"));
        passwordFiled.sendKeys("Amin12345");
        Thread.sleep(2000);

        WebElement phoneFiled = driver.findElement(By.cssSelector("input[name='phone']"));
        phoneFiled.sendKeys("706-402-1556");
        Thread.sleep(2000);

        WebElement genderRadioBtn = driver.findElement(By.cssSelector("input[value='male']"));
        genderRadioBtn.click();
        Thread.sleep(2000);

        WebElement dateOfBirth = driver.findElement(By.cssSelector("input[name='birthday']"));
        dateOfBirth.sendKeys("01/15/1989");
        Thread.sleep(2000);

        WebElement selectDepartment = driver.findElement(By.cssSelector("select[name='department']"));
        Select depSelectObj = new Select(selectDepartment);
        depSelectObj.selectByIndex(1);
        Thread.sleep(2000);


        WebElement selectTitle = driver.findElement(By.cssSelector("select[name='job_title']"));
        Select titleSelectObj = new Select(selectTitle);
        titleSelectObj.selectByIndex(3);
        Thread.sleep(2000);

        WebElement checkbox1 = driver.findElement(By.cssSelector("#inlineCheckbox2"));
        checkbox1.click();
        Thread.sleep(2000);

        WebElement signupBtn = driver.findElement(By.cssSelector("#wooden_spoon"));
        signupBtn.click();
        Thread.sleep(2000);

        driver.quit();




    }
}
