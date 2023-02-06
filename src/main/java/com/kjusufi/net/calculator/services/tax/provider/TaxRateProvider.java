package com.kjusufi.net.calculator.services.tax.provider;

import java.math.BigDecimal;

public interface TaxRateProvider {

    BigDecimal getByCountryIso(String countryIso);
}
