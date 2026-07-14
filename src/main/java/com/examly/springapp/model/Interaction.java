package com.examly.springapp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Interaction {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private InteractionType type;

    private String notes;
    private LocalDateTime timestamp;

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public Customer getCustomer(){return customer;}
    public void setCustomer(Customer customer){this.customer=customer;}
    public User getUser(){return user;}
    public void setUser(User user){this.user=user;}
    public InteractionType getType(){return type;}
    public void setType(InteractionType type){this.type=type;}
    public String getNotes(){return notes;}
    public void setNotes(String notes){this.notes=notes;}
    public LocalDateTime getTimestamp(){return timestamp;}
    public void setTimestamp(LocalDateTime timestamp){this.timestamp=timestamp;}
}