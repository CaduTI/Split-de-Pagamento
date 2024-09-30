package br.com.sps.services;

import br.com.sps.model.Split;
import br.com.sps.model.Transactions;


public interface SplitService {

    public Split findById(Long id);
    public Split createSplit(Transactions model);
    public void deleteSplit(Long id);

}
