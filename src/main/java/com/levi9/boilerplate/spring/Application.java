package com.levi9.boilerplate.spring;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import com.levi9.boilerplate.spring.security.CustomAuthenticationEntryPoint;

/**
 * @author Andrey Korchan
 * @since 01-Nov-15 16:35
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
        return new SecurityConfiguration();
    }

    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    public static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Autowired
        private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

        @Override
        protected void configure(AuthenticationManagerBuilder builder) throws Exception {
            builder.inMemoryAuthentication().withUser("user").password("user").roles("USER");
            builder.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
            builder.inMemoryAuthentication().withUser("dba").password("dba").roles("ADMIN", "DBA");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()

                    //front-end
                    .antMatchers("/public/partials/admin/**").access("hasRole('ADMIN')")

                    //back-end
                    .antMatchers("/api/**").permitAll()
                    .antMatchers("/admin/api/**").access("hasRole('ADMIN')")
//                    .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")



                    .and().formLogin().loginPage("/login").successHandler(new SimpleUrlAuthenticationSuccessHandler())

                    .and().csrf()
                    .and().csrf().csrfTokenRepository(csrfTokenRepository())
                    .and().addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
            http.exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint);

        }

        private CsrfTokenRepository csrfTokenRepository() {
            HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
            repository.setHeaderName("X-XSRF-TOKEN");
            return repository;
        }

        private class CsrfHeaderFilter extends OncePerRequestFilter {
            @Override
            protected void doFilterInternal(HttpServletRequest request,
                                            HttpServletResponse response, FilterChain filterChain)
                    throws ServletException, IOException {
                CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class
                        .getName());
                if (csrf != null) {
                    Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
                    String token = csrf.getToken();
                    if (cookie==null || token!=null && !token.equals(cookie.getValue())) {
                        cookie = new Cookie("XSRF-TOKEN", token);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                    }
                }
                filterChain.doFilter(request, response);
            }
        }
    }

}
