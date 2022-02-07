package org.enset.billingservice.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.enset.billingservice.dto.InvoiceRequestDto;
import org.enset.billingservice.dto.InvoiceResponseDto;
import org.enset.billingservice.entities.Customer;
import org.enset.billingservice.entities.Invoice;
import org.enset.billingservice.exceptions.CustomerNotFoundException;
import org.enset.billingservice.mappers.InvoiceMapper;
import org.enset.billingservice.openfeign.CustomerRestClient;
import org.enset.billingservice.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InvoiceServiceImpl implements invoiceService {
	
	private InvoiceRepository invoiceRepository;
	private InvoiceMapper invoiceMapper;
	private CustomerRestClient customerRestClient;
	

	public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper,
			CustomerRestClient customerRestClient) {
		this.invoiceRepository = invoiceRepository;
		this.invoiceMapper = invoiceMapper;
		this.customerRestClient = customerRestClient;
	}

	@SuppressWarnings("unused")
	@Override
	public InvoiceResponseDto save(InvoiceRequestDto invoiceRequestDto) {
		// TODO Auto-generated method stub
		try {
			Customer customer=customerRestClient.getCustomer(invoiceRequestDto.getCustomerId());
			
		}catch(Exception e) {
			throw new CustomerNotFoundException("Customer Not Found");
			}
		Invoice invoice=invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDto);
		invoice.setId(UUID.randomUUID().toString());
		invoice.setDate(new Date());
		Invoice saveInvoice=invoiceRepository.save(invoice);
		return invoiceMapper.fromInvoice(saveInvoice);
	}

	@Override
	public InvoiceResponseDto getInvoice(String id) {
		// TODO Auto-generated method stub
		Invoice invoice=invoiceRepository.findById(id).get();
		Customer customer=customerRestClient.getCustomer(invoice.getCustomerId());
		invoice.setCustomer(customer);
		
		return invoiceMapper.fromInvoice(invoice);
	}

	@Override
	public List<InvoiceResponseDto> invoicesByCustomer(String customerID) {
		// TODO Auto-generated method stub
		List<Invoice>invoices=invoiceRepository.findByCustomerId(customerID);
		for (Invoice invoice : invoices) {
			Customer customer=customerRestClient.getCustomer(invoice.getCustomerId());
			invoice.setCustomer(customer);
		}
		return invoices.stream()
				.map(invoice->invoiceMapper.fromInvoice(invoice))
				.collect(Collectors.toList());
	}

	@Override
	public List<InvoiceResponseDto> allInvoices() {
		// TODO Auto-generated method stub
		List<Invoice>invoices=invoiceRepository.findAll();
		for (Invoice invoice : invoices) {
			Customer customer=customerRestClient.getCustomer(invoice.getCustomerId());
			invoice.setCustomer(customer);
		}
		return invoices.stream()
				.map(invoice->invoiceMapper.fromInvoice(invoice))
				.collect(Collectors.toList());
	}

}
