package com.github.jabbalaci.pyjava;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.jabbalaci.pyjava.Common;
import com.github.jabbalaci.pyjava.Py;
import com.github.jabbalaci.pyjava.PyList;
import com.github.jabbalaci.pyjava.ValueError;

public class ListTest {
	
	@Test
	public void testCreate_new_list() {
		List<Integer> a = Py.new_list(0);
		assertEquals(0, a.size());
		List<Double> b = Py.new_list(0.0);
		assertEquals(0, b.size());
		List<String> c = Py.new_list("");
		assertEquals(0, c.size());
		//
		List<String> d = Py.to_list("");    // another way to create an empty string list
		assertEquals(0, d.size());
	}
	
	@Test
	public void testAs_list() {
		List<Integer> li = Py.as_list(1, 2, 3);
		assertEquals(3, li.size());
		assertEquals(1, (int)li.get(0));
		assertEquals(2, (int)li.get(1));
		assertEquals(3, (int)li.get(2));
		//
		List<Integer> b = new ArrayList<>();
		b.add(1); b.add(2); b.add(3);
		assertEquals(true, li.equals(b));
		//
		li.add(9);
		assertEquals(4, li.size());
		assertEquals(9, (int)li.get(3));
	}

    @Test
    public void testLists_equal_int() {
        List<Integer> l1 = Py.as_list(1, 2, 3);
        List<Integer> l2 = Py.as_list(1, 2, 3);
        assertEquals(true, l1.equals(l2));
        //
        l2.add(4);
        assertEquals(false, l1.equals(l2));
        //
        l1.clear(); l2.clear();
        assertEquals(true, l1.equals(l2));
        //
        l1.add(1);
        assertEquals(false, l1.equals(l2));
        //
        l2.add(1);
        assertEquals(true, l1.equals(l2));
        //
        l1.clear(); l2.clear();
        l1.add(1); l1.add(2);
        l2.add(100); l2.add(2);
        assertEquals(false, l1.equals(l2));
    }
    
    @Test
    public void testLists_equal_double() {
        List<Double> l1 = Py.as_list(1.0, 2.0, 3.0);
        List<Double> l2 = Py.as_list(1.0, 2.0, 3.0);
        assertEquals(true, l1.equals(l2));
        //
        l2.add(4.0);
        assertEquals(false, l1.equals(l2));
        //
        l1.clear(); l2.clear();
        assertEquals(true, l1.equals(l2));
        //
        l1.add(1.0);
        assertEquals(false, l1.equals(l2));
        //
        l2.add(1.0);
        assertEquals(true, l1.equals(l2));
        //
        l1.clear(); l2.clear();
        l1.add(1.0); l1.add(2.0);
        l2.add(1.001); l2.add(2.0);
        assertEquals(false, l1.equals(l2));    // out of tolerance
    }
    
    @Test
    public void testLists_equal_String() {
        List<String> l1 = Py.as_list("a", "b", "c");
        List<String> l2 = Py.as_list("a", "b", "c");
        assertEquals(true, l1.equals(l2));
        
        l2.add("d");
        assertEquals(false, l1.equals(l2));
        //
        l1.clear(); l2.clear();
        assertEquals(true, l1.equals(l2));
        //
        l1.add("a");
        assertEquals(false, l1.equals(l2));
        //
        l2.add("a");
        assertEquals(true, l1.equals(l2));
        //
        l1.clear(); l2.clear();
        l1.add("aa"); l1.add("bb");
        l2.add("AA"); l2.add("bb");
        assertEquals(false, l1.equals(l2));
    }
    
    @Test
    public void testList() {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = Py.new_list(0);
        assertEquals(true, l1.equals(l2));
        //
        List<Double> l1_d = new ArrayList<>();
        List<Double> l2_d = Py.new_list(0.0);
        assertEquals(true, l1_d.equals(l2_d));
        //
        List<String> l1_s = new ArrayList<>();
        List<String> l2_s = Py.to_list("");
        assertEquals(true, l1_s.equals(l2_s));
    }
    
    @Test
    public void testMax() {
        List<Integer> li = Py.as_list(3, 1, 6, 5);
        assertEquals(6, (int)Py.max(li));
    }
    
    @Test
    public void testMin() {
        List<Integer> li = Py.as_list(3, 1, 6, 5);
        assertEquals(1, (int)Py.min(li));
    }
    
    @Test
    public void testMax_double() {
        List<Double> li = Py.as_list(3.0, 1.0, 6.0, 5.0);
        assertEquals(6.0, (double)Py.max(li), Common.TOLERANCE);
    }
    
    @Test
    public void testMin_double() {
        List<Double> li = Py.as_list(3.0, 1.0, 6.0, 5.0);
        li.add(3.0); li.add(1.0); li.add(6.0); li.add(5.0);
        assertEquals(1.0, (double)Py.min(li), Common.TOLERANCE);
    }
    
    @Test
    public void testMax_String() {
        List<String> li = Py.as_list("c", "a", "f", "e");
        assertEquals("f", (String)Py.max(li));
    }
    
    @Test
    public void testMin_String() {
        List<String> li = Py.as_list("c", "a", "f", "e");
        assertEquals("a", (String)Py.min(li));
    }
    
    @Test(expected = ValueError.class)
    public void testMaxException() {
        List<Integer> li = Py.new_list(0);
        assertEquals(0, (int)Py.max(li));    // dummy value
    }
    
    @Test(expected = ValueError.class)
    public void testMinException() {
        List<Integer> li = Py.new_list(0);
        assertEquals(0, (int)Py.min(li));    // dummy value
    }
    
    @Test
    public void testSum() {
        List<Integer> li = Py.as_list(3, 1, 6, 5);
        assertEquals(15, Py.sum(li, 0));
        //
        li.clear();
        assertEquals(0, Py.sum(li, 0));
    }
    
    @Test
    public void testSum_double() {
        List<Double> li = Py.as_list(3.0, 1.0, 6.0, 5.0);
        assertEquals(15.0, Py.sum(li, 0), Common.TOLERANCE);
        //
        li.clear();
        assertEquals(0.0, Py.sum(li, 0.0), Common.TOLERANCE);
    }
    
    @Test
    public void testProd() {
        List<Integer> li = Py.as_list(3, 1, 6, 5);
        assertEquals(90, Py.prod(li, 0));
        //
        li.clear();
        assertEquals(1, Py.prod(li, 0));
    }
    
    @Test
    public void testProd_double() {
        List<Double> li = Py.as_list(3.0, 1.0, 6.0, 5.0);
        assertEquals(90.0, Py.prod(li, 0), Common.TOLERANCE);
        //
        li.clear();
        assertEquals(1.0, Py.prod(li, 0.0), Common.TOLERANCE);
    }
    
    // ---------- sort* ----------
    
    @Test
    public void testSorted() {
        List<Integer> unsorted = Py.as_list(3, 1, 6, 5);
        //
        List<Integer> work = Py.as_list(3, 1, 6, 5);
        //
        List<Integer> sorted = Py.as_list(1, 3, 5, 6);
        //
        List<Integer> result = Py.sorted(work);
        // work is unchanged
        assertEquals(true, work.equals(unsorted));
        // result is sorted
        assertEquals(true, result.equals(sorted));
        // empty list //
        List<Integer> empty = Py.new_list(0);
        result = Py.sorted(empty);
        assertEquals(true, result.isEmpty());
    }
    
    @Test
    public void testSorted_reverse_false() {
        List<Integer> unsorted = Py.as_list(3, 1, 6, 5);
        //
        List<Integer> work = Py.as_list(3, 1, 6, 5);
        //
        List<Integer> sorted = Py.as_list(1, 3, 5, 6);
        //
        List<Integer> result = Py.sorted(work, false);
        // work is unchanged
        assertEquals(true, work.equals(unsorted));
        // result is sorted
        assertEquals(true, result.equals(sorted));
        // empty list //
        List<Integer> empty = Py.new_list(0);
        result = Py.sorted(empty, false);
        assertEquals(true, result.isEmpty());
    }
    
    @Test
    public void testSorted_reverse_true() {
        List<Integer> unsorted = Py.as_list(3, 1, 6, 5);
        //
        List<Integer> work = Py.as_list(3, 1, 6, 5);
        //
        List<Integer> reversed = Py.as_list(6, 5, 3, 1);
        //
        List<Integer> result = Py.sorted(work, true);    // decreasing order
        // work is unchanged
        assertEquals(true, work.equals(unsorted));
        // result is sorted in decreasing order
        assertEquals(true, result.equals(reversed));
        // empty list //
        List<Integer> empty = Py.new_list(0);
        result = Py.sorted(empty, true);
        assertEquals(true, result.isEmpty());
    }
    
    @Test
    public void testSort() {
        List<Integer> unsorted = Py.as_list(3, 1, 6, 5);
        //
        List<Integer> work = Py.as_list(3, 1, 6, 5);
        //
        List<Integer> sorted = Py.as_list(1, 3, 5, 6);
        //
        PyList.sort(work);
        // work is changed
        assertEquals(false, work.equals(unsorted));
        // work is sorted
        assertEquals(true, work.equals(sorted));
        // empty list //
        List<Integer> empty = Py.new_list(0);
        PyList.sort(empty);
        assertEquals(true, empty.isEmpty());
    }
    
    @Test
    public void testSort_reverse_false() {
        List<Integer> unsorted = Py.as_list(3, 1, 6, 5);
        //
        List<Integer> work = Py.as_list(3, 1, 6, 5);
        //
        List<Integer> sorted = Py.as_list(1, 3, 5, 6);
        //
        PyList.sort(work, false);
        // work is changed
        assertEquals(false, work.equals(unsorted));
        // work is sorted
        assertEquals(true, work.equals(sorted));
        // empty list //
        List<Integer> empty = Py.new_list(0);
        PyList.sort(empty, false);
        assertEquals(true, empty.isEmpty());
    }
    
    @Test
    public void testSort_reverse_true() {
        List<Integer> unsorted = Py.as_list(3, 1, 6, 5);
        //
        List<Integer> work = Py.as_list(3, 1, 6, 5);
        //
        List<Integer> reversed = Py.as_list(6, 5, 3, 1);
        //
        PyList.sort(work, true);    // decreasing order
        // work is changed
        assertEquals(false, work.equals(unsorted));
        // work is sorted
        assertEquals(true, work.equals(reversed));
        // empty list //
        List<Integer> empty = Py.new_list(0);
        PyList.sort(empty, true);
        assertEquals(true, empty.isEmpty());
    }
    
    // ---------- reverse* ----------
    
    @Test
    public void testReversed() {
        List<Integer> work = Py.as_list(1, 3, 5, 6);
        //
        List<Integer> sorted = Py.as_list(1, 3, 5, 6);
        //
        List<Integer> reversed = Py.as_list(6, 5, 3, 1);
        //
        List<Integer> result = Py.reversed(work);
        // work is unchanged
        assertEquals(true, work.equals(sorted));
        // result is reversed
        assertEquals(true, result.equals(reversed));
        // empty list //
        List<Integer> empty = Py.new_list(0);
        result = Py.reversed(empty);
        assertEquals(true, result.isEmpty());
    }

    @Test
    public void testReverse() {
        List<Integer> work = Py.as_list(1, 3, 5, 6);
        //
        List<Integer> sorted = Py.as_list(1, 3, 5, 6);
        //
        List<Integer> reversed = Py.as_list(6, 5, 3, 1);
        //
        PyList.reverse(work);
        // work is changed
        assertEquals(false, work.equals(sorted));
        // work is reversed
        assertEquals(true, work.equals(reversed));
        // empty list //
        List<Integer> empty = Py.new_list(0);
        PyList.reverse(empty);
        assertEquals(true, empty.isEmpty());
    }
    
    // ---------- list(...) ----------
    
    @Test
    public void testList_explode_string() {
        List<String> li = Py.to_list("python");
        assertEquals(6, li.size());
        assertEquals("p", li.get(0));
        assertEquals("y", li.get(1));
        assertEquals("t", li.get(2));
        assertEquals("h", li.get(3));
        assertEquals("o", li.get(4));
        assertEquals("n", li.get(5));
        //
        li = Py.to_list("");
        assertEquals(true, li.isEmpty());
    }
    
}