package me.julianrivers.login.config;

import me.julianrivers.login.service.interfaces.UsuarioServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UsuarioServiceInterface usuarioService;
    private final BCryptPasswordEncoder passwordEncoder;

    public SecurityConfig(UsuarioServiceInterface usuarioService, BCryptPasswordEncoder passwordEncoder){
        this.usuarioService=usuarioService;
        this.passwordEncoder=passwordEncoder;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/**").permitAll() // Permitir acceso a todas las rutas GET sin autenticación
                .antMatchers(HttpMethod.POST, "/usuario").permitAll() // Permitir acceso sin autenticación para el método POST en la ruta /usuario
                .anyRequest().authenticated() // Requiere autenticación para todas las demás solicitudes
                .and().httpBasic();

        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder);
    }
}
