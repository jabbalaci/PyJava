package com.github.jabbalaci.pyjava;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.github.jabbalaci.pyjava.PyStr;

public class StringMethodsTest {

    @Test
    public void testCapitalize() {
        assertEquals("", PyStr.capitalize(""));
        assertEquals("Jabba", PyStr.capitalize("jabba"));
        assertEquals("Jabba", PyStr.capitalize("jABBA"));
        assertEquals("Jabba", PyStr.capitalize("JABBA"));
    }

    @Test
    public void testReverse() {
        assertEquals("", PyStr.reverse(""));
        assertEquals("a", PyStr.reverse("a"));
        assertEquals("ba", PyStr.reverse("ab"));
        assertEquals("avaJyP", PyStr.reverse("PyJava"));
    }

    @Test
    public void testRepeat() {
        assertEquals("", PyStr.repeat("-", 0));
        assertEquals("", PyStr.repeat("-", -1));
        assertEquals("-", PyStr.repeat("-", 1));
        assertEquals("-----", PyStr.repeat("-", 5));
    }

    @Test
    public void testCenter() {
        assertEquals("*", PyStr.center("*", 1));
        assertEquals(" * ", PyStr.center("*", 3));
        assertEquals("  * ", PyStr.center("*", 4));
        assertEquals(" ** ", PyStr.center("**", 4));
        //
        assertEquals("*", PyStr.center("*", 0));
        assertEquals("*****", PyStr.center("*****", 3));
    }

    @Test
    public void testSplit() {
        List<String> li = PyStr.split("a:b:c:d", ":");
        assertEquals(4, li.size());
        assertEquals("a", li.get(0));
        assertEquals("b", li.get(1));
        assertEquals("c", li.get(2));
        assertEquals("d", li.get(3));
        //
        li = PyStr.split("a:b:c:d", "x");
        assertEquals(1, li.size());
        assertEquals("a:b:c:d", li.get(0));
    }

    @Test
    public void testSplit_no_sep() {
        List<String> li = PyStr.split("   a    b     c   d    ");
        assertEquals(4, li.size());
        assertEquals("a", li.get(0));
        assertEquals("b", li.get(1));
        assertEquals("c", li.get(2));
        assertEquals("d", li.get(3));
        //
        li = PyStr.split("       ");
        assertEquals(true, li.isEmpty());
    }
    
    @Test
    public void testJoin() {
    	List<String> li = Arrays.asList("aa", "bb", "cc");
    	assertEquals("aa:bb:cc", PyStr.join(":", li));
    	assertEquals("aabbcc", PyStr.join("", li));
    	assertEquals("aa", PyStr.join(":", Arrays.asList("aa")));
    }

}
