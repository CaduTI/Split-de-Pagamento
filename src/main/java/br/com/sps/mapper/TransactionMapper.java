package br.com.sps.mapper;

import br.com.sps.dtos.response.TransactionResponse;
import br.com.sps.model.Customer;
import br.com.sps.model.Transactions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public TransactionResponse toDTO(Transactions model){
        TransactionResponse response = new TransactionResponse();

        Customer customer = new Customer();

        customer.setCustomerName(model.getCustomerName());
        customer.setDocumentNumber(model.getDocumentNumber());
        customer.setPhoneNumber(model.getPhoneNumber());
        customer.setEmail(model.getEmail());

        response.setIdTransaction(model.getIdTransaction());
        response.setIdMaster(model.getIdMaster());
        response.setCustomer(customer);
        response.setIdSubordinate(model.getIdSubordinate());
        response.setTotalAmount(model.getTotalAmount());
        response.setCreatedAt(model.getCreatedAt());
        response.setUpdatedAt(model.getUpdatedAt());

        return response;
    }
}
