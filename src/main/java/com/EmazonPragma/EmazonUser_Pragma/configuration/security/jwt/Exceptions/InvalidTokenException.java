package com.EmazonPragma.EmazonUser_Pragma.configuration.security.jwt.Exceptions;

import com.EmazonPragma.EmazonUser_Pragma.domain.utils.DomainConstants;
import org.springframework.security.core.AuthenticationException;

public class InvalidTokenException extends AuthenticationException {
    public InvalidTokenException() {
        super(DomainConstants.INVALID_TOKEN_MESSAGE);
    }
}
