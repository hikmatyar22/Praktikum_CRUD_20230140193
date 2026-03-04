package com.deploy.praktikum1.util;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Component;

@Component
public class ValidationUtil {

    private Validator validator;

    public ValidationUtil() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    public void validate(Object object) {
        var violations = validator.validate(object);
        if (!violations.isEmpty()) {
            throw new RuntimeException("Validation error");
        }
    }
}
