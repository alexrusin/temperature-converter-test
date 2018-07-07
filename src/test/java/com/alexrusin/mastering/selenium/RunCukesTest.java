package com.alexrusin.mastering.selenium;

import org.junit.runner.RunWith;
import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(
        format = {"pretty", "html:target/cucumber-htmlreport","json-pretty:target/cucumber-report.json"},
        features = "C:\\Users\\alexr\\IdeaProjects\\temperature-converter\\src\\test\\resources\\com.alexrusin.mastering.selenium"
)

public class RunCukesTest {
}