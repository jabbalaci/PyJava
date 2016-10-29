package com.github.jabbalaci.pyjava;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOError;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.jabbalaci.pyjava.Py;
import com.github.jabbalaci.pyjava.TypeError;
import com.github.jabbalaci.pyjava.ValueError;

public class FileReadTest {
	
	/**
	 * http://stackoverflow.com/a/28674230/232485
	 * 
	 * @param fname File name of a resource file.
	 * @return Absolute path of the given resource file.
	 */
	private String getPathOfResourceFile(String fname) {
		ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fname).getFile());
        return file.getAbsolutePath();
	}

    @Test
    public void testReadlines_1() {
        String fpath = getPathOfResourceFile("text.txt");
        List<String> got = Py.readlines(fpath);
        List<String> expected = new ArrayList<>();
        expected.add("First line.");
        expected.add("Second line.");
        assertEquals(expected, got);
    }
    
    @Test
    public void testReadlines_2() {
        String fpath = getPathOfResourceFile("symbols.txt");
        List<String> got = Py.readlines(fpath, "iso-8859-1");
    }
    
    @Test
    public void testRead_1() {
        String fpath = getPathOfResourceFile("text.txt");
        String got = Py.read(fpath);
        String expected = "First line.\nSecond line.\n";
        assertEquals(expected, got);
    }
    
    @Test
    public void testRead_2() {
        String fpath = getPathOfResourceFile("text.txt");
        String got = Py.read(fpath, "iso-8859-1");
    }

}
