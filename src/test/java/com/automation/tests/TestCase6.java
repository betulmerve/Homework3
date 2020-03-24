package com.automation.tests;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase6 {

    //step 10?
    private WebDriver driver;
    @Test
    public void testCase6() {
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get("https://www.tempmailaddress.com/");
        String email=driver.findElement(By.id("email")).getText();
        BrowserUtils.wait(2);
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.name("full_name")).sendKeys("merve cakir");
        driver.findElement(By.name("email")).sendKeys(email);
        BrowserUtils.wait(2);
        driver.findElement(By.name("wooden_spoon")).click();
        BrowserUtils.wait(2);
        String expected="Thank you for signing up. Click the button below to return to the home page.";
        String actual=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(actual,expected);
        driver.navigate().to("https://www.tempmailaddress.com/");
        BrowserUtils.wait(5);
        //Step10
        WebElement received=driver.findElement(By.xpath("//td[text()='Thanks for subscribing to practice.cybertekschool.com!']"));
        Assert.assertTrue(received.isDisplayed());
        received.click();
        BrowserUtils.wait(2);

        String expectedMail="do-not-reply@practice.cybertekschool.com";
        String actualMail=driver.findElement(By.id("odesilatel")).getText();
        Assert.assertEquals(actualMail,expectedMail);
        String expectedSubject="Thanks for subscribing to practice.cybertekschool.com!";
        String actualSubject=driver.findElement(By.id("predmet")).getText();
        Assert.assertEquals(actualSubject,expectedSubject);

        driver.quit();

    }
}
