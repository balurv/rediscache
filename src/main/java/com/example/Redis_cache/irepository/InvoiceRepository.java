package com.example.Redis_cache.irepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Redis_cache.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{

}
