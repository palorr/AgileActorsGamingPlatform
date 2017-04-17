package com.agile.handlers;

import com.agile.validator.LoggednInUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {
            System.out.println("Can't redirect");
            return;
        }


        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    private String determineTargetUrl(Authentication authentication) {
        LoggednInUser loggednInUser = (LoggednInUser)authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<>();

        authorities.stream().forEach(role -> roles.add(role.getAuthority()));
        
        return selectRedirectUrl(roles, loggednInUser);
    }

    private String selectRedirectUrl(List<String> roles, LoggednInUser loggednInUser) {
        if(isAdmin(roles))
            return "/admin";
        else if(isUser(roles)) {
            return "/userByUsername/"+loggednInUser.getUser().getUsername();
        }
        else
            return "/home";
    }

    private boolean isUser(List<String> roles) {
        return (roles.contains("USER"));
    }

    private boolean isAdmin(List<String> roles) {
        return (roles.contains("ADMIN"));
    }
}
