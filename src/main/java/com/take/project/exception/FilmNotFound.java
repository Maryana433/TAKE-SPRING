package com.take.project.exception;

public class FilmNotFound extends RuntimeException {

    public FilmNotFound(String message){
        super(message);
    }
}
