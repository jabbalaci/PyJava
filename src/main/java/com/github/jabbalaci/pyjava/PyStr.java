package com.github.jabbalaci.pyjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * String methods.
 *
 * @author jabba
 */

public class PyStr {

    /**
     * @param s A string.
     * @return Capitalize the string.
     */
    public static String capitalize(String s) {
        if (s.isEmpty()) {
            return "";
        }
        String first = "" + s.charAt(0);    // 1-long string
        String rest = s.substring(1);

        return first.toUpperCase() + rest.toLowerCase();
    }

    /**
     * @param s A string.
     * @return Reverse the order of characters in the string and return the reversed string.
     */
    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * @param s A string.
     * @param rep Repetition number.
     * @return Take the given string "rep" times and concatenate the pieces into one string.
     */
    public static String repeat(String s, int rep) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rep; ++i) {
            sb.append(s);
        }
        return sb.toString();
    }

    /**
     * Center a text of a given width.
     *
     * @param s A string to be centered.
     * @param width A width. The text must go to the middle of this width.
     * @return A string where the given text is centered of a given width.
     */
    public static String center(String s, int width) {
        int rest = width - s.length();
        int right = rest / 2;
        int left = rest - right;
        return repeat(" ", left) + s + repeat(" ", right);
    }

    /**
     * Split a string by a separator string.
     * The return value is a list.
     *
     * @param s A string.
     * @param sep A separator string (can be 1-long).
     * @return The exploded (split up) string.
     */
    public static List<String> split(String s, String sep) {
        String[] parts = s.split(sep);
        return Arrays.asList(parts);
    }

    /**
     * Split a string by whitespace characters.
     *
     * @param s A string.
     * @return The exploded (split up) string.
     */
    public static List<String> split(String s) {
        String sep = "\\s+";    // regexp for whitespace
        String[] parts = s.split(sep);
        List<String> li = new ArrayList<>();
        for (String p : parts) {
            if (p.isEmpty() == false) {
                li.add(p);
            }
        }
        return li;
    }
    
    public static String join(String sep, List<String> li) {
    	return String.join(sep, li);
    }

}
