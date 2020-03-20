package com.locatorsHomework.tests.same_test_with_testNG;

import com.locatorsHomework.utilities.BrowserFactory;
import com.locatorsHomework.utilities.LocatorFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonTitleWithTestNG {
    WebDriver driver;

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
    public void checkTitle(){
        String searchItem = "wooden spoon";

        driver.get("https://www.amazon.com/");
        WebElement searchField = LocatorFactory.locateElement(driver,"id", "twotabsearchtextbox");
        searchField.sendKeys(searchItem);
        WebElement searchButton = LocatorFactory.locateElement(driver,"xpath", "//input[@type='submit' and @class='nav-input']");
        searchButton.click();

        System.out.println("4. verify page title contains the search term");
        Assert.assertTrue(driver.getTitle().contains(searchItem));
    }


}
