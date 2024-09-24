package br.com.sps.controller;

import br.com.sps.dtos.response.TransactionResponse;
import br.com.sps.model.Transactions;
import br.com.sps.dtos.request.TransactionRequest;
import br.com.sps.services.impl.TransactionServiceImpl;
import br.com.sps.util.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/transaction/v1")
public class TransactionController {

    @Autowired
    TransactionServiceImpl service;


    @GetMapping(value = "/{id}",
            produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
    public Transactions getTransactions(@PathVariable("id") Long id) throws SQLException {
        return service.FindTransactionById(id);
    }

    @PostMapping(consumes = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML},
            produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
    public TransactionResponse createTransactions(@RequestBody TransactionRequest model){
        return service.createTransaction(model);
    }


    @PutMapping(consumes = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML},
            produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
    public TransactionResponse updateTransactions(@RequestBody TransactionRequest model){
        return service.createTransaction(model);
    }

    @DeleteMapping(value = "/{id}",
            produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
    public ResponseEntity<?> deleteTransactions(@PathVariable("id") Long id) throws SQLException {
        service.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
