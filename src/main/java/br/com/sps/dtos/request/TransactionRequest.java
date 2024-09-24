package br.com.sps.dtos.request;

import br.com.sps.model.Customer;
import br.com.sps.model.PaymentInformation;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest{
    //informações da hierarquia
    Long idTransaction;
    Long idMaster;
    //informações do pagador
    Customer customer;
    //dadostransacionais
    Long idSubordinate;
    Float totalAmount;
}
