package com.makersharks.supplierapi.exception;

public class SupplierNotFoundException  extends  RuntimeException{
    public SupplierNotFoundException(String message) {
        super(message);
    }
}
