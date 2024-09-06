package br.com.sps.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sps.data.mapper.SubordinateMapper;
import br.com.sps.data.vo.SubordinateVO;
import br.com.sps.exceptions.ResourceNotFoundException;
import br.com.sps.model.Subordinate;
import br.com.sps.repository.SubordinateRepository;
import br.com.sps.services.SubordinateService;

@Service
public class SubordinateServiceImpl implements SubordinateService{
	
	@Autowired
	SubordinateRepository repository;
	
	@Autowired
	SubordinateMapper mapper;
	
	@Override
	public SubordinateVO getSubordinate(Long id) {
		Subordinate findId = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Carrinho não encontrado."));
		
		SubordinateVO vo = mapper.toVO(findId);
		
		return vo;
	}

	@Override
	public SubordinateVO createSubordinate(SubordinateVO sub) {
		Subordinate  subordinate = mapper.toEntity(sub);
		SubordinateVO vo = mapper.toVO(repository.save(subordinate));
		return vo;
	}

	@Override
	public SubordinateVO updateSubordinate(SubordinateVO sub) {
		Subordinate findId = repository.findById(sub.getIdSubordinate())
				.orElseThrow(() -> new ResourceNotFoundException("Carrinho não encontrado."));		
		
		findId.setName(sub.getName());
		findId.setDocumentNumber(sub.getDocumentNumber());
		findId.setPercentRepass(sub.getPercentRepass());
		
		SubordinateVO vo = mapper.toVO(repository.save(findId));

		return vo;
	}

	@Override
	public void deleteSubordinate(Long id) {
		Subordinate findId = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Carrinho não encontrado."));
		
		repository.delete(findId);
	}

}
