package com.agile.handlers;

import com.agile.model.RolesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import static com.agile.handlers.UriPaths.*;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class SecurityConfigHandler extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    LoginSuccessHandler loginSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HOME_ONE_URI, HOME_TWO_URI).permitAll()
                .antMatchers(ADMIN_URI).hasAuthority(RolesEnum.ADMIN.getValue())
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin()
                .loginPage(LOGIN_URI)
                .successHandler(loginSuccessHandler)
                //.failureUrl("/login?error")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll();
                //.and()
                //.exceptionHandling().accessDeniedPage("/403");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService);
                //.passwordEncoder(new BCryptPasswordEncoder());
    }
}
