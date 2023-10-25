package ru.ykhdr.springsandbox.restapiproject.exceptions;

public class PersonNotCreatedException extends RuntimeException {
    public PersonNotCreatedException(String msg) {
        super(msg);
    }
}
