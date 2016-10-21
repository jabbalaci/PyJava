package com.github.jabbalaci.pyjava.examples;

import java.util.List;

/*
 removing duplicates

 Consider the following list: [5, 2, 3, 5, 1, 4, -200, 5, 1, 3, 2, 2, 5] . 
 Remove the duplicates, i.e. an element should be present in the list maximum once. 
 Let the result be a sorted list.
*/

import com.github.jabbalaci.pyjava.Py;

public class Example10 {
	
    public static void main(String[] args) {
        Example10 m = new Example10();
        m.start();
    }
    
	private void start() {
		List<Integer> li = Py.as_list(5, 2, 3, 5, 1, 4, -200, 5, 1, 3, 2, 2, 5);
		Py.print(li);
		Py.print(Py.sorted(Py.to_list(Py.to_set(li))));
	}

}
