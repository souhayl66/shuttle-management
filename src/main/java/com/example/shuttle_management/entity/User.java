package com.example.shuttle_management.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.example.shuttle_management.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    @Transient
    @Autowired
    private transient SubscriptionRepository subscriptionRepository;

    public boolean hasActiveAbonnement() {
        if (subscriptionRepository == null) {
            throw new IllegalStateException("SubscriptionRepository is not injected.");
        }
        Optional<Subscription> subscription = subscriptionRepository.findByUserId(this.id);
        return subscription.isPresent() && subscription.get().isValid();
    }
}