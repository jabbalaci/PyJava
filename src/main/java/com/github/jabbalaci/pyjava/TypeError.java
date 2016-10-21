package com.github.jabbalaci.pyjava;

@SuppressWarnings("serial")
public class TypeError extends RuntimeException {
    public TypeError(String message) {
        super(message);
    }
}