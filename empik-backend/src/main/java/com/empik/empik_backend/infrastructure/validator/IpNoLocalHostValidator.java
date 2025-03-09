package com.empik.empik_backend.infrastructure.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IpNoLocalHostValidator implements ConstraintValidator<IpNoLocalhost, String>
{

    @Override
    public boolean isValid(String ip, ConstraintValidatorContext constraintValidatorContext) {

        return !"127.0.0.1".equals(ip);
    }
}