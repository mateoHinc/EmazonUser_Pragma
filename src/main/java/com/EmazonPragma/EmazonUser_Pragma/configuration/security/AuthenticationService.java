package com.EmazonPragma.EmazonUser_Pragma.configuration.security;

import com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.entity.UserEntity;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driven.jpa.persistence.UserRepository;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.request.AuthenticationRequest;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.request.AuthorizationRequest;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.response.AuthenticationResponse;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.response.AuthorizationResponse;
import com.EmazonPragma.EmazonUser_Pragma.configuration.security.jwt.Exceptions.InvalidTokenException;
import com.EmazonPragma.EmazonUser_Pragma.configuration.security.jwt.JwtService;
import com.EmazonPragma.EmazonUser_Pragma.domain.exceptions.UserWithEmailNotFoundException;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
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

        UserEntity user = userRepository.findByEmail(request.getEmail())
                            .orElseThrow(() -> new UserWithEmailNotFoundException(request.getEmail()));

        Map<String, String> claims = new HashMap<>();
        claims.put("role", user.getAuthorities().stream().toList().get(0).getAuthority());
        String token = jwtService.generateToke(claims, user);

        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    public AuthorizationResponse authorize(AuthorizationRequest authorizationRequest) {
        try {
            String email = jwtService.getClaim(authorizationRequest.getToken(), Claims::getSubject);
            String role = jwtService.getClaim(authorizationRequest.getToken(), claim -> claim.get("role")).toString();
            UserEntity user = userRepository
                    .findByEmail(email)
                    .orElseThrow(() -> new UserWithEmailNotFoundException(email));

            boolean authorized = jwtService.isTokenValid(authorizationRequest.getToken(), user);

            return AuthorizationResponse.builder()
                    .authorized(authorized)
                    .role(role).email(email)
                    .build();

        } catch (InvalidTokenException e) {
            return AuthorizationResponse.builder()
                    .authorized(false)
                    .role(null).email(null)
                    .build();

        }
    }
}
