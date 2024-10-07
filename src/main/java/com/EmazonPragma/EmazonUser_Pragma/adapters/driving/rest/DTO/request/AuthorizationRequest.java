package com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.request;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationRequest {
    private String token;
}
