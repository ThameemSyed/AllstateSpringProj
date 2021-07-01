package com.allstate.customer.control;

import com.allstate.customer.domain.CustomerData;
import com.allstate.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin
@Transactional(Transactional.TxType.REQUIRED)
@RequestMapping("/customer/data")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping()
    public List<CustomerData> getCustomerData(@RequestParam(value = "customerId", required = false) Integer customerId,
    @RequestParam(value = "firstName", required = false) String firstName)
    {
        if(customerId != null) {
            return service.getCustomerDataById(customerId);
        }
        else if (firstName != null) {
            return service.getCustomerDataByFirstName(firstName);
        }else {
            return service.getAllCustomerData();
        }
    }
}
