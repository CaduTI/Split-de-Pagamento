package br.com.sps.services.impl;

import br.com.sps.data.mapper.vo.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.sps.data.vo.CustomerVO;
import br.com.sps.exceptions.ResourceNotFoundException;
import br.com.sps.model.Customer;
import br.com.sps.repository.CustomerRepository;
import br.com.sps.services.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository repository;
	
	@Autowired
	CustomerMapper mapper;

	@Override
	public CustomerVO getAcquirer(Long id) {
		Customer findById = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Master not found."));
		CustomerVO returnVo = mapper.toVO(findById);
		return returnVo;
	}

	@Override
	public CustomerVO createAcquirer(CustomerVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerVO updateAcquirer(CustomerVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAcquirer(Long id) {
		// TODO Auto-generated method stub
		
	}

}
