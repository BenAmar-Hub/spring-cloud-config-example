package org.openlab.openlabcustomerservice.web;

import java.util.List;
import java.util.UUID;

import org.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import org.openlab.openlabcustomerservice.dto.CustomerResponseDTO;
import org.openlab.openlabcustomerservice.services.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class CustomerRestApi {
	private CustomerService customerService;

	public CustomerRestApi(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping(path = "/customers")
	public List<CustomerResponseDTO>allCustomers(){
	
		return customerService.listCustomer();
	}
	@PostMapping(path = "/customers")
	public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO) {
		customerRequestDTO.setId(UUID.randomUUID().toString());
		return customerService.save(customerRequestDTO);
	}
	@GetMapping(path = "/customers/{id}")
	public CustomerResponseDTO getCustomer(@PathVariable String id) {
		return customerService.getCustomer(id);
	}
	}
