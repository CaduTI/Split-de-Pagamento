package br.com.sps.services;

import br.com.sps.data.vo.SplitVO;

public interface SplitService {
	public SplitVO FindSplitById(Long id);
	
	public SplitVO createSplit(SplitVO vo);
	
	public SplitVO updateSplit(SplitVO vo);
	
	public void deleteSplit(Long id);
	
	public SplitVO commissionRepass();
}
