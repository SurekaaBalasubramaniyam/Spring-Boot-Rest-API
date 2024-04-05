package com.Rest.API.service;

import com.Rest.API.dao.CustomerRepository;
import com.Rest.API.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public List<Customer> getAllCustomer(){

        return customerRepository.findAll();

    }

    public Customer getCustomer(Long id){
        Optional<Customer> maybeCustomer = customerRepository.findById(id);
        return maybeCustomer.orElse(null);
    }

    public Customer createCustomer(Customer customer){
        Customer customer1 = customerRepository.save(customer);
        return customer1;
    }

    public Customer updateCustomer(Long id, Customer customer){

        Customer customer1 = customerRepository.findById(id).get();
        customer1.setContact(customer.getContact());
        customer1.setCustomer_name(customer.getCustomer_name());
        customer1.setAddress(customer.getAddress());
        customer1.setContact(customer.getContact());
        return customerRepository.save(customer1);

    }

    public void deleteCustomer(Long id){

        boolean customerExist = customerRepository.existsById(id);

        if(customerExist){
            customerRepository.deleteById(id);
        }

    }
}


