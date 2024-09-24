package br.com.sps.services.impl;

import br.com.sps.exceptions.ResourceNotFoundException;
import br.com.sps.model.Customer;
import br.com.sps.repository.CustomerRepository;
import br.com.sps.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository repository;


	@Override
	public Customer getCustomer(Long id) {
		Customer findById = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Master not found."));

		return findById;
	}

	@Override
	public Customer createCustomer(Customer entity) {

		return repository.save(entity);
	}

	@Override
	public Customer updateCustomer(Customer entity) {
		Customer findById = repository.findById(entity.getIdCustomer())
				.orElseThrow(() -> new ResourceNotFoundException("Master not found."));

		findById.setCustomerName(entity.getCustomerName());
		findById.setDocumentNumber(entity.getDocumentNumber());
		findById.setEmail(entity.getEmail());
		findById.setPhoneNumber(entity.getPhoneNumber());

		return repository.save(entity);
	}

	@Override
	public void deleteCustomer(Long id) {
		Customer findById = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Master not found."));

		repository.delete(findById);
		
	}

}
