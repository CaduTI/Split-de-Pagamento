package br.com.sps.services;

import java.sql.SQLException;
import java.util.List;

import br.com.sps.data.vo.TransactionVO;

public interface TransactionService {
	public TransactionVO FindSplitById(Long id) throws SQLException;
	
	public List<TransactionVO> FindAllSplit(Long id);
	
	public TransactionVO createSplit(TransactionVO vo);
	
	public TransactionVO updateSplit(TransactionVO vo);
	
	public void deleteSplit(Long id) throws SQLException;
	
	public TransactionVO commissionRepass();
}
