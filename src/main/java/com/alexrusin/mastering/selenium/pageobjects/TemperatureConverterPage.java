package com.alexrusin.mastering.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TemperatureConverterPage {
    private WebDriver driver;
    public TemperatureConverterPage(WebDriver driver){
        this.driver = driver;
        String pageTitle = driver.getTitle();
//        String[] titleArray = new String[2];
//        titleArray[0] = "from fahrenheit to celsius - Google Search";
//        titleArray[1] = "from celsius to fahrenheit - Google Search";
        System.out.println(pageTitle);
//        if (!Arrays.asList(titleArray).contains(pageTitle)){
//            throw new WrongPageException("Incorrect page for Temperature Conversion page");
//        }
    }
    public void inputTemperature(double valueOfFahrenheit){
        String s = Double.toString(valueOfFahrenheit);
        driver.findElement(By.cssSelector("#HG5Seb .vXQmIe")).clear();
        driver.findElement(By.cssSelector("#HG5Seb .vXQmIe")).sendKeys(s);
    }
    public String actualResult(){
        String valueOfCelsius = driver.findElement(By.cssSelector("#NotFQb .vXQmIe")).getAttribute("value");
        System.out.println(valueOfCelsius);
        return valueOfCelsius;
    }
    public String expectedResult(){
        return "37";
    }

    public String expectedResultFarenheit() { return "104";}
}
