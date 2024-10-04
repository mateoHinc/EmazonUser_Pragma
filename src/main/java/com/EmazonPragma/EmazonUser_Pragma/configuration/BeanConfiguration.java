package com.EmazonPragma.EmazonUser_Pragma.configuration;

import com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.adapter.UserJpaAdapter;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.mapper.UserEntityMapper;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.persistence.RoleRepository;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.persistence.UserRepository;
import com.EmazonPragma.EmazonUser_Pragma.domain.api.UserServicePort;
import com.EmazonPragma.EmazonUser_Pragma.domain.api.usecase.UserUseCase;
import com.EmazonPragma.EmazonUser_Pragma.domain.exceptions.UserWithEmailNotFoundException;
import com.EmazonPragma.EmazonUser_Pragma.domain.spi.UserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final RoleRepository roleRepository;

    @Bean
    UserPersistencePort userPersistencePort() {
        return new UserJpaAdapter(userRepository, userEntityMapper, roleRepository);
    }

    @Bean
    UserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort());
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    UserDetailsService userDetailsService() {
        return email -> userRepository.findByEmail(email)
                .orElseThrow(() -> new UserWithEmailNotFoundException(email));
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

}
