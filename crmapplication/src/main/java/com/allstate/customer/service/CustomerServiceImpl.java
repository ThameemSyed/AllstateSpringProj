package com.allstate.customer.service;

import com.allstate.customer.data.CustomerRepository;
import com.allstate.customer.data.InteractionRepository;
import com.allstate.customer.domain.CustomerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository  repository;

    @Autowired
    private InteractionRepository InteractRepo;

    @Override
    public List<CustomerData> getAllCustomerData() {
        return repository.findAll() ;
    }

    @Override
    public List<CustomerData> findAllByCustomerId(Integer customerId) {
        return repository.findAllByCustomerId(customerId);
    }

    @Override
    public List<CustomerData> getCustomerDataByFirstName(String firstName) {
        return repository.getAllByFirstName(firstName);
    }

    @Override
    public Integer addCustomerData(CustomerData newCustomer) {
        repository.save(newCustomer);
        return newCustomer.getCustomerId();
    }

    @Override
    public void updateCustomerData(Integer id, CustomerData newCustomer) {
        CustomerData custData = repository.findById(id).get();

        if (newCustomer.getFirstName() != null) {
            System.out.println("at line 45"+custData.getFirstName());
            custData.setFirstName(newCustomer.getFirstName());
        }
        if(newCustomer.getLastName() != null){
            custData.setLastName(newCustomer.getLastName());
        }
        if(custData.getMiddleName() != null){
            custData.setMiddleName((newCustomer.getMiddleName()));
        }
        repository.save(custData);
        System.out.println("at line 42" + custData);
    }

    @Override
    public CustomerData getCustomerById(Integer id) {

        CustomerData resCust = repository.findById(id).get();
        return resCust;
    }

    @Override
    public void deleteCustomerData(Integer id) {

        repository.deleteById(id);
        InteractRepo.deleteAllByCustD_CustomerId(id);
    }
}
