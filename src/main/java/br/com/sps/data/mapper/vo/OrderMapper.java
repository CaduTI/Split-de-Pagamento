package br.com.sps.data.mapper.vo;

import org.springframework.stereotype.Component;

import br.com.sps.data.vo.OrderVO;
import br.com.sps.model.Order;

@Component
public class OrderMapper {
	public OrderVO toVO(Order entity) {
		return new OrderVO(entity.getOrderId(),entity.getSubordinateId(), entity.getItemName(),entity.getAmount());
	}
	
	public Order toEntity(OrderVO vo) {
		Order entity = new Order();
		
		entity.setOrderId(vo.getOrderId());
		entity.setSubordinateId(vo.getSubordinateId());
		entity.setItemName(vo.getItemName());
		entity.setAmount(vo.getAmount());
		
		return entity;
	}
}
