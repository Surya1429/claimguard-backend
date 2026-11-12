package com.claimguard.claimguard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/api/healthController/health").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());
                return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails analyst = User.withUsername("analyst")
                .password("{noop}analyst123")
                .roles("CLAIMS_ANALYST")
                .build();

        UserDetails reviewer = User.withUsername("reviewer")
                .password("{noop}reviewer123")
                .roles("CLINICAL_REVIEWER")
                .build();

        UserDetails supervisor = User.withUsername("supervisor")
                .password("{noop}supervisor123")
                .roles("SUPERVISOR")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password("{noop}admin123")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(analyst, reviewer, supervisor, admin);
    }

}
