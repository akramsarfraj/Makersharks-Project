package com.makersharks.supplierapi.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int supplier_id;

    @NotEmpty(message = "company name is mandatory")
    @Column(unique = true)
    private String company_name;

    @NotEmpty(message = "website is mandatory")
    @Column(unique = true)
    private String website;
    @NotEmpty(message = "location is mandatory")
    private String location;
    @NotEmpty(message = "business nature is mandatory")
    private String nature_of_business;
    @NotEmpty(message = "manufacturing process is mandatory")
    private String manufacturing_process;

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name.toLowerCase();
    }

    public void setWebsite(String website) {
        this.website = website.toLowerCase();
    }

    public void setLocation(String location) {
        this.location = location.toLowerCase();
    }

    public void setNature_of_business(String nature_of_business) {
        this.nature_of_business = nature_of_business.toLowerCase();
    }

    public void setManufacturing_process(String manufacturing_process) {
        this.manufacturing_process = manufacturing_process.toLowerCase();
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getWebsite() {
        return website;
    }

    public String getLocation() {
        return location;
    }

    public String getNature_of_business() {
        return nature_of_business;
    }

    public String getManufacturing_process() {
        return manufacturing_process;
    }
}
