package com.github.jabbalaci.pyjava;

/**
 PyJava
 ======

 Pythonize Java to make it more fun to use.

 Here I implement(ed) some features of Python that I miss a lot when using Java.

 Author: Laszlo Szathmary, alias Jabba Laci, 2016
 E-mail: jabba.laci@gmail.com
 GitHub: https://github.com/jabbalaci
*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class Py {

    /**
     * Access things in PyStr as (examples):
     * 1) PyStr.reverse(...) , or
     * 2) Py.str.reverse(...)
     */
    public static PyStr str;

    /**
     * Access things in PyList as (examples):
     * 1) PyList.sort(...) , or
     * 2) Py.list.sort(...)
     */
    public static PyList list;

    /**
     * For reading from the stdin.
     */
    private static Scanner scanner = new Scanner(System.in);

    // ----------------------------------------------------------------------
    // System.out.print*
    // ----------------------------------------------------------------------

    /**
     * shortcut for System.out.println
     *
     * @param o An object you want to print.
     */
    public static void print(Object o) {
        System.out.println(o);
    }
    
    /**
     * In Python, print's help looks like this:
     * print(value, ..., sep=' ', end='\n', file=sys.stdout, flush=False)
     * sep could work if we used variable number or arguments and print them
     * one by one, but then how to recognize the optional parameters at the end?
     * So I skipped sep and went with end. If end is given, then it's printed at
     * the end instead of a newline.
     * 
     * @param o An object to print.
     * @param end Print this after the object.
     */
    public static void print(Object o, String end) {
        System.out.print(o);
        System.out.print(end);
    }

    /**
     * Print a newline.
     */
    public static void print() {
        System.out.println();
    }

    /**
     * shortcut for System.out.printf(...)
     * 
     * @param format
     * @param args
     */
    public static void printf(String format, Object ... args) {
		System.out.printf(format, args);
	}
    
    // ----------------------------------------------------------------------
    // type conversions
    // ----------------------------------------------------------------------

    /**
     * @param o An object.
     * @return Return a string containing a nicely printable representation of an object.
     */
    public static <T> String to_str(T o) {
        return "" + o;
    }

    /**
     * @param s A string.
     * @return Integer version of the string.
     */
    public static int to_int(String s) {
        return Integer.parseInt(s);
    }

    /**
     * This function cannot be called "double", that's why it is named as "to_double".
     * I suggest using this instead of "to_float".
     *
     * @param s A string.
     * @return Double version of the string.
     */
    public static double to_double(String s) {
        return Double.parseDouble(s);
    }

    /**
     * This function cannot be called "float", that's why it is named as "to_float".
     * I suggest using "to_double" instead.
     *
     * @param s A string.
     * @return Float version of the string.
     */
    public static float to_float(String s) {
        return Float.parseFloat(s);
    }

    // ----------------------------------------------------------------------
    // reading from stdin
    // ----------------------------------------------------------------------

    /**
     * @return Read a line from stdin and return the line as a string.
     */
    public static String input() {
        return Py.scanner.nextLine();
    }

    /**
     * @param prompt A prompt.
     * @return Print the prompt, read a line from stdin and return the line as a string.
     */
    public static String input(String prompt) {
        System.out.print(prompt);
        return Py.scanner.nextLine();
    }

    // ----------------------------------------------------------------------
    // Python 2's range
    // ----------------------------------------------------------------------

    /**
     * In the name "range2" the "2" shows that it's an implementation
     * of Python 2's range, i.e. it creates a new list.
     * Don't use it for big ranges!
     *
     * @param end End position.
     * @return A ranged list from 0 (included) to end (excluded).
     */
    public static List<Integer> range2(int end) {
        List<Integer> li = new ArrayList<>();
        //
        for (int i = 0; i < end; ++i) {
            li.add(i);
        }
        //
        return li;
    }

    /**
     * In the name "range2" the "2" shows that it's an implementation
     * of Python 2's range, i.e. it creates a new list.
     * Don't use it for big ranges!
     *
     * @param start Start position.
     * @param end End position.
     * @return A ranged list from start (included) to end (excluded).
     */
    public static List<Integer> range2(int start, int end) {
        List<Integer> li = new ArrayList<>();
        //
        for (int i = start; i < end; ++i) {
            li.add(i);
        }
        //
        return li;
    }

    /**
     * In the name "range2" the "2" shows that it's an implementation
     * of Python 2's range, i.e. it creates a new list.
     * Don't use it for big ranges!
     *
     * @param start Start position.
     * @param end End position.
     * @param step Step value.
     * @return A ranged list from start (included) to end (excluded) that contains every "step"th value.
     */
    public static List<Integer> range2(int start, int end, int step) {
        List<Integer> li = new ArrayList<>();
        //
        if (step > 0) {
            for (int i = start; i < end; i += step) {
                li.add(i);
            }
        }
        else if (step < 0) {
            for (int i = start; i > end; i += step) {
                li.add(i);
            }
        }
        else {
            throw new ValueError("range() step argument must not be zero");
        }
        //
        return li;
    }

    // ----------------------------------------------------------------------
    // create a new empty list
    // ----------------------------------------------------------------------

    /**
     * Provide a type and a new list of that type is returned. Examples:
     *
     * List<Integer> = Py.new_list(0);    // where 0 is an integer => create a list of integers
     * List<String> = Py.new_list("");    // where "" is a string => create a list of strings
     *
     * @param type A type.
     * @return A new ArrayList of the given type.
     */
    public static <T> List<T> new_list(T type) {
        return new ArrayList<T>();
    }

    // ----------------------------------------------------------------------
    // max, min, sum, prod
    // ----------------------------------------------------------------------

    /**
     * @param li A list.
     * @return Maximal element of the list.
     */
    public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> li) {
        if (li.isEmpty()) {
            throw new ValueError("max() arg is an empty sequence");
        }
        return Collections.max(li);
    }

    /**
     * @param li A list.
     * @return Minimal element of the list.
     */
    public static <T extends Object & Comparable<? super T>> T min(Collection<? extends T> li) {
        if (li.isEmpty()) {
            throw new ValueError("min() arg is an empty sequence");
        }
        return Collections.min(li);
    }

    /**
     * @param li A list.
     * @param type A type. It indicates the type of the elements in the list.
     * @return Sum of the elements in the list.
     */
    public static int sum(List<Integer> li, int type) {
        // requires Java 8
        return li.stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * @param li A list.
     * @param type A type. It indicates the type of the elements in the list.
     * @return Sum of the elements in the list.
     */
    public static double sum(List<Double> li, double type) {
        // requires Java 8
        return li.stream().mapToDouble(Double::doubleValue).sum();
    }

    /**
     * There's no such built-in function in Python but I thought
     * it would be useful. If there is "sum", there should be a "prod" too
     * IMO.
     *
     * @param li A list.
     * @param type A type. It indicates the type of the elements in the list.
     * @return Product of the elements in the list.
     */
    public static int prod(List<Integer> li, int type) {
        int total = 1;
        for (int e : li) {
            total *= e;
        }
        return total;
    }

    /**
     * @param li A list.
     * @param type A type. It indicates the type of the elements in the list.
     * @return Product of the elements in the list.
     */
    public static double prod(List<Double> li, double type) {
        double total = 1.0;
        for (double e : li) {
            total *= e;
        }
        return total;
    }

    // ----------------------------------------------------------------------
    // ASCII stuff: chr, ord
    // ----------------------------------------------------------------------

    /**
     * @param i An ASCII-value.
     * @return The string version of a character whose ASCII code is the integer i.
     */
    public static String chr(int i) {
        // Return the string representing a character
        // whose Unicode code point is the integer i.
        if ((i < 0) || (i > 255)) {
            throw new ValueError("chr() arg not in range(256)");
        }
        return Character.toString((char)i);
    }

    /**
     * @param c A character.
     * @return An integer representing the Unicode code point of the given character.
     */
    public static int ord(char c) {
        return (int)c;
    }

    /**
     * @param s A 1-long string.
     * @return An integer representing the Unicode code point of the given 1-long string.
     */
    public static int ord(String s) {
        if (s.length() != 1) {
            String msg = String.format("TypeError: ord() expected a character, but string of length %d found", s.length());
            throw new TypeError(msg);
        }
        return Py.ord(s.charAt(0));
    }
    
    // ----------------------------------------------------------------------
    // bin, hex
    // ----------------------------------------------------------------------
    
    /**
     * Convert decimal to binary. Python adds the "0b" prefix, so
     * it was kept.
     * 
     * @param n
     * @return
     */
    public static String bin(int n) {
        String pre = "";
        if (n < 0) {
            pre = "-";
            n *= -1;
        }
    	return pre + "0b" + Integer.toString(n, 2);
    }
    
    /**
     * Python doesn't have it. If prefix is false, then
     * the prefix is not added.
     * Rationale: in Python I always cut off the prefix...
     * 
     * @param n A decimal number.
     * @param prefix Add the prefix or not.
     * @return Binary version of the decimal number.
     */
    public static String bin(int n, boolean prefix) {
    	if (prefix == false) {
    		return Integer.toString(n, 2);
    	}
    	// else
    	return Py.bin(n);
    }

    // ----------------------------------------------------------------------
    // sorted, reversed
    // ----------------------------------------------------------------------

    /**
     * It makes a shallow (!) copy of the list, sorts the copy, and returns
     * the sorted copy.
     *
     * @param li A list.
     * @return A sorted (shallow) copy of the list.
     */
    public static <T extends Object & Comparable<? super T>> List<T> sorted(List<T> li) {
        // it makes a shallow copy
        List<T> copy = new ArrayList<>(li);
        Collections.sort(copy);
        return copy;
    }

    /**
     * @param li
     * @param reverse If true, then reverse order is applied.
     * @return
     */
    public static <T extends Object & Comparable<? super T>> List<T> sorted(List<T> li, boolean reverse) {
        if (reverse == false) {
            return Py.sorted(li);
        }
        // else, if reverse == true
        // it makes a shallow copy
        List<T> copy = new ArrayList<>(li);
        Collections.sort(copy, Collections.reverseOrder());
        return copy;
    }

    /**
     * It makes a shallow (!) copy of the list, reverses the copy, and returns
     * the reversed copy.
     *
     * @param li A list.
     * @return A reversed (shallow) copy of the list.
     */
    public static <T extends Object & Comparable<? super T>> List<T> reversed(List<T> li) {
        // it makes a shallow copy
        List<T> copy = new ArrayList<>(li);
        Collections.reverse(copy);
        return copy;
    }

    // ----------------------------------------------------------------------
    // list(...)
    // ----------------------------------------------------------------------

    /**
     * Take the elements and put them in a list.
     * 
     * @param params Variable number of parameters.
     * @return The given parameters put in a List.
     */
    @SafeVarargs
	public static <T> List<T> as_list(T... params) {
    	List<T> li = new ArrayList<>();
    	for (int i = 0; i < params.length; ++i) {
    		li.add(params[i]);
    	}
    	return li;
    }
    
    /**
     * Explode a string to a list of characters.
     * The characters in the list are stored as
     * 1-long Strings.
     *
     * @param s The string to be exploded.
     * @return A list of 1-long Strings that are the
     * characters of the input string.
     */
    public static List<String> to_list(String s) {
        List<String> li = new ArrayList<>();
        for (char c : s.toCharArray()) {
            li.add("" + c);
        }
        return li;
    }
    
    /**
     * set -> list
     * 
     * @param set An arbitrary set.
     * @return A new list that contains the elements of the set.
     */
    public static <T> List<T> to_list(Set<T> set) {
    	List<T> li = new ArrayList<>();
    	for (T e : set) {
    		li.add(e);
    	}
    	return li;
	}
    
    // ----------------------------------------------------------------------
    // set(...)
    // ----------------------------------------------------------------------
    
    /**
     * list -> set
     * 
     * @param li An arbitrary list.
     * @return A new set that contains the elements of the list.
     */
    public static <T> Set<T> to_set(List<T> li) {
    	Set<T> set = new HashSet<>();
    	for (T e : li) {
    		set.add(e);
    	}
    	return set;
	}

    // ----------------------------------------------------------------------
    // print a separator line
    // ----------------------------------------------------------------------

    /**
     * Take the given string "rep" times and concatenate the pieces into one string.
     * Then print this string to the stdout. Goal: draw a separator line.
     *
     * @param s A string.
     * @param rep Repetition number.
     */
    public static void sep(String s, int rep) {
        System.out.println(PyStr.repeat(s, rep));
    }

}
