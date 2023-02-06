package com.kjusufi.net.calculator.services.tax.provider;

import com.kjusufi.net.calculator.models.TaxRateExternalResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.Duration;

public class ExternalTaxRateProvider implements TaxRateProvider {

    private final RestTemplate restTemplate;

    public ExternalTaxRateProvider() {
        this.restTemplate = new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofSeconds(500))
                .setReadTimeout(Duration.ofSeconds(500))
                .build();
    }

    @Override
    public BigDecimal getByCountryIso(String countryIso) {
        String url = "https://api.apilayer.com/tax_data/tax_rates?country={country}";

        HttpHeaders headers = new HttpHeaders();
        headers.add("apikey", "wAaZs1oZjOUYt29z8mM5FhInFU39AyHy");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<TaxRateExternalResponse> response = this.restTemplate.exchange(url, HttpMethod.GET, entity, TaxRateExternalResponse.class, countryIso);
            if (response.getStatusCode() == HttpStatus.OK
                    && response.getBody() != null && response.getBody().getStandardRate() != null) {
                return BigDecimal.valueOf(response.getBody().getStandardRate().getRate());
            }
        } catch (RestClientException e) {
            throw new IllegalArgumentException("Unknown country ISO: " + countryIso);
        }
        return null;
    }
}
