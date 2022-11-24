package org.springframework.samples.petclinic.web;
import org.springframework.samples.petclinic.model.Memo;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MemoValidator implements Validator {
    private static final String REQUIRED = "required";

    @Override
    public void validate(Object obj, Errors errors) {
        Memo memo = (Memo) obj;
        String description = memo.getDescription();
        // description validation
        if (!StringUtils.hasLength(description)) {
            errors.rejectValue("description", REQUIRED, REQUIRED);
        }
    }
    /**
     * This Validator validates *just* Memo instances
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Memo.class.isAssignableFrom(clazz);
    }
}
