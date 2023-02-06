package com.kjusufi.net.calculator.services;

import com.kjusufi.net.calculator.services.tax.provider.TaxRateProvider;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class NetCalculatorService {

    private final TaxRateProvider taxRateProvider;

    public NetCalculatorService(TaxRateProvider taxRateProvider) {
        this.taxRateProvider = taxRateProvider;
    }

    public BigDecimal calculateNetPrice(BigDecimal grossPrice, String countryIso) {
        BigDecimal taxRate = taxRateProvider.getByCountryIso(countryIso);
        if (taxRate == null) {
            throw new IllegalArgumentException("Unknown Country ISO: " + countryIso);
        }
        BigDecimal netPrice = grossPrice.divide(taxRate.add(BigDecimal.ONE), 2, RoundingMode.HALF_UP);
        return netPrice;
    }
}
