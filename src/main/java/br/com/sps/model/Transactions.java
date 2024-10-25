package br.com.sps.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Transactions implements Serializable{

	private static final long serialVersionUID = 1L;

	//informações da hierarquia
	private Long idTransaction;
	private Long idMaster;
	//informações do pagador
	private Long idCustomer;
	private String customerName;
	private String documentNumber;
	private  String phoneNumber;
	private String email;
	//dadostransacionais
	private  Long idSubordinate;
	private Float TotalAmount;
	//Data de criação e atualização
	private Date createdAt;
	private Date updatedAt;
}
