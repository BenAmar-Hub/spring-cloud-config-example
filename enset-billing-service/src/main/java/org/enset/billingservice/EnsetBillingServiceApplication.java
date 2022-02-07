package org.enset.billingservice;

import java.math.BigDecimal;

import org.enset.billingservice.dto.InvoiceRequestDto;
import org.enset.billingservice.services.invoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class EnsetBillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnsetBillingServiceApplication.class, args);
	}
	
	
	@Bean
	CommandLineRunner commandLineRunner(invoiceService invoiceService) {
		return 
				args->{
					invoiceService.save(new InvoiceRequestDto(BigDecimal.valueOf(980000),"CO1"));
					invoiceService.save(new InvoiceRequestDto(BigDecimal.valueOf(9988888),"CO1"));
					invoiceService.save(new InvoiceRequestDto(BigDecimal.valueOf(5430000),"CO2"));


					
				};
		
	}

}
