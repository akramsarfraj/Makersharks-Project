package com.makersharks.supplierapi.exception;

import com.makersharks.supplierapi.dto.ValidationError;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class SupplierApiExceptionHandler {

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody String noResourceFoundException(NoResourceFoundException exception){
        System.out.println(exception.getStatusCode());
        return exception.getMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ValidationError mANVException(MethodArgumentNotValidException exception){
        List<String> defaultMessage = new ArrayList<String>();
        System.out.println(exception.getStatusCode());
        for (ObjectError error : exception.getBindingResult().getAllErrors()){
            defaultMessage.add(error.getDefaultMessage());
        }

        return  new ValidationError(exception.getStatusCode().value(),defaultMessage);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody String DataIntegrityViolationHandler(DataIntegrityViolationException exception){
        return "Cannot have duplicate company name or company website";
    }

    @ExceptionHandler(SupplierNotFoundException.class)
    public @ResponseBody ResponseEntity<String> supplierExceptionHandler(SupplierNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }


    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> missingRequestParamHandler(MissingServletRequestParameterException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity<String> invalidParamterHandler(InvalidParameterException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
}
