package com.github.jabbalaci.pyjava.examples;

/*
 Double-base palindromes

 The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.

 Find the sum of all numbers, less than one million, which are palindromic 
 in base 10 and base 2.

 (Please note that the palindromic number, in either base, may not include leading zeros.)

 */

import com.github.jabbalaci.pyjava.Py;
import com.github.jabbalaci.pyjava.PyStr;

public class Example09 {

	private static final int UPTO = 1000000;
	
    public static void main(String[] args) {
        Example09 m = new Example09();
        m.start();
    }
    
    private boolean is_palindrome(String s) {
		return s.equals(PyStr.reverse(s));
	}
    
	private boolean palindrome_base_2(int n) {
		return is_palindrome(Py.bin(n, false));
	}

	private boolean palindrome_base_10(int n) {
		return is_palindrome(Py.to_str(n));
	}

	private void start() {
		int total = 0;
		
		for (int i = 0; i < UPTO; ++i) {
			if (palindrome_base_10(i) && palindrome_base_2(i)) {
				total += i;
//				Py.print(i);
			}
		}
		Py.print(total);
	}

}
