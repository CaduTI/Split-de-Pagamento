package br.com.sps.repository.impl;

import br.com.sps.mapper.dao.SplitDAOMapper;
import br.com.sps.model.Split;
import br.com.sps.repository.SplitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SplitRepositoryImpl implements SplitRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    private static final String SELECT_SPLIT_QUERY = "SELECT * FROM split WHERE idSplit = :idSplit";
    private static final String INSERT_SPLIT_QUERY  = "INSERT INTO split (idSplit,idAcquirer, acquirerRate, acquirerCommission, idMaster, masterRate, masterCommission, idSubordinate, subordinateRate, subordinateCommission, totalAmount, createdAt, updatedAt) VALUES (:idSplit, :idAcquirer, :acquirerRate, :acquirerCommission, :idMaster, :masterRate, :masterCommission, :idSubordinate, :subordinateRate, :subordinateCommission, :totalAmount, :createdAt, :updatedAt) ";
    private static final String DELETE_SPLIT_QUERY = "DELETE FROM split WHERE idSplit = :idSplit";


    @Override
    public Split selectSplit(Long id) {
        MapSqlParameterSource mapParameters = new MapSqlParameterSource();

        mapParameters.addValue("idSplit", id);

        return jdbcTemplate.query(SELECT_SPLIT_QUERY,mapParameters, new SplitDAOMapper()).get(0);
    }

    @Override
    public void createSplit(Split model) {
        MapSqlParameterSource mapParameters = new MapSqlParameterSource();

        mapParameters.addValue("idSplit", model.getIdSplit());
        mapParameters.addValue("idAcquirer", model.getIdAcquirer());
        mapParameters.addValue("acquirerRate", model.getAcquirerRate());
        mapParameters.addValue("acquirerCommission", model.getAcquirerCommission());
        mapParameters.addValue("idMaster", model.getIdMaster());
        mapParameters.addValue("masterRate", model.getMasterRate());
        mapParameters.addValue("masterCommission", model.getMasterCommission());
        mapParameters.addValue("idSubordinate", model.getIdSubordinate());
        mapParameters.addValue("subordinateRate", model.getSubordinateRate());
        mapParameters.addValue("subordinateCommission", model.getSubordinateCommission());
        mapParameters.addValue("totalAmount", model.getTotalAmount());
        mapParameters.addValue("createdAt", model.getCreatedAt());
        mapParameters.addValue("updatedAt", model.getUpdatedAt());

        jdbcTemplate.update(INSERT_SPLIT_QUERY, mapParameters);
    }
    @Override
    public void deleteSplit(Long id) {
        MapSqlParameterSource mapParameters = new MapSqlParameterSource();

        mapParameters.addValue("idSplit", id);

        jdbcTemplate.update(DELETE_SPLIT_QUERY,mapParameters);
    }
}
