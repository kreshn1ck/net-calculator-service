package com.kjusufi.net.calculator.services.tax.provider;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class InHouseTaxRateProvider implements TaxRateProvider {

    private final Map<String, BigDecimal> taxRateByCountryIso;

    public InHouseTaxRateProvider() {
        this.taxRateByCountryIso = new HashMap<>();
        this.taxRateByCountryIso.put("EN", new BigDecimal("0.20"));
        this.taxRateByCountryIso.put("DE", new BigDecimal("0.19"));
        this.taxRateByCountryIso.put("AL", new BigDecimal("0.14"));
        this.taxRateByCountryIso.put("KS", new BigDecimal("0.13"));
        this.taxRateByCountryIso.put("FR", new BigDecimal("0.20"));
    }
    @Override
    public BigDecimal getByCountryIso(String countryIso) {
        BigDecimal taxRate = taxRateByCountryIso.get(countryIso);
        if (taxRate == null) {
            throw new IllegalArgumentException("Unknown country ISO: " + countryIso);
        }
        return taxRate;
    }
}
