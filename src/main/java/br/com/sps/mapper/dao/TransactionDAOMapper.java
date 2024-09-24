package br.com.sps.mapper.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import br.com.sps.model.Transactions;

@Component
public class TransactionDAOMapper implements RowMapper<Transactions> {
	
	@Override
	public Transactions mapRow(ResultSet rs, int rowNum) throws SQLException{
		Transactions bean = new Transactions();

		bean.setIdTransaction(rs.getLong("idTransaction"));
		bean.setIdMaster(rs.getLong("idMaster"));
		bean.setIdCustomer(rs.getLong("idCustomer"));
		bean.setCustomerName(rs.getString("customerName"));
		bean.setDocumentNumber(rs.getString("documentNumber"));
		bean.setEmail(rs.getString("email"));
		bean.setIdSubordinate(rs.getLong("idSubordinate"));
		bean.setTotalAmount(rs.getFloat("totalAmount"));
		bean.setCreatedAt(rs.getDate("createdAt"));
		bean.setUpdatedAt(rs.getDate("updateAt"));

		return bean;
	} 
}
