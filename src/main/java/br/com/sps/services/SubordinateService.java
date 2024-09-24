package br.com.sps.services;


import br.com.sps.model.Subordinate;

public interface SubordinateService {
	 public Subordinate getSubordinate(Long id);
	 public Subordinate createSubordinate(Subordinate vo);
	 public Subordinate updateSubordinate(Subordinate vo);
	 public void deleteSubordinate(Long id);
	
}
