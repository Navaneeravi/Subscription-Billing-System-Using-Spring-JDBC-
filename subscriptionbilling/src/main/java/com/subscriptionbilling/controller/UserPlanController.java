package com.subscriptionbilling.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subscriptionbilling.entity.SubscriptionPlan;
import com.subscriptionbilling.service.SubscriptionPlanService;

@RestController
@RequestMapping("/api/user/plans") // User-specific endpoint
public class UserPlanController {
    private final SubscriptionPlanService planService;

    public UserPlanController(SubscriptionPlanService planService) {
        this.planService = planService;
    }

    @GetMapping
    public List<SubscriptionPlan> getAllPlans() {
        return planService.getAllPlans();
    }
}
