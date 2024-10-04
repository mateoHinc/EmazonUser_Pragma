package com.EmazonPragma.EmazonUser_Pragma.domain.exceptions;

import com.EmazonPragma.EmazonUser_Pragma.domain.utils.DomainConstants;

public class EmptyFieldException extends RuntimeException{
    public EmptyFieldException(String field) {
        super(String.format(DomainConstants.EMPTY_EMAIL_MESSAGE, field));
    }
}
