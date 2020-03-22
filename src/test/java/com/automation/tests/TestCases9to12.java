package com.automation.tests;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases9to12 {

    private WebDriver driver;
    @Test
    public void testCase9(){
        //step 4?

        driver.findElement(By.linkText("200")).click();
        BrowserUtils.wait(2);
        String expected="This page returned a 200 status code";
        WebElement message=driver.findElement(By.tagName("p"));
        Assert.assertTrue(message.isDisplayed());
    }
    @Test
    public void testCase10(){

        driver.findElement(By.linkText("301")).click();
        BrowserUtils.wait(2);
        String expected="This page returned a 301 status code";
        WebElement message=driver.findElement(By.tagName("p"));
        Assert.assertTrue(message.isDisplayed());
    }

    @Test
    public void testCase11(){

        driver.findElement(By.linkText("404")).click();
        BrowserUtils.wait(2);
        String expected="This page returned a 404 status code";
        WebElement message=driver.findElement(By.tagName("p"));
        Assert.assertTrue(message.isDisplayed());
    }

    @Test
    public void testCase12(){

        driver.findElement(By.linkText("500")).click();
        BrowserUtils.wait(2);
        String expected="This page returned a 500 status code";
        WebElement message=driver.findElement(By.tagName("p"));
        Assert.assertTrue(message.isDisplayed());
    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Status Codes")).click();
        BrowserUtils.wait(2);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
