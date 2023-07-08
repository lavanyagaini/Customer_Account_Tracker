package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.capstone.bean.AccountBean;
import com.wipro.capstone.bean.CustomerBean;
import com.wipro.capstone.controller.CustomerController;
import com.wipro.capstone.dao.AccountDao;
import com.wipro.capstone.dao.CustomerDao;
import com.wipro.capstone.service.CustomerService;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {



    @InjectMocks
    private CustomerController customercontroller;

    @MockBean
    CustomerDao cd;

    @MockBean
    AccountDao ad;

    @MockBean
    CustomerService cs;

 

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper obj;

    private List<AccountBean> list;
    private CustomerBean customer;


     @Test
      void shouldCreateCustomer() throws Exception {
         list=new ArrayList<AccountBean>();
         list.add(new AccountBean(1,101,"savings","lavanya",5000.0));
            list.add(new AccountBean(2,102,"current","vinay",15000.0));
            customer=new CustomerBean(1,"lavanya","gdk","9076543456","10001",list);

        mvc.perform(MockMvcRequestBuilders.post("/customer/addcustomer")
            .content(obj.writeValueAsString(customer))
            .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(print());
      }
     
}

