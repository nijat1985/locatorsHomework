package com.locatorsHomework.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorFactory {
    public static WebElement locateElement(WebDriver driver, String by, String locator){
        locator = locator.toLowerCase();
        WebElement element;
        switch (by){
            case "id":
                element = driver.findElement(By.id(locator));
                break;
            case "xpath":
                element = driver.findElement(By.xpath(locator));
                break;
            case "name":
                element = driver.findElement(By.name(locator));
                break;
            default:
                element = null;
        }
        return element;
    }
}
