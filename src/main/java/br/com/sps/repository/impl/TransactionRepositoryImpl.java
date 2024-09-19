package br.com.sps.repository.impl;

import br.com.sps.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.sps.mapper.TransactionDAOMapper;
import br.com.sps.repository.TransactionRepository;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository{
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	TransactionDAOMapper mapper;
	
	private static final String INSERT_SPLIT_QUERY = "INSERT INTO Split(idSplit,idAcquirer,idMaster,GrossAmount,netAmount,transactionList) values(:idSplit,:idAcquirer,:idMaster,:idSubordinate,:isCommission,:GrossAmount,:netAmount,:transactionList)";
    private static final String UPDATE_SPLIT_BY_ID_QUERY = "UPDATE SPLIT SET idMaster:idMaster, idSubordinate:idSubordinate, isCommission:isCommission, grossAmount:grossAmount, netAmount:netAmount, transactionList:transactionList WHERE = idSplit:idSplit";
    private static final String SELECT_SPLIT_QUERY = "SELECT * FROM SPLIT WHERE idSplit:idSplit";
    private static final String DELETE_SPLIT_BY_ID_QUERY = "DELETE FROM SPLIT WHERE idSplit:idSplit";
	
	@Override
	public Transaction selectSplit(Long id) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		
		mapParameters.addValue("idSplit", id);

       return jdbcTemplate.query(SELECT_SPLIT_QUERY, mapParameters, new TransactionDAOMapper()).get(0);
	}

	@Override
	public void createSplit(Transaction vo) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		

		
		jdbcTemplate.update(INSERT_SPLIT_QUERY, mapParameters);
		
	}

	@Override
	public void updateSplit(Transaction vo) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		
		mapParameters.addValue("idSplit", vo.getIdMaster());
		
		jdbcTemplate.update(UPDATE_SPLIT_BY_ID_QUERY, mapParameters);
		
	}

	@Override
	public void deleteSplit(Long id) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		
		mapParameters.addValue("idSplit", id);	
		
		jdbcTemplate.update(DELETE_SPLIT_BY_ID_QUERY, mapParameters);	
	}

}
