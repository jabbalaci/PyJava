package com.github.jabbalaci.pyjava;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.github.jabbalaci.pyjava.Py;
import com.github.jabbalaci.pyjava.ValueError;

public class RangeTest {
    
    @Test
    public void testRange2_end() {
        List<Integer> a = Py.range2(5);
        assertEquals(5, a.size());
        assertEquals(0, (int)a.get(0));
        assertEquals(1, (int)a.get(1));
        assertEquals(2, (int)a.get(2));
        assertEquals(3, (int)a.get(3));
        assertEquals(4, (int)a.get(4));
        //
        a = Py.range2(0);
        assertEquals(true, a.isEmpty());
        //
        a = Py.range2(-1);
        assertEquals(true, a.isEmpty());
        //
        a = Py.range2(1000);
        assertEquals(1000, a.size());
    }
    
    @Test
    public void testRange2_start_end() {
        List<Integer> a = Py.range2(3, 6);
        assertEquals(3, a.size());
        assertEquals(3, (int)a.get(0));
        assertEquals(4, (int)a.get(1));
        assertEquals(5, (int)a.get(2));
        //
        a = Py.range2(6, 3);
        assertEquals(true, a.isEmpty());
        //
        a = Py.range2(6, 6);
        assertEquals(true, a.isEmpty());
    }
    
    @Test
    public void testRange2_start_end_positiveStep() {
        List<Integer> a = Py.range2(3, 10, 2);
        assertEquals(4, a.size());
        assertEquals(3, (int)a.get(0));
        assertEquals(5, (int)a.get(1));
        assertEquals(7, (int)a.get(2));
        assertEquals(9, (int)a.get(3));
        //
        a = Py.range2(6, 3, 2);
        assertEquals(true, a.isEmpty());
        //
        a = Py.range2(5, 5, 3);
        assertEquals(true, a.isEmpty());
    }
    
    @Test
    public void testRange2_start_end_negativeStep() {
        List<Integer> a = Py.range2(10, 5, -1);
        assertEquals(5, a.size());
        assertEquals(10, (int)a.get(0));
        assertEquals(9, (int)a.get(1));
        assertEquals(8, (int)a.get(2));
        assertEquals(7, (int)a.get(3));
        assertEquals(6, (int)a.get(4));
        //
        a = Py.range2(5, 10, -1);
        assertEquals(true, a.isEmpty());
        //
        a = Py.range2(5, 5, -1);
        assertEquals(true, a.isEmpty());
    }
    
    @Test(expected = ValueError.class)
    public void testRange2_start_end_zeroStep() {
        @SuppressWarnings("unused")
        List<Integer> dummy = Py.range2(10, 5, 0);
    }
    
}