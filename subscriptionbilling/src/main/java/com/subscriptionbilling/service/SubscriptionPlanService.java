package com.subscriptionbilling.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.subscriptionbilling.entity.SubscriptionPlan;
import com.subscriptionbilling.repository.SubscriptionPlanRepository;

@Service
public class SubscriptionPlanService {
    private final SubscriptionPlanRepository planRepository;

    public SubscriptionPlanService(SubscriptionPlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public int addPlan(SubscriptionPlan plan) {
        return planRepository.save(plan);
    }

    public List<SubscriptionPlan> getAllPlans() {
        return planRepository.findAll();
    }
}

