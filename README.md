# Project Based Learning (Java)

This is a temporary repository containing work done in Project Based Learning Lab, SY Sem 4 B.Tech Engineering.

## Assignment 1

### Part 1 - PBL_1.java

Implement a menu-driven Java program (like fib or factorial) to implement these input methods in java (command line args, Scanner, BufferedReader, DataInputStream, Console)

### Part 2 - PBL_1_2.java & Calculator.java

Implement a simple menu driven calculator in java to implement addition, subtraction, multiplication, division, square root, power, mean, variance. Implement a separate Calculator class to include all related function inside that class. (For mean calculation: Program reads numbers from the keyboard, summing them in the process until the user enters the string “end”. It then stops input & displays the avg. of numbers)

### Part 3 - PBL_1_3.java

Find the GCD of two integers. By definition, GCD(a, b) is the greatest factor that divides both a and b. Assume that a and b are positive integers, and a ≥ b, the Euclid's algorithm is based on these two properties:

GCD(a, 0) = a

GCD(a, b) = GCD(b, a mod b)

where (a mod b) denotes the remainder of a divides by b.

## Assignment 2 - PBL_2.java

Implement the following four programs to understand basic concepts of operators, arrays
in Java
* W.A.P that declares two arrays named ‘even’ and ‘odd’. Accept numbers from the user and move them to respective arrays depending on whether they are even or odd.
* Write a Java program to find the second smallest element in an array.
* Write a Java program to convert an Array to ArrayList.
* Write a Java program to convert an ArrayList to an Array.

## Assignment 3

### Part 1 - PBL_3_1.java & Student.java

Write a menu-driven Java Program to study the concepts of classes, array of objects, instancemembers, constructors in java.

Assignment description: ​Create a Student class describing attributes of a student like prn, name, DoB, marks etc.

DOB is created as a separate class and each Student will have a DoB. Write a suitable constructors (parameterized, default) Create an array/ArrayList of objects of Student class and perform operations like: Add students, Display, Search (by prn, by name, by position), Update/Edit and Delete. For each student, compute the total marks ranging from 0 - 100.

Then compute and print the number of students who have obtained marks in the range:
* 81 – 100 ‘A’
* 61 – 80 ‘B+’
* 41- 60 ‘B’
* 0 – 40 ‘C’
* <40 ‘F’

Display a ​sorted list of students, sorted based on total marks.

*(Hint: Use the Comparator & Iterator classin java). The entire program should be written in Object Oriented Programming style.*

### Part 2 - PBL_3_2.java & Employee.java

The Employee information you must track is as follows:
ID
* Name
* Sex
* Job Title
* Organization they work for

Implement following using vectors
* ​​Add employee
* ​​Delete Employee
* ​​Compare two employees (by salary)
* ​​Search employee (By Id, Name)​
* ​​Sort (by Names, Use Comparator)

*Also have a method to keep a count of number of instances created for the Employee class.(Use: static)*

## Assignment 4 - PBL_4.java, Card.java & Deck.java

Write a menu-driven Java Program for the following:

There are 52 cards in a deck, each of which belongs to one of four suits and one of 13 ranks. Represent a deck of cards as an array of Objects *(you may use the ArrayList class)*

* Use integers to encode the ranks and suits (1 pt)
* Have suitable default & parameterized constructors (2 pt)
* All data members to have private access (1 pt)
* The class ‘Card’ to have following methods: (4 pt)
    * createDeck()
    * printCard()
    * printDeck ()
    * sameCard()
    * compareCard()
    * sortCard()
    * findCard() which searches through an array of Cards to see whether it contains a certain card
    * dealCards() function: To print 5 random cards from the existing deck. (1 pt)
* Illustrate the use of Garbage Collection in java by including suitable code (1 pt)