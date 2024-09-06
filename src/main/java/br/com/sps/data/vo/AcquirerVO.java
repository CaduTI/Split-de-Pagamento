package br.com.sps.data.vo;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@JsonPropertyOrder({"IdAcquirer","name","documentNumber","percentRepass"})
public class AcquirerVO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long IdAcquirer;
	
	
	private String Name;
	
	
	private String DocumentNumber;
	
	
	private Float PercentRepass;

	public AcquirerVO(){}
	
	public AcquirerVO(Long idAcquirer, String name, String documentNumber, Float percentRepass) {
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
		AcquirerVO other = (AcquirerVO) obj;
		return Objects.equals(DocumentNumber, other.DocumentNumber) && Objects.equals(IdAcquirer, other.IdAcquirer)
				&& Objects.equals(Name, other.Name) && Objects.equals(PercentRepass, other.PercentRepass);
	}
	
	
}
