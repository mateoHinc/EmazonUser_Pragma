package com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationResponse {
    private boolean authorized;
    private String email;
    private String role;
}
