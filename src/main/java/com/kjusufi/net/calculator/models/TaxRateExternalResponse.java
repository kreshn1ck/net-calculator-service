package com.kjusufi.net.calculator.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaxRateExternalResponse {

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("standard_rate")
    private StandardRate standardRate;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public StandardRate getStandardRate() {
        return standardRate;
    }

    public void setStandardRate(StandardRate standardRate) {
        this.standardRate = standardRate;
    }

    public static class StandardRate {
        private String className;
        private double rate;

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public double getRate() {
            return rate;
        }

        public void setRate(double rate) {
            this.rate = rate;
        }
    }
}
