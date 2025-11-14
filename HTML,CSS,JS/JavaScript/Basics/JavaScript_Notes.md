## 🚀 JavaScript Notes Part - 1

📝 Compiled with ☕ and ❤️ by **Vamsha vardhan**

**GitHub:** [github.com/Vamshavardhan50](https://github.com/Vamshavardhan50)  
**LinkedIn:** [linkedin.com/in/chintha-vamsha-vardhan-4b3991253](https://www.linkedin.com/in/chintha-vamsha-vardhan-4b3991253/)

## 🟨 Chapter - 0. **Introduction to JavaScript**

---

### 📌 What is JavaScript?

- **JavaScript** is a high-level, interpreted programming language primarily used to create **interactive and dynamic** behavior on websites.
- It is one of the **core technologies of the web**, alongside **HTML** and **CSS**.
- JavaScript is **event-driven**, **prototype-based**, and **multi-paradigm** (supports object-oriented, functional, and imperative styles).

> 🔹 Originally created to make web pages interactive (e.g., image sliders, form validation, dynamic content updates).
> 🔹 Today, it powers **full-stack applications** (frontend and backend) and **native apps** using various libraries and frameworks.

---

### 🕰️ History of JavaScript

| Year     | Event                                                                                                                                      |
| -------- | ------------------------------------------------------------------------------------------------------------------------------------------ |
| **1995** | Created by **Brendan Eich** at Netscape in just 10 days; initially called **Mocha**, later renamed to **LiveScript**, then **JavaScript**. | 
| **1996** | Microsoft introduced **JScript** (its own implementation of JavaScript).                                                                   |
| **1997** | JavaScript was standardized under **ECMAScript (ECMA-262)** by **ECMA International**.                                                     |
| **2009** | **Node.js** was created by Ryan Dahl, enabling JavaScript to run on servers.                                                               |
| **2015** | **ES6 (ECMAScript 2015)** introduced major features like `let`, `const`, arrow functions, classes, promises, etc.                          |
| **Now**  | JavaScript powers web apps, mobile apps (React Native), desktop apps (Electron), and even IoT devices.                                     |

---

### 💡 Why is it called "JavaScript"?

- The name was a **marketing strategy** by Netscape to ride the popularity of **Java**, even though Java and JavaScript are **completely different languages**.
- JavaScript syntax borrows from C and Java, but their **use cases, engines, and architectures are entirely different**.

---

### 🧰 Use-Cases of JavaScript

1. **Client-side (Frontend) Web Development**

   - Dynamic UI behavior (modals, dropdowns, sliders)
   - Form validation
   - SPA (Single Page Applications) using **React**, **Vue**, **Angular**

2. **Server-side Web Development**

   - Backend APIs using **Node.js**
   - Real-time communication (e.g., chats via WebSockets)

3. **Mobile App Development**

   - Cross-platform apps using **React Native**, **Ionic**

4. **Desktop Applications**

   - Apps like **VS Code**, **Slack** built with **Electron.js**

5. **Game Development**

   - 2D/3D browser games using **Phaser**, **Three.js**

6. **Machine Learning / Data Science**

   - Libraries like **TensorFlow\.js**, **Brain.js**

7. **Internet of Things (IoT)**

   - Control hardware using Node.js and microcontrollers (e.g., Johnny-Five)

---

### 🌐 Role in Web Development

| Technology     | Role                       |
| -------------- | -------------------------- |
| **HTML**       | Structure of the webpage   |
| **CSS**        | Styling and layout         |
| **JavaScript** | Behavior and interactivity |

- JavaScript allows **real-time updates**, **DOM manipulation**, **AJAX requests**, **API integrations**, and more.
- Modern web development heavily relies on JavaScript frameworks and libraries (like **React**, **Next.js**, **Vue.js**).
- Almost every modern browser has a **JavaScript engine** (e.g., V8 in Chrome, SpiderMonkey in Firefox) to execute JS code.

---

### ✅ Summary

- JavaScript is **essential for modern web development**.
- It evolved from a simple scripting tool to a **powerful, versatile, full-stack language**.
- Learning JavaScript opens doors to a wide range of development domains — from websites to servers, apps, and even AI.

## 📌 1 . Variables and Data Types

### 🟢 Variable Declarations: `var`, `let`, `const`

#### ✅ `var` (Old way - avoid in modern code)

- **Function-scoped**
- Can be **redeclared and updated**
- Hoisted (moved to the top of their scope, but not initialized)

```js
console.log(a); // undefined (due to hoisting)
var a = 10;
```

#### ✅ `let` (Modern way)

- **Block-scoped**
- Can be **updated**, but **not redeclared** in the same scope
- Hoisted but **not initialized** (temporal dead zone)

```js
let b = 20;
b = 30; // ✅
let b = 40; // ❌ Error: Identifier 'b' has already been declared
```

#### ✅ `const` (Modern, for constants)

- **Block-scoped**
- **Cannot be updated or redeclared**
- Must be **initialized** at declaration

```js
const PI = 3.14;
PI = 3.15; // ❌ TypeError: Assignment to constant variable
```

---

### 🟣 Data Types in JavaScript

JavaScript has two main categories of data types:

### 1. 🧪 **Primitive Types** (Immutable, stored by value)

> They hold **single values** and are **copied** when assigned or passed.

| Type        | Example                      |
| ----------- | ---------------------------- |
| `String`    | `'hello'`, `"JS"`            |
| `Number`    | `42`, `3.14`, `NaN`          |
| `Boolean`   | `true`, `false`              |
| `undefined` | declared but not assigned    |
| `null`      | intentional absence of value |
| `Symbol`    | unique value (ES6)           |
| `BigInt`    | large integers: `123n`       |

```js
let str = "Hello";
let num = 100;
let isDone = false;
let nothing = null;
let notAssigned;
let big = 123456789012345678901234567890n;
let uniqueId = Symbol("id");
```

### 2. 🧱 **Reference Types** (Mutable, stored by reference)

> Objects are stored in memory and **referenced** via variables.

| Type                   | Example                     |
| ---------------------- | --------------------------- |
| `Object`               | `{ name: "John" }`          |
| `Array`                | `[1, 2, 3]`                 |
| `Function`             | `function() {}` or `()=>{}` |
| `Date`, `RegExp`, etc. | `new Date()`                |

```js
let obj = { name: "Alice" };
let arr = [1, 2, 3];
let greet = () => console.log("Hi");
```

---

### 📌 Key Difference: Primitive vs Reference

| Feature       | Primitive           | Reference                  |
| ------------- | ------------------- | -------------------------- |
| Stored by     | Value               | Reference (memory address) |
| Copy behavior | Copies actual value | Copies reference           |
| Mutability    | Immutable           | Mutable                    |

```js
let x = 10;
let y = x;
y = 20;
console.log(x); // 10 (unchanged)

let obj1 = { age: 25 };
let obj2 = obj1;
obj2.age = 30;
console.log(obj1.age); // 30 (changed via reference)
```
---
## 🧠 Chapter-2 Core Concepts

### 🔸 **Operand**

> The **values** on which an operator performs actions.

For example, in:

```js
5 + 3;
```

- `5` and `3` are **operands**
- `+` is the **operator**

---

### 🔸 **Operator**

> A **symbol** that performs an operation on operands.

In the example above:

- `+` adds the two operands.

---

### 🔸 **Operation / Result / Value**

> The **output or result** produced after applying an operator to the operands.

For:

```js
5 + 3;
```

- The **operation** is addition.
- The **result (value)** is `8`.

## 🧠 **1. Arithmetic Operators**

Used to perform mathematical operations.

| Operator | Name                | Example  | Result      |
| -------- | ------------------- | -------- | ----------- |
| `+`      | Addition            | `5 + 2`  | `7`         |
| `-`      | Subtraction         | `5 - 2`  | `3`         |
| `*`      | Multiplication      | `5 * 2`  | `10`        |
| `/`      | Division            | `5 / 2`  | `2.5`       |
| `%`      | Modulus (Remainder) | `5 % 2`  | `1`         |
| `**`     | Exponentiation      | `2 ** 3` | `8`         |
| `++`     | Increment           | `a++`    | `a = a + 1` |
| `--`     | Decrement           | `a--`    | `a = a - 1` |

---

## 🧮 **2. Assignment Operators**

Used to assign values to variables.

| Operator | Description         | Example   | Equivalent to |
| -------- | ------------------- | --------- | ------------- |
| `=`      | Assignment          | `x = 5`   | `x = 5`       |
| `+=`     | Add and assign      | `x += 2`  | `x = x + 2`   |
| `-=`     | Subtract and assign | `x -= 2`  | `x = x - 2`   |
| `*=`     | Multiply and assign | `x *= 2`  | `x = x * 2`   |
| `/=`     | Divide and assign   | `x /= 2`  | `x = x / 2`   |
| `%=`     | Modulo and assign   | `x %= 2`  | `x = x % 2`   |
| `**=`    | Exponent and assign | `x **= 2` | `x = x ** 2`  |

---

## 🧾 **3. Comparison Operators**

Used to compare two values and return a boolean.

| Operator | Description              | Example     | Result  |
| -------- | ------------------------ | ----------- | ------- |
| `==`     | Equal to (loose)         | `5 == '5'`  | `true`  |
| `===`    | Strict equal to          | `5 === '5'` | `false` |
| `!=`     | Not equal to (loose)     | `5 != '5'`  | `false` |
| `!==`    | Strict not equal to      | `5 !== '5'` | `true`  |
| `>`      | Greater than             | `5 > 3`     | `true`  |
| `<`      | Less than                | `5 < 3`     | `false` |
| `>=`     | Greater than or equal to | `5 >= 5`    | `true`  |
| `<=`     | Less than or equal to    | `3 <= 5`    | `true`  |

---

## 🔗 **4. Logical Operators**

Used to combine multiple conditions.

| Operator | Name | Description           | Example                 |                              |        |     |                |
| -------- | ---- | --------------------- | ----------------------- | ---------------------------- | ------ | --- | -------------- |
| `&&`     | AND  | True if both are true | `true && false → false` |                              |        |     |                |
| `        |      | \`                    | OR                      | True if at least one is true | \`true |     | false → true\` |
| `!`      | NOT  | Inverts the value     | `!true → false`         |                              |        |     |                |

---

## 🔀 **5. Ternary Operator**

Short form of if-else.

```js
condition ? exprIfTrue : exprIfFalse;
```

**Example:**

```js
let age = 20;
let msg = age >= 18 ? "Adult" : "Minor";
```

---

## 🔤 **6. String Operators**

| Operator | Description       | Example             | Result            |
| -------- | ----------------- | ------------------- | ----------------- |
| `+`      | Concatenation     | `"Hello" + "World"` | `"HelloWorld"`    |
| `+=`     | Append and assign | `msg += "!"`        | `msg = msg + "!"` |

---

## 🔍 **7. Type Operators**

| Operator     | Description                                 | Example                   |
| ------------ | ------------------------------------------- | ------------------------- |
| `typeof`     | Returns the data type                       | `typeof 123` → `"number"` |
| `instanceof` | Checks if object is instance of constructor | `obj instanceof Array`    |

---

## ✅ Chapter 3: Control Flow – `if-else`, `switch`, and `ternary` in JavaScript

### 🔹 1. `if`, `else if`, `else`

#### ✅ Syntax:

```js
if (condition1) {
  // Executes if condition1 is true
} else if (condition2) {
  // Executes if condition2 is true
} else {
  // Executes if none of the above conditions are true
}
```

#### ✅ How it works:

- JavaScript evaluates conditions from top to bottom.
- The **first truthy** condition gets executed; the rest are skipped.
- If no condition is met, the `else` block (if present) runs.

#### ✅ Example:

```js
let age = 18;

if (age < 13) {
  console.log("Child");
} else if (age < 20) {
  console.log("Teenager");
} else {
  console.log("Adult");
}
// Output: Teenager
```

#### 🔍 Important Notes:

- Conditions must return a **boolean** (`true` or `false`).
- Curly braces `{}` are optional for one-liners, but **recommended** for clarity.
- Can be **nested**, but avoid deeply nested `if-else` for readability.

#### ❗Common Pitfalls:

- Accidentally using `=` (assignment) instead of `==` or `===`.
- Over-nesting logic: prefer `switch` or functions when needed.

---

### 🔹 2. `switch` Statement

#### ✅ Syntax:

```js
switch (expression) {
  case value1:
    // code block
    break;
  case value2:
    // code block
    break;
  default:
  // default code block
}
```

#### ✅ How it works:

- Evaluates `expression` once.
- Compares the result with each `case` (using **strict equality** `===`).
- If matched, runs the associated block until `break` or the end.
- `default` block runs if no match is found.

#### ✅ Example:

```js
let fruit = "apple";

switch (fruit) {
  case "banana":
    console.log("Banana is yellow");
    break;
  case "apple":
    console.log("Apple is red");
    break;
  default:
    console.log("Unknown fruit");
}
// Output: Apple is red
```

#### 🔍 Important Notes:

- **Always use `break`** to avoid fall-through (unintended execution of next cases).
- `default` is **optional**, but good for handling unexpected input.

#### ❗Fall-through example:

```js
let grade = "B";

switch (grade) {
  case "A":
    console.log("Excellent");
  case "B":
    console.log("Good");
  case "C":
    console.log("Average");
  default:
    console.log("Try again");
}
// All lines will execute from "Good" onwards due to missing `break`s
```

---

### 🔹 3. Ternary Operator (`? :`)

#### ✅ Syntax:

```js
condition ? expressionIfTrue : expressionIfFalse;
```

#### ✅ How it works:

- Used as a **shortcut for `if-else`**.
- Evaluates the `condition`.
- If true → returns `expressionIfTrue`.
- If false → returns `expressionIfFalse`.

#### ✅ Example:

```js
let age = 20;
let category = age >= 18 ? "Adult" : "Minor";
console.log(category); // Adult
```

#### 🔍 Use Cases:

- Quick assignments.
- Inline rendering in JSX.
- Conditionally returning values.

#### ⚠ Avoid when:

- Logic is complex or spans multiple lines.
- Nesting ternary operators (hard to read).

#### ❗Bad Example (nested ternaries):

```js
let score = 85;
let result = score >= 90 ? "A" : score >= 80 ? "B" : "C";
// Can be confusing to read
```

---

## 🔁 Comparison Summary

| Feature     | `if-else`                                    | `switch`                            | Ternary                        |
| ----------- | -------------------------------------------- | ----------------------------------- | ------------------------------ |
| Best for    | Multiple conditions                          | Comparing single value to constants | Simple conditional expressions |
| Syntax      | Verbose but flexible                         | Cleaner for many discrete cases     | Short, inline                  |
| Performance | Similar, switch may be faster for many cases | Similar                             | Same                           |
| Readability | Good for range-based checks                  | Good for equality checks            | Only for simple checks         |

---

## 🧠 Best Practices

1. **Use `if-else`** when dealing with:

   - Ranges (e.g., `if (age < 18)`)
   - Complex logic
   - Boolean flags

2. **Use `switch`** when:

   - Comparing a single variable against many fixed values

3. **Use ternary** for:

   - Simple true/false value decisions
   - Inline JSX rendering

---

## ✅ Chapter 4: JavaScript Loops – `for loop`, `while loop`, and `do-while loop` in JavaScript

### 🔁 **`for` Loop**

The `for` loop is used when the number of iterations is known in advance.

#### ✅ Syntax:

```javascript
for (initialization; condition; increment / decrement) {
  // code to run in each iteration
}
```

#### ✅ Example:

```javascript
for (let i = 0; i < 5; i++) {
  console.log(i); // Outputs: 0 1 2 3 4
}
```

#### ✅ How it works:

1. **Initialization**: Runs once before the loop starts.
2. **Condition**: Checked before each iteration; loop runs while this is `true`.
3. **Increment/Decrement**: Updates the loop counter after each iteration.

---

### 🔄 **`while` Loop**

The `while` loop is used when the number of iterations is **not known in advance**.

#### ✅ Syntax:

```javascript
while (condition) {
  // code to run
}
```

#### ✅ Example:

```javascript
let i = 0;
while (i < 5) {
  console.log(i); // Outputs: 0 1 2 3 4
  i++;
}
```

#### ✅ How it works:

- Checks the condition **before** every iteration.
- If `condition` is `true`, runs the code inside.
- Continues until `condition` becomes `false`.

---

### 🔁 `do...while` Loop

Similar to `while`, but guarantees the loop runs **at least once**.

#### ✅ Syntax:

```javascript
do {
  // code to run
} while (condition);
```

#### ✅ Example:

```javascript
let i = 0;
do {
  console.log(i); // Outputs: 0 even if condition is false initially
  i++;
} while (i < 5);
```

---

### 🧠 Quick Tips:

- Use `for` when you know how many times to loop.
- Use `while` or `do...while` when you don’t know the exact number of repetitions.
- Always ensure your loop has a condition that eventually becomes `false` to avoid **infinite loops**.

## Chapter-5. **Functions in JavaScript**

---

A function in JavaScript is a block of reusable code designed to perform a specific task. You can think of it as a machine: you give it inputs (called arguments), it processes them, and gives you an output (a return value).

### 🔹 1. Function Declaration vs Function Expression

#### ✅ **Function Declaration**

A function declared with the `function` keyword.

```js
function greet(name) {
  return `Hello, ${name}!`;
}

console.log(greet("Alice")); // Hello, Alice!
```

**Key Points:**

- **Hoisted**: Can be called before the function is defined.
- Defined with the `function` keyword at the top level.

#### ✅ **Function Expression**

A function assigned to a variable.

```js
const greet = function (name) {
  return `Hello, ${name}!`;
};

console.log(greet("Bob")); // Hello, Bob!
```

**Key Points:**

- **Not hoisted**: Cannot be called before the line it's defined.
- Can be anonymous or named.

#### ❗ Difference Example:

```js
sayHi(); // ✅ Works
function sayHi() {
  console.log("Hi!");
}

sayHello(); // ❌ TypeError: sayHello is not a function
const sayHello = function () {
  console.log("Hello!");
};
```

---

### 🔹 2. Arrow Functions

Introduced in ES6, arrow functions are a concise way to write functions.

```js
const add = (a, b) => {
  return a + b;
};

console.log(add(2, 3)); // 5
```

#### ✅ **Implicit Return**

If the body is a single expression, it is returned automatically (no `return` keyword needed):

```js
const multiply = (a, b) => a * b;
console.log(multiply(4, 5)); // 20
```

#### ✅ **Single Parameter (no parentheses needed)**

```js
const square = (x) => x * x;
console.log(square(6)); // 36
```

#### ⚠️ **Arrow Functions vs Regular Functions**

- Arrow functions do **not have their own `this`** binding.
- Arrow functions cannot be used as **constructors**.
- You cannot use `arguments` inside an arrow function.

```js
const obj = {
  name: "Alice",
  greet: function () {
    return `Hi, I'm ${this.name}`;
  },
  badGreet: () => {
    return `Hi, I'm ${this.name}`; // ❌ `this` is not bound to `obj`
  },
};

console.log(obj.greet()); // Hi, I'm Alice
console.log(obj.badGreet()); // Hi, I'm undefined
```

---

### 🔹 3. Parameters vs Arguments

- **Parameters**: Variables listed in the function definition.
- **Arguments**: Actual values passed to the function when called.

```js
function greet(name, time) {
  // ← parameters
  return `Good ${time}, ${name}!`;
}

console.log(greet("Eve", "morning")); // ← arguments
// Good morning, Eve!
```

#### ✅ Default Parameters

You can assign default values to parameters.

```js
function greet(name = "Guest") {
  return `Hello, ${name}!`;
}

console.log(greet()); // Hello, Guest!
```

---

### 🔹 4. Return Values

A function can return a value using the `return` keyword. Once `return` is hit, the function exits.

```js
function sum(a, b) {
  return a + b;
  console.log("This won't run"); // Unreachable
}

const result = sum(5, 10);
console.log(result); // 15
```

#### ❗ Return vs console.log

- `return` sends data _out_ of the function.
- `console.log` prints to the console but doesn’t affect return value.

```js
function add(a, b) {
  console.log(a + b); // prints to console
  return a + b; // returns the value
}
```

---

### Summary Table

| Concept                 | Example                                  | Notes              |
| ----------------------- | ---------------------------------------- | ------------------ |
| Function Declaration    | `function add() {}`                      | Hoisted            |
| Function Expression     | `const add = function() {}`              | Not hoisted        |
| Arrow Function          | `const add = () => {}`                   | No own `this`      |
| Parameters vs Arguments | `function greet(name)` / `greet("John")` | Definition vs call |
| Return                  | `return a + b;`                          | Stops execution    |

---

# Chapter-6 **Scope and Hoisting in JavaScript**

## 1. 🔍 Global vs Local Scope

### ✅ **Global Scope**

- Variables declared **outside of any function or block** are in the global scope.
- Accessible **anywhere in the code** after their declaration.
- If declared using `var` in the global scope, they become properties of the `window` object in browsers.

```js
var a = 10; // global
function show() {
  console.log(a); // 10
}
show();
console.log(window.a); // 10 (in browser)
```

### ✅ **Local Scope**

- Variables declared **inside a function or block** (`{}`) are scoped to that function or block.
- They are not accessible outside that function/block.

```js
function test() {
  let x = 5; // local
  console.log(x); // 5
}
test();
console.log(x); // ReferenceError: x is not defined
```

### 🧠 Key Difference

| Feature         | Global Scope            | Local Scope                     |
| --------------- | ----------------------- | ------------------------------- |
| Accessibility   | Anywhere in the code    | Only inside the function/block  |
| Memory lifetime | Lives till program ends | Lives during function execution |

---

## 2. 🧭 Lexical Scoping

### ✅ **Definition**

- **Lexical scoping** means that the **scope of a variable is determined by its position in the source code** (during writing, not runtime).
- A function **remembers the scope** in which it was defined, not where it is executed.

```js
function outer() {
  let outerVar = "I am from outer";

  function inner() {
    console.log(outerVar); // Lexical scoping: can access outerVar
  }

  return inner;
}

const fn = outer();
fn(); // 'I am from outer'
```

### 📌 Notes:

- Lexical scope forms the foundation for **closures** in JavaScript.
- Scope is **static**, meaning it doesn't change based on the call stack.

---

## 3. 🚀 Variable Hoisting

### ✅ **What is Hoisting?**

- JavaScript **moves declarations to the top** of their scope during compilation (before execution).
- Only the **declaration** is hoisted, not the **initialization**.

### ✅ **With `var`**

```js
console.log(a); // undefined (not ReferenceError)
var a = 5;
```

- JS interprets it as:

```js
var a;
console.log(a); // undefined
a = 5;
```

### ✅ **With `let` and `const`**

```js
console.log(b); // ReferenceError (Temporal Dead Zone)
let b = 10;
```

### ⚠️ Temporal Dead Zone (TDZ)

- Time between entering scope and declaration.
- Accessing a variable in the TDZ throws an error.

### 💡 Summary

| Keyword | Hoisted | Initialized | TDZ Exists | Redeclarable |
| ------- | ------- | ----------- | ---------- | ------------ |
| `var`   | ✅      | ❌          | ❌         | ✅           |
| `let`   | ✅      | ❌          | ✅         | ❌           |
| `const` | ✅      | ❌          | ✅         | ❌           |

---

## 4. ⚙️ Function Hoisting

### ✅ Function Declarations

- **Fully hoisted** (both name and body).

```js
greet(); // "Hello"
function greet() {
  console.log("Hello");
}
```

### ✅ Function Expressions (using `var`, `let`, or `const`)

- **Only the variable** is hoisted (not the function body).
- Accessing before initialization causes error or `undefined`.

```js
sayHi(); // TypeError: sayHi is not a function
var sayHi = function () {
  console.log("Hi");
};
```

```js
sayHi(); // ReferenceError
let sayHi = function () {
  console.log("Hi");
};
```

### ✅ Arrow Functions

Behave like function expressions. Not hoisted.

---

## ✅ Final Recap

| Concept           | Behavior                                                              |
| ----------------- | --------------------------------------------------------------------- |
| Global Scope      | Declared outside all functions; accessible everywhere                 |
| Local Scope       | Declared inside a function or block; limited to that function/block   |
| Lexical Scope     | Determined by code structure at **definition**, not **execution**     |
| Variable Hoisting | `var` gets hoisted (as `undefined`), `let`/`const` hoisted but in TDZ |
| Function Hoisting | Declarations hoisted, expressions are not                             |

---

## 🔹Chapter-7 **Core JavaScript Array Concepts**

### 1. **What is an Array?**

- A data structure used to store multiple values in a single variable.
- Ordered and indexed (starts from index `0`).
- Can hold elements of **any data type**, including other arrays.

---

### 2. **Declaring Arrays**

```js
let arr1 = [1, 2, 3]; // most common
let arr2 = new Array(1, 2, 3); // less common
let emptyArr = []; // empty array
```

---

### 3. **Accessing Array Elements**

```js
let fruits = ["apple", "banana", "cherry"];
console.log(fruits[0]); // 'apple'
console.log(fruits[2]); // 'cherry'
```

---

### 4. **Modifying Elements**

```js
fruits[1] = "mango"; // change 'banana' to 'mango'
```

---

### 5. **Array Length**

```js
console.log(fruits.length); // total number of items
```

---

### 6. **Indexing Rules**

- First element is at index `0`.
- Last element is at `array.length - 1`.
- If you access an index that doesn’t exist, it returns `undefined`.

---

### 7. **Arrays Are Mutable**

```js
let a = [1, 2];
let b = a;
b[0] = 99;

console.log(a); // [99, 2] — same reference!
```

Use spread to copy:

```js
let c = [...a]; // independent copy
```

---

### 8. **Holes in Arrays (Sparse Arrays)**

```js
let arr = [1, , 3]; // index 1 is a "hole"
console.log(arr[1]); // undefined
```

---

### 9. **Arrays Can Contain Mixed Types**

```js
let mixed = [1, "hello", true, null, [5, 6]];
```

---

### 10. **Multidimensional Arrays**

```js
let matrix = [
  [1, 2],
  [3, 4],
];

console.log(matrix[1][1]); // 4
```

## 📚 chapter-8 **JavaScript Array Methods (with Examples)**

### 🔁 **Mutator Methods** (Modify the original array)

1. **push()**

- Adds item(s) to the **end** of the array.

```js
const arr = [1, 2];
arr.push(3); // [1, 2, 3]
```

2. **pop()**

- Removes the **last** item and returns it.

```js
const arr = [1, 2, 3];
arr.pop(); // returns 3, arr is now [1, 2]
```

3. **shift()**

- Removes the **first** item and returns it.

```js
const arr = [1, 2, 3];
arr.shift(); // returns 1, arr is now [2, 3]
```

4. **unshift()**

- Adds item(s) to the **beginning** of the array.

```js
const arr = [2, 3];
arr.unshift(1); // [1, 2, 3]
```

5. **splice(start, deleteCount, ...items)**

- Modifies the **original array**.
- Can **remove**, **replace**, or **insert** elements.

---

### ✅ 1. **Remove elements**

```js
const arr1 = [1, 2, 3, 4];
arr1.splice(1, 2); // removes 2 items from index 1 → [2, 3]
console.log(arr1); // [1, 4]
```

---

### 🔁 2. **Replace elements**

```js
const arr2 = [1, 2, 3, 4];
arr2.splice(1, 2, 9, 8); // remove 2 items from index 1 and add 9, 8
console.log(arr2); // [1, 9, 8, 4]
```

---

### ➕ 3. **Add elements (without deleting)**

```js
const arr3 = [1, 2, 3];
arr3.splice(1, 0, 5); // at index 1, remove 0, insert 5
console.log(arr3); // [1, 5, 2, 3]
```

---

### 🧪 4. **Remove all from a position**

```js
const arr4 = [1, 2, 3, 4, 5];
arr4.splice(2); // removes from index 2 to end
console.log(arr4); // [1, 2]
```

6. **sort(\[compareFn])**

- Sorts elements **in-place**.

```js
const arr = [3, 1, 2];
arr.sort(); // [1, 2, 3]
```

7. **reverse()**

- Reverses the array **in-place**.

```js
const arr = [1, 2, 3];
arr.reverse(); // [3, 2, 1]
```

---

### 🧪 **Accessor / Non-Mutating Methods**

8. **slice(start, end)**

- Returns a **shallow copy** of part of the array.

```js
const arr = [1, 2, 3];
arr.slice(0, 2); // [1, 2]
```

9. **concat()**

- Combines arrays, returns **new array**.

```js
const a = [1],
  b = [2];
const result = a.concat(b); // [1, 2]
```

10. **includes(value)**

- Checks if an array **contains** a value.

```js
[1, 2, 3].includes(2); // true
```

11. **indexOf(value)**

- Returns index of the value or `-1`.

```js
[1, 2, 3].indexOf(2); // 1
```

12. **join(separator)**

- Converts array to string.

```js
[1, 2, 3].join("-"); // "1-2-3"
```

---

### 🔄 **Iteration Methods**

13. **forEach(callback)**

- Executes function for each item.
- **No return value**.

```js
[1, 2].forEach((num) => console.log(num));
```

14. **map(callback)**

- Returns **new array** of transformed elements.

```js
[1, 2, 3].map((n) => n * 2); // [2, 4, 6]
```

15. **filter(callback)**

- Returns **new array** with elements that pass condition.

```js
[1, 2, 3].filter((n) => n > 1); // [2, 3]
```

16. **reduce(callback, initialValue)**

- Reduces array to a **single value**.

```js
[1, 2, 3].reduce((acc, curr) => acc + curr, 0); // 6
```

17. **find(callback)**

- Returns **first match**, or `undefined`.

```js
[1, 2, 3].find((n) => n > 1); // 2
```

18. **findIndex(callback)**

- Returns **index** of first match, or `-1`.

```js
[1, 2, 3].findIndex((n) => n > 1); // 1
```

19. **some(callback)**

- Returns `true` if **any** element passes the test.

```js
[1, 2].some((n) => n > 1); // true
```

20. **every(callback)**

- Returns `true` if **all** elements pass the test.

```js
[2, 4].every((n) => n % 2 === 0); // true
```

## 🔤 Chapter-9 **What is a String in JavaScript?**

A **string** is a **primitive data type** used to represent text. Strings are **immutable**, meaning once created, their content **cannot be changed**—any operation that seems to modify a string returns a **new string**.

---

## 🛠 2. How to Create Strings

```js
let str1 = "Hello"; // Single quotes
let str2 = "World"; // Double quotes
let str3 = `Hello ${str2}`; // Template literals (backticks)
```

### ✅ Best Practice

Use **template literals (\`)** when you need interpolation or multi-line strings.

```js
let name = "John";
let greeting = `Hi, ${name}!`;
```

---

## 🔁 3. Strings are Immutable

```js
let str = "Hello";
str[0] = "Y"; // ❌ Doesn't change the string
console.log(str); // "Hello"
```

---

## 📏 4. String Properties

- **`length`** – returns the number of characters in a string.

```js
let text = "JavaScript";
console.log(text.length); // 10
```

---

## 🧰 5. Common String Methods (at least 10+)

---

### 1. `charAt(index)`

Returns the character at the specified index.

```js
"JavaScript".charAt(4); // 'S'
```

---

### 2. `charCodeAt(index)`

Returns the Unicode of the character at a given index.

```js
"A".charCodeAt(0); // 65
```

---

### 3. `slice(start, end?)`

Extracts a section of a string and returns it as a new string.

```js
"Hello World".slice(0, 5); // "Hello"
"Hello World".slice(-5); // "World"
```

---

### 4. `substring(start, end)`

Similar to `slice()` but **doesn't support negative indices**.

```js
"JavaScript".substring(4, 10); // "Script"
```

---

### 5. `substr(start, length)`

Extracts a substring with a given length (deprecated, but still used).

```js
"JavaScript".substr(4, 6); // "Script"
```

---

### 6. `toUpperCase()` / `toLowerCase()`

Converts the string to uppercase or lowercase.

```js
"hello".toUpperCase(); // "HELLO"
"HELLO".toLowerCase(); // "hello"
```

---

### 7. `includes(substring)`

Returns `true` if the string contains the substring.

```js
"JavaScript".includes("Script"); // true
```

---

### 8. `startsWith()` / `endsWith()`

Checks whether the string starts or ends with the given substring.

```js
"JavaScript".startsWith("Java"); // true
"JavaScript".endsWith("Script"); // true
```

---

### 9. `indexOf()` / `lastIndexOf()`

Returns the position of the first/last occurrence of a value.

```js
"banana".indexOf("a"); // 1
"banana".lastIndexOf("a"); // 5
```

---

### 10. `replace(searchValue, newValue)`

Replaces the first match by default (use regex with `g` flag for all).

```js
"apple banana apple".replace("apple", "orange"); // "orange banana apple"
"apple banana apple".replace(/apple/g, "orange"); // "orange banana orange"
```

---

### 11. `trim()` / `trimStart()` / `trimEnd()`

Removes whitespace from both ends of a string.

```js
"  hello world  ".trim(); // "hello world"
"  hello world  ".trimStart(); // "hello world  "
```

---

### 12. `split(separator, limit?)`

Splits a string into an array based on a separator.

```js
"red,green,blue".split(","); // ["red", "green", "blue"]
```

---

### 13. `repeat(n)`

Repeats the string `n` times.

```js
"Hi ".repeat(3); // "Hi Hi Hi "
```

---

### 14. `padStart(targetLength, padString)` / `padEnd(...)`

Pads the string to a certain length.

```js
"5".padStart(3, "0"); // "005"
"5".padEnd(3, "*"); // "5**"
```

---

### 15. `concat(...)`

Joins strings together (less used today in favor of `+` or template literals).

```js
"Hello".concat(" ", "World"); // "Hello World"
```

---

## 🧠 6. String Internals & Unicode

- JavaScript uses **UTF-16 encoding**.
- Characters outside the Basic Multilingual Plane (BMP), like emojis, are encoded using **surrogate pairs**.

```js
"😊".length; // 2 – it's actually two UTF-16 code units
```

Use `.codePointAt()` and `for...of` to handle such cases correctly.

---

## 🧪 7. Useful Tips & Gotchas

### Checking for Empty String

```js
if (str === "") // true for an empty string
```

### Comparing Strings

```js
"apple" < "banana"; // true, lexicographic order
```

### String to Array to Modify Characters (workaround for immutability)

```js
let str = "hello";
let arr = str.split("");
arr[0] = "H";
str = arr.join(""); // "Hello"
```

---

## 📚 8. Real-World Use Cases

- **Sanitizing user input**: `.trim()`, `.toLowerCase()`
- **Creating slugs**: `.toLowerCase().replace(/\s+/g, '-')`
- **Keyword search**: `.includes()`, `.indexOf()`
- **Formatting UI text**: `.padStart()`, `.repeat()`

---

## 🔚 Summary Table

| Method          | Purpose                         |
| --------------- | ------------------------------- |
| `charAt()`      | Get character at index          |
| `slice()`       | Extract substring               |
| `substring()`   | Substring (no negative indices) |
| `toUpperCase()` | Convert to uppercase            |
| `includes()`    | Check if substring exists       |
| `startsWith()`  | Begins with substring?          |
| `replace()`     | Replace part of string          |
| `trim()`        | Remove whitespace               |
| `split()`       | Convert to array                |
| `repeat()`      | Repeat string                   |
| `padStart()`    | Left-pad the string             |
| `concat()`      | Combine multiple strings        |

## 🔑 1. `Object.keys(obj)`

### ➤ What it does:

Returns an array of **all the keys** in the object.

### ✅ Example:

```js
const user = { name: "Alice", age: 25 };
console.log(Object.keys(user));
// Output: ["name", "age"]
```

---

## 🔑 2. `Object.values(obj)`

### ➤ What it does:

Returns an array of **all the values** in the object.

### ✅ Example:

```js
const user = { name: "Alice", age: 25 };
console.log(Object.values(user));
// Output: ["Alice", 25]
```

---

## 🔑 3. `Object.entries(obj)`

### ➤ What it does:

Returns an array of **\[key, value] pairs**.

### ✅ Example:

```js
const user = { name: "Alice", age: 25 };
console.log(Object.entries(user));
// Output: [["name", "Alice"], ["age", 25]]
```

> Useful for looping:

```js
for (const [key, value] of Object.entries(user)) {
  console.log(`${key} = ${value}`);
}
```

---

## 🔑 4. `Object.assign(target, ...sources)`

### ➤ What it does:

**Copies properties** from one or more source objects into the target object.

### ✅ Example:

```js
const a = { x: 1 };
const b = { y: 2 };
const c = Object.assign({}, a, b);

console.log(c);
// Output: { x: 1, y: 2 }
```

> It **modifies** the target object.

---

## 🔑 5. `Object.freeze(obj)`

### ➤ What it does:

**Freezes** the object. You can't change, add, or delete properties.

### ✅ Example:

```js
const settings = { theme: "dark" };
Object.freeze(settings);

settings.theme = "light"; // ❌ Won’t work
console.log(settings.theme); // Output: "dark"
```

---

## 🔑 6. `Object.hasOwn(obj, key)` (ES2022+)

### ➤ What it does:

Returns `true` if the object has the **specified key (own property)**.

### ✅ Example:

```js
const user = { name: "Bob" };
console.log(Object.hasOwn(user, "name")); // true
console.log(Object.hasOwn(user, "age")); // false
```

> It's a modern and safer version of `obj.hasOwnProperty(key)`.

---

## 📝 Summary Table

| Method             | Purpose                          | Example Output                     |
| ------------------ | -------------------------------- | ---------------------------------- |
| `Object.keys()`    | Get all keys                     | `["name", "age"]`                  |
| `Object.values()`  | Get all values                   | `["Alice", 25]`                    |
| `Object.entries()` | Get key-value pairs              | `[["name", "Alice"], ["age", 25]]` |
| `Object.assign()`  | Copy/merge objects               | `{ x: 1, y: 2 }`                   |
| `Object.freeze()`  | Make object read-only            | `{ theme: "dark" }` (unchangeable) |
| `Object.hasOwn()`  | Check if a key exists (own prop) | `true / false`                     |

---

## Chapter-10. `Objects`

## 🔑 1. `Object.keys(obj)`

### ➤ What it does:

Returns an array of **all the keys** in the object.

### ✅ Example:

```js
const user = { name: "Alice", age: 25 };
console.log(Object.keys(user));
// Output: ["name", "age"]
```

---

## 🔑 2. `Object.values(obj)`

### ➤ What it does:

Returns an array of **all the values** in the object.

### ✅ Example:

```js
const user = { name: "Alice", age: 25 };
console.log(Object.values(user));
// Output: ["Alice", 25]
```

---

## 🔑 3. `Object.entries(obj)`

### ➤ What it does:

Returns an array of **\[key, value] pairs**.

### ✅ Example:

```js
const user = { name: "Alice", age: 25 };
console.log(Object.entries(user));
// Output: [["name", "Alice"], ["age", 25]]
```

> Useful for looping:

```js
for (const [key, value] of Object.entries(user)) {
  console.log(`${key} = ${value}`);
}
```

---

## 🔑 4. `Object.assign(target, ...sources)`

### ➤ What it does:

**Copies properties** from one or more source objects into the target object.

### ✅ Example:

```js
const a = { x: 1 };
const b = { y: 2 };
const c = Object.assign({}, a, b);

console.log(c);
// Output: { x: 1, y: 2 }
```

> It **modifies** the target object.

---

## 🔑 5. `Object.freeze(obj)`

### ➤ What it does:

**Freezes** the object. You can't change, add, or delete properties.

### ✅ Example:

```js
const settings = { theme: "dark" };
Object.freeze(settings);

settings.theme = "light"; // ❌ Won’t work
console.log(settings.theme); // Output: "dark"
```

---

## 🔑 6. `Object.hasOwn(obj, key)` (ES2022+)

### ➤ What it does:

Returns `true` if the object has the **specified key (own property)**.

### ✅ Example:

```js
const user = { name: "Bob" };
console.log(Object.hasOwn(user, "name")); // true
console.log(Object.hasOwn(user, "age")); // false
```

> It's a modern and safer version of `obj.hasOwnProperty(key)`.

---

## 📝 Summary Table

| Method             | Purpose                          | Example Output                     |
| ------------------ | -------------------------------- | ---------------------------------- |
| `Object.keys()`    | Get all keys                     | `["name", "age"]`                  |
| `Object.values()`  | Get all values                   | `["Alice", 25]`                    |
| `Object.entries()` | Get key-value pairs              | `[["name", "Alice"], ["age", 25]]` |
| `Object.assign()`  | Copy/merge objects               | `{ x: 1, y: 2 }`                   |
| `Object.freeze()`  | Make object read-only            | `{ theme: "dark" }` (unchangeable) |
| `Object.hasOwn()`  | Check if a key exists (own prop) | `true / false`                     |

---

## 🧮 Chapter -11 **JavaScript Numbers – Complete Notes**

### 🔹 1. **Basics of Numbers in JavaScript**

- JavaScript has **only one number type**: `Number` (IEEE 754 double-precision 64-bit binary format).
- Numbers can be:

  - **Integers:** `42`
  - **Floats (decimals):** `3.14`
  - **Scientific notation:** `1.5e3` (i.e., 1500)

```js
let num1 = 10;
let num2 = 3.14;
let sci = 2.5e6;
```

---

### 🔹 2. **Special Number Values**

| Value                     | Description                            |
| ------------------------- | -------------------------------------- |
| `Infinity`                | Larger than any other number           |
| `-Infinity`               | Smaller than any other number          |
| `NaN`                     | "Not-a-Number" (invalid number result) |
| `Number.MAX_VALUE`        | Largest possible number                |
| `Number.MIN_VALUE`        | Smallest possible number > 0           |
| `Number.MAX_SAFE_INTEGER` | `2^53 - 1` (largest safe integer)      |
| `Number.MIN_SAFE_INTEGER` | `-(2^53 - 1)`                          |

```js
console.log(1 / 0); // Infinity
console.log(-1 / 0); // -Infinity
console.log("abc" * 2); // NaN
```

---

### 🔹 3. **Number Conversion**

- `Number(value)` – Converts to number
- `parseInt(value)` – Parses integer from string
- `parseFloat(value)` – Parses float from string

```js
Number("42"); // 42
parseInt("42px"); // 42
parseFloat("3.14abc") + // 3.14
  "123"; // 123
```

---

### 🔹 4. **Checking Numbers**

```js
isNaN(NaN); // true
Number.isNaN(NaN); // true
Number.isNaN("abc"); // false

isFinite(100); // true
Number.isFinite(100); // true
Number.isFinite("100"); // false

Number.isInteger(42); // true
Number.isSafeInteger(9007199254740991); // true
```

---

### 🔹 5. **Number Methods**

| Method | Description |
| ------ | ----------- |

#### 🔸 `toFixed(n)`

- Returns a string with `n` digits after the decimal

```js
let n = 3.14159;
n.toFixed(2); // "3.14"
```

#### 🔸 `toPrecision(n)`

- Returns a string with a total of `n` significant digits

```js
let n = 123.456;
n.toPrecision(4); // "123.5"
```

#### 🔸 `toExponential(n)`

- Converts to exponential notation

```js
let n = 12345;
n.toExponential(2); // "1.23e+4"
```

#### 🔸 `toString(base)`

- Converts number to string in given base (2 to 36)

```js
(255).toString(2); // "11111111"
(255).toString(16); // "ff"
```

#### 🔸 `valueOf()`

- Returns the primitive value of a number object

```js
let n = new Number(5);
n.valueOf(); // 5
```

---

### 🔹 6. **Math Methods (commonly used)**

```js
Math.round(4.7); // 5
Math.floor(4.7); // 4
Math.ceil(4.1); // 5
Math.trunc(4.9); // 4
Math.abs(-7); // 7
Math.sqrt(16); // 4
Math.pow(2, 3); // 8
Math.random(); // 0 <= x < 1
Math.min(1, 3, -5); // -5
Math.max(1, 3, -5); // 3
```

---

### 🔹 7. **BigInt (for large integers)**

- Used when numbers exceed `2^53 - 1`

```js
const big = 1234567890123456789012345678901234567890n;
typeof big; // "bigint"
```

---

### 🔹 8. **Common Issues with Numbers**

#### Floating Point Precision

```js
0.1 + 0.2 === 0.3; // false
```

> Use `Number.EPSILON` to compare safely:

```js
Math.abs(0.1 + 0.2 - 0.3) < Number.EPSILON; // true
```

---

### 🔹 9. **Useful Constants**

```js
Number.EPSILON; // Smallest difference between 1 and next number
Number.MAX_SAFE_INTEGER; // 9007199254740991
Number.MIN_SAFE_INTEGER; // -9007199254740991
Number.POSITIVE_INFINITY;
Number.NEGATIVE_INFINITY;
Number.NaN;
```

---

## ✅ Summary

| Task                      | Method / Property                  |
| ------------------------- | ---------------------------------- |
| Check NaN                 | `isNaN()`, `Number.isNaN()`        |
| Check finite number       | `Number.isFinite()`                |
| Convert to number         | `Number()`, `+value`, `parseInt()` |
| Fix decimal places        | `.toFixed(n)`                      |
| Format significant digits | `.toPrecision(n)`                  |
| Convert to base           | `.toString(base)`                  |
| Random number             | `Math.random()`                    |
| Handle large integers     | `BigInt`                           |

## 📆 Chapter -12 **JavaScript Dates – In-Depth Notes**

---

### 🔹 1. **Creating Dates**

JavaScript uses the `Date` object to work with dates and times.

```js
let now = new Date(); // Current date and time
let date1 = new Date("2025-05-15"); // From ISO date string
let date2 = new Date(2025, 4, 15); // Year, Month (0-based), Day → May 15, 2025
let date3 = new Date(2025, 4, 15, 12, 30, 0); // + hours, minutes, seconds
let date4 = new Date(0); // Unix epoch → Jan 1, 1970 UTC
let date5 = new Date(1000 * 60 * 60); // 1 hour after epoch
```

> Note: **Months are 0-indexed** (January = 0, December = 11)

---

### 🔹 2. **Date Internals: Timestamps**

- Dates are stored as **milliseconds since Unix Epoch**: Jan 1, 1970 UTC

```js
let timestamp = Date.now(); // Current timestamp in ms
let d = new Date(timestamp); // Convert back to Date
```

---

### 🔹 3. **Get Methods**

| Method                | Description                    |
| --------------------- | ------------------------------ |
| `getFullYear()`       | Year (4-digit)                 |
| `getMonth()`          | Month (0–11)                   |
| `getDate()`           | Day of the month (1–31)        |
| `getDay()`            | Day of the week (0–6, Sun = 0) |
| `getHours()`          | Hour (0–23)                    |
| `getMinutes()`        | Minutes (0–59)                 |
| `getSeconds()`        | Seconds (0–59)                 |
| `getMilliseconds()`   | Milliseconds (0–999)           |
| `getTime()`           | Timestamp (ms since epoch)     |
| `getTimezoneOffset()` | Minutes offset from UTC        |
| `toISOString()`       | ISO 8601 string in UTC         |
| `toDateString()`      | Human-readable date string     |
| `toTimeString()`      | Human-readable time string     |
| `toLocaleString()`    | Local date and time string     |

```js
let d = new Date("2025-05-15T10:30:00");
d.getFullYear(); // 2025
d.getMonth(); // 4 (May)
d.getDate(); // 15
d.getDay(); // 4 (Thursday)
```

---

### 🔹 4. **Set Methods**

| Method                | Description             |
| --------------------- | ----------------------- |
| `setFullYear(y)`      | Set year                |
| `setMonth(m)`         | Set month (0–11)        |
| `setDate(d)`          | Set day of month        |
| `setHours(h)`         | Set hour                |
| `setMinutes(m)`       | Set minutes             |
| `setSeconds(s)`       | Set seconds             |
| `setMilliseconds(ms)` | Set milliseconds        |
| `setTime(ms)`         | Set time from timestamp |

```js
let d = new Date();
d.setFullYear(2026);
d.setMonth(11); // December
d.setDate(25); // 25th
```

---

### 🔹 5. **Parsing Dates**

| Method            | Description                       |
| ----------------- | --------------------------------- |
| `Date.parse(str)` | Parses date string → timestamp    |
| `new Date(str)`   | Also parses ISO-like date strings |

```js
Date.parse("2025-05-15"); // Returns timestamp
new Date("2025-05-15"); // Valid date object
```

> Best to use **ISO 8601 format** (`YYYY-MM-DD` or `YYYY-MM-DDTHH:mm:ssZ`) for cross-browser compatibility.

---

### 🔹 6. **Formatting Dates**

| Method                 | Description                    |
| ---------------------- | ------------------------------ |
| `toDateString()`       | Returns just the date part     |
| `toTimeString()`       | Returns just the time part     |
| `toISOString()`        | Returns UTC time in ISO format |
| `toLocaleDateString()` | Returns date in local format   |
| `toLocaleTimeString()` | Returns time in local format   |
| `toLocaleString()`     | Full localized date and time   |

```js
let d = new Date();
d.toISOString(); // "2025-05-15T12:30:00.000Z"
d.toLocaleDateString(); // e.g., "5/15/2025" (US)
```

---

### 🔹 7. **Date Comparison**

```js
let d1 = new Date("2025-05-15");
let d2 = new Date("2025-05-20");

d1 > d2; // false
d1.getTime() === d2.getTime(); // false
```

You can directly compare Date objects using `>` `<` `===`, but using `.getTime()` is safer for equality.

---

### 🔹 8. **Date Arithmetic**

You can **add/subtract** using timestamps:

```js
let d = new Date();
let tomorrow = new Date(d.getTime() + 24 * 60 * 60 * 1000); // add 1 day
let lastWeek = new Date(d.getTime() - 7 * 24 * 60 * 60 * 1000); // subtract 7 days
```

Or manipulate with `.setDate()`, `.setMonth()` etc.:

```js
let d = new Date("2025-05-15");
d.setDate(d.getDate() + 5); // Adds 5 days
```

---

### 🔹 9. **Working with Timezones**

JavaScript `Date` is based on **local time**, but you can get UTC components:

```js
d.getUTCFullYear();
d.getUTCHours();
```

> To convert between timezones, use libraries like **Luxon**, **date-fns-tz**, or **moment-timezone**.

---

### 🔹 10. **International Formatting with `Intl.DateTimeFormat`**

```js
let formatter = new Intl.DateTimeFormat("en-US", {
  dateStyle: "full",
  timeStyle: "short",
  timeZone: "Asia/Kolkata",
});

formatter.format(new Date());
// Example: "Thursday, May 15, 2025 at 6:00 PM"
```

---

### 🔹 11. **Libraries to Handle Dates**

- **[date-fns](https://date-fns.org/):** Functional, modular, lightweight
- **[Luxon](https://moment.github.io/luxon):** Powerful, modern alternative to Moment.js
- **[Day.js](https://day.js.org/):** Small and Moment-compatible
- **[Moment.js](https://momentjs.com/):** Popular but now legacy (not recommended for new projects)

---

### ✅ Common Use Cases

| Task                      | How to Do It                            |
| ------------------------- | --------------------------------------- |
| Get current timestamp     | `Date.now()`                            |
| Convert timestamp to date | `new Date(ms)`                          |
| Format to ISO string      | `date.toISOString()`                    |
| Add days to a date        | `date.setDate(date.getDate() + n)`      |
| Compare two dates         | `date1.getTime() > date2.getTime()`     |
| Parse ISO string          | `new Date("YYYY-MM-DD")`                |
| Format to local date/time | `date.toLocaleString("en-IN", options)` |
