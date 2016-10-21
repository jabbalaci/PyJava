package com.github.jabbalaci.pyjava.proba;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.github.jabbalaci.pyjava.Py;
import com.github.jabbalaci.pyjava.PyList;
import com.github.jabbalaci.pyjava.PyStr;

/**
 * This file is used as a sandbox for trying out different things.
 * 
 * @author jabba
 */

public class TestPy {

    public static void main(String[] args) {
        TestPy m = new TestPy();
//      m.built_in_functions();
//      m.range();
//      m.print();
//      m.min_max_sum_prod();
//      m.chr_ord();
//      m.sort();
//      m.print();
//      m.array();
//      m.bin_hex();
//      m.conversions();
//      m.stdout();
//        m.sysout();
//        m.set();
//        m.py_dot_str();
        m.proba();
    }

	private void proba() {
//		List<Integer> li = Py.to_list(1, 2, 3);
		List<String> li = Py.to_list("laci");
		System.out.println(li);
	}

	private void py_dot_str() {
		Py.print(Py.str.reverse("PyJava"));
	}

	@SuppressWarnings("unused")
	private void set() {
		Set<Integer> bag = new HashSet<>();
		bag.add(7); bag.add(4); bag.add(9); bag.add(-200);
		List<Integer> li = Py.sorted(Py.to_list(bag));
		Py.print(bag);
		Py.print(li);
		
		Set<Integer> uj = Py.to_set(li);
		Py.print(uj);
	}

	@SuppressWarnings("unused")
	private void sysout() {
		System.out.println();
	}

	@SuppressWarnings("unused")
	private void stdout() {
        // Create a stream to hold the output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        // IMPORTANT: Save the old System.out!
        PrintStream old = System.out;
        // Tell Java to use your special stream
        System.setOut(ps);
        // Print some output: goes to your special stream
        System.out.println("Foofoofoo!");
        // Put things back
        System.out.flush();
        System.setOut(old);
        // Show what happened
        System.out.println("Here: " + baos.toString());
    }

    @SuppressWarnings("unused")
    private void conversions() {
        Py.print(Py.to_int("42f"));
        
    }

    @SuppressWarnings("unused")
    private void bin_hex() {
		int n = 585;
		Py.print(Py.bin(n));
		Py.print(Py.bin(n, false));
	}

//	@SuppressWarnings("unused")
//    private void array() {
//		Integer[] eh = Py.to_int_array(1, 2, 3, 4, 5);
//		Py.print(eh.length);
//	}

	@SuppressWarnings("unused")
    private void sort() {
        List<Integer> li = Py.new_list(0);
        li.add(3); li.add(1); li.add(6); li.add(5);
        Py.print(li);

        List<Integer> copy = Py.sorted(li);
        Py.print(copy);
        Py.print(li);
        Py.sep("-", 30);
        PyList.sort(li);
        Py.print(li);
    }

    @SuppressWarnings("unused")
    private void chr_ord() {
        Py.print(Py.chr(65));
        Py.print(Py.ord('A'));
        Py.print(Py.ord("A"));
    }

    @SuppressWarnings("unused")
    private void min_max_sum_prod() {
//      List<Integer> li = Py.list(0);
//      li.add(3);
//      Py.print(li);
//      //
//      List<Double> li2 = Py.list(0.0);
//      li2.add(3.14);
//      Py.print(li2);
//      //
//      List<String> li3 = Py.list("");
//      li3.add("PyJava");
//      Py.print(li3);

        List<Integer> li = Py.new_list(0);
        li.add(3); li.add(1); li.add(6); li.add(5);
        Py.print(li);
        Py.print(Py.max(li));
        Py.print(Py.min(li));
        Py.print(Py.sum(li, 0));
        Py.print(Py.prod(li, 0));
        //
        List<Integer> li2 = Py.new_list(0);
        Py.print(Py.max(li2));
        int maxi = Py.max(li2);
    }

    @SuppressWarnings("unused")
    private void print() {
        Py.print("Hello, PyJava!", "");
        Py.print("second line");
    }

    @SuppressWarnings("unused")
    private void range() {
        List<Integer> li = Py.range2(5);
        Py.print(li);
        //
        List<Integer> li6 = Py.range2(0);
        Py.print(li6);
        //
        List<Integer> li7 = Py.range2(-2);
        Py.print(li7);
        //
        List<Integer> li2 = Py.range2(5, 15);
        Py.print(li2);
        //
        List<Integer> li8 = Py.range2(15, 5);
        Py.print(li8);
        //
        List<Integer> li3 = Py.range2(5, 15, 2);
        Py.print(li3);
        //
        List<Integer> li9 = Py.range2(10, 4, 3);
        Py.print(li9);
        //
        List<Integer> li4 = Py.range2(15, 5, -1);
        Py.print(li4);
        //
//      List<Integer> li5 = Py.range(15, 5, 0);
//      Py.print(li5);

    }

    @SuppressWarnings("unused")
    private void built_in_functions() {
        String s = Py.to_str(6);
        Py.print(s);
        //
        String s2 = Py.to_str(3.14);
        Py.print(s2);
        //
        int n = Py.to_int("42");
        Py.print(n);
        //
        double d = Py.to_double("3.14");
        Py.print(d);
        //
        float f = Py.to_float("3.14");
        Py.print(f);
        //
//      String line = Py.input();
//      Py.print(line);
//      String line = Py.input("Name: ");
//      Py.print(line);
        //
        String s3 = "jabba";
        Py.print(PyStr.capitalize(s3));
        //
        String s4 = "Pythonization of Java";
        Py.print(PyStr.reverse(s4));
    }

}
