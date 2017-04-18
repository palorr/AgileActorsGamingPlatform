package com.agile.validator;

import com.agile.model.UserSaveData;
import com.agile.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserUpdateFormValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserSaveData.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserSaveData userData = (UserSaveData) target;
        validatePasswords(errors, userData);
    }

    private void validatePasswords(Errors errors, UserSaveData userData) {
        if (!userData.getPassword().equals(userData.getPasswordRepeated())) {
            errors.reject("password.no_match", "Passwords do not match");
        }
    }
}
