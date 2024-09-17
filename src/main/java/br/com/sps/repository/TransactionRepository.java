package br.com.sps.repository;

import br.com.sps.data.vo.TransactionVO;

public interface TransactionRepository {
 public TransactionVO selectSplit(Long id);
 public void createSplit(TransactionVO vo);
 public void updateSplit(TransactionVO vo);
 public void deleteSplit(Long id);
}
