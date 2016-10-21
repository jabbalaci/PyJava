package com.github.jabbalaci.pyjava;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.jabbalaci.pyjava.Py;
import com.github.jabbalaci.pyjava.TypeError;
import com.github.jabbalaci.pyjava.ValueError;

public class AsciiTest {

    @Test
    public void testChr() {
        assertEquals("A", Py.chr(65));
        assertEquals("d", Py.chr(100));
    }

    @Test(expected = ValueError.class)
    public void testChrException1() {
        assertEquals("_", Py.chr(256));    // _ for dummy value
    }

    @Test(expected = ValueError.class)
    public void testChrException2() {
        assertEquals("_", Py.chr(-1));    // _ for dummy value
    }

    @Test
    public void testOrdChar() {
        assertEquals(97, Py.ord('a'));
    }

    @Test
    public void testOrdString() {
        assertEquals(97, Py.ord("a"));
    }

    @Test(expected = TypeError.class)
    public void testOrdStringException1() {
        assertEquals(0, Py.ord(""));    // 0 for dummy value
    }

    @Test(expected = TypeError.class)
    public void testOrdStringException2() {
        assertEquals(0, Py.ord("aa"));    // 0 for dummy value
    }
}
