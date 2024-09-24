package br.com.sps.services.impl;

import br.com.sps.exceptions.ResourceNotFoundException;
import br.com.sps.model.Acquirer;
import br.com.sps.repository.AcquirerRepository;
import br.com.sps.services.AcquirerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcquirerServiceImpl implements AcquirerService{

	@Autowired
	AcquirerRepository repository;
	

	
	@Override
	public Acquirer getAcquirer(Long id) {
		Acquirer findById = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Master not found."));

		
		//returnVo.add(linkTo(methodOn(AcquirerController.class).getAcquirer(id)).withSelfRel());
		
		return findById;
	}

	@Override
	public Acquirer createAcquirer(Acquirer entity) {
		return repository.save(entity);
	}

	@Override
	public Acquirer updateAcquirer(Acquirer entity) {
		Acquirer findById = repository.findById(entity.getIdAcquirer())
				.orElseThrow(() -> new ResourceNotFoundException("Master not found."));
		
		findById.setName(entity.getName());
		findById.setDocumentNumber(entity.getDocumentNumber());
		findById.setPercentRepass(entity.getPercentRepass());

		return repository.save(findById);
	}

	@Override
	public void deleteAcquirer(Long id) {
		Acquirer findById = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Master not found."));
		repository.delete(findById);
		
	}

	

}
