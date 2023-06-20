package me.julianrivers.login.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/**").permitAll() // Permitir acceso a todas las rutas GET sin autenticación
                .antMatchers(HttpMethod.POST, "/usuario").permitAll() // Permitir acceso sin autenticación para el método POST en la ruta /usuario
                .anyRequest().authenticated() // Requiere autenticación para todas las demás solicitudes
                .and().httpBasic();
    }
}
