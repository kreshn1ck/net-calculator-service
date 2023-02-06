package com.kjusufi.net.calculator.controllers;

import com.kjusufi.net.calculator.services.NetCalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

@Controller
public class NetPriceController {

    private final NetCalculatorService netCalculatorService;

    public NetPriceController(NetCalculatorService netCalculatorService) {
        this.netCalculatorService = netCalculatorService;
    }

    @GetMapping("/calculateNetPrice")
    public String calculateNetPricePage(Model model) {
        model.addAttribute("netPriceForm", new NetPriceForm());
        return "calculateNetPrice";
    }

    @PostMapping("/calculateNetPrice")
    public String calculateNetPrice(@ModelAttribute NetPriceForm netPriceForm, Model model) {
        BigDecimal grossPrice = netPriceForm.getGrossPrice();
        String countryIso = netPriceForm.getCountryIso();
        try {
            BigDecimal netPrice = netCalculatorService.calculateNetPrice(grossPrice, countryIso);
            model.addAttribute("netPrice", netPrice);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
        } catch (Exception e) {
            model.addAttribute("errorMessage", "There was some error. Please try again.");
        }
        return "calculateNetPrice";
    }
}
