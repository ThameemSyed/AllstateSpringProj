package com.allstate.customer.service;

import com.allstate.customer.domain.CustomerData;

import java.util.List;

public interface CustomerService {

    public List<CustomerData> getAllCustomerData();
    public List<CustomerData> findAllByCustomerId(Integer customerId);
    public List<CustomerData> getCustomerDataByFirstName(String firstName);
    public Integer addCustomerData(CustomerData newCustomer);
    public void updateCustomerData(Integer id, CustomerData updatedCustomer);
    public CustomerData getCustomerById(Integer id);
    public void deleteCustomerData(Integer id);
}
