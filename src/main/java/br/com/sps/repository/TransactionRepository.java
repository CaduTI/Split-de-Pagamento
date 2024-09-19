package br.com.sps.repository;

import br.com.sps.model.Transaction;

public interface TransactionRepository {
 public Transaction selectSplit(Long id);
 public void createSplit(Transaction vo);
 public void updateSplit(Transaction vo);
 public void deleteSplit(Long id);
}
