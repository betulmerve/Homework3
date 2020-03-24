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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCases9to12 {

    private WebDriver driver;

    @DataProvider(name = "testData")
    public static Object[] testData(){
        return new Object[]{"200","301","404","500"};
    }

    @Test(dataProvider = "testData")
    public void testCases(String code){

        driver.findElement(By.linkText(code)).click();
        BrowserUtils.wait(2);
        String expected="This page returned a "+code+" status code";
        WebElement message=driver.findElement(By.tagName("p"));
        Assert.assertTrue(message.getText().contains(expected),"The status code does not exist");
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
