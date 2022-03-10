package com.cydeo.tests.day10_upload_action_jsexecutor;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice {

    @Test
    public void test_upload() {

        Driver.getDriver().get("https://practice.cydeo.com/upload");

        String path ="C:\\Users\\nasir\\IdeaProjects\\seleniumprojectB25\\src\\test\\java\\com\\cydeo\\tests\\day10_upload_action_jsexecutor\\T2_Upload_Practice.java";


        WebElement fileUpload = Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));
        BrowserUtils.sleep(3);
        fileUpload.sendKeys(path);

        WebElement uploadButton = Driver.getDriver().findElement(By.xpath("//input[@id='file-submit']"));

        uploadButton.click();

       WebElement fileUploaded = Driver.getDriver().findElement(By.xpath("//h3"));

        Assert.assertTrue(fileUploaded.isDisplayed());







    }
}
/*
TC #2 Upload Test
1. Go to https://practice.cydeo.com/upload
2. Find some small file from your computer, and get the path of it.
3. Upload the file.
4. Assert:
-File uploaded text is displayed on the page
 */