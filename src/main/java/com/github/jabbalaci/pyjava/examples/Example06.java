package com.github.jabbalaci.pyjava.examples;

/*
 Palindrome

 Write a function that decides about a string if it's a palindrome. 
 A string is said to be palindrome if it reads the same backwards as 
 forwards, e.g. madam. 
 */

import com.github.jabbalaci.pyjava.Py;
import com.github.jabbalaci.pyjava.PyStr;

public class Example06 {

    public static void main(String[] args) {
        Example06 m = new Example06();
        m.start();
    }
    
    private boolean is_palindrome(String s) {
		return s.equals(PyStr.reverse(s));
	}

    private void start() {
        String s = "madam";
        Py.printf("%s is palindrome: %b", s, is_palindrome(s));
    }

}
