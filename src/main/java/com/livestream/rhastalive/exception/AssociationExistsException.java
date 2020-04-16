package com.livestream.rhastalive.exception;

import com.livestream.rhastalive.errors.ErrorMessage;

public class AssociationExistsException extends RhastaliveExceptionHandler {

    public AssociationExistsException() {
        super(ErrorMessage.ASSOCIATION_EXISTS);
    }
}
