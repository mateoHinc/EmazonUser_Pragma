package com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.service.impl;

import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.request.UserRequest;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.response.RegisterResponse;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.mapper.request.UserRequestMapper;
import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.service.UserService;
import com.EmazonPragma.EmazonUser_Pragma.domain.api.UserServicePort;
import com.EmazonPragma.EmazonUser_Pragma.domain.model.Role;
import com.EmazonPragma.EmazonUser_Pragma.domain.model.User;
import com.EmazonPragma.EmazonUser_Pragma.domain.utils.DomainConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserServicePort userServicePort;
    private final UserRequestMapper userRequestMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponse createWarehouseAssistant(UserRequest userRequest) {
        User user = userRequestMapper.toUser(userRequest);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setRole(new Role(userRequest.getRoleName()));
        userServicePort.createWarehouseAssistant(user);
        return RegisterResponse.builder().status(DomainConstants.WAREHOUSE_ASSISTANT_REGISTERED_MESSAGE).build();
    }
}
