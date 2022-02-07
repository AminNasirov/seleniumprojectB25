package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {



        // 1- set up the browser driver

        WebDriverManager.chromedriver().setup();

        // 2- Create instance of the Selenium web driver
        // this is line opening an empty browser
        WebDriver driver = new ChromeDriver();


        // this line will maximize browser
        driver.manage().window().maximize();

       // driver.manage().window().fullscreen(); same thing with maximize for MAC


        // 3- got to "https://www.tesla.com"
        driver.get("https://www.tesla.com");


        // get the tittle of the page
        String currentTittle = driver.getTitle();
        System.out.println("currentTittle = " + currentTittle);


        String currentURL =  driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);



        // stop code execution for 3 seconds
       Thread.sleep(3000);


        // use selenium to navigate back
        driver.navigate().back();



        // stop code execution for 3 seconds
        Thread.sleep(3000);


        // use selenium to navigate forward
        driver.navigate().forward();



        // stop code execution for 3 seconds
        Thread.sleep(3000);


        // use selenium to navigate refresh
        driver.navigate().refresh();


        // stop code execution for 3 seconds
        Thread.sleep(3000);

        // use navigate().to()
        driver.navigate().to("https://www.google.com");

        // getting current tittle after getting the google tittle
        currentTittle= driver.getTitle();


        // get the tittle of the page
        //System.out.println("driver.getTitle() = " + driver.getTitle());


        System.out.println("currentTittle = " + currentTittle);


        // get the current URL using Selenium
        currentURL =  driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        // this will close the currently opened window
        driver.close();

        // this will close all the opened browsers
        driver.quit();







    }

}
