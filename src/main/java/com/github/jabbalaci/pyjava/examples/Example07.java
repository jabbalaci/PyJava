package com.github.jabbalaci.pyjava.examples;

/*
 ASCII table

 Print the ASCII table in the following form (sample):

	...
	55: 7
	56: 8
	57: 9
	58: :
	59: ;
	60: <
	61: =
	62: >
	63: ?
	64: @
	65: A
	66: B
	67: C
	68: D
	...

 It's enough to print from the 32-127 interval, since the characters 
 from 0 to 31 are special, non-printable characters.

 Tip: use the chr built-in function. Example: chr(97) → 'a'. 
 
 Extra Question
 --------------

 What is the sum of the ASCII values of the upper case letters in the English alphabet? 
 */

import com.github.jabbalaci.pyjava.Py;

public class Example07 {

    public static void main(String[] args) {
        Example07 m = new Example07();
//        m.start();
        m.extra();
    }
    
    private void extra() {
    	int total = 0;
		for (int i = Py.ord("A"); i <= Py.ord("Z"); ++i) {
//			Py.print(Py.chr(i));
			total += i;
		}
		Py.print(total);
	}

	@SuppressWarnings("unused")
	private void start() {
        for (int i = 32; i < 128; ++i) {
        	Py.printf("%d: %s\n", i, Py.chr(i));
        }
    }

}
