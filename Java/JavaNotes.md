# The Ultimate Java Study Guide: A Deep Dive

## Part 1: Java Fundamentals

### 1. Introduction & Core Concepts

#### The `main` Method Signature

The entry point of every Java application is the `main` method. Its signature is `public static void main(String[] args)`. Let's break it down:

- **`public`**: An access modifier. `public` means this method is accessible from anywhere in the application, specifically by the JVM which exists outside your project's scope.
- **`static`**: This keyword means the method belongs to the class itself, not to a specific object (instance) of the class. The JVM can call this method without having to create an object of your class first.
- **`void`**: This is the return type. `void` means the method does not return any value.
- **`main`**: The name of the method, which is a special name recognized by the JVM.
- **`String[] args`**: The parameter. This is an array of `String` objects that allows you to pass arguments to your program from the command line.

**Example: Command-Line Arguments**

```java
// Save as Main.java
public class Main {
    public static void main(String[] args) {
        System.out.println("Total arguments: " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("Argument " + i + ": " + args[i]);
        }
    }
}
```

- **Compile:** `javac Main.java`
- **Run:** `java Main arg1 "second argument" 123`
- **Output:**
  ```
  Total arguments: 3
  Argument 0: arg1
  Argument 1: second argument
  Argument 2: 123
  ```

#### The Compilation & Execution Process

Java's "Write Once, Run Anywhere" (WORA) philosophy is enabled by a two-step process:

1.  **Compilation:**

    - **Source Code (`.java` file):** This is the human-readable code you write.
    - **Java Compiler (`javac`):** This tool, part of the JDK (Java Development Kit), compiles your source code. It checks for syntax errors.
    - **Bytecode (`.class` file):** The output of the compiler. It's a highly optimized set of instructions, not for a specific CPU, but for the **JVM**. A separate `.class` file is generated for every class in your `.java` file.

2.  **Execution (Interpretation):**
    - **JVM (Java Virtual Machine):** This is an abstract computing machine that enables a computer to run a Java program. The JVM is platform-dependent (there's a different JVM for Windows, macOS, Linux).
    - **Class Loader:** When you run the program (`java MyClass`), the JVM's class loader loads the bytecode for `MyClass` into memory.
    - **Bytecode Verifier:** It checks the bytecode for security issues and ensures it adheres to JVM specifications.
    - **Interpreter/JIT Compiler:**
      - The **Interpreter** reads the bytecode and translates it into native machine code line by line.
      - The **JIT (Just-In-Time) Compiler** is a key optimization. It identifies "hotspots" (frequently executed code) and compiles them into native machine code all at once. This makes subsequent calls to that code much faster.

### 2. Variables, Data Types, and Memory

- **Instance Variables (Fields):**

  - **Scope:** Declared inside a class but outside any method.
  - **Lifecycle:** Tied to the object's lifecycle. Created when an object is instantiated, destroyed when the object is garbage collected.
  - **Memory:** Stored in the **Heap**.
  - **Default Values:** They are automatically initialized with default values if not explicitly assigned.
    - Numeric (`byte`, `short`, `int`, `long`): `0`
    - Floating-point (`float`, `double`): `0.0`
    - `char`: `'\u0000'` (null character)
    - `boolean`: `false`
    - Object References (`String`, etc.): `null`

- **Local Variables:**
  - **Scope:** Declared inside a method, constructor, or block.
  - **Lifecycle:** Exist only as long as the method is executing.
  - **Memory:** Stored in the **Stack**.
  - **Default Values:** **None.** They must be explicitly initialized before being used, or a compile-time error will occur.

```java
class Car {
    // Instance variables (have default values)
    private String model; // default is null
    private int year;     // default is 0

    public void display(String owner) { // 'owner' is a local variable
        // 'message' is a local variable and must be initialized
        String message = owner + "'s car is a " + year + " " + model;
        System.out.println(message);
    }
}
```

- **Primitive Types vs. Reference Types:**

  - **Primitive Types:** Store the actual value directly in the memory location (stack for local, heap for instance).
    - `byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean`.
  - **Reference Types:** Store a reference (a memory address or "pointer") to the location in the heap where the actual object data is stored.
    - `String`, `Arrays`, and all class objects.

  ```java
  int a = 10; // 'a' contains the value 10
  int b = a;  // 'b' gets a copy of the value 10. 'a' and 'b' are independent.

  Car car1 = new Car(); // 'car1' contains the memory address of the new Car object.
  Car car2 = car1;     // 'car2' gets a copy of the memory address. Both point to the SAME object.
  ```

- **Wrapper Classes:**
  - Every primitive type has a corresponding wrapper class in the `java.lang` package (e.g., `int` -> `Integer`, `char` -> `Character`).
  - **Purpose:** To allow primitives to be used in contexts where objects are required (e.g., in Collections like `ArrayList<Integer>`).
  - **Autoboxing & Unboxing:** The automatic conversion between primitives and their wrapper classes.
    - **Autoboxing:** `int` to `Integer`. `Integer i = 100;`
    - **Unboxing:** `Integer` to `int`. `int j = i;`

### 3. Type Casting, Conversion & Promotion

- **Type Conversion (Widening Casting):** Automatic and safe.

  - `byte` → `short` → `int` → `long` → `float` → `double`

- **Type Casting (Narrowing Casting):** Manual and risky (potential data loss).

  - **Data Loss:** When casting a floating-point number to an integer, the fractional part is truncated.
    ```java
    double d = 9.78;
    int i = (int) d; // i becomes 9
    ```
  - **Data Overflow (Wraparound):** When casting a larger integer type to a smaller one, the value wraps around based on the smaller type's range. The calculation is effectively `value % range_of_smaller_type`.
    ```java
    int i = 257; // Binary: 00000001 00000001
    byte b = (byte) i; // Byte can only hold 8 bits, so the leading part is truncated.
                       // Becomes 00000001, which is 1.
    System.out.println(b); // Output: 1
    ```

- **Type Promotion in Expressions:**
  - To prevent precision loss and overflow during calculations, Java automatically promotes smaller data types (`byte`, `short`, `char`) to `int` before performing an arithmetic operation.
  - If an operation involves different types, the result is promoted to the larger type.
    - `int + long` → `long`
    - `long + double` → `double`

---

## Part 2: Object-Oriented Programming (OOP) in Java

### 1. The Four Pillars of OOP

#### a) Encapsulation

- **Concept:** Bundling data (instance variables) and the code that operates on that data (methods) into a single unit (the class). It's also about **data hiding**—protecting an object's internal state from unauthorized access.
- **Implementation:**
  1.  Declare all instance variables as `private`.
  2.  Provide `public` **getter** (accessor) and **setter** (mutator) methods to control access to the variables.
- **Benefits:**
  - **Control:** Setters can include validation logic to ensure data remains in a valid state.
  - **Security:** Prevents external code from corrupting an object's state.
  - **Flexibility & Maintainability:** The internal implementation can change without affecting the code that uses the class, as long as the public methods remain the same.

```java
public class BankAccount {
    private double balance; // Hidden from the outside world

    public double getBalance() { // Getter provides read-only access
        return this.balance;
    }

    public void deposit(double amount) { // Setter provides controlled modification
        if (amount > 0) {
            this.balance += amount;
        }
    }
}
```

#### b) Inheritance

- **Concept:** A mechanism where a new class (subclass/child) derives properties and behaviors from an existing class (superclass/parent). This models an "**is-a**" relationship (a `Dog` is-an `Animal`).
- **Implementation:** Using the `extends` keyword.
- **Key Points:**
  - A subclass inherits all non-private members of the superclass.
  - Constructors are **not** inherited. The subclass must call the superclass constructor using `super()`. This call is implicitly made if you don't add it.
  - **The Diamond Problem:** This is why Java does not support multiple inheritance of _classes_. If class `C` could extend both `A` and `B`, and both `A` and `B` have a method `doWork()`, the compiler wouldn't know which version `C` should inherit, causing ambiguity. This is solved using interfaces.

```java
class Animal { // Superclass
    public void eat() {
        System.out.println("This animal eats food.");
    }
}

class Dog extends Animal { // Subclass
    public void bark() {
        System.out.println("The dog barks.");
    }
}
```

#### c) Polymorphism

- **Concept:** "Many forms." The ability of an object to take on many forms. In Java, this means a single action can be performed in different ways.
- **Types:**

  1.  **Compile-Time Polymorphism (Static Binding / Method Overloading):**
      - Having multiple methods in the same class with the same name but different **method signatures** (different number, type, or order of parameters).
      - The correct method to call is resolved at **compile time**.
      ```java
      class Calculator {
          int add(int a, int b) { return a + b; }
          double add(double a, double b) { return a + b; }
      }
      ```
  2.  **Run-Time Polymorphism (Dynamic Binding / Method Overriding):**

      - A subclass provides its own specific implementation of a method that is already defined in its superclass.
      - The method signature must be identical. The `@Override` annotation is used to ensure correctness.
      - This is achieved through a parent class reference variable holding a child class object. The JVM determines which method to execute at **runtime** based on the actual object type.

      ```java
      class Animal {
          public void makeSound() { System.out.println("Generic animal sound"); }
      }
      class Cat extends Animal {
          @Override
          public void makeSound() { System.out.println("Meow"); }
      }

      // Runtime Polymorphism in action
      Animal myPet = new Cat(); // Parent reference, Child object
      myPet.makeSound(); // Output: "Meow". JVM calls the Cat's method.
      ```

#### d) Abstraction

- **Concept:** Hiding complex implementation details and exposing only the essential functionalities to the user. It focuses on _what_ an object does, rather than _how_ it does it.
- **Implementation:** Achieved through `abstract` classes and `interfaces`.

### 2. Abstract Classes vs. Interfaces

| Feature         | Abstract Class                                                                                                                                                      | Interface                                                                                                                         |
| --------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------- |
| **Purpose**     | To provide a common base class with some shared, default implementation and some abstract methods to be implemented by children. Models an **"is-a"** relationship. | To define a contract of capabilities. It specifies _what_ a class can do, but not _how_. Models a **"can-do"** relationship.      |
| **Inheritance** | A class can `extends` **only one** abstract class.                                                                                                                  | A class can `implements` **multiple** interfaces.                                                                                 |
| **Methods**     | Can have `abstract` methods (no body) and concrete methods (with a body).                                                                                           | Pre-Java 8: Only `public abstract` methods. <br> Java 8+: Can also have `public default` and `public static` methods with bodies. |
| **Variables**   | Can have instance variables of any type (`final`, non-`final`, `static`, non-`static`).                                                                             | Variables are implicitly `public static final` (they are constants).                                                              |
| **Constructor** | **Has a constructor**. It cannot be instantiated directly, but the constructor is called by subclasses using `super()`.                                             | **Does not have a constructor.**                                                                                                  |
| **When to Use** | When you want to share code among several closely related classes.                                                                                                  | When you want to specify a behavior that disparate classes can implement (e.g., `Comparable`, `Runnable`).                        |

### 3. Strings: Immutable Objects

- **Immutability Explained:** Once a `String` object is created in memory, its internal character array cannot be changed. Any operation that appears to modify a string (like `concat` or `substring`) actually creates and returns a **new** `String` object.
- **String Pool (String Constant Pool):**
  - A special memory area in the Java Heap.
  - When you create a string literal (e.g., `String s1 = "Java";`), the JVM checks the pool. If "Java" already exists, it returns a reference to the existing object. If not, it creates it in the pool.
  - This saves memory by promoting reuse.
- **`==` vs. `.equals()` for Strings:**

  - `==`: Compares object references (memory addresses).
  - `.equals()`: Compares the actual character sequences of the strings.

  ```java
  String s1 = "Hello"; // Created in the pool
  String s2 = "Hello"; // Reuses the object from the pool
  String s3 = new String("Hello"); // Forces creation of a new object in the heap

  System.out.println(s1 == s2);      // true (both point to the same pool object)
  System.out.println(s1 == s3);      // false (s3 is a different object in the heap)
  System.out.println(s1.equals(s3)); // true (the content is the same)
  ```

- **Mutable String Classes:**
  - **`StringBuilder`:** **Not thread-safe**. It is faster because it doesn't have the overhead of synchronization. It should be your default choice for string manipulation in a single-threaded context (like building a long string inside a method).
  - **`StringBuffer`:** **Thread-safe**. All its public methods are `synchronized`. It should be used when a mutable string is shared and modified by multiple threads.

---

## Part 3: Advanced Java Concepts (Full Details)

### 1. Exception Handling

- **Hierarchy Deep Dive:**

  - `java.lang.Throwable`: The root class for all errors and exceptions.
    - `java.lang.Error`: Represents serious, unrecoverable problems that an application should not try to catch. Examples: `OutOfMemoryError`, `StackOverflowError`.
    - `java.lang.Exception`: Represents conditions that a reasonable application might want to catch.
      - **Checked Exceptions:** Subclasses of `Exception` (but not `RuntimeException`). The compiler **checks** that you handle them. They represent external, recoverable conditions.
        - **Examples:** `IOException`, `SQLException`, `ClassNotFoundException`.
        - **Handling:** You must either wrap the code in a `try-catch` block or declare the exception in the method signature using the `throws` keyword.
      - **Unchecked (Runtime) Exceptions:** Subclasses of `RuntimeException`. The compiler does **not** check if you handle them. They typically represent programming errors.
        - **Examples:** `NullPointerException`, `ArrayIndexOutOfBoundsException`, `IllegalArgumentException`, `ArithmeticException`.
        - **Handling:** You _can_ catch them, but the best practice is often to fix the underlying code to prevent them from occurring in the first place.

- **Handling Keywords:**

  - **`try`**: The block of code to be monitored for exceptions.
  - **`catch`**: The block that is executed if an exception of a specified type occurs in the `try` block. You can have multiple `catch` blocks for different exception types.
  - **`finally`**: This block is **always** executed, whether an exception is thrown or not. It's crucial for resource cleanup (closing files, network connections, etc.) to prevent resource leaks.
  - **`throw`**: Used to manually or explicitly throw an exception object. `throw new IllegalArgumentException("Amount must be positive");`
  - **`throws`**: Used in a method signature to declare that the method might throw one or more checked exceptions. It delegates the responsibility of handling the exception to the calling method.

- **Try-with-Resources (Java 7+):**

  - **Problem it solves:** Before Java 7, resource cleanup in the `finally` block was verbose and error-prone (the `close()` method itself could throw an exception).
  - **Solution:** A `try` statement that declares one or more resources. A resource is an object that must be closed after the program is finished with it (it must implement the `AutoCloseable` or `Closeable` interface).
  - The JVM automatically calls the `close()` method on the resources in the reverse order of their creation, ensuring they are always closed.

  ```java
  // Old way with finally
  FileReader fr = null;
  try {
      fr = new FileReader("file.txt");
      // ... read file
  } catch (IOException e) {
      // ... handle error
  } finally {
      if (fr != null) {
          try {
              fr.close();
          } catch (IOException e) {
              // ... handle close error
          }
      }
  }

  // New way with try-with-resources
  try (FileReader fr = new FileReader("file.txt")) {
      // ... read file. 'fr' will be closed automatically.
  } catch (IOException e) {
      // ... handle error
  }
  ```

### 2. Collections Framework

- **Interface Hierarchy:**
  - `Iterable` (root): Guarantees the class can be iterated over (e.g., in a for-each loop).
    - `Collection`: The foundation for most data structures.
      - `List`: An **ordered** sequence that allows **duplicate** elements. Access by index.
        - `ArrayList`: Backed by a dynamic array. Fast random access (`get(index)` is O(1)). Slow for insertions/deletions in the middle (O(n)).
        - `LinkedList`: Backed by a doubly-linked list. Slow random access (O(n)). Fast insertions/deletions (O(1)).
        - `Vector`: A legacy, synchronized version of `ArrayList`. Slower. Generally replaced by `ArrayList`.
      - `Set`: A collection that contains **no duplicate** elements.
        - `HashSet`: Unordered. Uses `hashCode()` for storage. Offers O(1) time complexity for `add`, `remove`, `contains`.
        - `LinkedHashSet`: Ordered. Maintains insertion order. Slower than `HashSet`.
        - `TreeSet`: Sorted. Elements are ordered according to their natural ordering or a supplied `Comparator`. Slower (O(log n)) but provides sorted iteration.
      - `Queue`: A collection designed for holding elements prior to processing.
        - `PriorityQueue`: Elements are ordered based on priority (natural order or `Comparator`).
  - `Map`: An object that maps **unique keys** to **values**.
    - `HashMap`: Unordered. Uses `hashCode()`. O(1) performance for `get`/`put`. Allows one `null` key and multiple `null` values.
    - `LinkedHashMap`: Ordered. Maintains insertion order.
    - `TreeMap`: Sorted. Keys are sorted.
    - `Hashtable`: A legacy, synchronized version of `HashMap`. Does not allow `null` keys or values. Slower. Generally replaced by `ConcurrentHashMap`.

### 3. Functional Programming (Java 8+)

- **Functional Interface:**

  - An interface with exactly **one abstract method (SAM)**.
  - The `@FunctionalInterface` annotation is a compile-time check to ensure this contract is met.
  - Java provides many built-in functional interfaces in the `java.util.function` package:
    - `Predicate<T>`: Takes an argument, returns a `boolean`. (`T -> boolean`). Used for filtering.
    - `Function<T, R>`: Takes an argument, returns a result. (`T -> R`). Used for mapping/transformation.
    - `Consumer<T>`: Takes an argument, performs an action, returns nothing. (`T -> void`). Used for iteration.
    - `Supplier<T>`: Takes no arguments, returns a result. (`() -> T`). Used for generating values.

- **Lambda Expression (`->`):**

  - A concise, anonymous function that provides an implementation for a functional interface.
  - **Syntax:** `(parameters) -> { body }`
  - If the body is a single expression, the braces and `return` keyword can be omitted.

  ```java
  // Before Java 8 (Anonymous Inner Class)
  new Thread(new Runnable() {
      @Override
      public void run() {
          System.out.println("Running in a thread!");
      }
  }).start();

  // With Lambda Expression
  new Thread(() -> System.out.println("Running in a thread!")).start();
  ```

- **Stream API:**
  - A sequence of elements from a source that you can process in a declarative way.
  - **Key Characteristics:**
    1.  **Not a data structure:** It doesn't store data. It carries values from a source (like a `Collection`) through a pipeline of operations.
    2.  **Declarative:** You describe _what_ you want to do, not _how_ to do it.
    3.  **Lazy:** Intermediate operations are not executed until a terminal operation is invoked.
    4.  **Possibly parallel:** Streams can be processed in parallel with minimal code changes (`.parallelStream()`).
  - **Pipeline Structure:**
    1.  **Source:** e.g., `myList.stream()`
    2.  **Intermediate Operations (0 or more):** These return a new stream.
        - `filter(Predicate<T>)`: Selects elements that match a criteria.
        - `map(Function<T, R>)`: Transforms each element.
        - `sorted()`: Sorts the elements.
        - `distinct()`: Removes duplicates.
    3.  **Terminal Operation (1):** This produces a result or a side-effect and closes the stream.
        - `forEach(Consumer<T>)`: Performs an action for each element.
        - `collect(Collectors.toList())`: Gathers elements into a `List`.
        - `reduce()`: Combines all elements into a single result.
        - `count()`: Returns the number of elements.
        - `anyMatch()`, `allMatch()`, `noneMatch()`: Return a boolean.

---

## Part 4: Critical Interview Topics (Deepest Dive)

### 1. The `equals()` and `hashCode()` Contract

This is arguably one of the most important core Java concepts.

- **The Problem:** Hash-based collections (`HashMap`, `HashSet`, `Hashtable`) use an object's `hashCode()` to determine where to store it in memory (which "bucket").
- **The Contract:**
  1.  **If `obj1.equals(obj2)` is true, then `obj1.hashCode()` MUST be equal to `obj2.hashCode()`**.
      - **Why?** If two objects are equal, they must be stored in the same bucket in a `HashMap`. If they had different hash codes, the map would look in the wrong bucket and would never find the object.
  2.  **If `obj1.hashCode()` is equal to `obj2.hashCode()`, `obj1.equals(obj2)` is NOT required to be true.**
      - **Why?** This is called a **hash collision**. It's acceptable for two different objects to end up in the same bucket. When this happens, the `HashMap` will iterate through the list (or tree) in that bucket and use the `.equals()` method to find the correct object.
- **Consequences of Breaking the Contract:** If you override `equals()` but not `hashCode()`, you will not be able to reliably retrieve objects from a `HashMap` or `HashSet`.

  ```java
  // You add an object to a HashSet.
  mySet.add(myObject); //
  // The set calculates hashCode() to find the bucket and stores it.

  // You check if the object exists.
  mySet.contains(myObject);
  // The set calculates hashCode() again to find the right bucket to look in.
  // If you changed equals() but not hashCode(), the hashCode() might be different
  // from the default, or just inconsistent, and the set would look in the wrong bucket.
  ```

- **Correct Implementation:**

  ```java
  import java.util.Objects;

  public class User {
      private final int id;
      private final String username;
      // constructor...

      @Override
      public boolean equals(Object o) {
          if (this == o) return true; // Are they the same object in memory?
          if (o == null || getClass() != o.getClass()) return false; // Are they the same type?
          User user = (User) o;
          // Check if the business key fields are equal
          return id == user.id && Objects.equals(username, user.username);
      }

      @Override
      public int hashCode() {
          // Use the same fields that were used in the equals() method
          return Objects.hash(id, username);
      }
  }
  ```

### 2. Creating an Immutable Class

An immutable object is one whose state cannot be changed after it's created. This is highly desirable in multi-threaded environments as it is inherently thread-safe.

- **Steps to Create an Immutable Class:**

  1.  Declare the class as `final` so it cannot be extended.
  2.  Make all fields `private` and `final`. This forces them to be initialized in the constructor and prevents them from being reassigned.
  3.  Do not provide any "setter" methods.
  4.  **Perform defensive copies for any mutable object fields.** This is the most critical and often forgotten step.
      - In the constructor, create a new copy of any mutable objects passed in.
      - In the getter for a mutable object, return a new copy, not a reference to the internal object.

- **Example with Defensive Copying:**

  ```java
  import java.util.Date;

  public final class ImmutablePerson {
      private final String name;
      private final Date birthDate; // Date is a mutable object!

      public ImmutablePerson(String name, Date birthDate) {
          this.name = name;
          // 1. Defensive copy on input
          this.birthDate = new Date(birthDate.getTime());
      }

      public String getName() {
          return name;
      }

      public Date getBirthDate() {
          // 2. Defensive copy on output
          return new Date(this.birthDate.getTime());
      }
  }
  ```

### 3. Internal Working of `HashMap`

- **Data Structure:** A `HashMap` internally uses an array of `Node` objects, called `table`. Each element of this array is a "bucket". A `Node` holds the hash, key, value, and a reference to the next `Node`.
- **The `put(K key, V value)` Process:**

  1.  **Null Key:** If the `key` is `null`, it's stored in a special place, usually at `table[0]`.
  2.  **Calculate Hash:** The `key.hashCode()` is called. This hash is then passed through another internal hashing function to reduce collisions and determine the index (bucket) in the `table` array. `index = hash & (n-1)`, where `n` is the table size.
  3.  **Find Bucket:** The `HashMap` goes to the calculated `index`.
  4.  **Handle Collision:**
      - If the bucket at `index` is empty, a new `Node(key, value)` is created and placed there.
      - If the bucket is not empty (a collision), the `HashMap` iterates through the linked list at that bucket. For each node in the list, it checks if the key is the same using `equals()`.
        - If a matching key is found, the old value is replaced with the new value.
        - If no matching key is found, the new `Node` is added to the end of the list.
  5.  **Treeify (Java 8+):** If the number of nodes in a single bucket's linked list exceeds a threshold (`TREEIFY_THRESHOLD`, default is 8), the linked list is converted into a self-balancing Red-Black Tree. This improves the worst-case performance for search from O(n) to O(log n).

- **Resizing:**
  - The **load factor** (default 0.75) is a measure of how full the hash map is allowed to get before its capacity is automatically increased.
  - When `(number of entries) > (capacity * load factor)`, the `HashMap` is **resized**.
  - A new, larger array (usually double the size) is created, and all existing entries are **rehashed** and placed into the new buckets of the larger array. This is an expensive operation.

### 4. Concurrency & Multithreading Deep Dive

- **The `volatile` Keyword:**

  - **Solves Visibility Problem:** In a multi-core CPU environment, each core might have its own cache of memory. A thread running on Core 1 might change a variable, but a thread on Core 2 might still see the old value from its cache.
  - `volatile` ensures that any write to that variable is written directly to main memory, and any read of that variable is read directly from main memory. It establishes a "happens-before" relationship, guaranteeing visibility.
  - **Limitations:** It does **not** guarantee atomicity. An operation like `count++` is actually three steps (read, increment, write). If two threads do this at the same time on a `volatile` variable, you can still lose an update. For atomic operations, use `AtomicInteger` or `synchronized`.

- **The `synchronized` Keyword:**

  - **Provides Mutual Exclusion (Locking):** It ensures that only one thread can execute a block of code at a time. Every Java object has an intrinsic lock (a monitor).
  - **Provides Visibility:** When a thread exits a `synchronized` block, it establishes a happens-before relationship with any subsequent thread entering a `synchronized` block protected by the same lock. This guarantees that all variable changes are visible to the next thread.
  - **Types of Synchronization:**
    - **Synchronized Instance Method:** Locks on the instance (`this`) object. `public synchronized void myMethod() {}`
    - **Synchronized Static Method:** Locks on the `Class` object (`MyClass.class`). `public static synchronized void myStaticMethod() {}`
    - **Synchronized Block:** Allows for more granular locking on any object.
      ```java
      private final Object lock = new Object();
      public void myMethod() {
          synchronized(lock) {
              // ... critical section
          }
      }
      ```

- **Deadlock:**

  - A situation where two or more threads are blocked forever, each waiting for a resource held by the other.
  - **Example:**
    - Thread 1 locks Resource A and tries to acquire Resource B.
    - Thread 2 locks Resource B and tries to acquire Resource A.
  - **Prevention:** The most common strategy is to ensure that all threads acquire locks in the **same fixed order**. If both threads had to acquire Lock A before Lock B, deadlock would be impossible.

- **Executor Framework:**

  - **Problem with `new Thread()`:** Manually creating threads is inefficient. There's overhead in creating and destroying them, and you can easily crash an application by creating too many.
  - **Solution:** The Executor Framework decouples task submission from task execution. You submit `Runnable` or `Callable` tasks to an `ExecutorService`, which manages a pool of worker threads.
  - **Benefits:**
    - **Thread Pooling:** Reuses existing threads, reducing overhead.
    - **Resource Management:** Limits the number of concurrent threads.
    - **Lifecycle Management:** Provides methods to shut down the service gracefully.
    - **Handles Results:** Using `Callable` and `Future`, you can get results back from asynchronous tasks and handle exceptions.

  ```java
  ExecutorService executor = Executors.newFixedThreadPool(10); // A pool of 10 threads
  Callable<String> task = () -> {
      Thread.sleep(1000);
      return "Task finished!";
  };
  Future<String> future = executor.submit(task);

  // do other work...

  String result = future.get(); // This blocks until the task is complete
  System.out.println(result);
  executor.shutdown();
  ```
