package com.co.indra.coinmarketcap.users.exceptions;


import com.co.indra.coinmarketcap.users.model.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public ErrorResponse handleBusinessException(BusinessException exception) {
        return new ErrorResponse(exception.getCode(), exception.getMessage());
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleNotFoundException(MethodArgumentNotValidException exception) {
        return new ErrorResponse("NOT_FOUND", exception.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception exception) {
        return new ErrorResponse("500", exception.getMessage());
    }
}
