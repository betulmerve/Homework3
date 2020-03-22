package com.automation.tests;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase8 {
    private WebDriver driver;
    @Test
    public void testCase8(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.xpath("//input[@type='button']")).click();
        BrowserUtils.wait(2);
        String expected="You selected: United States of America";
        String actual=driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actual,expected);

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
