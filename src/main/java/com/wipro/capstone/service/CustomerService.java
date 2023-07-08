package com.wipro.capstone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.capstone.bean.CustomerBean;
import com.wipro.capstone.controller.CustomerController;
import com.wipro.capstone.dao.AccountDao;
import com.wipro.capstone.dao.CustomerDao;


@Service

public class CustomerService {

	@Autowired
	private CustomerDao cd;
	
	@Autowired
	private AccountDao ad;

	
	@Autowired
	public CustomerService(CustomerDao cd)
	{
		this.cd=cd;
	}
	
	public String CreateCustomer(CustomerBean customerbean) {
		if(cd.existsById(customerbean.getId())) {
			return "customer already Exists...";
		}
		cd.save(customerbean);
		return  "Customer added SuccessFull.....";
	}
	
	public String updateCustomer(CustomerBean a) {
		Optional<CustomerBean> customer=cd.findById(a.getId());
		if(customer.isPresent()) {
			cd.save(a);
			return "Customer Created!!! " + " " + a;
		}else {
			return "No Customer present with given userId";
		}
	}
	
	public List<CustomerBean> GetAllCustomer(){
		List<CustomerBean> list=(List<CustomerBean>)cd.findAll();
		if(list.size()>0) {
			return list;
		}
		else {
			return new ArrayList<CustomerBean>();
		}
		
	}
	
	public CustomerBean GetCustomerById(int id) {
		Optional<CustomerBean> customer=cd.findById(id);
		if(customer.isPresent()) {
			return customer.get();
		}else {
			return  new CustomerBean();
		}
	}
	
	public String DeleteById(int id) {
		Optional<CustomerBean> customer=cd.findById(id);
		if(customer.isPresent()) {
			cd.deleteById(id);
			return "Customer Deleted";
		}else {
			
			return "No Customer record exist for given userId";
		}
	}
	
//	public List<CustomerBean> DeleteAllCustomer(){
//		List<CustomerBean> customer=cd.findAll();
//		if(customer.)
//		return cd.deleteAll();
//		
//	}
	
	
}
