package br.com.sps.services;


import br.com.sps.model.Customer;

public interface CustomerService {
	public Customer getCustomer(Long id);
	public Customer createCustomer(Customer vo);
	public Customer updateCustomer(Customer vo);
	public void deleteCustomer(Long id);
}
