package com.toto.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
// This will cause Spring boot to respond with the specified 
// HTTP status code whenever this exception is thrown from your controller
public class NotFoundException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public NotFoundException (String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName(){
        return resourceName;
    }

    public String getFieldName(){
        return fieldName;
    }

    public Object getFieldValue(){
        return fieldValue;
    }

}

// The APIs will throw a NotFoundException whenever a Todo with a given id is not found in the database