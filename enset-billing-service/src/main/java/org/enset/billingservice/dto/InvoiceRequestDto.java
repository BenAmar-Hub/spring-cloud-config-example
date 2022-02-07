package org.enset.billingservice.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor

public class InvoiceRequestDto {
	private BigDecimal amount;
	private String customerId;

}
