package br.com.sps.data.mapper;


import org.springframework.context.annotation.Configuration;

import br.com.sps.data.vo.MasterVO;
import br.com.sps.model.Master;

@Configuration
public class MasterMapper {
	public MasterVO toVO(Master entity) {
		return new MasterVO(entity.getIdMaster(), entity.getName(), entity.getDocumentNumber(), entity.getPercentRepass());
	}
	
	public Master toEntity(MasterVO vo) {
		Master entity = new Master();
		
		entity.setIdMaster(vo.getIdMaster());
		entity.setName(vo.getName());
		entity.setDocumentNumber(vo.getDocumentNumber());
		entity.setPercentRepass(vo.getPercentRepass());
		
		return entity;
	}
}
