package com.allstate.customer.service;

import com.allstate.customer.data.CustomerRepository;
import com.allstate.customer.domain.CustomerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository  repository;

    @Override
    public List<CustomerData> getAllCustomerData() {
        return repository.findAll() ;
    }


    @Override
    public List<CustomerData> getCustomerDataById(Integer customerId) {
        return repository.findCustomerDataByCustomerId(customerId);
    }

    @Override
    public List<CustomerData> getCustomerDataByFirstName(String firstName) {
        return repository.getAllByFirstName(firstName);
    }

}
