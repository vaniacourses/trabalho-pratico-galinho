package com.galinho.backend.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()

                        .requestMatchers(HttpMethod.GET, "/clientes").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.DELETE, "/clientes").hasRole("CLIENTE")
                        .requestMatchers(HttpMethod.PUT, "/clientes").hasRole("CLIENTE")
                        .requestMatchers(HttpMethod.POST, "/clientes").permitAll()
                        
                        .requestMatchers(HttpMethod.GET, "/caixas").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.DELETE, "/caixas").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.POST, "/caixas").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.PUT, "/caixas").hasAnyRole("GERENTE","CAIXA")

                        .requestMatchers(HttpMethod.GET, "/gestores").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.DELETE, "/gestores").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.POST, "/gestores").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.PUT, "/gestores").hasAnyRole("GERENTE","GESTOR_DE_ESTOQUE")

                        .requestMatchers(HttpMethod.GET, "/mecanicos").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.DELETE, "/mecanicos").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.POST, "/mecanicos").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.PUT, "/mecanicos").hasAnyRole("GERENTE","MECANICO")
                        
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public RoleHierarchy roleHierarchy() {
        return RoleHierarchyImpl.withDefaultRolePrefix()
                .role("GERENTE").implies("CAIXA")
                .role("GERENTE").implies("GESTOR_ESTOQUE")
                .role("GERENTE").implies("MECANICO")
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
