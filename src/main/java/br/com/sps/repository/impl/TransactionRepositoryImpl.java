package br.com.sps.repository.impl;

import br.com.sps.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.sps.mapper.dao.TransactionDAOMapper;
import br.com.sps.repository.TransactionRepository;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository{
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	private static final String INSERT_Transaction_QUERY = "INSERT INTO Transactions(idTransaction,idMaster,customerName,documentNumber,phoneNumber,email,totalAmount,idSubordinate,createdAt,updatedAt) values(:idTransaction,:idMaster,:customerName,:documentNumber,:phoneNumber,:email,:totalAmount,:idSubordinate,:createdAt,:updatedAt)";
    private static final String UPDATE_Transaction_BY_ID_QUERY = "UPDATE SPLIT SET , :customerName,:documentNumber,:phoneNumber, :email, :totalAmount, :idSubordinate, :createdAt, :updatedAt WHERE = :idTransaction";
    private static final String SELECT_Transaction_QUERY = "SELECT * FROM SPLIT WHERE :idTransaction";
    private static final String DELETE_Transaction_BY_ID_QUERY = "DELETE FROM SPLIT WHERE :idTransaction";
	
	@Override
	public Transactions selectSplit(Long id) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		
		mapParameters.addValue("idTransaction", id);

       return jdbcTemplate.query(SELECT_Transaction_QUERY, mapParameters, new TransactionDAOMapper()).get(0);
	}

	@Override
	public void createSplit(Transactions model) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();

		mapParameters.addValue("idTransaction", model.getIdTransaction());
		mapParameters.addValue("idMaster", model.getIdMaster());
		mapParameters.addValue("customerName", model.getCustomerName());
		mapParameters.addValue("documentNumber", model.getDocumentNumber());
		mapParameters.addValue("phoneNumber", model.getPhoneNumber());
		mapParameters.addValue("email", model.getEmail());
		mapParameters.addValue("idSubordinate", model.getIdSubordinate());
		mapParameters.addValue("totalAmount", model.getTotalAmount());
		mapParameters.addValue("createdAt", model.getCreatedAt());
		mapParameters.addValue("updatedAt", model.getUpdatedAt());

		jdbcTemplate.update(INSERT_Transaction_QUERY, mapParameters);
	}

	@Override
	public void updateSplit(Transactions model) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();

		mapParameters.addValue("idCustomer", model.getIdCustomer());
		mapParameters.addValue("customerName", model.getCustomerName());
		mapParameters.addValue("documentNumber", model.getCustomerName());
		mapParameters.addValue("documentNumber", model.getDocumentNumber());
		mapParameters.addValue("phoneNumber", model.getPhoneNumber());
		mapParameters.addValue("email", model.getEmail());
		mapParameters.addValue("idSubordinate", model.getIdSubordinate());
		mapParameters.addValue("totalAmount", model.getTotalAmount());
		mapParameters.addValue("createdAt", model.getCreatedAt());
		mapParameters.addValue("updateAt", model.getUpdatedAt());

		jdbcTemplate.update(UPDATE_Transaction_BY_ID_QUERY, mapParameters);
	}

	@Override
	public void deleteSplit(Long id) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		
		mapParameters.addValue("idSplit", id);	
		
		jdbcTemplate.update(DELETE_Transaction_BY_ID_QUERY, mapParameters);
	}

}
