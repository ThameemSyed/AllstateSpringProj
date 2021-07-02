package com.allstate.customer.data;

import com.allstate.customer.domain.CustomerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerData, Integer> {

    public  List<CustomerData> findAllByCustomerId(Integer customerId);
    public List<CustomerData> getAllByFirstName(String firstName);

}
