package com.subscriptionbilling.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subscriptionbilling.entity.SubscriptionPlan;
import com.subscriptionbilling.service.SubscriptionPlanService;

@RestController
@RequestMapping("/api/admin/plans") // Admin-specific endpoint
public class AdminPlanController {
    private final SubscriptionPlanService planService;

    public AdminPlanController(SubscriptionPlanService planService) {
        this.planService = planService;
    }

    @PostMapping
    public ResponseEntity<String> addPlan(@RequestBody SubscriptionPlan plan) {
        planService.addPlan(plan);
        return ResponseEntity.ok("Plan added successfully!");
    }


    @GetMapping
    public List<SubscriptionPlan> getAllPlans() {
        return planService.getAllPlans();
    }
}
