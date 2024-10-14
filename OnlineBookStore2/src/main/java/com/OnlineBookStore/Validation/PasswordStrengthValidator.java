package com.OnlineBookStore.Validation;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.OnlineBookStore.Annotations.PasswordValidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class PasswordStrengthValidator implements ConstraintValidator<PasswordValidator, String>{

	List<String> weakPasswords;
	
	@Override
    public void initialize(PasswordValidator passwordValidator) {
        weakPasswords = Arrays.asList("12345", "password", "qwerty");
    }

	@Override
	public boolean isValid(String passwordField, ConstraintValidatorContext context) {
		return passwordField != null && (!weakPasswords.contains(passwordField));
	}

}
