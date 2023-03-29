package com.company.gamestore.Repositories;

import com.company.gamestore.Models.Console;
import com.company.gamestore.Models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
