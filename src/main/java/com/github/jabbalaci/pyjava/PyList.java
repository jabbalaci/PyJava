package com.github.jabbalaci.pyjava;

import java.util.Collections;

/**
 * List methods.
 * List helpers.
 *
 * @author jabba
 */

import java.util.List;


public class PyList {

    /**
     * Sort the list in place. It has no return value.
     *
     * @param li A list to be sorted.
     */
    public static <T extends Object & Comparable<? super T>> void sort(List<T> li) {
        Collections.sort(li);
    }

    /**
     * Sort the list in place. It has no return value.
     *
     * @param li The list to be sorted.
     * @param reverse If set to true, then the list is sorted in
     * descending order.
     */
    public static <T extends Object & Comparable<? super T>> void sort(List<T> li,  boolean reverse) {
        if (reverse == false) {
            sort(li);
            return;
        }
        // else, if reverse == true
        Collections.sort(li, Collections.reverseOrder());
    }

    /**
     * Reverse the list in place. It has no return value.
     *
     * @param li A list to be reversed.
     */
    public static <T extends Object & Comparable<? super T>> void reverse(List<T> li) {
        Collections.reverse(li);
    }

}
