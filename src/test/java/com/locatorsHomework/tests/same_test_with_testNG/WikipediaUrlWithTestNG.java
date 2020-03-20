package com.locatorsHomework.tests.same_test_with_testNG;

import com.locatorsHomework.utilities.BrowserFactory;
import com.locatorsHomework.utilities.LocatorFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WikipediaUrlWithTestNG {
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
    public void checkUrl(){
        driver.get("https://www.wikipedia.org/");
        String searchTerm = "selenium webdriver";
        String expectedEndsWith = "Selenium_(software)";

        WebElement searchField = LocatorFactory.locateElement(driver,"id","searchInput");
        searchField.sendKeys(searchTerm);

        WebElement searchButton = LocatorFactory.locateElement(driver,"xpath","//button[starts-with(@class,\"pure-button\") and @type=\"submit\"]");
        searchButton.click();

        WebElement seleniumSoftwareLink = LocatorFactory.locateElement(driver,"xpath","//a[@href=\"/wiki/Selenium_(software)\"]");
        seleniumSoftwareLink.click();

        System.out.println("5. verify url ends with Selenium_(software)");
        Assert.assertTrue(driver.getCurrentUrl().endsWith(expectedEndsWith));
    }


}
