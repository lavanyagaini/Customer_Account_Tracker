package com.wipro.capstone.bean;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class CustomerBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="user_id")
	private int id;
	private String name;
	private String address;
	private String phoneNo;
	private String aadharNo;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_user_id",referencedColumnName="user_id")
	private List<AccountBean> accountbean;

	public CustomerBean(int id, String name, String address, String phoneNo, String aadharNo,
			List<AccountBean> accountbean) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.aadharNo = aadharNo;
		this.accountbean = accountbean;
	}

	public CustomerBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public List<AccountBean> getAccountbean() {
		return accountbean;
	}

	public void setAccountbean(List<AccountBean> accountbean) {
		this.accountbean = accountbean;
	}

	@Override
	public String toString() {
		return "CustomerBean [id=" + id + ", name=" + name + ", address=" + address + ", phoneNo=" + phoneNo
				+ ", aadharNo=" + aadharNo + ", accountbean=" + accountbean + "]";
	}

	
	}