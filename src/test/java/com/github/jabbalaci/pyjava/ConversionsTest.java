package com.github.jabbalaci.pyjava;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.jabbalaci.pyjava.Common;
import com.github.jabbalaci.pyjava.Py;

public class ConversionsTest {

    @Test
    public void testStrInt() {
        assertEquals("6", Py.to_str(6));
        assertEquals("0", Py.to_str(0));
        assertEquals("-20", Py.to_str(-20));
    }

    @Test
    public void testStrDouble() {
        assertEquals("6.0", Py.to_str(6.0));
        assertEquals("0.0", Py.to_str(0.0));
        assertEquals("-6.0", Py.to_str(-6.0));
    }

    @Test
    public void testTo_int() {
        assertEquals(42, Py.to_int("42"));
        assertEquals(0, Py.to_int("0"));
        assertEquals(-42, Py.to_int("-42"));
    }

    @Test
    public void testTo_double() {
        assertEquals(3.14, Py.to_double("3.14"), Common.TOLERANCE);
        assertEquals(0.0, Py.to_double("0.0"), Common.TOLERANCE);
        assertEquals(-3.14, Py.to_double("-3.14"), Common.TOLERANCE);
    }

    @Test
    public void testTo_float() {
        assertEquals(3.14, Py.to_float("3.14"), Common.TOLERANCE);
        assertEquals(0.0, Py.to_float("0.0"), Common.TOLERANCE);
        assertEquals(-3.14, Py.to_float("-3.14"), Common.TOLERANCE);
    }
    
    // ---------- bin / hex ----------
    
    @Test
    public void testBin() {
        assertEquals("0b0", Py.bin(0));
        assertEquals("0b1010", Py.bin(10));
        assertEquals("-0b1010", Py.bin(-10));
    }
    
    @Test
    public void testBin_with_prefix() {
        assertEquals("0b0", Py.bin(0, true));
        assertEquals("0b1010", Py.bin(10, true));
        assertEquals("-0b1010", Py.bin(-10, true));
    }
    
    @Test
    public void testBin_without_prefix() {
        assertEquals("0", Py.bin(0, false));
        assertEquals("1010", Py.bin(10, false));
        assertEquals("-1010", Py.bin(-10, false));
    }


}
