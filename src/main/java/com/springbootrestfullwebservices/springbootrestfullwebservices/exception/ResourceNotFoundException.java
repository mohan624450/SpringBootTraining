package com.springbootrestfullwebservices.springbootrestfullwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private UUID fieldValue;

    public ResourceNotFoundException(String resourceName,String fieldName, UUID fieldValue){
        super(String.format("%s Not Found With %s : '%s'",resourceName,fieldName,fieldValue));
        System.out.println("Inside ResouceNotFoundExcetion");
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
