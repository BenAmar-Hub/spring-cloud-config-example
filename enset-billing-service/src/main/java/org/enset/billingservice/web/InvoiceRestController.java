package org.enset.billingservice.web;

import java.util.List;

import org.enset.billingservice.dto.InvoiceRequestDto;
import org.enset.billingservice.dto.InvoiceResponseDto;
import org.enset.billingservice.services.invoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class InvoiceRestController {

	private invoiceService invoiceService;

	public InvoiceRestController(org.enset.billingservice.services.invoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	@GetMapping(path = "/invoices/{id}")
	public InvoiceResponseDto getInvoice(@PathVariable(name = "id") String invoiceId) {

		return invoiceService.getInvoice(invoiceId);
	}

	@GetMapping(path = "/invoicesByCustomer/{customerId}")
	public List<InvoiceResponseDto> getInvoicesByCustomer(@PathVariable String customerId) {

		return invoiceService.invoicesByCustomer(customerId);

	}

	@PostMapping(path = "/invoices")
	public InvoiceResponseDto save(@RequestBody InvoiceRequestDto invoiceRequestDto) {

		return invoiceService.save(invoiceRequestDto);
	}
	@GetMapping(path = "/invoices")
	public List<InvoiceResponseDto> allInvoices(){
		return invoiceService.allInvoices();
	}
	/* 
	 * c est comme ci je dis a spring n importe quel type exception retenu appel cette fonction  */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exceptionHandler(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
