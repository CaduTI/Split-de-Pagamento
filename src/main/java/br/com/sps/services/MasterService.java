package br.com.sps.services;

import br.com.sps.data.vo.MasterVO;

public interface MasterService {

	public MasterVO getMaster(Long id);
	public MasterVO createMaster(MasterVO vo);
	public MasterVO updateMaster(MasterVO vo);
	public void deleteMaster (Long id);
}
