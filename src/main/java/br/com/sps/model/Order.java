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
@Table(name = "Orders")
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	
	@Column(name = "SubordinateId")
	private Long subordinateId;
	
	@Column(name = "itemName")
	private String itemName;
	
	@Column(name = "Amount")
	private Float amount;
	
	public Order(Long orderId, Long subordinateId, String itemName, Float amount) {
		this.orderId = orderId;
		this.subordinateId = subordinateId;
		this.itemName = itemName;
		this.amount = amount;
	}

	public Order() {}

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
		return Objects.hash(amount, itemName, orderId, subordinateId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(itemName, other.itemName)
				&& Objects.equals(orderId, other.orderId) && Objects.equals(subordinateId, other.subordinateId);
	}
	
	
}
