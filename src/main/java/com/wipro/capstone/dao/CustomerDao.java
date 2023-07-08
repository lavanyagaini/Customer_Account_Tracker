package com.wipro.capstone.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.capstone.bean.CustomerBean;

@Repository
public interface CustomerDao extends JpaRepository<CustomerBean,Integer>{
	
	Optional<CustomerBean> getById(int id);
	Optional<CustomerBean> deleteById(int id);
	
	
	
	
}
