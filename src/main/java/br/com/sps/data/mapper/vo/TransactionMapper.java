package br.com.sps.data.mapper.vo;

import static org.mockito.ArgumentMatchers.nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import br.com.sps.data.vo.TransactionVO;
import br.com.sps.model.Transaction;

@Component
public class TransactionMapper {
	public TransactionVO toVO(Transaction entity) {
		return null;
		}
	
	public Transaction toEntity(TransactionVO vo) {
		Transaction entity =  new Transaction();
		
		
		
		
		return entity;
	}
	
}
