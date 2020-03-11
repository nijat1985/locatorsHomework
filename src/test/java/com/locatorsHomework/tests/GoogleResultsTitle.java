package com.locatorsHomework.tests;
import java.util.*;
import com.locatorsHomework.utilities.BrowserFactory;
import com.locatorsHomework.utilities.LocatorFactory;
import com.locatorsHomework.utilities.StringUtility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleResultsTitle {
    public static void main(String[] args) throws Exception {
        List<String> searchStrs = Arrays.asList("Java", "cucumber bdd", "Selenium web browser automation");
        WebDriver driver = BrowserFactory.getDriver("chrome");
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
            StringUtility.verifyEquals(driver.getCurrentUrl(),url);
            Thread.sleep(3000);
            driver.navigate().back();
            Thread.sleep(3000);
        }

        driver.quit();
        //https://www.java.com/en/

    }
}
