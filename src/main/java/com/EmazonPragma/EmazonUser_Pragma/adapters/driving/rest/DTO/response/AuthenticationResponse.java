package com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.response;

import lombok.*;

@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;
}
