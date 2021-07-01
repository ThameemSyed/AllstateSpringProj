package com.allstate.customer.service;

import com.allstate.customer.domain.CustomerData;

import java.util.List;

public interface CustomerService {

    public List<CustomerData> getAllCustomerData();
    public List<CustomerData> getCustomerDataById(Integer customerId);
    public List<CustomerData> getCustomerDataByFirstName(String firstName);



}
