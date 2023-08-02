package com.example.Redis_cache.service;

import java.util.List;
import java.util.Optional;

import com.example.Redis_cache.model.Invoice;

public interface InvoiceService {
	public Invoice saveInvoice(Invoice inv);

	public Invoice updateInvoice(Invoice inv, Integer invId);

	public void deleteInvoice(Integer invId);

	public Optional<Invoice> getOneInvoice(Integer invId);

	public List<Invoice> getAllInvoices();
}
