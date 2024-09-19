package br.com.sps.services.impl;

import java.sql.SQLException;
import java.util.List;

import br.com.sps.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.sps.repository.impl.TransactionRepositoryImpl;
import br.com.sps.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	TransactionRepositoryImpl repository;
	
	@Override
	public Transaction FindSplitById(Long id) throws SQLException{
		
		return repository.selectSplit(id);
 }
	
	@Override
	public List<Transaction> FindAllSplit(Long id){
		//criar um condicional com base no type o id fornecido, ex: um busca caso acquirer,master e sub.
		
		return null;
	}
	@Override
	public Transaction createSplit(Transaction vo) {
		
		return null;
	}

	@Override
	public Transaction updateSplit(Transaction vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSplit(Long id) throws SQLException {
		repository.selectSplit(id);

		
		
		
	}

	@Override
	public Transaction commissionRepass() {
		// TODO Auto-generated method stub
		return null;
	}

}
