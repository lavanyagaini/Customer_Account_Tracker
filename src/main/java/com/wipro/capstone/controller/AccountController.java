package com.wipro.capstone.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.capstone.bean.AccountBean;
import com.wipro.capstone.bean.CustomerBean;
import com.wipro.capstone.dao.AccountDao;
import com.wipro.capstone.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService as;
	
	
	
	@Autowired
	private AccountDao ad;
	
	@PutMapping ("/addAccount")
	public  String addAccount(@RequestBody AccountBean accountbean) {
		return as.save(accountbean);
	}
	
	
	@GetMapping("/getById/{accId}")
	public ResponseEntity<AccountBean> getAccountByaccId(@PathVariable long accId){
		
		Optional<AccountBean> cust=ad.findByaccId(accId);
		if(cust.isPresent()) {
			return new ResponseEntity<AccountBean>(cust.get(),HttpStatus.FOUND);
		}else {
			return new ResponseEntity<AccountBean>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/fundTranfer/{from}/{to}/{amount}")
	public ResponseEntity<?> fundTranfer(@PathVariable long from,@PathVariable long to,@PathVariable float amount)
	{
		String result=as.fundTranfer(from,to,amount);
		return new ResponseEntity<>(result,HttpStatus.OK);
		
	}
}
