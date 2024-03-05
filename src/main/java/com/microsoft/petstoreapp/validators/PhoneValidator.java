package com.microsoft.petstoreapp.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator
    implements ConstraintValidator<Phone, String>{
        
    @Override
    //Here arg0 will get the input value of the phone
    //Which we have to validate
    public boolean isValid(String arg0, ConstraintValidatorContext arg1){
        //[0-9] indicate any digit
        //+ indicates more than 1 digit
        boolean condtition = arg0.length() == 10 && arg0.matches("[0-9]+");
        return condtition;

    }
    
    
}

