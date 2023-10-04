package com.springSecurity.springSecurity_second.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

//WE REQUIRE THE CONFIGURATION FIRST
@Configuration
@EnableWebSecurity
public class SecurityConfig {
//    initiate the filter chain
    @Bean
    public SecurityFilterChain  securityFilterChain (HttpSecurity http) throws Exception{

//        1.DISABLE CSRF FAST
        http.csrf(AbstractHttpConfigurer::disable)
//WHITE LIST APIS THAT ARE NOT TO BE SECURED
                .authorizeHttpRequests(auth->auth.requestMatchers("/fastApi/v1/**")

                        // PERMIT ANY URL THAT COMES WITH THE URL ABOVE
                        .permitAll()

//              ANY OTHER REQUEST IS NOT PERMITTED
                        .anyRequest()
                        .authenticated());
        return http.build();





    }
}
