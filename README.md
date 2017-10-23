**New (Oct 23, 2017):** If you want to work with Java but you need something
similar to Python, I suggest [Kotlin](https://en.wikipedia.org/wiki/Kotlin_(programming_language)).
Kotlin knows all these things that I implemented here. For instance,
take the first example (see below): reverse the digits of an integer,
and the result must also be an integer: `val res = number.toString().reversed().toInt()`.
Kotlin is quite similar to Python, it runs on the JVM, much simpler than
Java, and fun to use. Try Kotlin!

**New (Jan 9, 2017):** This project is not maintained anymore. It was fun
for 2 weeks, but then I realized I won't use it. If you want to add something
to it, make a fork. Thanks.

PyJava
======

PyJava is a small Java library that aims to bring some Python to Java land.
If you are familiar with Python, then with PyJava you can code
in Java similar to Python. PyJava tries to bring some fun to Java
users.

Let's start with some examples to see what it looks like. First:

    // Write a function that receives a whole number (integer) and
    // returns its reverse as a whole number.

    int reverse(int n) {
        return Py.to_int(Py.str.reverse(Py.to_str(n)));
    }

    Py.print(2016);             // 2016
    Py.print(reverse(2016));    // 6102

Second:

    // Using a for loop, print the lower case letters of the English alphabet:
    //
    // a b c d e f g h i j k l m n o p q r s t u v w x y z

    int start = Py.ord('a');
    int end = Py.ord('z');

    for (int i = start; i <= end; ++i) {
        Py.print(Py.chr(i), " ");    // " " means: end=" "
    }
    Py.print();

Third:

	// removing duplicates
	//
	// Consider the following list: [5, 2, 3, 5, 1, 4, -200, 5, 1, 3, 2, 2, 5] .
	// Remove the duplicates, i.e. an element should be present in the list maximum once.
	// Let the result be a sorted list.

	List<Integer> li = Py.as_list(5, 2, 3, 5, 1, 4, -200, 5, 1, 3, 2, 2, 5);
	Py.print(Py.sorted(Py.to_list(Py.to_set(li))));

See the `.../pyjava/examples` package for more examples.

But why?
--------
I know about Jython and Groovy, but I wanted to use plain Java.
I also wanted something lighweight, nothing complicated, that is
familiar to Python programmers. This project was made for fun,
so I don't think anyone should program in Java like this :)
But sometimes I need to use Java, and I always miss the
Python goodies. That's why this library was born.

How to use it?
--------------
Simply import the class `Py`:

    import com.github.jabbalaci.pyjava.Py;

All its functions are static, so there is no need to instantiate it.
`Py` contains the built-in functions of Python (some of them).
String-related functions (that are in Python's `str` class) are
in `Py.str`. As an alternative, you can also use the class `PyStr`.
List-related functions (that are in Python's `list` class) are
in `Py.list`. As an alternative, you can also use the class `PyList`.

Python to PyJava
================

Built-in functions
------------------

    Python                             PyJava                     remark
    ======                             ======                     ======

    print(...)                         Py.print(...)              newline added
    print(..., end=" ")                Py.print(..., " ")         specify the end character
    print()                            Py.print()                 print just a newline
    print("...".format(...))           Py.printf(...)             shortcut for System.out.printf(...)
    input()                            Py.input()                 read from stdin
    input(prompt)                      Py.input(prompt)           add a prompt
    str(obj)                           Py.to_str(obj)             try to convert anything to String
    int("5")                           Py.to_int("5")             convert to int
    float("3.14")                      Py.to_float("3.14")        returns a float
                                       Py.to_double("3.14")       returns a double (use this)
    range(end)                         Py.range2(end)             Python 2's range, i.e. returns a list
    range(start, end)                  Py.range2(start, end)
    range(start, end, step)            Py.range2(start, end, step)
    li = []                            List<Integer> li = Py.new_list(0)    0 is the integer type
                                       List<String> li = Py.new_list("")    "" is the String type
    min(my_list)                       Py.min(my_list)
    max(my_list)                       Py.max(my_list)
    sum(my_list)                       Py.sum(my_list)             works with int and double lists
    --                                 Py.prod(my_list)            product of the elements
                                                                   works with int and double lists
    chr(65)                            Py.chr(65)                  ASCII value to char
    ord('a')                           Py.ord('a')                 char to ASCII value
                                       Py.ord("a")
    bin(n)                             Py.bin(n)                   0b prefix is present
    --                                 Py.bin(n, false)            0b prefix is removed
    sorted(my_list)                    Py.sorted(my_list)          returns a sorted shallow copy
    sorted(my_list, reverse=True)      Py.sorted(my_list, true)    descending order
    reversed(my_list)                  Py.reversed(my_list)        returns a reversed shallow copy
    li = [6, 4, 3]                     List<Integer> li = Py.as_list(6, 4, 3)
    li = ["aa", "bb", "cc"]            List<String> li = Py.as_list("aa", "bb", "cc")
    list("pyjava")                     Py.to_list("pyjava")        explode to characters (1-long strings, actually)
    list(set(1, 1, 2))                 Py.to_list(Set set)
    set([1, 3, 6])                     Set<Integer> bag = Py.to_set(Py.as_list(1, 3, 6))
    print("-" * 20)                    Py.sep("-", 20)             print a separator line


PyStr class (available as Py.str too)
------------------------------------------

    Python                             PyJava                               remark
    ======                             ======                               ======

    str.capitalize("john")             Py.str.capitalize("john")
    "pyjava"[::-1]                     Py.str.reverse("pyjava")
    "-" * 20                           Py.str.repeat("-", 20)
    str.center("py", 10)               Py.str.center("py", 10)
    str.split("aa:bb", ":")            Py.str.split("aa:bb", ":")           returns a List<String>
    str.split("  a  b ")               Py.str.split("  a  b ")              split by whitespaces
    str.join(":", ["a", "b"])          Py.str.join(":", List<String> li)


PyList class (available as Py.list too)
---------------------------------------

    Python                             PyJava                        remark
    ======                             ======                        ======

    my_list.sort()                     Py.list.sort(my_list)         sort in place
    my_list.sort(reverse=True)         Py.list.sort(my_list, true)   descending order
    my_list.reverse()                  Py.list.reverse(my_list)      reverse in place


TODO
====

Unit tests are added but the documentation is not yet perfect. Generating the javadoc
(with `maven javadoc:javadoc` for instance) fails. Contributions are welcome here :)

Contributors
------------

[Peter Jeszenszky](https://github.com/jeszy75)
