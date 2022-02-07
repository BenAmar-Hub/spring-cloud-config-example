package org.openlab.openlabcustomerservice.services;

import java.util.List;
import java.util.stream.Collectors;


import org.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import org.openlab.openlabcustomerservice.dto.CustomerResponseDTO;
import org.openlab.openlabcustomerservice.entities.Customer;
import org.openlab.openlabcustomerservice.mappers.CustomerMapper;
import org.openlab.openlabcustomerservice.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	private CustomerRepository customerRepository;
	private CustomerMapper customerMapper;

	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}

	@Override
	public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
		// TODO Auto-generated method stub
		Customer customer = customerMapper.customerRequestDTOCustomer(customerRequestDTO);
		Customer saveCustomer = customerRepository.save(customer);
		CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerResponseDTO(saveCustomer);
		return customerResponseDTO;
	}

	@Override
	public CustomerResponseDTO getCustomer(String id) {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findById(id).get();
		return customerMapper.customerToCustomerResponseDTO(customer);
	}

	@Override
	public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
		// TODO Auto-generated method stub
		Customer customer = customerMapper.customerRequestDTOCustomer(customerRequestDTO);
		Customer updatedCustomer = customerRepository.save(customer);
		return customerMapper.customerToCustomerResponseDTO(updatedCustomer);
	}

	@Override
	public List<CustomerResponseDTO> listCustomer() {
		// TODO Auto-generated method stub
		List<Customer> customers = customerRepository.findAll();
		List<CustomerResponseDTO> customerResponseDTOs = customers.stream()
				.map(cust -> customerMapper.customerToCustomerResponseDTO(cust)).collect(Collectors.toList());
		return customerResponseDTOs;
	}

}
