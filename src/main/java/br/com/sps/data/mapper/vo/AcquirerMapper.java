package br.com.sps.data.mapper.vo;

import org.springframework.context.annotation.Configuration;

import br.com.sps.data.vo.AcquirerVO;
import br.com.sps.model.Acquirer;

@Configuration
public class AcquirerMapper {
	public AcquirerVO toVO(Acquirer entity) {
		return new AcquirerVO(entity.getIdAcquirer(), entity.getName(), entity.getDocumentNumber(), entity.getPercentRepass());
	}
	
	public Acquirer toEntity(AcquirerVO vo) {
		Acquirer entity = new Acquirer();
		
		entity.setIdAcquirer(vo.getIdAcquirer());
		entity.setName(vo.getName());
		entity.setDocumentNumber(vo.getDocumentNumber());
		entity.setPercentRepass(vo.getPercentRepass());
		
		return entity;
	}
}
