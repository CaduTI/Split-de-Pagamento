package br.com.sps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sps.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
