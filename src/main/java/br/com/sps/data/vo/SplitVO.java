package br.com.sps.data.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.sps.model.Order;
import jakarta.persistence.Id;

@JsonPropertyOrder({"idSplit","idAcquirer","idMaster","idSubordinate","isCommission","GrossAmount","netAmount","transactionList"})
public class SplitVO extends RepresentationModel<SplitVO> implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private Long idSplit;
	private Long idAcquirer;
	private Long idMaster;
	private Long idSubordinate;
	private Boolean isCommission;
	private Float GrossAmount;
	private Float netAmount;
	private List<Order> transactionInfo;
	
	public SplitVO() {}
	
	public SplitVO(Long idSplit, Long idAcquirer, Long idMaster, Long idSubordinate, Boolean isCommission,
			Float grossAmount, Float netAmount, List<Order> transactionInfo) {
		this.idSplit = idSplit;
		this.idAcquirer = idAcquirer;
		this.idMaster = idMaster;
		this.idSubordinate = idSubordinate;
		this.isCommission = isCommission;
		this.GrossAmount = grossAmount;
		this.netAmount = netAmount;
		this.transactionInfo = transactionInfo;
	}


	public Long getIdSplit() {
		return idSplit;
	}


	public void setIdSplit(Long idSplit) {
		this.idSplit = idSplit;
	}


	public Long getIdAcquirer() {
		return idAcquirer;
	}


	public void setIdAcquirer(Long idAcquirer) {
		this.idAcquirer = idAcquirer;
	}


	public Long getIdMaster() {
		return idMaster;
	}


	public void setIdMaster(Long idMaster) {
		this.idMaster = idMaster;
	}


	public Long getIdSubordinate() {
		return idSubordinate;
	}


	public void setIdSubordinate(Long idSubordinate) {
		this.idSubordinate = idSubordinate;
	}


	public Boolean getIsCommission() {
		return isCommission;
	}


	public void setIsCommission(Boolean isCommission) {
		this.isCommission = isCommission;
	}


	public Float getGrossAmount() {
		return GrossAmount;
	}


	public void setGrossAmount(Float grossAmount) {
		GrossAmount = grossAmount;
	}


	public Float getNetAmount() {
		return netAmount;
	}


	public void setNetAmount(Float netAmount) {
		this.netAmount = netAmount;
	}


	public List<Order> getTransactionList() {
		return transactionInfo;
	}


	public void setTransactionList(List<Order> transactionList) {
		this.transactionInfo = transactionList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(GrossAmount, idAcquirer, idMaster, idSplit, idSubordinate, isCommission, netAmount,
				transactionInfo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SplitVO other = (SplitVO) obj;
		return Objects.equals(GrossAmount, other.GrossAmount) && Objects.equals(idAcquirer, other.idAcquirer)
				&& Objects.equals(idMaster, other.idMaster) && Objects.equals(idSplit, other.idSplit)
				&& Objects.equals(idSubordinate, other.idSubordinate)
				&& Objects.equals(isCommission, other.isCommission) && Objects.equals(netAmount, other.netAmount)
				&& Objects.equals(transactionInfo, other.transactionInfo);
	}

	
	
}

	
