package br.com.sps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sps.model.PaymentInformation;

@Repository
public interface OrderRepository extends JpaRepository<PaymentInformation, Long>{

}
