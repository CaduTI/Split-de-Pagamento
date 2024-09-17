package br.com.sps.data.mapper.vo;

import org.springframework.stereotype.Component;

import br.com.sps.data.vo.SubordinateVO;
import br.com.sps.model.Subordinate;

@Component
public class SubordinateMapper {
	
	public SubordinateVO toVO(Subordinate model) {
		return new SubordinateVO(model.getIdSubordinate(),model.getName(),model.getDocumentNumber(),model.getPercentRepass());
	}
	
	public Subordinate toEntity(SubordinateVO vo) {
		Subordinate model = new Subordinate();
		
		model.setIdSubordinate(vo.getIdSubordinate());
		model.setName(vo.getName());
		model.setDocumentNumber(vo.getDocumentNumber());
		model.setPercentRepass(vo.getPercentRepass());
		
		return model;
	}
}
