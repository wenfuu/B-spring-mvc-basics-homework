package com.thoughtworks.capacity.gtb.mvc;

public class UserExistException extends RuntimeException {

    public UserExistException(String message) {
        super(message);
    }
}
