package com.example.Redis_cache.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Invoice implements Serializable{

    private static final long serialVersionUID = -4439114469417994311L;

    @Id
    @GeneratedValue
    private Integer invId;
    private String invName;
    private Double invAmount;
	public Integer getInvId() {
		return invId;
	}
	public void setInvId(Integer invId) {
		this.invId = invId;
	}
	public String getInvName() {
		return invName;
	}
	public void setInvName(String invName) {
		this.invName = invName;
	}
	public Double getInvAmount() {
		return invAmount;
	}
	public void setInvAmount(Double invAmount) {
		this.invAmount = invAmount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}