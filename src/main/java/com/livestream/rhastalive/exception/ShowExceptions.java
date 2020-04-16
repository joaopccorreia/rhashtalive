package com.livestream.rhastalive.exception;


import com.livestream.rhastalive.errors.ErrorMessage;

public class ShowExceptions extends RhastaliveExceptionHandler{


    public ShowExceptions() {
        super(ErrorMessage.SHOW_NOT_FOUND);
    }
}

