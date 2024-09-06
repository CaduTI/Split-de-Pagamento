package br.com.sps.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import br.com.sps.controller.AcquirerController;
import br.com.sps.data.mapper.AcquirerMapper;
import br.com.sps.data.vo.AcquirerVO;
import br.com.sps.exceptions.ResourceNotFoundException;
import br.com.sps.model.Acquirer;
import br.com.sps.repository.AcquirerRepository;
import br.com.sps.services.AcquirerService;

@Service
public class AcquirerServiceImpl implements AcquirerService{

	@Autowired
	AcquirerRepository repository;
	
	@Autowired
	AcquirerMapper mapper;
	
	@Override
	public AcquirerVO getAcquirer(Long id) {
		Acquirer findById = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Master not found."));
		AcquirerVO returnVo = mapper.toVO(findById);
		
		//returnVo.add(linkTo(methodOn(AcquirerController.class).getAcquirer(id)).withSelfRel());
		
		return returnVo;
	}

	@Override
	public AcquirerVO createAcquirer(AcquirerVO vo) {
		Acquirer entity = mapper.toEntity(vo);
		AcquirerVO returnVo = mapper.toVO(repository.save(entity));
		
		
		return returnVo;
	}

	@Override
	public AcquirerVO updateAcquirer(AcquirerVO vo) {
		Acquirer findById = repository.findById(vo.getIdAcquirer())
				.orElseThrow(() -> new ResourceNotFoundException("Master not found."));
		
		findById.setName(vo.getName());
		findById.setDocumentNumber(vo.getDocumentNumber());
		findById.setPercentRepass(vo.getPercentRepass());
		AcquirerVO returnVo = mapper.toVO(repository.save(findById));
		
		return returnVo;
	}

	@Override
	public void deleteAcquirer(Long id) {
		Acquirer findById = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Master not found."));
		repository.delete(findById);
		
	}

	

}
