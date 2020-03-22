package com.automation.tests;
import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestCases1to5 {

    private WebDriver driver;

    @Test
    public void testCase1() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Registration Form")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        BrowserUtils.wait(3);

        WebElement warningMessage=driver.findElement(By.xpath("//small[text()='The date of birth is not valid']"));
        Assert.assertTrue(warningMessage.isDisplayed());

    }

    @Test
    public void testCase2() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Registration Form")).click();
        BrowserUtils.wait(3);
        WebElement c=driver.findElement(By.id("inlineCheckbox1"));
        WebElement js=driver.findElement(By.id("inlineCheckbox2"));
        WebElement java=driver.findElement(By.id("inlineCheckbox3"));
        Assert.assertTrue(c.isDisplayed());
        Assert.assertTrue(js.isDisplayed());
        Assert.assertTrue(java.isDisplayed());

    }

    @Test
    public void testCase3() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Registration Form")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("firstname")).sendKeys("a");
        WebElement warningMessage=driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warningMessage.isDisplayed());
    }
    @Test
    public void testCase4() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Registration Form")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("lastname")).sendKeys("a");
        WebElement warningMessage=driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warningMessage.isDisplayed());

    }

    @Test
    public void testCase5() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Registration Form")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("firstname")).sendKeys("merve");
        driver.findElement(By.name("lastname")).sendKeys("cakir");
        driver.findElement(By.name("username")).sendKeys("mervecakir");
        driver.findElement(By.name("email")).sendKeys("mc@gmail.com");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.name("phone")).sendKeys("203-456-7768");
        driver.findElement(By.cssSelector("input[value='female']")).click();
        driver.findElement(By.name("birthday")).sendKeys("01/01/1990");
        WebElement department=driver.findElement(By.name("department"));
        Select departmentSelect=new Select(department);
        departmentSelect.selectByVisibleText("Mayor's Office");
        WebElement jobTitle=driver.findElement(By.name("job_title"));
        Select jobTitleSelect=new Select(jobTitle);
        jobTitleSelect.selectByVisibleText("SDET");
        driver.findElement(By.id("inlineCheckbox2")).click();
        BrowserUtils.wait(5);

        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(5);

        WebElement successMessage=driver.findElement(By.xpath("//p"));
        Assert.assertTrue(successMessage.isDisplayed());

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
