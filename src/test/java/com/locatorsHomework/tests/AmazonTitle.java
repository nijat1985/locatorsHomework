package com.locatorsHomework.tests;

import com.locatorsHomework.utilities.BrowserFactory;
import com.locatorsHomework.utilities.LocatorFactory;
import com.locatorsHomework.utilities.StringUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTitle {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        String searchItem = "wooden spoon";

        driver.get("https://www.amazon.com/");
        WebElement searchField = LocatorFactory.locateElement(driver,"id", "twotabsearchtextbox");
        searchField.sendKeys(searchItem);
        WebElement searchButton = LocatorFactory.locateElement(driver,"xpath", "//input[@type='submit' and @class='nav-input']");
        searchButton.click();

        System.out.println("4. verify page title contains the search term");
        StringUtility.verifyContains(driver.getTitle(), searchItem);

        driver.quit();

    }
}
