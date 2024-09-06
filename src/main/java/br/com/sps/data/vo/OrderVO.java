package br.com.sps.data.vo;

import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"orderId","subordinateId","itemName","amount"})
public class OrderVO extends RepresentationModel<OrderVO>{
	private Long orderId;
	private Long subordinateId;
	private String itemName;
	private Float amount;
	
	public OrderVO() {};
	
	public OrderVO(Long orderId, Long subordinateId, String itemName, Float amount) {
		this.orderId = orderId;
		this.subordinateId = subordinateId;
		this.itemName = itemName;
		this.amount = amount;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getSubordinateId() {
		return subordinateId;
	}

	public void setSubordinateId(Long subordinateId) {
		this.subordinateId = subordinateId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(amount, itemName, orderId, subordinateId);
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
		OrderVO other = (OrderVO) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(itemName, other.itemName)
				&& Objects.equals(orderId, other.orderId) && Objects.equals(subordinateId, other.subordinateId);
	}

	
	
}
