package com.lkjc.consumablesmanager.security;

import com.lkjc.consumablesmanager.service.LKUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        /*http.csrf().and().authorizeRequests().antMatchers("/**").permitAll();*/
        http.csrf().disable()

                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .antMatchers("/**/**.css","/**/*.js").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/index").permitAll()
                //.antMatchers("/**").access("hasRole('ADMIN')")
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/login")
                .successForwardUrl("/index")
                .failureUrl("/login?error=true")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/index")
        ;
    }

    @Autowired
    private LKUserDetailsService lKUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(lKUserDetailsService);
    }


    @Bean(name = "lKUserDetailsService")
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }
}
