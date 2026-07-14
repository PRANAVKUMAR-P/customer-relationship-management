package com.examly.springapp.service;

import com.examly.springapp.model.*;
import com.examly.springapp.repository.*;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InteractionService {
    private final InteractionRepository repo;
    private final CustomerRepository customerRepo;

    public InteractionService(InteractionRepository repo,
                              CustomerRepository customerRepo){
        this.repo=repo;
        this.customerRepo=customerRepo;
    }

    public Interaction add(Long customerId,Interaction i){
        Customer c=customerRepo.findById(customerId).orElse(null);
        i.setCustomer(c);
        i.setTimestamp(LocalDateTime.now());
        return repo.save(i);
    }

    public List<Interaction> getByCustomer(Long id){
        return repo.findByCustomerId(id);
    }

    public List<Interaction> getAll(){
        return repo.findAll();
    }
}