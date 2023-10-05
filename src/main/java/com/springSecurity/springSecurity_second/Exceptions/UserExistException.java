package com.springSecurity.springSecurity_second.Exceptions;

public class UserExistException  extends  RuntimeException{
    public UserExistException (String message){
        super(message);
    }
}
