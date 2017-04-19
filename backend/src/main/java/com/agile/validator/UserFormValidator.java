package com.agile.validator;

import com.agile.resources.UserSaveData;
import com.agile.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserFormValidator implements Validator {

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
        validateUsername(errors, userData);
        validateAttributes(errors, userData);
    }

    private void validatePasswords(Errors errors, UserSaveData userData) {
        if (!userData.getPassword().equals(userData.getPasswordRepeated())) {
            errors.reject("password.no_match", "Passwords do not match");
        }
    }

    private void validateUsername(Errors errors, UserSaveData userData) {
        if (userService.getUserByUsername(userData.getUsername()) != null) {
            errors.reject("username.exists", "Username exists or needs to be updated");
        }
    }

    private void validateAttributes(Errors errors, UserSaveData userData) {
        if ( !(isValid(userData.getName())      &&
                isValid(userData.getSurname())  &&
                isValid(userData.getPassword()) &&
                isValid(userData.getUsername()) &&
                isValid(userData.getRole())) )
            errors.reject("attributes.no_valid", "Some attributes are null or empty");
    }

    private boolean isValid(String attribute){
        return ((attribute != null) && (!attribute.isEmpty()));
    }
}
