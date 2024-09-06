package br.com.sps.services;

import br.com.sps.data.vo.OrderVO;

public interface OrderService {
	public OrderVO getOrder(Long id);
	public OrderVO createOrder(OrderVO vo);
	public OrderVO updateOrder(OrderVO vo);
	public void deleteOrder(Long id);
}
