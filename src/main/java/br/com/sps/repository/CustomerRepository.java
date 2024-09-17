package br.com.sps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sps.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{}
