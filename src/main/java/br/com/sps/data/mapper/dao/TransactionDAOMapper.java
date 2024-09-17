package br.com.sps.data.mapper.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import br.com.sps.data.vo.TransactionVO;

@Component
public class TransactionDAOMapper implements RowMapper<TransactionVO> {
	
	@Override
	public TransactionVO mapRow(ResultSet rs, int rowNum) throws SQLException{
		TransactionVO bean = new TransactionVO();
		
		bean.setIdSplit(rs.getLong("idSplit"));
		bean.setIdAcquirer(rs.getLong("idAcquirer"));
		bean.setIdMaster(rs.getLong);
		bean.setIdSubordinate(rs.getLong);
		bean.setIsCommission(null);
		bean.setGrossAmount(null);
		bean.setNetAmount(null);
		bean.setTransactionList(null);
		
		return bean;
		
		return null;
	} 
}
