package com.examly.springapp.controller;

import com.examly.springapp.model.Interaction;
import com.examly.springapp.repository.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
public class InteractionController {

    private final InteractionRepository interactionRepo;
    private final CustomerRepository customerRepo;

    public InteractionController(InteractionRepository interactionRepo,
                                 CustomerRepository customerRepo) {
        this.interactionRepo = interactionRepo;
        this.customerRepo = customerRepo;
    }

    @PostMapping("/api/interactions")
    public ResponseEntity<?> create(@RequestBody Interaction i) {

        if (!customerRepo.existsById(i.getCustomer().getId()))
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Customer not found"));


        return ResponseEntity.status(HttpStatus.CREATED)
                .body(interactionRepo.save(i));
    }

    @GetMapping("/api/customers/{id}/interactions")
    public List<Interaction> getByCustomer(@PathVariable Long id) {
        return interactionRepo.findByCustomerId(id);
    }
}