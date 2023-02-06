package com.kjusufi.net.calculator;

import com.kjusufi.net.calculator.services.NetCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TheNetCalculatorServiceApplication {

	private static NetCalculatorService netCalculatorService;

	@Autowired
	public TheNetCalculatorServiceApplication(NetCalculatorService netCalculatorService) {
		TheNetCalculatorServiceApplication.netCalculatorService = netCalculatorService;
	}

	public static void main(String[] args) {
		SpringApplication.run(TheNetCalculatorServiceApplication.class, args);
	}

}
