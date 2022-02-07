package org.openlab.openlabcustomerservice.services;

import java.util.List;

import org.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import org.openlab.openlabcustomerservice.dto.CustomerResponseDTO;

public interface CustomerService {

	CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
	CustomerResponseDTO getCustomer(String id);
	CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
	List<CustomerResponseDTO>listCustomer();
	
}
