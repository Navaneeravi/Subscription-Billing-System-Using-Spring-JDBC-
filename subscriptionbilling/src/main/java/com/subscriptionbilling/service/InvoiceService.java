package com.subscriptionbilling.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.subscriptionbilling.entity.Invoice;
import com.subscriptionbilling.repository.InvoiceRepository;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public int generateInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getInvoicesByUserId(int userId) {
        return invoiceRepository.findByUserId(userId);
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }
}

