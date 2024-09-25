package com.EmazonPragma.EmazonUser_Pragma.configuration.security;

import com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.entity.UserEntity;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.persistence.UserRepository;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.request.AuthenticationRequest;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.response.AuthenticationResponse;
import com.EmazonPragma.EmazonUser_Pragma.configuration.security.jwt.JwtService;
import com.EmazonPragma.EmazonUser_Pragma.domain.exceptions.UserWithEmailNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        UserEntity user = userRepository.findById(request.getEmail())
                            .orElseThrow(() -> new UserWithEmailNotFoundException(request.getEmail()));

        Map<String, String> claims = new HashMap<>();
        String token = jwtService.generateToke(claims, user);
        claims.put("role", user.getAuthorities().stream().toList().get(0).getAuthority());

        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }
}
