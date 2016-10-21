package com.github.jabbalaci.pyjava.examples;

/*
 Using a for loop, print the lower case letters of the English alphabet:

 a b c d e f g h i j k l m n o p q r s t u v w x y z

 As can be seen, there is a space between the letters.
 */

import com.github.jabbalaci.pyjava.Py;

public class Example03 {

    public static void main(String[] args) {
        Example03 m = new Example03();
        m.start();
    }

    private void start() {
        int start = Py.ord('a');
        int end = Py.ord('z');

        for (int i = start; i <= end; ++i) {
            Py.print(Py.chr(i), " ");    // " " means: end=" "
        }
        Py.print();
    }

}
