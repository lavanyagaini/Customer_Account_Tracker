package com.wipro.capstone.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AccountBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private long accId;
	private String name;
	private String accType;
	private Double balance;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getAccId() {
		return accId;
	}
	public void setAccId(long accId) {
		this.accId = accId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public AccountBean(int id, long accId, String name, String accType, Double balance) {
		super();
		this.id = id;
		this.accId = accId;
		this.name = name;
		this.accType = accType;
		this.balance = balance;
	}
	public AccountBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AccountBean [id=" + id + ", accId=" + accId + ", name=" + name + ", accType=" + accType + ", balance="
				+ balance + "]";
	}

	
	
}