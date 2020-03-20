package com.locatorsHomework.tests.same_test_with_testNG;

import com.locatorsHomework.utilities.BrowserFactory;
import com.locatorsHomework.utilities.LocatorFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class VytrackTitleTestWithTestNG {
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
    public void checkTitle() throws InterruptedException {
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
        Assert.assertTrue(title.startsWith(text));
    }
}
