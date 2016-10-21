package com.github.jabbalaci.pyjava.examples;

/*
 Write a function that receives a whole number (integer) and returns its reverse as a whole number.

 Examples: 1977 → 7791; 12568 → 86521.
 */

import com.github.jabbalaci.pyjava.Py;

public class Example01 {

    public static void main(String[] args) {
        Example01 m = new Example01();
        m.start();
    }

    private int reverse(int n) {
        return Py.to_int(Py.str.reverse(Py.to_str(n)));
    }

    private void start() {
        int n = 1977;
        int reversed = reverse(n);
        Py.print(n);
        Py.print(reversed);
    }

}
