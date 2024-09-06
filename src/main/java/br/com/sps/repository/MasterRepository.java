package br.com.sps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sps.model.Master;

@Repository
public interface MasterRepository extends JpaRepository<Master, Long>{

}
