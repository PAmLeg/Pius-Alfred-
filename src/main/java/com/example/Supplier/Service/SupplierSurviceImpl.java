package com.example.Supplier.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Supplier.Entity.Supplier;
import com.example.Supplier.Respository.SupplierRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SupplierSurviceImpl implements SupplierService {
  private SupplierRepository supplierRepository;
  @Override
  public Supplier createSupplier(Supplier supplier) {
    return supplierRepository.save(supplier);
  }

  @Override
  public Supplier getSupplierById(Long supplierId) {
    Optional<Supplier> optionalSupplier = supplierRepository.findById(supplierId);
    return optionalSupplier.get();
  }

  @Override
  public List<Supplier> getAllSuppliers() {
    return supplierRepository.findAll();
  }

  @Override
  public Supplier updatSupplier(Supplier supplier) {
    Supplier existSupplier = supplierRepository.findById(supplier.getId()).get();
    existSupplier.setFirstname(supplier.getFirstname());
    existSupplier.setLastname(supplier.getLastname());
    existSupplier.setEmail(supplier.getEmail());
    Supplier updatedSupplier = supplierRepository.save(existSupplier);
    return updatedSupplier;
  }

  @Override
  public Void deleteSupplier(Long supplierId) {
    supplierRepository.deleteById(supplierId);
    return null;
  }
  
}
