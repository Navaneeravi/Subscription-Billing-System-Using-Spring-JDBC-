package com.subscriptionbilling.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subscriptionbilling.entity.Invoice;
import com.subscriptionbilling.service.InvoiceService;

@RestController
@RequestMapping("/api/user/invoices")
public class UserInvoiceController {
    private final InvoiceService invoiceService;

    public UserInvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateUserInvoice(@RequestBody Invoice invoice) {
        invoiceService.generateInvoice(invoice); // Use service logic
        return ResponseEntity.ok("Invoice generated successfully!");
    }
}
