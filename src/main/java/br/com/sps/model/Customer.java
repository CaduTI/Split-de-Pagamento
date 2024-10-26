package br.com.sps.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
//@Accessors(fluent = false)
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;

	private String customerName;

	private String documentNumber;

	private String phoneNumber;

	private String email;
	
}
