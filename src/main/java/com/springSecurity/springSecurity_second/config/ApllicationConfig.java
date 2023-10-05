package com.springSecurity.springSecurity_second.config;

import com.springSecurity.springSecurity_second.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApllicationConfig {

    private final UserRepository userRepository;

    @Bean
    public UserDetailsService  userDetailsService(){
       return username -> userRepository.findByEmail(username)
               .orElseThrow(()-> new UsernameNotFoundException("user not found"));
    }

//    Responsible fo fetching user data and encode passwords
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider= new DaoAuthenticationProvider();
// this method uses the userDetailsService method above there
        authProvider.setUserDetailsService(userDetailsService());
      authProvider.setPasswordEncoder(passwordEncoder());
      return authProvider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws  Exception{
        return   config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return  new BCryptPasswordEncoder();
    }
}
