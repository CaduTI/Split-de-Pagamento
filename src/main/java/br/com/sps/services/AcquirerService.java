package br.com.sps.services;


import br.com.sps.model.Acquirer;

public interface AcquirerService {
	public Acquirer getAcquirer(Long id);
	public Acquirer createAcquirer(Acquirer vo);
	public Acquirer updateAcquirer(Acquirer vo);
	public void deleteAcquirer(Long id);
}
