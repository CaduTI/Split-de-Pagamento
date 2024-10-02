package br.com.sps.services.impl;


import br.com.sps.model.Split;
import br.com.sps.model.Transactions;
import br.com.sps.repository.impl.SplitRepositoryImpl;
import br.com.sps.services.SplitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class SplitServiceImpl implements SplitService {

    @Autowired
    SplitRepositoryImpl repository;

    @Autowired
    AcquirerServiceImpl acquirer;
    @Autowired
    MasterServiceImpl master;

    @Autowired
    SubordinateServiceImpl subordinate;

    @Override
    public Split findById(Long id) {
        return repository.selectSplit(id);
    }

    @Override
    public Split createSplit(Transactions model) {
        Split split = new Split();

        float acquirerRate = acquirer.getAcquirer(1l).getPercentRate();
        float masterRate = master.getMaster(model.getIdMaster()).getPercentRate();
        float subordinateRate = subordinate.getSubordinate(model.getIdSubordinate()).getPercentRate();

        float subordinateCommission = (model.getTotalAmount() * subordinateRate)/100;
        float masterCommission = (model.getTotalAmount() * masterRate)/100;
        float acquirerCommission = (masterCommission * acquirerRate)/100;



        split.setIdSplit(new Random().nextLong(2000000));
        split.setIdAcquirer(1l);
        split.setAcquirerRate(acquirerRate);
        split.setAcquirerCommission(acquirerCommission);
        split.setIdMaster(model.getIdMaster());
        split.setMasterRate(masterRate);
        split.setMasterCommission(masterCommission);
        split.setIdSubordinate(model.getIdSubordinate());
        split.setSubordinateRate(subordinateRate);
        split.setSubordinateCommission(subordinateCommission);
        split.setTotalAmount(model.getTotalAmount());
        split.setCreatedAt(new Date());
        split.setUpdatedAt(new Date());

        repository.createSplit(split);

        return split;
    }

    @Override
    public void deleteSplit(Long id) {
        repository.deleteSplit(id);
    }

}
