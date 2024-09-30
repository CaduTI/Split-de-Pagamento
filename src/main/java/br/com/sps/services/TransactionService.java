package br.com.sps.services;

import br.com.sps.dtos.response.TransactionResponse;
import br.com.sps.model.Transactions;
import br.com.sps.dtos.request.TransactionRequest;

import java.sql.SQLException;
import java.util.List;

public interface TransactionService {
	public Transactions FindTransactionById(Long id) throws SQLException;
	
	public TransactionResponse createTransaction(TransactionRequest vo);
	
	public TransactionResponse updateTransaction(TransactionRequest vo);
	
	public void deleteTransaction(Long id) throws SQLException;

}
