package com.jobbox.Project_Jobbox.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig {

  
   

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
    	int strength=10;
        return new BCryptPasswordEncoder(strength);
    }
}

  


