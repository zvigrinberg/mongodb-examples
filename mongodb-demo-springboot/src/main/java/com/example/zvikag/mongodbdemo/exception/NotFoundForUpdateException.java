package com.example.zvikag.mongodbdemo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;


public class NotFoundForUpdateException extends Exception {
    public NotFoundForUpdateException(String message) {
        super(message);
    }
}
