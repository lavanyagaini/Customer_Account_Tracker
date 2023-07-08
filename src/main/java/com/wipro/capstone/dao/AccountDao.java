package com.wipro.capstone.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.capstone.bean.AccountBean;

@Repository
public interface AccountDao extends JpaRepository<AccountBean,Integer> {
	
	//Optional<AccountBean> findByAccNumber(long accnumber);

	Optional<AccountBean> findByaccId(long fromAccount);

	boolean existsById(long accId);

	

}
