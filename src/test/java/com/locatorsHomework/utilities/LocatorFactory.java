package com.locatorsHomework.utilities;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorFactory {
    public static WebElement locateElement(WebDriver driver, String by, String locator) {
        by = by.toLowerCase();
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
            case "css":
                element = driver.findElement(By.cssSelector(locator));
                break;
            case "linkText":
                element = driver.findElement(By.linkText(locator));
                break;
            default:
                element = null;
        }
        return element;
    }
    public static List<WebElement> locateElements(WebDriver driver, String by, String locator) {
        by = by.toLowerCase();
        List<WebElement> element;
        switch (by){
            case "id":
                element = driver.findElements(By.id(locator));
                break;
            case "xpath":
                element = driver.findElements(By.xpath(locator));
                break;
            case "name":
                element = driver.findElements(By.name(locator));
                break;
            case "css":
                element = driver.findElements(By.cssSelector(locator));
                break;
            default:
                element = null;
        }
        return element;
    }
}
