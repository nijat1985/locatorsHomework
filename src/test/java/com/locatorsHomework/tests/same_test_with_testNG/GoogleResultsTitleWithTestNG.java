package com.locatorsHomework.tests.same_test_with_testNG;

import com.locatorsHomework.utilities.BrowserFactory;
import com.locatorsHomework.utilities.LocatorFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class GoogleResultsTitleWithTestNG {
    WebDriver driver;
    List<String> searchStrs = Arrays.asList("Java", "cucumber bdd", "Selenium web browser automation");

    @BeforeMethod
    public void openBrowser(){
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void googleResults() throws InterruptedException {
        driver.get("https://www.google.com/");

        for(String str : searchStrs){
            WebElement searchField = LocatorFactory.locateElement(driver,"name","q");
            searchField.clear();
            searchField.sendKeys(str + Keys.ENTER);
            String url = LocatorFactory.locateElement(driver,"xpath","//cite").getText();
            WebElement firstRsult = LocatorFactory.locateElement(driver,"xpath","//div/a/h3");
            Thread.sleep(3000);
            firstRsult.click();
            System.out.println("6. Verify that url is equal to the value from step 4");
            Assert.assertEquals(driver.getCurrentUrl(),url);
            Thread.sleep(3000);
            driver.navigate().back();
            Thread.sleep(3000);
        }
    }
}
