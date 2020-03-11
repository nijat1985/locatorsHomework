package com.locatorsHomework.tests;
import com.locatorsHomework.utilities.BrowserFactory;
import com.locatorsHomework.utilities.LocatorFactory;
import com.locatorsHomework.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EtsySearchTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        String searchItem = "wooden spoon";

        WebElement searchField = LocatorFactory.locateElement(driver,"css","#gh-ac");
        searchField.sendKeys(searchItem);

        WebElement searchButton = LocatorFactory.locateElement(driver,"css","#gh-btn");
        searchButton.click();
        //String locator = "//h1/span[@class='BOLD'][1]"; this xpath version
        Thread.sleep(2000);
        WebElement result = LocatorFactory.locateElement(driver,"css","html>body h1>span:nth-of-type(1)");
        int totalNumberOfResults = Integer.parseInt(result.getText().replace(",",""));

        WebElement all = LocatorFactory.locateElement(driver,"css","#x-refine__group__0>ul>li>a>span");
        all.click();

        WebElement resultAll = LocatorFactory.locateElement(driver,"css","html>body h1>span:nth-of-type(1)");
        int totalNumberOfResultsAll = Integer.parseInt(resultAll.getText().replace(",",""));

        System.out.println("6. Verify that number of results is bigger than the number in step 4");
        if (totalNumberOfResultsAll > totalNumberOfResults){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("totalNumberOfResults = " + totalNumberOfResults);
            System.out.println("totalNumberOfResultsAll = " + totalNumberOfResultsAll);
        }

        driver.navigate().back();
        searchField = LocatorFactory.locateElement(driver,"css","#gh-ac");

        System.out.println("\n8. Verify that wooden spoon is still displayed in the search box");
        StringUtility.verifyEquals(searchField.getAttribute("value"),searchItem);

        driver.navigate().back();
        searchField = LocatorFactory.locateElement(driver,"css","#gh-ac");

        System.out.println("\n10. Verify that search box is blank");
        if (searchField.getAttribute("value").isBlank()){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("searchField = " + searchField.getAttribute("value"));
        }


        Thread.sleep(2000);
        driver.quit();
    }
}
