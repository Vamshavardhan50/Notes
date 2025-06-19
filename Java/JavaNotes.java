// java notes

// Data types:
// primitive Data types and non primitive Data types

// primitive Data types:
//     Integer 
//     Float 
//     Character
//     boolean

// Integer

//   byte - 1byte
//   short - 2byte
//   int - 4byte
//   long  - 8 byte  Syntax: long num = 48.433l

// Float

//   Float - 4 bytes // Syntax: float num = 48.433f
//   double - 8bytes


// Character

//   char - 2byte in java
  
// Boolean
// True or False


// Non primitive Data types
//   Collection Framework



// Typecasting_and_typeConversion
 

// Typecasting ->explicit Conversion(done by developer)
// Type conversion ->implicit Conversion(done by compiler)


// byte a = 127;   range -> -126 to 126
// int b = 257; range -> -2147483648 to 2147483647

// widening->  a=b ❌ higher range can`t be assign to lower range 
// narrowing  ->  b=a  ✅ lower range can be assign to higher range


// Example

// class JavaNotes{
//   public static void main(String[] args) {
    
//     int a = 257;
//     byte k = (byte) a;    // convert int to byte by range 257%256
//     System.out.println(k);
//   }
// }


// Type promotion 

// class JavaNotes{
//   public static void main(String[] args) {
    
//     byte a =10;
//     byte b =30;

//     int result = a*b; --> byte * byte convert promoted to int becaause of range
//     System.out.println(result);
//   }
// }


// operators ---> learn from python ,common in all languages and same 
// types of operators and ternary operator 



// conditional statements

// //syntax
// if(conditional){

// }
// else{

// }


// switch case 

// syntax
// switch(n){
//   case 1:
//     break;
//   case 2:
//     break;
//   case 3:
//     break;
//   case 4:
//     break;
//   case n:
//     break;

// }


// loops in java
// loop --> for,while,do while,for each




// Object oriented programming 
// Object --> State and behaviours 

// creation of object 

// class_name object_name = new constructor();

// example



// class calculator{
//   public int add(int a,int b){
//     int r = a+b;
//     return r;
//   }
// }
// class JavaNotes{
//   public static void main(String[] args) {
//     calculator c = new calculator();
//     int result = c.add(4,6);
//     System.out.println(result);
//     }
//    }


// Arrays

// syntax-1D
// int num[] = new int[Size]


// syntax-2D
// int num[][] = new int[col][row];


// jagged array
// int num[][] = new int[col][];--> row or col miss we can add     

// creation of object array 

// class Student{
//   rollno = 1;
//   name="Harsha";
//   marks=74;
// }
// class JavaNotes{
//   public static void main(String[] args) {
    
//     Main syntax
//     👉 Student students[] =new Student[3 / size];  
//     students[0]=s1;
//     students[1]=s2;
//     students[2]=s3;
//   }
// }

// Example
// class JavaNotes{
//   public static void main(String[] args) {
//     int nums[] = {1,2,3,4};
//     for (int n:nums){
//       System.out.println(n);
//     }  
//   } 
// }



// String class
// String are immutable 

// strings have many methods 
// 👉 you can modify the string by two methods that are
// 1.String Buffer 
// 2.String Builder 

// 1.String Buffer

// Syntax 👉 StringBuffer objName = new StringBuffer("String")
// Methods 
// objName.length();
// objName.capacity();
// objName.append();
// objName.insert(); 


//Static Keyword
// static can be accesed by only class name only 

// To load the class we have to use Class.forname

//example

// class Mobile{
//   static String name;
//   static String rollno;
//   static{  //👉 this Method is called only once when obj is created ,One class one time called
//     name= "Phone";
//   }

//   Mobile(){
//     name = "Smartphone"; //👉 This constructor is called we an object is created

//   }
// }
// public class JavaNotes{
//   public static void main(String[] args) throws ClassNotFoundException {
//     Class.forName("Mobile");
    
//     Mobile obj1 = new Mobile();
//   }
// }



//OOP concepts

// 1.Class
// 2.objects 

//3.Encapulsation is not but the hiding the data which not useful for users
//Encapulsation 👉 Setter and getters

//Example
 
// class Human{
//   private String name;
//   private int Age;

//   public String getName() {
//     return name;
//   }
//   public void setName(String name) {
//     this.name = name;
//   }
//   public int getAge() {
//     return Age;
//   }
//   public void setAge(int age) {
//     Age = age;
//   }
// }

// class JavaNotes{
//   public static void main(String[] args) {
//     Human obj1 = new Human();
//     obj1.setName("vamsha");
//     obj1.setAge(19);
//     String Name =obj1.getName();
//     int Age =obj1.getAge();
//     System.out.println(Name +" " + Age);
//   }
// }


// This keyword and constructor you known that one
// constructor 👉 what is constructor
//             👉 Types of constructor
//                 👉 Default constructor
//                 👉 Parameterized constructor

// Inheritance
// Learn 👉 Types of Inheritance 

// Example


// class A{

// }
// class B extends A{
//   B(){

//     System.out.println("In the b class");
//   }
// }

// class JavaNotes{
//   public static void main(String[] args) {
//     B b = new B();   }
// }


// final keyword 👉 Makes the values final and u cant modify the data 

// abstract classes
 
// inner classes

// creation of obj of inner class 👉 A.B obj1 = obj.new B()

// anynomus class 👉
// syntax


// class A  {
//   public void show(){

//   }
// }
// class JavaNotes{
//   public static void main(String[] args) {
//      A obj = new A(){
//       public void show(){
//         System.out.println("new show method");
//       }
//      };
//      obj.show();
//   }
// }


// Interface

//enum

//example
// enum Status{
//   Running,Failed,Pending,Sucess
// }

// class JavaNotes{
//   public static void main(String[] args) {
//     Status[] s = Status.values();
//     System.out.println(s[0]);
//   }
// }


//Annotations 👉 Annotations are used to provide supplemental information about a program. 

//Examples

// @Override
// @Deprecated
// @SuppressWarnings


// Functional Interface 👉 is also called Single Abstract Method (SAM) interface

// only one method is allowed in interface 

// @FunctionalInterface
// interface A{
//   void show();
//   void run();
// } 



// lambda expression 
// 👉 A lambda expression in Java provides a concise way to represent an anonymous function, which is a function without a name.

// Denoted by 👉 "->"


// @FunctionalInterface
// interface A{
//   void show();
// }
// class JavaNotes{
//   public static void main(String[] args) {
//     A obj =() ->
//       {
//         System.out.println("In A show");
//       };
//     obj.show();
//   }
// }



// lambda expression  with return 

// @FunctionalInterface
// interface A{
//   int show(int i,int j);
// }
// class JavaNotes{
//   public static void main(String[] args) {
//     A obj =(i, j) -> i +j;  (or) A obj = (i,j)->{return i+j;}
//     int result = obj.show(4,6);
//     System.out.println(result);
//   }
// }


// Types of Interface
// 1)Normal Interface/SAM
// 2)FunctionalInterface 👉 only one method is allowed in interface 
// 3)Marker interface  👉 Blank interface/ No methods

//exception in Java
// 1) compile time error
// 2)Run time error
// 3)Logical error 


// Exceptional Handling using Try and catch block

//Example

// public class JavaNotes {
//   public static void main(String[] args) {
//     int i=5, j=10;
//     int result;
//     try{
//       result = j/i;
//       System.out.println(result);
//     }
//     catch(Exception e){
//       System.out.println("Something went wrong....");
//     }
//   }
// }

// Exception Hierachy 👉 Learn from Google just only the Hierachy

//Throw 👉 It is used to explicitly throw an exception.
//Throws 👉 It is used to declare that a method might throw one or more exceptions.

//👉 try with finally / Resources👉which means closing of db or file
//Finally block 👉 Always execute and run 

//Example

// try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
    // The reader will automatically close after the try block
// }

// User input from BufferReader and scanner class 

// System.out.println("Hello") 👉 Which is used to print the data to console
// int num = System.in.read()  👉 which read the int value but return the ASCII value of the number or char

// 1)Buffer Reader 👉 can be exceuted by 👇

// import java.io.*;
// class JavaNotes{
//   public static void main(String[] args) throws IOException {
//     InputStreamReader in = new InputStreamReader(System.in);
//     BufferedReader bf = new BufferedReader(in);

//     bf.close();
//   }
// }


//2)Scanner class

// import java.util.Scanner;

// class JavaNotes{
//   public static void main(String[] args) {
//     Scanner in = new Scanner(System.in);
      // int num = in.nextInt();
//   }
// }


// Threads 👉 A thread in Java represents an independent flow of execution within a program, enabling concurrent execution of multiple tasks. The Java Virtual Machine (JVM) allows multiple threads to run concurrently within an application


// multiple Threads 

// public class JavaNotes {
//  public static void main(String[] args) {
//     Runnable obj = ()->{
//         for(int i=0;i<10;i++){
//             System.out.println("Hi");
//             try {
//                 Thread.sleep(1000);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }
//     };
//     Runnable obj1 = ()->{
//         for(int i=0;i<10;i++){
//             System.out.println("Hello");
//             try {
//                 Thread.sleep(2000);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }
//     };
//     Thread t1= new Thread(obj);
//     Thread t2= new Thread(obj1);
//     t1.start();
//     t2.start();
//   }
// }

// Thread States 
// 1) New 👉 When a new thread is created, it is in the new state
// 2) Runnable 👉 A thread that is ready to run is moved to a runnable state
// 3) Running 👉 where the currently executing in the processor 
// 4) Waiting 👉 waiting for another thread to perform a particular action
// 5) Dead 👉 the presence of code within the application or system that don't serve any useful purpose


//Array list in java

// import java.util.*;
// class JavaNotes{
//     public static void main(String[] args) {
//         SortedSet<Integer> num = new TreeSet<Integer>();
//         num.add(3);
//         num.add(2);
//         num.add(5);
//         num.add(3);
//         num.add(8) ;
//         System.out.println(num);
//     }
// }

//Map in java

// import java.util.HashMap;
// import java.util.Map; 

// class JavaNotes{
//     public static void main(String[] args) {
//         Map<String ,Integer> s = new HashMap<>();
//         s.put("John", 90);
//         s.put("Mike", 80);
//         s.put("Sarah", 95);
//         System.out.println(s);
//     }
// }

// Comparator and Comparable 


//For each method

// import java.util.Arrays;
// import java.util.List;

// class JavaNotes {
//     public static void main(String[] args) {
//         List<Integer> num = Arrays.asList(1,2,3,4,5,6);

//         num.forEach(n->System.out.println(n));
//     }
// }

//Stream Api 👉 A stream represents a sequence of elements that supports various operations which can be pipelined to produce the desired result, without modifying the original data source

// Intermediate Operations
// filter(Predicate)
// map(Function)
// flatMap(Function)
// distinct()
// sorted()
// peek(Consumer)
// limit(long)


//Example

// import java.util.Arrays;
// import java.util.List;
// import java.util.stream.Stream;

// class JavaNotes {
//     public static void main(String[] args) {
//         List<Integer> num = Arrays.asList(1,2,3,4,5,6);
//         Stream<Integer> s1 = num.stream().filter(n->n%2==0).map(n->n*n);
//         s1.forEach(n->System.out.println(n) );
//         }
// }


//Var in java 👉 Instead of declarting the type of the variable we can can write "Var" in place of that one 

// 👉👉 But we can declare only in local but globally
// class JavaNotes{
//     public static void main(String[] args) {
//         var i =7;
//         System.out.println(i);
//     }
// }


// Sealed class in java 👉 let developers limit and control how deeply a component's type hierarchy can extend

// sealed class A permits B{

// }
// non-sealed class B extends A{

// }
// class JavaNotes{
//     public static void main(String[] args) {
        
//     }
// }


// // Record class

// 👉 A record class in Java is a special type of class designed to model data aggregates. Introduced in Java 16, it provides a concise syntax for declaring classes whose main purpose is to store data. Record classes automatically generate essential methods, reducing boilerplate code.


// Key Features

// Concise syntax: Reduces verbosity compared to traditional classes.
// Immutable: Record components are final and cannot be modified after creation.
// Automatic methods: Generates constructor, equals(), hashCode(), and toString() methods.
// Transparent data carrier: Primarily used for holding data.
// Final: Cannot be extended.
// Shallow immutability: The references of the fields are final, but the state of the referenced objects can change if they are mutable.


//example 
// record student (int id,String name){

// }
// public record JavaNotes() {
//     public static void main(String[] args) {
//         student s1= new student(16,"Vamsha");
//         System.out.println(s1);
//     }
// }