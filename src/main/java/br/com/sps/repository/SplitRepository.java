package br.com.sps.repository;

import br.com.sps.model.Split;
public interface SplitRepository {

    public Split selectSplit(Long id);
    public void createSplit(Split model);
    public void deleteSplit(Long id);

}
