package com.wipro.capstone.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.capstone.bean.AccountBean;
import com.wipro.capstone.bean.CustomerBean;
import com.wipro.capstone.dao.AccountDao;

@Service
public class AccountService {
	
	@Autowired
	AccountDao ad;

	public String fundTranfer(long fromAccount, long toAccount, float amount) {
		if(amount<1)
			return "amount must greaterthan 1";
		else if(fromAccount==toAccount)
			return "fromAccount and toAccount must Different";
		else {
			Optional<AccountBean> fromacc=ad.findByaccId(fromAccount);
			Optional<AccountBean> toacc=ad.findByaccId(toAccount);
			if(fromacc.isPresent()&&toacc.isPresent()) {
				AccountBean src=fromacc.get();
				AccountBean dest=toacc.get();
				if(src.getBalance()>amount) {
					src.setBalance(src.getBalance()-amount);
					dest.setBalance(dest.getBalance()+amount);
					ad.save(src);
					ad.save(dest);
					return "fund transferred is successfull";
				}
				else {
					return "Insufficient balance";
				}
			}
			else {
				return "from/to accounts not exists";
			}
		}
		
	}

	public String save(AccountBean accountbean) {
		if(ad.existsById(accountbean.getAccId())) {
			return "Account alredy exist...";
		}
		ad.save(accountbean);
		return "Account  added successfully";
	}
	
	
	public AccountBean getAccountByaccId(long accId) {
		Optional<AccountBean> account=ad.findByaccId(accId);
		if(account.isPresent()) {
			return account.get();
		}else {
			return  new AccountBean();
		}
	}

}
