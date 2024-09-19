package br.com.sps.services;

import br.com.sps.model.Master;

public interface MasterService {

	public Master getMaster(Long id);
	public Master createMaster(Master vo);
	public Master updateMaster(Master vo);
	public void deleteMaster (Long id);
}
