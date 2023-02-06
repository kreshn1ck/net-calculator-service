package com.kjusufi.net.calculator.controllers;

import java.math.BigDecimal;

public class NetPriceForm {

    private BigDecimal grossPrice;
    private String countryIso;

    public BigDecimal getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(BigDecimal grossPrice) {
        this.grossPrice = grossPrice;
    }

    public String getCountryIso() {
        return countryIso;
    }

    public void setCountryIso(String countryIso) {
        this.countryIso = countryIso;
    }
}
