package br.com.sps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sps.model.Subordinate;

@Repository
public interface SubordinateRepository extends JpaRepository<Subordinate, Long>{

}
