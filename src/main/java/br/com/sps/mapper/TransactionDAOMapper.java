package br.com.sps.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import br.com.sps.model.Transaction;

@Component
public class TransactionDAOMapper implements RowMapper<Transaction> {
	
	@Override
	public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException{
		Transaction bean = new Transaction();

		bean.setIdTransaction(rs.getLong("idTransaction"));
		bean.setIdCustomer(rs.getLong("idCustomer"));
		bean.setIdMaster(rs.getLong("idMaster"));
		bean.setTotalAmount(rs.getFloat("totalAmount"));
		bean.setSplitPayments(rs.getLong("splitPayments"));
		
		return bean;
	} 
}
