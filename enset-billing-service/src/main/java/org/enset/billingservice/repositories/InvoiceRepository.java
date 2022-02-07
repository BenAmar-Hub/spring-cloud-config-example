package org.enset.billingservice.repositories;

import java.util.List;

import org.enset.billingservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, String>{

	List<Invoice> findByCustomerId(String customerId);
}
