package com.example.Redis_cache.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.Redis_cache.exceptions.InvoiceNotFoundException;
import com.example.Redis_cache.irepository.InvoiceRepository;
import com.example.Redis_cache.model.Invoice;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepo;

	@Override
	public Invoice saveInvoice(Invoice inv) {

		return invoiceRepo.save(inv);
	}

	@Override
	@CachePut(value = "Invoice", key = "#invId")
	public Invoice updateInvoice(Invoice inv, Integer invId) {
		Invoice invoice = invoiceRepo.findById(invId)
				.orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
		invoice.setInvAmount(inv.getInvAmount());
		invoice.setInvName(inv.getInvName());
		return invoiceRepo.save(invoice);
	}

	@Override
	@CacheEvict(value = "Invoice", key = "#invId")
	// @CacheEvict(value="Invoice", allEntries=true) //in case there are multiple
	// records to delete
	public void deleteInvoice(Integer invId) {
		Invoice invoice = invoiceRepo.findById(invId)
				.orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
		invoiceRepo.delete(invoice);
	}

	@Override
	@Cacheable(value = "Invoice", key = "#invId")
	public Optional<Invoice> getOneInvoice(Integer invId) {
		Optional<Invoice> invoice = invoiceRepo.findById(invId);
//				.orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
		return invoice;
	}

	@Override
	@Cacheable(value = "Invoice")
	public List<Invoice> getAllInvoices() {
		return invoiceRepo.findAll();
	}
}
