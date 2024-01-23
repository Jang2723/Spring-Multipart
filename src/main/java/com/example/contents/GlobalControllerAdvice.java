package com.example.contents;

import com.example.contents.dto.ErrorDto;
import com.example.contents.exceptions.Status400Exception;
import com.example.contents.exceptions.UsernameExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Controller는 아니기ㅗ
// 예외처리를 위한 ExceptionHandler를 모아놓기 위한
@RestControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDto> handleIllegalArgument(
            final IllegalArgumentException exception
    ){
        ErrorDto dto = new ErrorDto();
        dto.setMessage(exception.getMessage());
        return ResponseEntity
                .badRequest()
                .body(dto);
    }

   /* @ExceptionHandler(UsernameExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleUsernameExists(
            final UsernameExistsException exception
    ){
        ErrorDto dto = new ErrorDto();
        dto.setMessage(exception.getMessage());
        return dto;
    }*/

    @ExceptionHandler(Status400Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handle400(
            final Status400Exception exception
    ) {
        ErrorDto dto = new ErrorDto();
        dto.setMessage(exception.getMessage());
        return dto;
    }

    }
