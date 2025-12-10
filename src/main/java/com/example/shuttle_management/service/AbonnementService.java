package com.example.shuttle_management.service;

import com.example.shuttle_management.entity.Subscription;
import com.example.shuttle_management.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class AbonnementService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public boolean hasValidAbonnement(Long userId) {
        Optional<Subscription> abonnement = subscriptionRepository.findByUserId(userId);
        return abonnement.isPresent() && abonnement.get().isValid();
    }

    public void createAbonnement(Long userId) {
        Subscription abonnement = new Subscription();
        abonnement.setStartDate(LocalDate.now());
        abonnement.setEndDate(LocalDate.now().plusMonths(1));
        subscriptionRepository.save(abonnement);
    }
}