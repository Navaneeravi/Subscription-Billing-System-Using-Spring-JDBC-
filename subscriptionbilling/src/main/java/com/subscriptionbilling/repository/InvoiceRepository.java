package com.subscriptionbilling.repository;


import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.subscriptionbilling.entity.Invoice;

@Repository
public class InvoiceRepository {
    private final JdbcTemplate jdbcTemplate;

    public InvoiceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(Invoice invoice) {
        String sql = "INSERT INTO invoices (user_id, plan_id, amount, created_at) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, invoice.getUserId(), invoice.getPlanId(), invoice.getAmount(), new Date());
    }

    public List<Invoice> findByUserId(int userId) {
        String sql = "SELECT * FROM invoices WHERE user_id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Invoice invoice = new Invoice();
            invoice.setId(rs.getInt("id"));
            invoice.setUserId(rs.getInt("user_id"));
            invoice.setPlanId(rs.getInt("plan_id"));
            invoice.setAmount(rs.getDouble("amount"));
            invoice.setCreatedAt(rs.getTimestamp("created_at"));
            return invoice;
        }, userId);
    }

    public List<Invoice> findAll() {
        String sql = "SELECT * FROM invoices";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Invoice invoice = new Invoice();
            invoice.setId(rs.getInt("id"));
            invoice.setUserId(rs.getInt("user_id"));
            invoice.setPlanId(rs.getInt("plan_id"));
            invoice.setAmount(rs.getDouble("amount"));
            invoice.setCreatedAt(rs.getTimestamp("created_at"));
            return invoice;
        });
    }
}

