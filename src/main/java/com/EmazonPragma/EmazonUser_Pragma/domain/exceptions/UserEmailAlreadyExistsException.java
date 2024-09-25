package com.EmazonPragma.EmazonUser_Pragma.domain.exceptions;

import com.EmazonPragma.EmazonUser_Pragma.domain.utils.DomainConstants;

public class UserEmailAlreadyExistsException extends RuntimeException {
    public UserEmailAlreadyExistsException(String email) {
        super(String.format(DomainConstants.USER_EMAIL_ALREADY_EXISTS_MESSAGE, email));
    }
}
