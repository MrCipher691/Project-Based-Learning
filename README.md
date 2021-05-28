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

## Assignment 5

### Part 1 - Circle.java, Rectangle.java, Shape.java, Shapes.java & Square.java

Pre-Built Code (! NOT MODIFIED YET !)

### Part 2 - PBL_5_2.java, Account.java, savingAcc.java & accDetail.java

Program to implement multilevel inheritance. Create class Account with cust_name and account_number as instance variables and write getdata and putData()  methods which will take customer name and account number and will display the same using putData method. Create another class savingAcc that extends class Account with min_balance and sav_bal as instance variables and getdata() and putData() method to take instance variables as well as call base class methods in respective getData and putData methods. Create another class accdetail with deposits and withdrawal as instance variables, getdata() and putData() method to take instance variables as well as call base class methods in respective getData and putData methods.Create separate class accountInfo which will create object of accdetail and its respective methods to get and display information.

The main part of program contains the following features:

* Creating Account
* Deleting Account
* Set Minimum Balance for an Account
* Deposit Money into Account
* Withdraw Money from Account

## Assignment 6

### Part 1 - PBL_6_1.java & Stud_data.java

Program to implement the following Multiple Inheritance.

<p align="center">
<img src="https://drive.google.com/uc?export=view&id=1L9g6UBripYWnORzijMqN-UBi_dveUjWK">
</p>

### Part 2 - DIRECTORY/PACKAGE PBL_6_2

An implementation of IntStack (integer stack) that uses fixed storage as well as "growable" using	interface.

<p align="center">
<img src="https://drive.google.com/uc?export=view&id=1SxwOhdD3toLukcEMQqpJL86DOG1zTkIQ">
</p>

Create a user defined package “pkg_Stack” where the interface is stored. The other two complete classes will need to import the package ‘pkg_Stack’ and then use it.

## Assignment 7

### Part 1 - PBL_7_1.java

A rational number is a number in the form of a/b where a and b are integers and b != 0. Rational numbers can be added, subtracted, multiplied, and divided. Write a Java application that will be able to add, subtract, multiply, divide, compare, convert to floating point, and find absolute value for rational numbers.  

Your program should be written in Object Oriented Programming style. The program should accept two rational numbers from the user using any method and output results of operations to console. Your program should solve operations efficiently and be able to recover from bad inputs. Use exception handling mechanism so as not to crash the program. 

Example Inputs:  

1234 / 5678 and 8765 / 4321 

0 / 1 and 34 / 675 

apple / 23   and  23 / 0

### Part 2 - PBL_7_2.java

Program to find the factorial of ‘n’ integers (as command line arguments CLA). Write your own exception “MyExcep” to validate integer values to be in certain range. 

Sample call: java ExceptionDemo 8 – 6 14 abcd 5 

Static main method invokes another method “factorial()” 

CLA which are strings but interpreted as integer values. 

The user-defined exception class MyExcep should have proper constructors / overridden toString() method to display exception message along with the wrong input number that had generated the exception. 

NumberFormatException and Your Exception class MyExcep( n<0 and n>12 ) 

## Assignment 8 - PBL_8.java

Create a Java Program for MySQL database connectivity. Perform following operations  

Create a table Employee with fields empno (int),ename(string),department(string) ,job(string) and salary(float). 

Add five employees to the Employee table at the time of table creation 

* EMPNO:8369, Ename:Smith, job:Manager, department:IT,Sal:80000.00 

* EMPNO:8654, Ename:Momin, job:Salesman, department:Sales ,Sal:12050.00 

* EMPNO:8839, Ename: Amir, department: Sales, job: President ,Sal:150000.00 

* EMPNO:8934, Ename:Mita, department:HR ,job:Clerk, Sal:23000.00 

* EMPNO:8900, Ename:Jatin, department:HR job:Clerk, Sal:25050.00 

Add new employee using Java program. 

Display all employees. 

Search a particular employee by using Name. 

Update employee salary using empno. 

Delete employee using empno. 

Exit 

<b>Empno will be PRIMARY KEY</b>