package br.com.sps.data.mapper;

import br.com.sps.data.vo.SplitVO;
import br.com.sps.model.Split;

public class SplitMapper {
	public SplitVO toVO(Split entity) {
		return new SplitVO(entity.getIdSplit(),entity.getIdAcquirer(),entity.getIdMaster(),entity.getIdSubordinate(),entity.getIsCommission(),entity.getGrossAmount(),entity.getNetAmount(),entity.getTransactionList());
	}
	
	public Split toEntity(SplitVO vo) {
		Split entity =  new Split();
		
		entity.setIdSplit(vo.getIdSplit());
		entity.setIdAcquirer(null);
		entity.setIdMaster(null);
		entity.setIdSubordinate(null);
		
		
		return entity;
	}
}
