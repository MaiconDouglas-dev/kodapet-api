package br.com.clyvo.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@Profile("dev")
public class DevUserDetailsConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(); // sem usuários
    }
}