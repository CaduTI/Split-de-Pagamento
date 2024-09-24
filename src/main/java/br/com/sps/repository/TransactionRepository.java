package br.com.sps.repository;

import br.com.sps.model.Transactions;

public interface TransactionRepository {
 public Transactions selectSplit(Long id);
 public void createSplit(Transactions vo);
 public void updateSplit(Transactions vo);
 public void deleteSplit(Long id);
}
