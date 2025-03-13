package com.subscriptionbilling.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subscriptionbilling.entity.Invoice;
import com.subscriptionbilling.service.InvoiceService;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateInvoice(@RequestBody Invoice invoice) {
        invoiceService.generateInvoice(invoice);
        return ResponseEntity.ok("Invoice generated successfully!");
    }

    @GetMapping("/user/{userId}")
    public List<Invoice> getInvoicesByUserId(@PathVariable int userId) {
        return invoiceService.getInvoicesByUserId(userId);
    }

    @GetMapping("/all")
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }
}

