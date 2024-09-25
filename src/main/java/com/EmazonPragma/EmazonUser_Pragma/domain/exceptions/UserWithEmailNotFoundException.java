package com.EmazonPragma.EmazonUser_Pragma.domain.exceptions;

import com.EmazonPragma.EmazonUser_Pragma.domain.utils.DomainConstants;

public class UserWithEmailNotFoundException extends RuntimeException {
    public UserWithEmailNotFoundException(String email) {
        super(String.format(DomainConstants.USER_WITH_EMAIL_NOT_FOUND_MESSAGE, email));
    }
}
