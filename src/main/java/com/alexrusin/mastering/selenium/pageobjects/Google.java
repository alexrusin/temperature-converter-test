package com.alexrusin.mastering.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Google {
    private WebDriver driver;
    private String baseURL;

    public Google(WebDriver driver){
        this.driver = driver;
        baseURL = "https://www.google.com/";
        driver.get(baseURL);
        System.out.println(driver.getTitle());
        if (!driver.getTitle().equals("Google")){
            throw new WrongPageException("Incorrect page for Google Home page");
        }
    }
    public TemperatureConverterPage goToTemperatureConversionPage(String query){
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys(query);
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
        return new TemperatureConverterPage(driver);
    }
}
