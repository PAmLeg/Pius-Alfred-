package com.example.Supplier.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Supplier.Entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
  
}
