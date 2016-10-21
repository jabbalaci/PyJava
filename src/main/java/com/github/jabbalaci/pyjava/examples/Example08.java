package com.github.jabbalaci.pyjava.examples;

/*
 Sentence without extra spaces.

	test('I  love   Python') == "I love Python"

 */

import com.github.jabbalaci.pyjava.Py;
import com.github.jabbalaci.pyjava.PyStr;

public class Example08 {

    public static void main(String[] args) {
        Example08 m = new Example08();
        m.start();
    }

	private void start() {
        String s = "I  love   Python";
        Py.print("'" + s + "'");
        String t = PyStr.join(" ", PyStr.split(s));
        Py.print("'" + t + "'");
    }

}
