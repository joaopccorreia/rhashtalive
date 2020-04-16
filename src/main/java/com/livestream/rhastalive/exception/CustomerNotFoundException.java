package com.livestream.rhastalive.exception;

import com.livestream.rhastalive.errors.ErrorMessage;

public class CustomerNotFoundException extends RhastaliveExceptionHandler {

    public CustomerNotFoundException() {
        super(ErrorMessage.CUSTOMER_NOT_FOUND);
    }
}
