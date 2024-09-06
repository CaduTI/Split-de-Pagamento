package br.com.sps.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sps.data.mapper.MasterMapper;
import br.com.sps.data.vo.MasterVO;
import br.com.sps.exceptions.ResourceNotFoundException;
import br.com.sps.model.Master;
import br.com.sps.repository.MasterRepository;
import br.com.sps.services.MasterService;

@Service
public class MasterServiceImpl implements MasterService{

	@Autowired
	MasterRepository repository;
	
	@Autowired
	MasterMapper mapper;
	
	@Override
	public MasterVO getMaster(Long id) {
		Master findById = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Master not found."));
		
		MasterVO vo = mapper.toVO(findById);
		
		return vo;
	}

	@Override
	public MasterVO createMaster(MasterVO vo) {
		Master entity = mapper.toEntity(vo);
		
		MasterVO returnVo = mapper.toVO(repository.save(entity));
		
		return returnVo;
	}

	@Override
	public MasterVO updateMaster(MasterVO vo) {
		Master findById = repository.findById(vo.getIdMaster())
				.orElseThrow(() -> new ResourceNotFoundException("Master not found."));
		
		findById.setName(vo.getName());
		findById.setDocumentNumber(vo.getDocumentNumber());
		findById.setPercentRepass(vo.getPercentRepass());
		
		MasterVO returnVo = mapper.toVO(findById);
		
		
		return returnVo;
	}

	@Override
	public void deleteMaster(Long id) {
		Master findById = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Master not found."));
		
		repository.delete(findById);
		
	}

}
