package com.gearupnepal.web;

import com.gearupnepal.web.entity.Authority;
import com.gearupnepal.web.entity.Login;
import com.gearupnepal.web.entity.User;
import com.gearupnepal.web.entity.repository.LoginRepository;
import com.gearupnepal.web.service.UserService;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    UserService userService;

    String authorityrole;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest arg0,
            HttpServletResponse arg1, Authentication authentication)
            throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        authorities.forEach(authority -> {
            System.out.println(authentication.getName() + " getting name");

            if (authority.getAuthority().equals("ROLE_USER")) {
                try {
                    for (User u : userService.getAll()) {
                        System.out.println(u.getUserName());
                        if (u.getEmail().equals(authentication.getName())) {
                            loginRepository.save(new Login(u.getUserName(), u.getEmail(),  u.getPassword(),
                                    "user",  new Date(), Boolean.TRUE));
                            
                            break;
                        }
                    }
                    authorityrole = "user";
                    redirectStrategy.sendRedirect(arg0, arg1, "/user/poinofsale");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else if (authority.getAuthority().equals("ROLE_ADMIN")) {
                try {
                    for (User u : userService.getAll()) {
                        System.out.println(u.getUserName());
                        if (u.getEmail().equals(authentication.getName())) {
                            loginRepository.save(new Login(u.getUserName(), u.getEmail(),  u.getPassword(),
                                    "admin",  new Date(), Boolean.TRUE));
                            
                            break;
                        }
                    }
                    authorityrole = "admin";
                    redirectStrategy.sendRedirect(arg0, arg1, "/admin/dash");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                throw new IllegalStateException();
            }
        });

    }

    public String getAuthority() {
        return authorityrole;
    }

}
