package com.alexrusin.mastering.selenium.steps;

import com.alexrusin.mastering.selenium.pageobjects.Google;
import com.alexrusin.mastering.selenium.pageobjects.TemperatureConverterPage;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ConversionToFarenheitStepDefs {
    private WebDriver driver;
    public Google googlePage;
    public TemperatureConverterPage temperatureConverterPage;

    @Given("^I want to  convert (\\d+) degree Celsius to Farenheit$")
    public void I_want_to_convert_degree_Celsius_to_Farenheit(int arg1) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        googlePage = new Google(driver);
        temperatureConverterPage = googlePage.goToTemperatureConversionPage("from celsius to fahrenheit");
    }

    @When("^I input the value of Celcius as (\\d+) in text field$")
    public void I_input_the_value_of_Celcius_as_in_text_field(int arg1) throws Throwable {
        temperatureConverterPage.inputTemperature(40);
    }

    @Then("^It should be converted to Farenheit as (\\d+) degree$")
    public void It_should_be_converted_to_Farenheit_as_degree(int arg1) throws Throwable {
        assertEquals(temperatureConverterPage.actualResult(), temperatureConverterPage.expectedResultFarenheit());
        driver.quit();
    }
}
