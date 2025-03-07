package com.empik.empik_backend.infrastructure.exception;

public class ClientException extends RuntimeException {
    public ClientException(String message) {
        super(message);
    }
}
