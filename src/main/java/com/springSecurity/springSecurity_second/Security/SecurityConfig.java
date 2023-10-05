package com.springSecurity.springSecurity_second.Security;

import com.springSecurity.springSecurity_second.config.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//WE REQUIRE THE CONFIGURATION FIRST
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
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
                        .authenticated())


                .sessionManagement(sess->sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();





    }
}
