package br.com.sps.services;

import br.com.sps.data.vo.CustomerVO;

public interface CustomerService {
	public CustomerVO getAcquirer(Long id);
	public CustomerVO createAcquirer(CustomerVO vo);
	public CustomerVO updateAcquirer(CustomerVO vo);
	public void deleteAcquirer(Long id);
}
