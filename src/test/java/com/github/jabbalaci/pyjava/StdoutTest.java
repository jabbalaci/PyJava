package com.github.jabbalaci.pyjava;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.jabbalaci.pyjava.Py;

public class StdoutTest {
    
    private ByteArrayOutputStream baos;
    
    private PrintStream old;
    
    @Before
    public void stdoutRedirectionOn() {
        this.baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        this.old = System.out;
        System.setOut(ps);
    }
    
    @After
    public void stdoutRedirectionOff() {
        System.setOut(this.old);
    }
    
    private String getStdout() {
        System.out.flush();
        return baos.toString();
    }

    @Test
    public void testPrint() {
        Py.print("");
        assertEquals("\n", this.getStdout());
    }
    
    @Test
    public void testPrint_nude() {
        Py.print();
        assertEquals("\n", this.getStdout());
    }
    
    @Test
    public void testPrint_2() {
        Py.print("hello");
        assertEquals("hello\n", this.getStdout());
    }
    
    @Test
    public void testPrint_with_end() {
        Py.print("aa", "");
        assertEquals("aa", this.getStdout());
    }
    
    @Test
    public void testPrint_with_end_2() {
        Py.print("aa", " ");
        assertEquals("aa ", this.getStdout());
    }
    
    @Test
    public void testPrint_with_end_3() {
        Py.print("aa", "::");
        assertEquals("aa::", this.getStdout());
    }
    
    @Test
    public void testPrint_with_end_4() {
        Py.print("aa", "\n");
        assertEquals("aa\n", this.getStdout());
    }
    
    @Test
    public void testPrint_with_end_5() {
        Py.print("aa", "::\n");
        assertEquals("aa::\n", this.getStdout());
    }
    
    @Test
    public void testPrintf() {
        Py.printf("%s", "py");
        assertEquals("py", this.getStdout());
    }
    
    @Test
    public void testPrintf_2() {
        Py.printf("%s was released in %d", "Python", 1991);
        assertEquals("Python was released in 1991", this.getStdout());
    }
    
    @Test
    public void testPrintf_3() {
        Py.printf("%s\n", "py");
        assertEquals("py\n", this.getStdout());
    }
    
    @Test
    public void testSep() {
        Py.sep("-", 3);
        assertEquals("---\n", this.getStdout());
    }
    
    @Test
    public void testSep_2() {
        Py.sep("ab", 3);
        assertEquals("ababab\n", this.getStdout());
    }

}
