package br.com.sps.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sps.data.mapper.OrderMapper;
import br.com.sps.data.vo.OrderVO;
import br.com.sps.exceptions.ResourceNotFoundException;
import br.com.sps.model.Order;
import br.com.sps.repository.OrderRepository;
import br.com.sps.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository repository;
	
	@Autowired
	OrderMapper mapper;
	
	
	@Override
	public OrderVO getOrder(Long id) {
		Order entity= repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("OrderId is not found"));
		
		OrderVO vo = mapper.toVO(entity);
		return vo;
	}

	@Override
	public OrderVO createOrder(OrderVO vo) {
		Order entity = mapper.toEntity(vo);
		
		OrderVO saveVO = mapper.toVO(repository.save(entity));
		
		return saveVO;
	}

	@Override
	public OrderVO updateOrder(OrderVO vo) {
		Order entity = repository.findById(vo.getOrderId())
				.orElseThrow(() -> new ResourceNotFoundException("OrderId is not found"));
		
		entity.setSubordinateId(vo.getSubordinateId());
		entity.setItemName(vo.getItemName());
		entity.setAmount(vo.getAmount());
		
		OrderVO saveVO = mapper.toVO(repository.save(entity));
		
		return saveVO;
	}

	@Override
	public void deleteOrder(Long id) {
		Order entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("OrderId is not found"));
		
		repository.delete(entity);
		
	}

}
