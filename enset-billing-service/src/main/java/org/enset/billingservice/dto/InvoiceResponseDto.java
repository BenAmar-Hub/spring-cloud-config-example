package org.enset.billingservice.dto;

import java.math.BigDecimal;
import java.util.Date;
import org.enset.billingservice.entities.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor

public class InvoiceResponseDto {
	private String id;
	private Date date;
	private BigDecimal amount;
	private Customer customer;

}
