package com.gearupnepal.web;

import com.gearupnepal.web.entity.User;
import com.gearupnepal.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SimpleAuthenticationSuccessHandler successHandler;

    @Autowired
    UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("**/login")).and().authorizeRequests()
                .antMatchers("/", "/home", "/assests/**", "/user/assests/**", "/admin/assests/**").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/admin/api/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .and().formLogin()
                .usernameParameter("email")
                .passwordParameter("password")
                .successHandler(successHandler)
                .loginPage("/login")
                //                .and().logout().permitAll
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").and().exceptionHandling()
                .accessDeniedPage("/acces=denied");

        System.out.println("1111111111111111111111111111111111");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("logging check .......:)))");

        for (User user : userService.getAll()) {
            if (user.getEmail().equals("nirajan.shrestha@gmail.com")) {
                auth.inMemoryAuthentication().withUser(user.getEmail()).password("{noop}" + user.getPassword()).roles("ADMIN");

            } else if (user.getEmail().equals("sanjay.shrestha@gmail.com")) {
                auth.inMemoryAuthentication().withUser(user.getEmail()).password("{noop}" + user.getPassword()).roles("ADMIN");

            } else {
                auth.inMemoryAuthentication().withUser(user.getEmail()).password("{noop}" + user.getPassword()).roles("USER");

            }

        }

//        auth.inMemoryAuthentication().withUser("user@gmail.com").password("{noop}password").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("{noop}password").roles("ADMIN");
       auth.inMemoryAuthentication().withUser("nirajan.shrestha@gmail.com").password("{noop}gearup2018").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("sanjay.shrestha@gmail.com").password("{noop}gearup2018").roles("ADMIN");
      //  auth.inMemoryAuthentication().withUser("dasrajesh@gmail.com").password("{noop}user").roles("USER");

        System.out.println("222222222222222222222222222222222");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/*.css", "/assests/**", "/admin/assests/**");
        web.ignoring().antMatchers("/*.js");
    }
}
