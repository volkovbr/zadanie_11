package ru.netology.Exception;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String msg){
        super(msg);
    }
}
