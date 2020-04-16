package com.livestream.rhastalive.exception;

public class AssociationExistsException extends Exception{

    public AssociationExistsException() {
        String associationExists = "Entity contains association with another entity";
    }
}
