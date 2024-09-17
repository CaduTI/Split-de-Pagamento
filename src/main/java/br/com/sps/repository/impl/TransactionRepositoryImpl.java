package br.com.sps.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.sps.data.mapper.dao.TransactionDAOMapper;
import br.com.sps.data.vo.TransactionVO;
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
	public TransactionVO selectSplit(Long id) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		
		mapParameters.addValue("idSplit", id);

       return jdbcTemplate.query(SELECT_SPLIT_QUERY, mapParameters, new TransactionDAOMapper()).get(0);
	}

	@Override
	public void createSplit(TransactionVO vo) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		
		mapParameters.addValue("idSplit", vo.getIdSplit());
		mapParameters.addValue("idAcquirer", 1);
		mapParameters.addValue("idMaster", vo.getIdMaster());
		mapParameters.addValue("GrossAmount", vo.getGrossAmount());
		mapParameters.addValue("netAmount", vo.getNetAmount());
		mapParameters.addValue("transactionList", vo.getTransactionList());
		
		jdbcTemplate.update(INSERT_SPLIT_QUERY, mapParameters);
		
	}

	@Override
	public void updateSplit(TransactionVO vo) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		
		mapParameters.addValue("idSplit", vo.getIdMaster());
		mapParameters.addValue("idSplit", vo.getIdSubordinate());
		mapParameters.addValue("idSplit", vo.getIsCommission());
		mapParameters.addValue("idSplit", vo.getGrossAmount());
		mapParameters.addValue("idSplit", vo.getNetAmount());
		mapParameters.addValue("idSplit", vo.getTransactionList());
		
		jdbcTemplate.update(UPDATE_SPLIT_BY_ID_QUERY, mapParameters);
		
	}

	@Override
	public void deleteSplit(Long id) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		
		mapParameters.addValue("idSplit", id);	
		
		jdbcTemplate.update(DELETE_SPLIT_BY_ID_QUERY, mapParameters);	
	}

}
