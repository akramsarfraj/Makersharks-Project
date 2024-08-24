package com.makersharks.supplierapi.service;

import com.makersharks.supplierapi.dao.SupplierDao;
import com.makersharks.supplierapi.dto.BodyResponse;
import com.makersharks.supplierapi.dto.Supplier;
import com.makersharks.supplierapi.exception.SupplierNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private SupplierDao dao;

    public String saveSupplierDetail(Supplier supplier){
        dao.saveSuppliers(supplier);
        return  "Supplier data uploaded";
    }

    public ResponseEntity<BodyResponse<List<Supplier>>> allSupplier(int pageno, int perpage){

        if(pageno!=1){
            pageno = (pageno-1)*perpage+1;
        }

        BodyResponse<List<Supplier>> response = new BodyResponse();
        List<Supplier> suppliers = dao.allSupplier(perpage,pageno-1);

        if(!suppliers.isEmpty()){
            response.setData(suppliers);
            response.setStatus(HttpStatus.OK.value());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            throw  new SupplierNotFoundException("No Supplier found");
        }

    }

    public ResponseEntity<BodyResponse> supplierByLocation(String location,int pageno ,int perpage){

        if(pageno!=1){
              pageno = (pageno-1)*perpage+1;
        }

         List<Supplier> suppliers = dao.findByLocation(location.toLowerCase(),perpage,pageno-1);
         BodyResponse<List<Supplier>> response = new BodyResponse();


         if(!suppliers.isEmpty()){
             response.setData(suppliers);
             response.setStatus(HttpStatus.OK.value());
             return ResponseEntity.status(HttpStatus.OK).body(response);
         }else{
             throw  new SupplierNotFoundException("No Supplier in this Location");
         }
    }

    // find supplier by location nature of business and manufacturing process
    public ResponseEntity<BodyResponse<List<Supplier>>> findSupplierByLocationProcessNature(String location, String nature, String process, int perpage, int pageno){
        if(pageno!=1){
            pageno = (pageno-1)*perpage+1;
        }
        BodyResponse<List<Supplier>> response = new BodyResponse();
        System.out.println(location+" "+nature+" "+process);

        List<Supplier> suppliers
                = dao.findSupplierByLocationProcessNature(location.toLowerCase(),nature.toLowerCase(),process.toLowerCase(),perpage,pageno-1);

        if(!suppliers.isEmpty()){
            response.setData(suppliers);
            response.setStatus(HttpStatus.OK.value());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            throw  new SupplierNotFoundException("No Supplier in this Location");
        }


    }

}
