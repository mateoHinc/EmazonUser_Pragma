package com.EmazonPragma.EmazonUser_Pragma.domain.exceptions;

import com.EmazonPragma.EmazonUser_Pragma.domain.utils.DomainConstants;

public class UnderAgeException extends RuntimeException{
    public UnderAgeException() {
        super(DomainConstants.UNDER_AGE_MESSAGE);
    }
}
