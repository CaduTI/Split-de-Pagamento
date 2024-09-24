package br.com.sps.services.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import br.com.sps.dtos.request.TransactionRequest;
import br.com.sps.dtos.response.TransactionResponse;
import br.com.sps.mapper.TransactionMapper;
import br.com.sps.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.sps.repository.impl.TransactionRepositoryImpl;
import br.com.sps.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	TransactionRepositoryImpl repository;

	@Autowired
	TransactionMapper mapper;
	
	@Override
	public Transactions FindTransactionById(Long id) throws SQLException{
		
		return repository.selectSplit(id);
 }
	
	@Override
	public List<Transactions> FindAllTransaction(Long id){
		//criar um condicional com base no type o id fornecido, ex: um busca caso acquirer,master e sub.


		return null;
	}
	@Override
	public TransactionResponse createTransaction(TransactionRequest request) {
		Transactions model = new Transactions();

		model.setIdTransaction(new Random().nextLong(2000000));
		model.setIdMaster(request.getIdMaster());
		model.setIdCustomer(request.getCustomer().getIdCustomer());
		model.setCustomerName(request.getCustomer().getCustomerName());
		model.setDocumentNumber(request.getCustomer().getDocumentNumber());
		model.setPhoneNumber(request.getCustomer().getPhoneNumber());
		model.setEmail(request.getCustomer().getEmail());
		model.setIdSubordinate(request.getIdSubordinate());
		model.setTotalAmount(request.getTotalAmount());
		model.setCreatedAt(new Date());
		model.setUpdatedAt(new Date());

		repository.createSplit(model);

		return  mapper.toDTO(model);
	}

	@Override
	public TransactionResponse updateTransaction(TransactionRequest request) {
		Transactions findById = repository.selectSplit(request.getIdTransaction());

		findById.setIdCustomer(request.getCustomer().getIdCustomer());
		findById.setCustomerName(request.getCustomer().getCustomerName());
		findById.setDocumentNumber(request.getCustomer().getDocumentNumber());
		findById.setEmail(request.getCustomer().getEmail());
		findById.setIdSubordinate(request.getIdSubordinate());
		findById.setTotalAmount(request.getTotalAmount());
		findById.setUpdatedAt(new Date());

		repository.updateSplit(findById);
		//criar o mapper
		return  mapper.toDTO(findById);
	}

	@Override
	public void deleteTransaction(Long id) throws SQLException {
		repository.selectSplit(id);
		
	}

}
