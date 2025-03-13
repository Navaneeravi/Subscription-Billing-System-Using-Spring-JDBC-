package com.subscriptionbilling.repository;


import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.subscriptionbilling.entity.SubscriptionPlan;

@Repository
public class SubscriptionPlanRepository {
    private final JdbcTemplate jdbcTemplate;

    public SubscriptionPlanRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(SubscriptionPlan plan) {
        String sql = "INSERT INTO subscription_plans (name, price, description) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, plan.getName(), plan.getPrice(), plan.getDescription());
    }

    public List<SubscriptionPlan> findAll() {
        String sql = "SELECT * FROM subscription_plans";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            SubscriptionPlan plan = new SubscriptionPlan();
            plan.setId(rs.getInt("id"));
            plan.setName(rs.getString("name"));
            plan.setPrice(rs.getDouble("price"));
            plan.setDescription(rs.getString("description"));
            return plan;
        });
    }
}

