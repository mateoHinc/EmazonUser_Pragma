package com.EmazonPragma.EmazonUser_Pragma.domain.exceptions;

import com.EmazonPragma.EmazonUser_Pragma.domain.utils.DomainConstants;

public class UserDocumentAlreadyExistsException extends RuntimeException {
    public UserDocumentAlreadyExistsException(String numberDocument) {
        super(String.format(DomainConstants.USER_DOCUMENT_ALREADY_EXISTS_MESSAGE, numberDocument));
    }
}
