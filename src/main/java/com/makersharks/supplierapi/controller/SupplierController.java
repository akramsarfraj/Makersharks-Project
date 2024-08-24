package com.makersharks.supplierapi.controller;


import com.makersharks.supplierapi.dto.BodyResponse;
import com.makersharks.supplierapi.dto.Supplier;
import com.makersharks.supplierapi.exception.InvalidParameterException;
import com.makersharks.supplierapi.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplierController
{
    @Autowired
    private SupplierService service;

    // saving Supplier data
    @PostMapping(value = "/api/supplier/query")
    public String saveSupplier(@Valid @RequestBody Supplier supplier){
        return  service.saveSupplierDetail(supplier);
    }

    //Fetch all Supplier Data
    @GetMapping(value = "/api/supplier/query/all")
    public ResponseEntity<BodyResponse<List<Supplier>>> listSupplier(@RequestParam(name = "page",defaultValue = "1") int pageno ,
                                                                     @RequestParam(name = "per_page",defaultValue = "10") int perpage){

        return service.allSupplier(pageno,perpage);
    }

    //Fetch Data base on location
    @GetMapping (value ="/api/supplier/query/{location}")

    public ResponseEntity<BodyResponse> listSupplier_location(@PathVariable(name = "location") String location,
                                                              @RequestParam(name = "page",defaultValue = "1") int pageno ,
                                                              @RequestParam(name = "per_page",defaultValue = "10") int perpage){
        System.out.println(perpage);
       return service.supplierByLocation(location,pageno,perpage);
    }


    //Fetch Data base on location , nature of business and manufacturing_process
    @GetMapping(value ="/api/supplier/query")
    public ResponseEntity<BodyResponse<List<Supplier>>> listSupplier_location_nature_process(@RequestParam(name = "location") String location,
                                                                                             @RequestParam(value = "nature" ) String nature,
                                                                                             @RequestParam(value = "process") String process,
                                                                                             @RequestParam(name = "page",defaultValue = "1") int pageno ,
                                                                                             @RequestParam(name = "per_page",defaultValue = "10") int perpage)
    {
        if(location==""){
            throw  new InvalidParameterException("Invalid location");
        } else if (nature == "") {
            throw  new InvalidParameterException("Invalid nature");
        } else if (process == "") {
            throw  new InvalidParameterException("Invalid process");
        }else {
           return service.findSupplierByLocationProcessNature(location,nature,process,perpage,pageno);
        }

    }



}
