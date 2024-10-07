package com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.service;

import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.request.AuthenticationRequest;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.request.AuthorizationRequest;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.request.UserRequest;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.response.AuthenticationResponse;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.response.AuthorizationResponse;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.response.RegisterResponse;

public interface UserService {
    RegisterResponse createWarehouseAssistant(UserRequest userRequest);
    AuthenticationResponse login(AuthenticationRequest authenticationRequest);
    AuthorizationResponse authorize(AuthorizationRequest authorizationResquest);
}
