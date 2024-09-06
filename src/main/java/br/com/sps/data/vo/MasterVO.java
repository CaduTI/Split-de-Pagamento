package br.com.sps.data.vo;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@JsonPropertyOrder({"idMaster","name","documentNumber","percentRepass"})
public class MasterVO implements Serializable{
		
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long idMaster;
		
		
		private String name;
		
		
		private String documentNumber;
		
		
		private Float percentRepass;

		public MasterVO(){}
		
		public MasterVO(Long idMaster, String name, String documentNumber, Float percentRepass) {
			this.idMaster = idMaster;
			this.name = name;
			this.documentNumber = documentNumber;
			this.percentRepass = percentRepass;
		}

		public Long getIdMaster() {
			return idMaster;
		}

		public void setIdMaster(Long idMaster) {
			this.idMaster = idMaster;
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
			return Objects.hash(documentNumber, idMaster, name, percentRepass);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MasterVO other = (MasterVO) obj;
			return Objects.equals(documentNumber, other.documentNumber) && Objects.equals(idMaster, other.idMaster)
					&& Objects.equals(name, other.name) && Objects.equals(percentRepass, other.percentRepass);
		}
		
		
}
