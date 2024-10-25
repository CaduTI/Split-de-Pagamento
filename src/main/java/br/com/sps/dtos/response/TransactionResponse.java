package br.com.sps.dtos.response;

import br.com.sps.model.Customer;
import br.com.sps.model.PaymentInformation;
import br.com.sps.model.Transactions;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse extends RepresentationModel<TransactionResponse> {

    //informações da hierarquia
    Long idTransaction;
    Long idMaster;
    //informações do pagador
    Customer customer;
    //dadostransacionais
    Long idSubordinate;
    Float totalAmount;
    Date createdAt;
    Date updatedAt;
}
