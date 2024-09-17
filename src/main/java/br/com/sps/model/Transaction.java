package br.com.sps.model;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Transaction implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long idTransaction;
	private Long idMaster;
	private Customer Customer;
	private Float TotalAmount;
	private List<Order> splitPayments;
	public Transaction(){}	
}
