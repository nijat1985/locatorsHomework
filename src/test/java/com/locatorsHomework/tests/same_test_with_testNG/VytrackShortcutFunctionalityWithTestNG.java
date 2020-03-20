package com.locatorsHomework.tests.same_test_with_testNG;

import com.locatorsHomework.utilities.BrowserFactory;
import com.locatorsHomework.utilities.LocatorFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VytrackShortcutFunctionalityWithTestNG {
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
    public void checkShortcutFunctionality() throws InterruptedException {
        driver.get("https://app.vytrack.com/user/login");
        driver.manage().window().maximize();

        LocatorFactory.locateElement(driver,"css","#prependedInput").sendKeys("salesmanager140");
        LocatorFactory.locateElement(driver,"css","#prependedInput2").sendKeys("UserUser123");
        LocatorFactory.locateElement(driver,"css","#_submit").click();

        String expectedTitle = "Dashboard";
        Thread.sleep(2000);
        String actualTitle = driver.getTitle();
        System.out.println("4. Verify Dashboard page is open");
        Assert.assertEquals(expectedTitle,actualTitle);

        Thread.sleep(2000);
        WebElement shortcutIcon = LocatorFactory.locateElement(driver,"css",".fa-share-square");
        shortcutIcon.click();

        Thread.sleep(2000);
        WebElement seeFullList = LocatorFactory.locateElement(driver,"xpath","//a[text()='See full list']");
        seeFullList.click();

        Thread.sleep(2000);
        WebElement opportunities = LocatorFactory.locateElement(driver,"xpath","//a[text()='Opportunities']");
        opportunities.click();

        Thread.sleep(2000);
        String expectedText = "Opportunities";
        WebElement opportunitiesPage = LocatorFactory.locateElement(driver,"xpath","//li[text()='Opportunities']");
        String actualText = opportunitiesPage.getText();
        System.out.println("8. Verify Open opportunities page is open");
        Assert.assertEquals(expectedText,actualText);

        Thread.sleep(2000);
        shortcutIcon = LocatorFactory.locateElement(driver,"css",".fa-share-square");
        shortcutIcon.click();

        Thread.sleep(2000);
        seeFullList = LocatorFactory.locateElement(driver,"xpath","//a[text()='See full list']");
        seeFullList.click();

        Thread.sleep(2000);
        WebElement vehicleServiceLog = LocatorFactory.locateElement(driver,"xpath","//a[text()='Vehicle Services Logs']");
        vehicleServiceLog.click();

        Thread.sleep(2000);
        String expectedMessage = "You do not have permission to perform this action.";
        WebElement vehicleServiceLogPage = LocatorFactory.locateElement(driver,"css",".message");
        String actualMessage = vehicleServiceLogPage.getText();
        System.out.println("12. Verify error message text is You do not have permission to perform this action.");
        Assert.assertEquals(expectedMessage,actualMessage);

        String expectedShortcutPageTitle = "Shortcut Actions List";
        Thread.sleep(2000);
        String actualShortcutPageTitle = driver.getTitle();
        System.out.println("13. Verify Shortcut Actions List page is still open");
        Assert.assertEquals(expectedShortcutPageTitle,actualShortcutPageTitle);
    }
}
