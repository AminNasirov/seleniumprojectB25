package com.cydeo.tests.day3_cssSelector_Xpath;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_getText_getAttribute {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/ ");

       WebElement rememberMeLabel =  driver.findElement(By.className("login-item-checkbox-label"));

       String expectedRememberMeLabel = "Remember me on this computer";
       String actualRememberMeLabel = rememberMeLabel.getText();

       if(actualRememberMeLabel.equals(expectedRememberMeLabel)){
           System.out.println("label verification passed!");
       }else{
           System.out.println("label verification failed!!!");
       }

       WebElement forgotPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));

       String expectedForgotPasswordLink = "Forgot your password?";
       String actualForgotPasswordLink = forgotPasswordLink.getText();

        if (actualForgotPasswordLink.equals(expectedForgotPasswordLink)) {
            System.out.println("forgot password link verification passed!");
        }else{
            System.err.println("forgot password link verification failed!!!");
            System.out.println("actualForgotPasswordLink = " + actualForgotPasswordLink);
            System.out.println("expectedForgotPasswordLink = " + expectedForgotPasswordLink);
        }

        //Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes

        String expectedInHrefAttributeValue = "forgot_password=yes";

        String actualInHrefAttributeValue = forgotPasswordLink.getAttribute("href");

        if(actualInHrefAttributeValue.contains(expectedInHrefAttributeValue)){
            System.out.println("HREF attribute value verification passed!");
        }else{
            System.out.println("HREF attribute value verification failed!!!");
        }





    }
}
/*
TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “remember me” label text is as expected:
Expected: Remember me on this computer
4- Verify “forgot password” link text is as expected:
Expected: Forgot your password?
5- Verify “forgot password” href attribute’s value contains expected:
Expected: forgot_password=yes



PS: Inspect and decide which locator you should be using to locate web
elements.
 */