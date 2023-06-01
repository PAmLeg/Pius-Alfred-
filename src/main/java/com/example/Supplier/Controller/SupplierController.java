package com.example.Supplier.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Supplier.Entity.Supplier;
import com.example.Supplier.Service.SupplierService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/supplier")
public class SupplierController {
  private SupplierService supplierService;

  // creating the REST API for the postmapping(CREATE)
  @PostMapping
  public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier){
    Supplier savedSupplier = supplierService.createSupplier(supplier);
    return new ResponseEntity<>(savedSupplier, HttpStatus.CREATED);
  }

  // creating the REST API for the get the data by id
  @GetMapping("{id}")
  public ResponseEntity<Supplier> getSupplierById(@PathVariable("id") Long supplierId){
    Supplier supplier = supplierService.getSupplierById(supplierId);
    return new ResponseEntity<>(supplier, HttpStatus.OK);
  }

  // creating the REST API for the getting all the data
  @GetMapping("/all")
  public ResponseEntity<List<Supplier>> getAllSuppliers(){
    List<Supplier> suppliers = supplierService.getAllSuppliers();
    return new ResponseEntity<>(suppliers, HttpStatus.OK);
  }

  // creating the REST API for the updating the 
  @PutMapping("{id}")
  public ResponseEntity<Supplier> updateSupplier(@PathVariable("id") Long supplierId, @RequestBody Supplier supplier){
    supplier.setId(supplierId);
    Supplier updatSupplier = supplierService.updatSupplier(supplier);
    return new ResponseEntity<>(updatSupplier, HttpStatus.OK);
  }

  // creating the REST API for the deleting the data
  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteSupplier(@PathVariable("id") Long supplierId){
    supplierService.deleteSupplier(supplierId);
    return new ResponseEntity<>("Supplier is successfuly deleted", HttpStatus.OK);
  }
}
