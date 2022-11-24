package org.springframework.samples.petclinic.web;

import org.springframework.util.StringUtils;
import org.springframework.samples.petclinic.model.Operation;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class OperationValidator implements Validator {

    private static final String REQUIRED = "required";

    @Override
    public void validate(Object target, Errors errors) {
        Operation operation = (Operation) target;
        String description = operation.getDescription();

        if (!StringUtils.hasLength(description)) {
            errors.rejectValue("description", REQUIRED, REQUIRED);
        }
    }

    /**
     * This Validator validates *just* Operation instances
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Operation.class.isAssignableFrom(clazz);
    }
}
