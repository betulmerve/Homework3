package com.automation.tests.cases1_5;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestCases1to5 {

    private WebDriver driver;

    @Test
    public void testCase1() throws Exception{
        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(3000);
        driver.findElement(By.linkText("Registration Form")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        Thread.sleep(3000);

        String expected="";
        String actual="";

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
