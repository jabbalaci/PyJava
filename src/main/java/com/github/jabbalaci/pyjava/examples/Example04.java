package com.github.jabbalaci.pyjava.examples;

import java.util.List;

/*
 Write a method that receives the height of a diamond.
 The method will have to print a diamond the following way:

 Height: 3

     *
    ***
     *

 Height: 7

       *
      ***
     *****
    *******
     *****
      ***
       *

 Accept odd numbers only for the value of the height.
 */

import com.github.jabbalaci.pyjava.Py;
import com.github.jabbalaci.pyjava.PyStr;

public class Example04 {

    public static void main(String[] args) {
        Example04 m = new Example04();
        m.diamond(7);
    }

    private void diamond(int height) {
        List<Integer> li = Py.range2(1, height+1, 2);
        List<Integer> li2 = Py.reversed(li.subList(0, li.size()-1));
        li.addAll(li2);
        Py.print(li);

        for (int n : li) {
            Py.print(PyStr.center(PyStr.repeat("*", n), height));
        }
    }

}
