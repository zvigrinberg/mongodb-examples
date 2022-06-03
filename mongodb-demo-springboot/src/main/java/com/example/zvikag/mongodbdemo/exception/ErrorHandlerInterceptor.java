package com.example.zvikag.mongodbdemo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorHandlerInterceptor {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ItemNotFoundException.class)
    public String respondWithNotFound(ItemNotFoundException e)
    {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundForDeleteException.class)
    public String respondWithNotFoundForDelete(NotFoundForDeleteException e)
    {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(NotFoundForUpdateException.class)
    public String respondWithNotFoundForUpdate(NotFoundForUpdateException e)
    {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String generalException(Exception e)
    {
        log.error(e.getMessage(),e.getStackTrace());
        return "A General error occurred, Please contact Admin!";
    }

}
