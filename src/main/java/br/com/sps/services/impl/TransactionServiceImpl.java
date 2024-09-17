package br.com.sps.services.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.sps.data.vo.TransactionVO;
import br.com.sps.repository.impl.TransactionRepositoryImpl;
import br.com.sps.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	TransactionRepositoryImpl repository;
	
	@Override
	public TransactionVO FindSplitById(Long id) throws SQLException{
		
		return repository.selectSplit(id);
 }
	
	@Override
	public List<TransactionVO> FindAllSplit(Long id){
		//criar um condicional com base no type o id fornecido, ex: um busca caso acquirer,master e sub.
		
		return null;
	}
	@Override
	public TransactionVO createSplit(TransactionVO vo) {
		
		return null;
	}

	@Override
	public TransactionVO updateSplit(TransactionVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSplit(Long id) throws SQLException {
		repository.selectSplit(id);

		
		
		
	}

	@Override
	public TransactionVO commissionRepass() {
		// TODO Auto-generated method stub
		return null;
	}

}
