package br.com.sps.services;

import br.com.sps.data.vo.SubordinateVO;

public interface SubordinateService {
	 public SubordinateVO getSubordinate(Long id);
	 public SubordinateVO createSubordinate(SubordinateVO vo);
	 public SubordinateVO updateSubordinate(SubordinateVO vo);
	 public void deleteSubordinate(Long id);
	
}
