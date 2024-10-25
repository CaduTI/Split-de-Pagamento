package br.com.sps.services.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import br.com.sps.controller.TransactionController;
import br.com.sps.dtos.request.TransactionRequest;
import br.com.sps.dtos.response.TransactionResponse;
import br.com.sps.mapper.TransactionMapper;
import br.com.sps.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.sps.repository.impl.TransactionRepositoryImpl;
import br.com.sps.services.TransactionService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	TransactionRepositoryImpl repository;

	@Autowired
	TransactionMapper mapper;

	@Autowired
	SplitServiceImpl split;

	@Override
	public Transactions FindTransactionById(Long id) throws SQLException{
		
		return repository.selectSplit(id);
 }
	

	@Override
	public TransactionResponse createTransaction(TransactionRequest request) throws SQLException {
		Transactions model = new Transactions();

		model.setIdTransaction(new Random().nextLong(2000000));
		model.setIdMaster(request.getIdMaster());
		model.setCustomerName(request.getCustomer().getCustomerName());
		model.setDocumentNumber(request.getCustomer().getDocumentNumber());
		model.setPhoneNumber(request.getCustomer().getPhoneNumber());
		model.setEmail(request.getCustomer().getEmail());
		model.setIdSubordinate(request.getIdSubordinate());
		model.setTotalAmount(request.getTotalAmount());
		model.setCreatedAt(new Date());
		model.setUpdatedAt(new Date());

		repository.createSplit(model);

		split.createSplit(model);



		var retorno = mapper.toDTO(model);

		retorno.add(linkTo(methodOn(TransactionController.class).getTransactions(retorno.getIdTransaction())).withSelfRel());
		return  retorno;
	}

	@Override
	public TransactionResponse updateTransaction(TransactionRequest request) throws SQLException {
		Transactions findById = repository.selectSplit(request.getIdTransaction());

		findById.setCustomerName(request.getCustomer().getCustomerName());
		findById.setDocumentNumber(request.getCustomer().getDocumentNumber());
		findById.setEmail(request.getCustomer().getEmail());
		findById.setIdSubordinate(request.getIdSubordinate());
		findById.setTotalAmount(request.getTotalAmount());
		findById.setUpdatedAt(new Date());

		repository.updateSplit(findById);

		var retorno = mapper.toDTO(findById);

		retorno.add(linkTo(methodOn(TransactionController.class).getTransactions(retorno.getIdTransaction())).withSelfRel());
		return  retorno;
	}

	@Override
	public void deleteTransaction(Long id) throws SQLException {
		repository.selectSplit(id);
		
	}

}
