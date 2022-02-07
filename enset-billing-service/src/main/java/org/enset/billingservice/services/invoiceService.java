package org.enset.billingservice.services;

import java.util.List;

import org.enset.billingservice.dto.InvoiceRequestDto;
import org.enset.billingservice.dto.InvoiceResponseDto;

public interface invoiceService {

	InvoiceResponseDto save(InvoiceRequestDto invoiceRequestDto);
	InvoiceResponseDto getInvoice(String id);
	List<InvoiceResponseDto>invoicesByCustomer(String customerID);
	List<InvoiceResponseDto>allInvoices();
	
}
