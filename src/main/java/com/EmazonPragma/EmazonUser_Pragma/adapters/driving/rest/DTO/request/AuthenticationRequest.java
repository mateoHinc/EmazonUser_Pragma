package com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.DTO.request;

import com.EmazonPragma.EmazonUser_Pragma.domain.utils.DomainConstants;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {
    @NotNull
    @Pattern(regexp = DomainConstants.EMAIL_REGEX_RFC5322, message = DomainConstants.NOT_VALID_EMAIL_MESSAGE)
    private String email;

    @NotNull
    @Size(min = 8, max = 64, message = DomainConstants.OUT_OF_BOUNDS_PASSWORD_MESSAGE)
    private String password;
}
