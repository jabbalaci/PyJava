package com.github.jabbalaci.pyjava.examples;

/*
 An anagram is a type of word play, the result of rearranging
 the letters of a word or phrase to produce a new word or phrase,
 using all the original letters exactly once.

 Examples:

    listen = silent
    A gentleman = Elegant man
    Clint Eastwood = Old west action

 Write a function that receives two strings and decides
 if the second string is an anagram of the first one.
 As you can see from the examples, whitespaces and upper and
 lower case letters don't matter.
 */

import com.github.jabbalaci.pyjava.Py;

public class Example05 {

    public static void main(String[] args) {
        Example05 m = new Example05();
        m.start();
    }

    private String clean(String s) {
        return s.replace(" ", "").toLowerCase();
    }

    private void start() {
        String s1_original = "A gentleman";
        String s2_original = "Elegant man";

        String s1 = clean(s1_original);
        String s2 = clean(s2_original);

        boolean res = Py.sorted(Py.to_list(s1)).equals(Py.sorted(Py.to_list(s2)));
        Py.printf("Anagramma(%s, %s): %b", s1_original,
                                           s2_original,
                                           res);
        Py.print();
    }

}
