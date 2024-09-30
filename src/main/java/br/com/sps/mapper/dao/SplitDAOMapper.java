package br.com.sps.mapper.dao;

import br.com.sps.model.Split;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SplitDAOMapper implements RowMapper<Split> {
    @Override
    public Split mapRow(ResultSet rs, int rowNum) throws SQLException {
        Split bean = new Split();

        bean.setIdSplit(rs.getLong("idSplit"));
        bean.setIdAcquirer(rs.getLong("idAcquirer"));
        bean.setAcquirerRate(rs.getFloat("acquirerRate"));
        bean.setAcquirerCommission(rs.getFloat("acquirerCommision"));
        bean.setIdMaster(rs.getLong("idMaster"));
        bean.setMasterRate(rs.getFloat("masterRate"));
        bean.setMasterCommission(rs.getFloat("masterCommission"));
        bean.setIdSubordinate(rs.getLong("idSubordinate"));
        bean.setSubordinateRate(rs.getFloat("subordinateRate"));
        bean.setSubordinateCommission(rs.getFloat("subordinateCommission"));
        bean.setTotalAmount(rs.getFloat("totalAmount"));
        bean.setCreatedAt(rs.getDate("createdAt"));
        bean.setUpdatedAt(rs.getDate("updateAt"));

        return bean;
    }
}
