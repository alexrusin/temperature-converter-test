Feature: Convert between different unit of temperatures


  Scenario: Convert  to Farenheit from Celcius

    Given I want to  convert 40 degree Celsius to Farenheit
    When I input the value of Celcius as 40 in text field
    Then It should be converted to Farenheit as 102 degree
