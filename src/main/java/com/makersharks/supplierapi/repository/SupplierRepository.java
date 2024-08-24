package com.makersharks.supplierapi.repository;

import com.makersharks.supplierapi.dto.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
    @Query(value = "select * from Supplier s limit ?1 offset ?2" ,nativeQuery = true)
    public  List<Supplier> findAllSupplier(int perpage,int pageno);

    @Query(value = "select * from Supplier s where s.location=?1 limit ?2 offset ?3 " ,nativeQuery = true)
    public List<Supplier> supplierByLocation(String location,int perpage,int pageno);


    @Query(value = "select * from Supplier s where s.manufacturing_process=?1 limit ?2 offset ?3 " ,nativeQuery = true)
    public List<Supplier> supplierByProcess(String process,int perpage,int pageno);

    // find by nature_of_business
    @Query(value = "select * from Supplier s where s.nature_of_business=?1 limit ?2 offset ?3 " ,nativeQuery = true)
    public List<Supplier> supplierByNature(String nature,int perpage,int pageno);


    // Query for finding Supplier data  based on location , nature_of_business
    @Query(value = "select * from Supplier s where s.location=?1 and s.nature_of_business=?2 limit ?3 offset ?4 ",nativeQuery = true)
    public List<Supplier> supplierByLocationAndNature(String location,String nature,int perpage,int pageno);

    // Query for finding Supplier data  based on location
    // and manufacturing_process
    @Query(value = "select * from Supplier s where s.location=?1 and s.manufacturing_process=?2 limit ?3 offset ?4 ",nativeQuery = true)
    public List<Supplier> supplierByLocationAndProcess(String location,String process,int perpage,int pageno);

    // Query for finding Supplier data  based  nature_of_business
    // and manufacturing_process
    @Query(value = "select * from Supplier s where s.nature_of_business=?1 and s.manufacturing_process=?2 limit ?3 offset ?4 ",nativeQuery = true)
    public List<Supplier> supplierByProcessAndNature(String nature,String process,int perpage,int pageno);


    // Query for finding Supplier data  based on location , nature_of_business
    // and manufacturing_process
    @Query(value = "select * from Supplier s where s.location=?1 and s.nature_of_business=?2 " +
            "and  s.manufacturing_process=?3 "+" limit ?4 offset ?5" , nativeQuery = true)
    public List<Supplier> findSupplierByLocationProcessNature(String location,String nature,String process,int perpage,int pageno);
}
