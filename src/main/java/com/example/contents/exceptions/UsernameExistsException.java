package com.example.contents.exceptions;

// 사용자 이름이 중복일때 발생하는 예외
public class UsernameExistsException
        extends Status400Exception{
    public UsernameExistsException(){
        super("username exists");
    }
}
