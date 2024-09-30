package br.com.sps.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.sps.exceptions.ResourceNotFoundException;
import br.com.sps.model.Master;
import br.com.sps.repository.MasterRepository;
import br.com.sps.services.MasterService;

@Service
public class MasterServiceImpl implements MasterService{

	@Autowired
	MasterRepository repository;
	
	@Override
	public Master getMaster(Long id) {
		Master findById = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Master not found."));
		

		
		return findById;
	}

	@Override
	public Master createMaster(Master entity) {
		return repository.save(entity);
	}

	@Override
	public Master updateMaster(Master entity) {
		Master findById = repository.findById(entity.getIdMaster())
				.orElseThrow(() -> new ResourceNotFoundException("Master not found."));
		
		findById.setName(entity.getName());
		findById.setDocumentNumber(entity.getDocumentNumber());
		findById.setPercentRate(entity.getPercentRate());

		return repository.save(findById);
	}

	@Override
	public void deleteMaster(Long id) {
		Master findById = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Master not found."));
		
		repository.delete(findById);
		
	}

}
