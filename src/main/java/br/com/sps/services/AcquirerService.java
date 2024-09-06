package br.com.sps.services;

import br.com.sps.data.vo.AcquirerVO;

public interface AcquirerService {
	public AcquirerVO getAcquirer(Long id);
	public AcquirerVO createAcquirer(AcquirerVO vo);
	public AcquirerVO updateAcquirer(AcquirerVO vo);
	public void deleteAcquirer(Long id);
}
