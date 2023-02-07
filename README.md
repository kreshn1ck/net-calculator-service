# net-calculator-service
Coding Test Assignment: The Net Calculator Service.  

>Build with Spring Boot v2.7.8.  
Uses java v11, maven, and thymeleaf 
>
## Intall the app:
```mvn clean install```

## Run the app:
```mvn spring-boot:run```

Application will run on default port: ```8090```

Open your browser and navigate to: [http://localhost:8090/calculateNetPrice](http://localhost:8090/calculateNetPrice)

## Tests
- You can use this command to run the tests:
```mvn test```

Tests are located in: ```src/test/java/com/kjusufi/net/calculator/services/NetCalculatorServiceTest.java```

## [Optional] Extra configurations: 

In `application.properties` file the `tax-rate.provider` default value is `in-house` in which case the App will make use of the **InHouseTaxRateProvider** that has a pre-defined Map of Tax Rates values by Country Iso.
Otherwise if another value is set, the App will use **ExternalTaxRateProvider** which will make use of an [external API](https://apilayer.com/marketplace/tax_data-api#documentation-tab) to get the Tax Rate info.

## Usage Example

<img width="389" alt="calculate-net-price" src="https://user-images.githubusercontent.com/18393837/217115283-0deec895-8397-41e3-bb14-3b77227e5e68.png">
