package com.makersharks.supplierapi.dao;

import com.makersharks.supplierapi.dto.Supplier;
import com.makersharks.supplierapi.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SupplierDao {
    @Autowired
    private SupplierRepository repository;

    public void saveSuppliers(Supplier supplier){
         repository.save(supplier);
    }

    public List<Supplier> allSupplier(int perpage,int pageno){
        return  repository.findAllSupplier(perpage,pageno);
    }

    public List<Supplier> findByLocation(String location,int perpage,int pageno){
        return repository.supplierByLocation(location,perpage,pageno);
    }

    public List<Supplier> supplierByProcess(String process,int perpage,int pageno){
        return  repository.supplierByProcess(process,perpage,pageno);
    }

    public List<Supplier> supplierByNature(String nature,int perpage,int pageno){
        return  repository.supplierByNature(nature,perpage,pageno);
    }

    // Method for finding Supplier data  based on location , nature_of_business
    public List<Supplier> supplierByLocationAndNature(String location,String nature,int perpage,int pageno){
        return  repository.supplierByLocationAndNature(location,nature,perpage,pageno);
    }

    // Method for finding Supplier data  based on location
    // and manufacturing_process
    public List<Supplier> supplierByLocationAndProcess(String location,String process,int perpage,int pageno){
        return  repository.supplierByLocationAndProcess(location,process,perpage,pageno);
    }

    // Method for finding Supplier data  based on  nature_of_business
    // and manufacturing_process
    public List<Supplier> supplierByProcessAndNature(String nature,String process,int perpage,int pageno){
        return repository.supplierByProcessAndNature(nature,process,perpage,pageno);
    }

    // Method for finding Supplier data  based on location , nature_of_business
    // and manufacturing_process
    public List<Supplier> findSupplierByLocationProcessNature(String location,String nature,String process,int perpage,int pageno){
        return  repository.findSupplierByLocationProcessNature(location,nature,process,perpage,pageno);
    }

}
