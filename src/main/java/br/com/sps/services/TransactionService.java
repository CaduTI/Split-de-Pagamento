package br.com.sps.services;

import br.com.sps.model.Transaction;

import java.sql.SQLException;
import java.util.List;

public interface TransactionService {
	public Transaction FindSplitById(Long id) throws SQLException;
	
	public List<Transaction> FindAllSplit(Long id);
	
	public Transaction createSplit(Transaction vo);
	
	public Transaction updateSplit(Transaction vo);
	
	public void deleteSplit(Long id) throws SQLException;
	
	public Transaction commissionRepass();
}
