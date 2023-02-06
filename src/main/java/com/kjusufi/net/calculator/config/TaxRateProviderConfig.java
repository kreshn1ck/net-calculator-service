package com.kjusufi.net.calculator.config;

import com.kjusufi.net.calculator.services.tax.provider.ExternalTaxRateProvider;
import com.kjusufi.net.calculator.services.tax.provider.InHouseTaxRateProvider;
import com.kjusufi.net.calculator.services.tax.provider.TaxRateProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaxRateProviderConfig {

    @Bean
    public TaxRateProvider taxRateProvider(@Value("${tax-rate.provider}") String provider) {
        if (provider.equals("in-house")) {
            return new InHouseTaxRateProvider();
        } else {
            return new ExternalTaxRateProvider();
        }
    }
}
