package com.enokdev.tacknoteapi.utils;

import com.enokdev.tacknoteapi.execeptions.ObjectValidationException;
import jakarta.validation.*;

import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DataValidator <T>{
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public void validate(T objectToValidate){
        Set<ConstraintViolation<T>> validations = validator.validate(objectToValidate);
        if (!validations.isEmpty()){
            Set<String> errorMessages = validations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());

            throw new ObjectValidationException(errorMessages, objectToValidate.getClass().getName());
        }

    }
}

