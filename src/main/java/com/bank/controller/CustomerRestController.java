package com.bank.controller;
import com.bank.dao.CustomerDao;
import com.bank.entity.Customer;
import com.bank.exceptions.custom.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerRestController {

    @Autowired
    CustomerDao customerDao;

    @GetMapping("/list")
    public List<Customer> allCustomer()
    {
        return  customerDao.allCustomer();
    }
    @PostMapping(value ="/create")
    public String createCustomer(@RequestBody Customer customer)
    {
           customerDao.createCustomer(customer,customer.getGivenBranchId());
           return "Customer Account open";
    }
    @DeleteMapping("/delete")
    public String deleteCustomer(@RequestParam String customerId)
    {
        customerDao.deleteCustomer(Integer.parseInt(customerId));
        return "Customer Account close";
    }
    @PostMapping(value ="/debit")
    public String debit(@RequestParam String amount,@RequestParam String customerId)
    {
        if(customerDao.getCustomer(Integer.parseInt(customerId))==null)
        {
            throw  new CustomException("Customer Not Found for this Id " +customerId);
        }
        int updateBc=customerDao.debit(Integer.parseInt(amount),Integer.parseInt(customerId));
        if(updateBc==-1)
        {
            return "you have not sufficient account balance";
        }
        else
        {
            return "your account debit "+amount+" now your account balance is "+updateBc;
        }
    }
    @PostMapping(value ="/credit")
    public int credit(@RequestParam String amount,@RequestParam String customerId)
    {
        if(customerDao.getCustomer(Integer.parseInt(customerId))==null)
        {
            throw  new CustomException("Customer Not Found for this Id " +customerId);
        }
        return customerDao.credit(Integer.parseInt(amount),Integer.parseInt(customerId));
    }
}
