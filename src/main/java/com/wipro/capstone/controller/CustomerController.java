package com.wipro.capstone.controller;

import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.capstone.bean.CustomerBean;
import com.wipro.capstone.dao.AccountDao;
import com.wipro.capstone.dao.CustomerDao;
import com.wipro.capstone.service.AccountService;
import com.wipro.capstone.service.CustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerDao cd;
	
	@Autowired
	AccountDao ad;
	@Autowired
	CustomerService cs;
	
	@PostMapping("/addcustomer")
	
	public String addAccount(@RequestBody CustomerBean customerbean) {
		return cs.CreateCustomer(customerbean);
		
	}
																																																																																												
	
	@GetMapping("/allcustomers")
	
	public ResponseEntity<List<CustomerBean>> getAllCustomers(){
		
		List<CustomerBean> cust=new ArrayList<>();
		cd.findAll().forEach(cust::add);
		return new ResponseEntity<List<CustomerBean>>(cust,HttpStatus.OK);
		
	}
	
	@GetMapping("/getById/{id}")
	
	public ResponseEntity<CustomerBean> getCustomerById(@PathVariable int id){
		
		Optional<CustomerBean> cust=cd.findById(id);
		if(cust.isPresent()) {
			return new ResponseEntity<CustomerBean>(cust.get(),HttpStatus.FOUND);
		}else {
			return new ResponseEntity<CustomerBean>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/update/{id}")
	
	public String updateCustomerById(@PathVariable int id,@RequestBody CustomerBean customerBean) {
		Optional<CustomerBean> cust=cd.findById(id);
		if(cust.isPresent()) {
			CustomerBean existCust=cust.get();
			existCust.setName(customerBean.getName());
			existCust.setAddress(customerBean.getAddress());
			existCust.setAadharNo(customerBean.getAadharNo());
			existCust.setPhoneNo(customerBean.getPhoneNo());
			existCust.setAccountbean(customerBean.getAccountbean());
			cd.save(existCust);
			return "customer details against id " + id + " updated";
		}else {
			return "customer details does not exist for id "+id;
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String DeleteCustomerById(@PathVariable int id) {
		cd.deleteById(id);
		return "Customer Deleted Successfully";
	}
	
	@DeleteMapping("/deleteAll")
	public String DeleteAllCustomers() {
		cd.deleteAll();
		return "Customers deleted SuccessFully....";
	}
}
