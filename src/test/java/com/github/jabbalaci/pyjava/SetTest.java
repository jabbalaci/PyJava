package com.github.jabbalaci.pyjava;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.junit.Test;

public class SetTest {
	
	@Test
	public void testList_to_set() {
		List<Integer> li = Py.as_list(8, 5, 2, 4);
		Set<Integer> bag = Py.to_set(li);
		assertEquals(4, bag.size());
		assertEquals(true, bag.contains(8));
		assertEquals(true, bag.contains(5));
		assertEquals(true, bag.contains(2));
		assertEquals(true, bag.contains(4));
		//
		li.add(8); 
		li.add(5);
		assertEquals(6, li.size());
		Set<Integer> nodup = Py.to_set(li);
		assertEquals(4, nodup.size());
	}
	
	@Test
	public void testSet_to_list() {
		List<Integer> li = Py.as_list(8, 5, 2, 4, 8, 5);
		assertEquals(6, li.size());
		Set<Integer> bag = Py.to_set(li);
		assertEquals(4, bag.size());
		//
		List<Integer> res = Py.to_list(bag);
		assertEquals(4, res.size());
	}
    
}