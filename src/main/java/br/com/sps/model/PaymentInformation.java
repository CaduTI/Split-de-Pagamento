package br.com.sps.model;

import java.io.Serializable;


import lombok.*;

@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentInformation implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long subordinateId;

	private Float amount;

	private float taxes;
}
