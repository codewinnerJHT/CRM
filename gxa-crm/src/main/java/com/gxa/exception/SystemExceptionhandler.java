package com.gxa.exception;


import com.gxa.dto.ResultDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SystemExceptionhandler {

    @ExceptionHandler(Exception.class)
    ResultDto myExceptionHander(Exception e){
        return new ResultDto(5001,e.getMessage());
    }
}
