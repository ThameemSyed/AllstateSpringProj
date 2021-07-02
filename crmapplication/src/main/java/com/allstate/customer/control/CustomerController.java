package com.allstate.customer.control;

import com.allstate.customer.domain.CustomerData;
import com.allstate.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.awt.*;
import java.util.List;

@RestController
@CrossOrigin
@Transactional(Transactional.TxType.REQUIRED)
@RequestMapping("api/clientdata")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping()
    public List<CustomerData> getCustomerData(@RequestParam(value = "customerId", required = false) Integer customerId,
    @RequestParam(value = "firstName", required = false) String firstName)
    {
        if(customerId != null) {
            return service.findAllByCustomerId(customerId);
        }
        else if (firstName != null) {
            return service.getCustomerDataByFirstName(firstName);
        }else {
            return service.getAllCustomerData();
        }
    }
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public CustomerData getCustomerById(@PathVariable Integer id){
        return service.getCustomerById(id);

    }

    @PostMapping()
    public String addCustomerData(@RequestBody CustomerData newCustomer )
    {
     Integer newCustId = service.addCustomerData(newCustomer);
     return ("{id:"+newCustId+"}");
    }

    @PutMapping("/{id}")
    public void updateCustomerData(@PathVariable Integer id,
            @RequestBody CustomerData updatedCustomerData)
    {
        service.updateCustomerData(id, updatedCustomerData);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerData(@PathVariable Integer id)
    {
        service.deleteCustomerData(id);
    }
}
