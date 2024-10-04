package com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.mapper.request;

import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.request.UserRequest;
import com.EmazonPragma.EmazonUser_Pragma.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRequestMapper {
    User toUser(UserRequest userRequest);
    List<User> toUser(List<UserRequest> userRequests);
}
