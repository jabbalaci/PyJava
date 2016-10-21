package com.github.jabbalaci.pyjava.examples;

/*
 sum of natural numbers from 1 to 100

 It's not an efficient implementation since it builds
 a list of 100 elements. It simply demonstrates the range2 function,
 which is the equivalent version of Python 2's range.
 */

import com.github.jabbalaci.pyjava.Py;

public class Example02 {

    public static void main(String[] args) {
        Example02 m = new Example02();
        m.start();
    }

    private void start() {
        // sum(list, type_of_elems_in_the_list)
        // sum(list, 0)    -> the list contains integers
        Py.print(Py.sum(Py.range2(100+1), 0));
    }

}
