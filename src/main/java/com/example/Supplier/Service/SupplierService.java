package com.example.Supplier.Service;

import java.util.List;

import com.example.Supplier.Entity.Supplier;

public interface SupplierService {
 Supplier createSupplier(Supplier supplier);
 
 Supplier getSupplierById(Long supplierId);

 List<Supplier> getAllSuppliers();

 Supplier updatSupplier(Supplier supplier);

 Void deleteSupplier(Long supplierId);
}
