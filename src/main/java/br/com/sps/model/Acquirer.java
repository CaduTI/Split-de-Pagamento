package br.com.sps.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Acquirer")
public class Acquirer implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long IdAcquirer;
	
	
	private String Name;
	
	
	private String DocumentNumber;
	
	
	private Float PercentRepass;
	
public Acquirer(){}
	
	public Acquirer(Long idAcquirer, String name, String documentNumber, Float percentRepass) {
		IdAcquirer = idAcquirer;
		Name = name;
		DocumentNumber = documentNumber;
		PercentRepass = percentRepass;
	}

	public Long getIdAcquirer() {
		return IdAcquirer;
	}

	public void setIdAcquirer(Long idAcquirer) {
		IdAcquirer = idAcquirer;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDocumentNumber() {
		return DocumentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		DocumentNumber = documentNumber;
	}

	public Float getPercentRepass() {
		return PercentRepass;
	}

	public void setPercentRepass(Float percentRepass) {
		PercentRepass = percentRepass;
	}

	@Override
	public int hashCode() {
		return Objects.hash(DocumentNumber, IdAcquirer, Name, PercentRepass);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acquirer other = (Acquirer) obj;
		return Objects.equals(DocumentNumber, other.DocumentNumber) && Objects.equals(IdAcquirer, other.IdAcquirer)
				&& Objects.equals(Name, other.Name) && Objects.equals(PercentRepass, other.PercentRepass);
	}
	
	
}
