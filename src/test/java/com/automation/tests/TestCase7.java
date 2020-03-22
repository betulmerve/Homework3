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

public class TestCase7 {

    private WebDriver driver;
    @Test
    public void testCase7(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("File Upload")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.id("file-upload")).sendKeys("/Users/mervefaki/Desktop/Deneme.txt");
        BrowserUtils.wait(2);
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(2);
        String expected="File Uploaded!";
        String actual=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(actual,expected);
        WebElement fileName=driver.findElement(By.id("uploaded-files"));
        Assert.assertTrue(fileName.isDisplayed());
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
