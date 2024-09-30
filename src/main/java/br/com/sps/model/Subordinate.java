package br.com.sps.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Subordinate")
public class Subordinate implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSubordinate;
	
	@Column(name = "Name", nullable = false)
	private String name;
	
	@Column(name = "DocumentNumber", nullable = false)
	private String documentNumber;
	
	@Column(name = "PercentRate", nullable = false)
	private Float percentRate;
	
	//Constructors
	public Subordinate(){};
	
	public Subordinate(Long idSubordinate, String name, String documentNumber, Float percentRate) {
		this.idSubordinate = idSubordinate;
		this.name = name;
		this.documentNumber = documentNumber;
		this.percentRate = percentRate;
	}
	
	//Getters and Setters
	public Long getIdSubordinate() {
		return idSubordinate;
	}

	public void setIdSubordinate(Long idSubordinate) {
		this.idSubordinate = idSubordinate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public Float getPercentRate() {
		return percentRate;
	}

	public void setPercentRate(Float percentRate) {
		this.percentRate = percentRate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(documentNumber, idSubordinate, name, percentRate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subordinate other = (Subordinate) obj;
		return Objects.equals(documentNumber, other.documentNumber)
				&& Objects.equals(idSubordinate, other.idSubordinate) && Objects.equals(name, other.name)
				&& Objects.equals(percentRate, other.percentRate);
	}
	
	
	
}
