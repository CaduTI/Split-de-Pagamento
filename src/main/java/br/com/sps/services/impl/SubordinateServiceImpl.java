package br.com.sps.services.impl;

import br.com.sps.exceptions.ResourceNotFoundException;
import br.com.sps.model.Subordinate;
import br.com.sps.repository.SubordinateRepository;
import br.com.sps.services.SubordinateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubordinateServiceImpl implements SubordinateService{
	
	@Autowired
	SubordinateRepository repository;
	
	@Override
	public Subordinate getSubordinate(Long id) {
		Subordinate findId = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Carrinho não encontrado."));
		

		
		return findId;
	}

	@Override
	public Subordinate createSubordinate(Subordinate sub) {

		return repository.save(sub);
	}

	@Override
	public Subordinate updateSubordinate(Subordinate sub) {
		Subordinate findId = repository.findById(sub.getIdSubordinate())
				.orElseThrow(() -> new ResourceNotFoundException("Carrinho não encontrado."));		
		
		findId.setName(sub.getName());
		findId.setDocumentNumber(sub.getDocumentNumber());
		findId.setPercentRepass(sub.getPercentRepass());
		
		return repository.save(findId);


	}

	@Override
	public void deleteSubordinate(Long id) {
		Subordinate findId = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Carrinho não encontrado."));
		
		repository.delete(findId);
	}

}
