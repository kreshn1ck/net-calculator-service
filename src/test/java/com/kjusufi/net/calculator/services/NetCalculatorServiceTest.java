package com.kjusufi.net.calculator.services;

import com.kjusufi.net.calculator.services.tax.provider.TaxRateProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class NetCalculatorServiceTest {

    @Autowired
    private NetCalculatorService netCalculatorService;

    @MockBean
    TaxRateProvider taxRateProvider;

    @Test
    public void testCalculateNetPrice_success() {
        BigDecimal grossPrice = new BigDecimal("100");
        BigDecimal expectedNetPrice = new BigDecimal("84.03");
        when(taxRateProvider.getByCountryIso("DE")).thenReturn(new BigDecimal("0.19"));
        BigDecimal actualNetPrice = netCalculatorService.calculateNetPrice(grossPrice, "DE");
        assertEquals(expectedNetPrice, actualNetPrice);

        grossPrice = new BigDecimal("1.99");
        expectedNetPrice = new BigDecimal("1.66");
        when(taxRateProvider.getByCountryIso("FR")).thenReturn(new BigDecimal("0.20"));
        actualNetPrice = netCalculatorService.calculateNetPrice(grossPrice, "FR");
        assertEquals(expectedNetPrice, actualNetPrice);
    }

    @Test()
    public void testCalculateNetPrice_withNonExistingCountryISO_throwsIllegalArgumentException() {
        BigDecimal grossPrice = new BigDecimal("100");
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                netCalculatorService.calculateNetPrice(grossPrice, "NON-EXISTING"));
        assertEquals("Unknown country ISO: NON-EXISTING", exception.getMessage());
    }
}
