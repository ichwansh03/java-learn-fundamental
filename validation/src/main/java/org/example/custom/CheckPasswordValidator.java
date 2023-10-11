package org.example.custom;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.Register;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {
    @Override
    public boolean isValid(Register register, ConstraintValidatorContext constraintValidatorContext) {
        if (register.getPassword() == null || register.getConfirmPassword() == null) {
            return true;
        }

        return register.getPassword().equals(register.getConfirmPassword());
    }
}
