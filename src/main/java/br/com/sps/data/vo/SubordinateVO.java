package br.com.sps.data.vo;

import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({"idSubordinate","name","documentNumber","percentRepass"})
public class SubordinateVO extends RepresentationModel<SubordinateVO>{
	private Long idSubordinate;
	private String name;
	private String documentNumber;
	private Float percentRepass;
	
	//Constructors
	public SubordinateVO(){};
	
	public SubordinateVO(Long idSubordinate, String name, String documentNumber, Float percentRepass) {
		this.idSubordinate = idSubordinate;
		this.name = name;
		this.documentNumber = documentNumber;
		this.percentRepass = percentRepass;
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

	public Float getPercentRepass() {
		return percentRepass;
	}

	public void setPercentRepass(Float percentRepass) {
		this.percentRepass = percentRepass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(documentNumber, idSubordinate, name, percentRepass);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubordinateVO other = (SubordinateVO) obj;
		return Objects.equals(documentNumber, other.documentNumber)
				&& Objects.equals(idSubordinate, other.idSubordinate) && Objects.equals(name, other.name)
				&& Objects.equals(percentRepass, other.percentRepass);
	}

	
}
