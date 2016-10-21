package com.github.jabbalaci.pyjava;

/*
 * "You can throw unchecked exceptions without having to declare them 
 * if you really want to. Unchecked exceptions extend RuntimeException."
 * http://stackoverflow.com/a/4519576/232485
 */
@SuppressWarnings("serial")
public class ValueError extends RuntimeException {
    public ValueError(String message) {
        super(message);
    }
}