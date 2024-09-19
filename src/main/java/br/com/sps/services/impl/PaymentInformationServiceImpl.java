package br.com.sps.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sps.exceptions.ResourceNotFoundException;
import br.com.sps.model.PaymentInformation;
import br.com.sps.repository.OrderRepository;
import br.com.sps.services.PaymentInformationService;

@Service
public class PaymentInformationServiceImpl implements PaymentInformationService {
	
	@Autowired
	OrderRepository repository;
	
	@Override
	public PaymentInformation getPaymentInfo(Long id) {
		PaymentInformation entity= repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("OrderId is not found"));
		

		return entity;
	}

	@Override
	public PaymentInformation createPaymentInfo(PaymentInformation entity) {
		PaymentInformation retorno = repository.save(entity);
		

		
		return entity;
	}

	@Override
	public PaymentInformation updatePaymentInfo(PaymentInformation vo) {
		PaymentInformation entity = repository.findById(vo.getOrderId())
				.orElseThrow(() -> new ResourceNotFoundException("OrderId is not found"));
		
		entity.setSubordinateId(vo.getSubordinateId());
		entity.setAmount(vo.getAmount());

		PaymentInformation retorno = repository.save(entity);
		
		return retorno;
	}

	@Override
	public void deletePaymentInfo(Long id) {
		PaymentInformation entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("OrderId is not found"));
		
		repository.delete(entity);
		
	}

}
