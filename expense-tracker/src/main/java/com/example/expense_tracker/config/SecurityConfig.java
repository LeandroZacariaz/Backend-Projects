package com.example.expense_tracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.expense_tracker.jwt.JwtAuthenticationFilter;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
   private final AuthenticationProvider authenticationProvider;
   private final JwtAuthenticationFilter jwtAuthenticationFilter;

   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      return http
         .csrf(csrf -> csrf.disable())
         .authorizeHttpRequests(authRequest -> authRequest
               .requestMatchers(
                  "/auth/**",
                  "/swagger-ui/**",  // Permitir acceso a Swagger UI
                  "/v3/api-docs/**"   // Permitir acceso a la documentación OpenAPI
               ).permitAll()
               .anyRequest().authenticated()
         )
         .sessionManagement(sessionManager -> sessionManager
               .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
         )
         .authenticationProvider(authenticationProvider)
         .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
         .build();
   }
}
