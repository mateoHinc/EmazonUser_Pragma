package com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.controller;

import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.request.AuthenticationRequest;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.request.AuthorizationRequest;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.request.UserRequest;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.response.AuthenticationResponse;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.response.AuthorizationResponse;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.response.RegisterResponse;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @Operation(summary = "Register a new warehouse assistant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Assistant has been registered"),
            @ApiResponse(responseCode = "409", description = "User with that email already exists"),
            @ApiResponse(responseCode = "409", description = "User with that identity document already exists"),
            @ApiResponse(responseCode = "409", description = "User is under aged"),
            @ApiResponse(responseCode = "400", description = "Some of the field doesn't pass validations"),
    })
    @PostMapping("/register/warehouse-assistant")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<RegisterResponse> saveWarehouseAssistant(@RequestBody @Valid UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createWarehouseAssistant(userRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest authorizationRequest) {
        return ResponseEntity.accepted().body(userService.login(authorizationRequest));
    }

    @PostMapping("/authorize")
    public ResponseEntity<AuthorizationResponse> authorize(@RequestBody @Valid AuthorizationRequest authorizationRequest) {
        return ResponseEntity.accepted().body(userService.authorize(authorizationRequest));
    }

}
