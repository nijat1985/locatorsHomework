package com.locatorsHomework.tests;

import java.util.*;
import com.locatorsHomework.utilities.BrowserFactory;
import com.locatorsHomework.utilities.LocatorFactory;
import com.locatorsHomework.utilities.StringUtility;
import org.openqa.selenium.*;

public class VytrackTitleTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://app.vytrack.com/user/login");

        LocatorFactory.locateElement(driver,"css","#prependedInput").sendKeys("storemanager52");
        LocatorFactory.locateElement(driver,"css","#prependedInput2").sendKeys("UserUser123");
        LocatorFactory.locateElement(driver,"css","#_submit").click();

        Thread.sleep(2000);
        WebElement yourName = LocatorFactory.locateElement(driver,"css","#user-menu");

        WebElement name = LocatorFactory.locateElement(driver,"css","#user-menu>a");
        String text = name.getText();

        yourName.click();

        //#user-menu>.dropdown-menu>li
        List<WebElement> myConfiguration = LocatorFactory.locateElements(driver,"css","#user-menu>.dropdown-menu>li");
        myConfiguration.get(0).click();

        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println("6. Verify that page title starts with the same name on top right");
        StringUtility.verifyStartsWith(title,text);






        Thread.sleep(2000);
        driver.quit();
    }
}
