package com.enokdev.tacknoteapi.execeptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
@Getter
public class ObjectValidationException extends RuntimeException {


    private final Set<String> violations;


    private final String violationSource;

}