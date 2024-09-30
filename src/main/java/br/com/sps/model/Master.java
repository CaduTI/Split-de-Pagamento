package br.com.sps.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "Master")
@Builder
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Master implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idMaster;
	
	@Column(name = "Name", nullable = false)
	private String name;
	
	@Column(name = "DocumentNumber", nullable = false)
	private String documentNumber;
	
	@Column(name = "PercentRate", nullable = false)
	private Float percentRate;
}
