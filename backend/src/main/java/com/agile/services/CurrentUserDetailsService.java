// handles the authentication
package com.agile.services;

import com.agile.model.User;
import com.agile.validator.LoggednInUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(s);
                //.orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", email)));
        LoggednInUser loggednInUser = new LoggednInUser(user);
        return loggednInUser;
    }
}
