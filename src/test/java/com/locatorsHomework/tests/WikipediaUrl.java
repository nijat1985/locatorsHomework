package com.locatorsHomework.tests;

import com.locatorsHomework.utilities.BrowserFactory;
import com.locatorsHomework.utilities.LocatorFactory;
import com.locatorsHomework.utilities.StringUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaUrl {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
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
        StringUtility.verifyEndsWith(driver.getCurrentUrl(),expectedEndsWith);

        driver.quit();
    }
}
