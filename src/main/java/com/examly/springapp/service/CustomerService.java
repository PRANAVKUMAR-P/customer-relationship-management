package com.examly.springapp.service;

import com.examly.springapp.model.Customer;
import com.examly.springapp.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo){
        this.repo=repo;
    }

    public List<Customer> getAll(){
        return repo.findAll();
    }

    public Customer get(Long id){
        return repo.findById(id).orElse(null);
    }

    public Customer add(Customer c){
        return repo.save(c);
    }

    public Customer update(Long id,Customer c){
        c.setId(id);
        return repo.save(c);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

    public List<Customer> search(String name){
        return repo.findByNameContainingIgnoreCase(name);
    }
}