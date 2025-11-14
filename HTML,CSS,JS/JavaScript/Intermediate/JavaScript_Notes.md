## 🚀 JavaScript Notes Part - 1

📝 Compiled with ☕ and ❤️ by **Vamsha vardhan**

**GitHub:** [github.com/Vamshavardhan50](https://github.com/Vamshavardhan50)  
**LinkedIn:** [linkedin.com/in/chintha-vamsha-vardhan-4b3991253](https://www.linkedin.com/in/chintha-vamsha-vardhan-4b3991253/)

# 📘Chapter-13 JSON (JavaScript Object Notation) – Complete Notes

---

## 🔷 What is JSON?

**JSON (JavaScript Object Notation)** is a lightweight **data interchange format** that is:

- Human-readable
- Easy for machines to parse and generate
- Language-independent (although it is based on a subset of JavaScript syntax)

### Example:

```json
{
  "name": "Alice",
  "age": 25,
  "isStudent": false,
  "skills": ["JavaScript", "Python"],
  "address": {
    "city": "Delhi",
    "pincode": 110001
  }
}
```

---

## 🔷 Why JSON is not a part of JavaScript?

### 🔸 JSON is a **data format**, not a **language feature**:

- JSON is **inspired by JavaScript object literals** but is **not the same thing**.
- It has **stricter syntax** rules:

  - All keys **must be in double quotes**.
  - Only **primitive values**, arrays, or nested JSON objects allowed.
  - Cannot include functions, `undefined`, comments, or symbols.

### 🔸 JSON was made language-agnostic:

- Designed for data exchange **between languages**.
- Can be used in Python, Java, PHP, Ruby, etc.

📌 That’s why JSON is **not just a JavaScript thing**, even though it originated from JS.

---

## 🔷 Why do we need JSON in JavaScript?

### ✅ **Data Exchange with APIs**:

Most modern web applications communicate with backends using **HTTP requests** where data is sent/received in JSON format.

### ✅ **Storage & Configuration**:

- Used in config files (`package.json`)
- Storing data in `localStorage` or `sessionStorage` (which can only store strings)

### ✅ **Serialization & Deserialization**:

- Convert objects to strings (for storage or network transmission)
- Convert strings back to usable JS objects

---

## 🔷 JSON vs JavaScript Objects

| Feature    | JSON                                              | JS Object                                         |
| ---------- | ------------------------------------------------- | ------------------------------------------------- |
| Syntax     | Very strict                                       | Flexible                                          |
| Quotes     | Double quotes only                                | Single/double or no quotes for keys               |
| Data types | Only string, number, boolean, null, array, object | Can include functions, `undefined`, symbols, etc. |
| Usage      | Data exchange format                              | Programming logic & in-memory data                |

---

## 🔷 How to Use JSON in JavaScript

JavaScript provides a **built-in global `JSON` object** with two key methods:

---

### 🔶 `JSON.stringify()`

**Purpose:** Convert a JavaScript object → JSON string

#### ✅ Syntax:

```js
JSON.stringify(value, replacer?, space?)
```

#### ✅ Example:

```js
const obj = {
  name: "Alice",
  age: 25,
  isAdmin: false,
  skills: ["HTML", "CSS"],
};

const jsonString = JSON.stringify(obj);
console.log(jsonString);
// Output: '{"name":"Alice","age":25,"isAdmin":false,"skills":["HTML","CSS"]}'
```

#### ✅ Optional Parameters:

- **`replacer`**: A function or array to filter properties.

  ```js
  JSON.stringify(obj, ["name", "age"]);
  // Output: '{"name":"Alice","age":25}'
  ```

- **`space`**: Adds indentation for readability (used in config files).

  ```js
  JSON.stringify(obj, null, 2);
  ```

#### ⚠️ Limitations:

- `undefined`, functions, and symbols are **omitted**
- `Date` objects become strings
- Circular references cause errors

---

### 🔶 `JSON.parse()`

**Purpose:** Convert a JSON string → JavaScript object

#### ✅ Syntax:

```js
JSON.parse(text, reviver?)
```

#### ✅ Example:

```js
const jsonString = '{"name":"Alice","age":25}';
const obj = JSON.parse(jsonString);

console.log(obj.name); // "Alice"
```

#### ✅ With `reviver`:

A function that transforms the results during parsing.

```js
const obj = JSON.parse(jsonString, (key, value) => {
  if (key === "age") return value + 1;
  return value;
});
```

#### ⚠️ Caveats:

- The string **must be valid JSON**
- Parsing invalid JSON will throw a **SyntaxError**
- All keys must be double-quoted

---

## 🔷 Practical Use Cases of JSON in JS

### ✅ 1. API Calls

```js
fetch("https://api.example.com/data")
  .then((res) => res.json())
  .then((data) => {
    console.log(data); // Already parsed to JS object
  });
```

### ✅ 2. LocalStorage

```js
const user = { name: "John", age: 30 };

// Store as string
localStorage.setItem("user", JSON.stringify(user));

// Retrieve and parse back
const storedUser = JSON.parse(localStorage.getItem("user"));
console.log(storedUser.name); // John
```

### ✅ 3. Config Files

```json
// package.json or any config.json
{
  "name": "my-app",
  "version": "1.0.0",
  "dependencies": {
    "express": "^4.18.2"
  }
}
```

---

## 🔷 Advanced Tips

### ✅ Handle Dates:

```js
const obj = { date: new Date() };
const json = JSON.stringify(obj);
console.log(json); // Date as ISO string

const parsed = JSON.parse(json);
parsed.date = new Date(parsed.date);
```

### ✅ Avoid Circular References:

```js
const a = {};
a.self = a;

JSON.stringify(a); // ❌ Throws error: Converting circular structure to JSON
```

### ✅ Pretty Printing:

```js
console.log(JSON.stringify(obj, null, 4));
```

---

## 🔚 Summary

| Operation             | Description                                               |
| --------------------- | --------------------------------------------------------- |
| `JSON.stringify(obj)` | Convert JS object → JSON string                           |
| `JSON.parse(string)`  | Convert JSON string → JS object                           |
| JSON is               | A lightweight format for data exchange                    |
| Syntax Rules          | Double-quoted keys & strings, no functions or `undefined` |

---

# Chapter-14 DOM

### 🔰 **1. What is the DOM?**

- DOM as a tree-like structure
- Difference between DOM and HTML
- `document` object and how JavaScript interacts with the DOM

---

### 🔹 **2. Selecting Elements**

#### Basic Selectors:

- `document.getElementById()`
- `document.getElementsByClassName()`
- `document.getElementsByTagName()`

#### Modern Selectors:

- `document.querySelector()`
- `document.querySelectorAll()`
- Difference between `NodeList` and `HTMLCollection`

## 🧒 Imagine This:

You have a **toy box** 🧸 that can hold different types of toys:

- Dolls
- Cars
- Balls
- Blocks

Now, imagine you asked your big brother JavaScript:

> "Hey, give me all the **red toys** from this toy box!"

Depending on how you ask, he might give you one of two **types of boxes**:

---

## 🎁 1. `HTMLCollection` – A Magic Box of Only “Toy Elements”

- This box **only gives real toys** (like dolls and cars, but not drawings or labels).
- It's **live** – if you add a red car later, it will magically appear in this box too!

### ✅ Key Features:

- **Only real HTML elements** (no text, no comments)
- **Live collection** – updates if the DOM changes
- Comes from:

  - `getElementsByClassName`
  - `getElementsByTagName`
  - `document.forms`, `document.images`, etc.

### 📦 Example:

```html
<div class="toy">Car</div>
<div class="toy">Doll</div>

<script>
  const toys = document.getElementsByClassName("toy");
  console.log(toys); // HTMLCollection [div, div]
</script>
```

If you later do:

```js
let newToy = document.createElement("div");
newToy.className = "toy";
newToy.textContent = "Ball";
document.body.appendChild(newToy);

console.log(toys); // Now magically includes Ball too! (LIVE!)
```

---

## 🎁 2. `NodeList` – A Normal Box with Toys _and_ Drawings

- This box can include **HTML elements**, **text**, **comments**, and more.
- Usually **not live** – once you get it, it doesn’t change even if the DOM changes (unless using `childNodes`).

### ✅ Key Features:

- Can include **all node types**, not just elements
- **Static** (usually doesn't auto-update)
- Comes from:

  - `querySelectorAll`
  - `childNodes` (live version)

- Can use `.forEach()` directly

### 📦 Example:

```html
<div class="toy">Car</div>
<div class="toy">Doll</div>

<script>
  const toys = document.querySelectorAll(".toy");
  console.log(toys); // NodeList [div, div]
</script>
```

If you later add:

```js
let newToy = document.createElement("div");
newToy.className = "toy";
newToy.textContent = "Ball";
document.body.appendChild(newToy);

console.log(toys); // Still just Car and Doll. Ball is NOT included!
```

---

## 🧠 Summary Table (Like a Cheat Sheet)

| Feature              | `HTMLCollection`       | `NodeList`                                   |
| -------------------- | ---------------------- | -------------------------------------------- |
| What it contains     | Only HTML Elements     | Any kind of nodes (elements, text, comments) |
| Live or Static       | ✅ Live (auto-updates) | ❌ Usually static                            |
| Can use `.forEach()` | ❌ No (convert first)  | ✅ Yes                                       |
| How to get it        | `getElementsBy*()`     | `querySelectorAll()`, `childNodes`           |

---

## 🎓 Final Analogy

- `HTMLCollection` is like a **magic toy box** that only holds **real toys** and **updates itself** when new toys are added.
- `NodeList` is like a **snapshot photo** of what was in the toy box **at the moment** you asked – it includes drawings too, but **won’t change** if you add more toys later.

### 🔹 **3. Changing Content**

- `element.innerText`
- `element.textContent`
- `element.innerHTML` (and dangers of using it)
- Setting vs getting content

---

### 🔹 **4. Changing Styles**

- `element.style.property`

  - Example: `element.style.color = 'red'`

- Changing multiple styles using:

  - `element.style.cssText`
  - `element.classList.add()`, `element.classList.remove()`, `element.classList.toggle()`, `element.classList.contains()`

- Introduction to `classList`

  - `.add()`, `.remove()`, `.toggle()`, `.contains()`

---

### 🔹 **5. Attributes**

- `getAttribute()`, `setAttribute()`, `removeAttribute()`
- Working with `href`, `src`, `alt`, `id`, etc.
- `dataset` and `data-*` attributes

---

### 🔹 **6. Creating and Adding Elements**

- `document.createElement()`
- `document.createTextNode()`
- `appendChild()`, `prepend()`, `insertBefore()`
- Modern: `append()`, `before()`, `after()`

## 👩‍💻 Setup (HTML for All Examples):

```html
<button id="myButton" class="btn">Click Me</button>

<style>
  .btn {
    background-color: blue;
    color: white;
    padding: 10px;
  }

  .active {
    background-color: green;
  }

  .hidden {
    display: none;
  }
</style>
```

---

## 1. `.add()` – Add a class 🎨

### ✅ Example:

```js
const btn = document.getElementById("myButton");
btn.classList.add("active");
```

### 💡 What happens?

The `<button>` will now have both `btn` and `active` classes:

```html
<button class="btn active">Click Me</button>
```

It turns green because the `active` class was added.

---

## 2. `.remove()` – Remove a class ❌

### ✅ Example:

```js
btn.classList.remove("btn");
```

### 💡 What happens?

Now the `btn` class is gone:

```html
<button class="active">Click Me</button>
```

So, blue background and padding are removed.

---

## 3. `.toggle()` – Add if it’s not there, remove if it is 🔁

### ✅ Example:

```js
btn.classList.toggle("hidden");
```

### 💡 First time:

- It adds `hidden`, so the button disappears.

### 💡 Second time (run again):

- It removes `hidden`, so the button comes back!

---

## 4. `.contains()` – Check if a class exists ✅❓

### ✅ Example:

```js
if (btn.classList.contains("active")) {
  console.log("Button is active!");
} else {
  console.log("Button is not active.");
}
```

### 💡 What happens?

It checks whether the class `"active"` is present or not and logs a message.

---

## 👀 Bonus: Use with Events

Here’s a quick interactive example:

```js
btn.addEventListener("click", () => {
  btn.classList.toggle("active");
});
```

### 🔹 **7. Removing Elements**

- `element.remove()` (modern)
- `parent.removeChild(child)` (older way)

---

### 🔹 **8. Event Handling (Intro)**

- `addEventListener()`

  - Click, mouseover, input, submit, etc.

- Arrow function vs named function as event handler
- Accessing `event` object
- `preventDefault()` for forms and links

---

### 🔹 **9. Form Manipulation**

- `value` property of input, textarea
- Handling checkbox, radio, select values
- Getting data from forms
- Disabling/enabling form elements

---

# Chapter - 15 Events in JavaScript

# 📘 JavaScript Events – Complete Notes

## 🔹 1. **What is an Event in JavaScript?**

An **event** is an action or occurrence that happens in the browser which JavaScript can "listen to" and react to.

🧠 Examples of events:

- User clicks a button → `click`
- Page finishes loading → `load`
- Key is pressed → `keydown`
- Form is submitted → `submit`
- Mouse moves over an element → `mouseover`

---

## 🔹 2. **Adding Event Listeners**

### ✅ Method: `addEventListener()`

```js
element.addEventListener("event", callbackFunction);
```

### 🔍 Example:

```js
const btn = document.getElementById("myButton");
btn.addEventListener("click", () => {
  alert("Button clicked!");
});
```

> 🔹 `click` → Event name
> 🔹 `() => {}` → Callback function (executes when event occurs)

---

## 🔹 3. **Common DOM Events**

| Event              | Triggered When...               |
| ------------------ | ------------------------------- |
| `click`            | An element is clicked           |
| `dblclick`         | Double-clicked                  |
| `mouseover`        | Mouse enters the element        |
| `mouseout`         | Mouse leaves the element        |
| `mousedown`        | Mouse button is pressed         |
| `mouseup`          | Mouse button is released        |
| `mousemove`        | Mouse is moved                  |
| `keydown`          | A key is pressed                |
| `keyup`            | A key is released               |
| `submit`           | A form is submitted             |
| `change`           | Form element value changes      |
| `input`            | Input value changes (real-time) |
| `load`             | Page or resource loads          |
| `DOMContentLoaded` | Entire HTML has been parsed     |

---

## 🔹 4. **The `event` Object**

Every event listener gets an `event` object as an argument, which holds details about the event.

### 🧪 Example:

```js
btn.addEventListener("click", (event) => {
  console.log(event.target); // The actual clicked element
});
```

### Useful properties:

- `event.target`: Element that triggered the event
- `event.type`: Type of event (e.g., "click")
- `event.preventDefault()`: Stops default behavior
- `event.stopPropagation()`: Stops event from bubbling up

---

## 🔹 5. **Preventing Default Behavior**

### ✅ Use Case:

Prevent form submission from reloading the page:

```js
form.addEventListener("submit", (e) => {
  e.preventDefault();
  console.log("Form submitted!");
});
```

---

## 🔹 6. **Event Propagation: Bubbling vs Capturing**

### 🧠 Two phases:

- **Bubbling**: Inner element triggers first → bubbles up to parents (default)
- **Capturing**: Outer elements trigger first → travels inward

```js
element.addEventListener("click", handler, useCapture);
```

- `useCapture = false` (default) → Bubbling
- `useCapture = true` → Capturing

### 🎯 Example:

```js
parent.addEventListener("click", () => {
  console.log("Parent clicked");
});

child.addEventListener("click", () => {
  console.log("Child clicked");
});
```

Clicking the `child` will print:

```
Child clicked
Parent clicked
```

---

## 🔹 7. **stopPropagation()**

Use this to stop the event from bubbling further.

```js
child.addEventListener("click", (e) => {
  e.stopPropagation();
  console.log("Only child clicked");
});
```

---

## 🔹 8. **Event Delegation**

Attach an event to a **common parent** instead of each child.

### ✅ Use Case:

Efficiently handle events on dynamic elements.

```js
document.getElementById("list").addEventListener("click", (e) => {
  if (e.target.tagName === "LI") {
    alert(`You clicked ${e.target.textContent}`);
  }
});
```

Even if new `<li>`s are added later, it works!

---

## 🔹 9. **Removing Event Listeners**

Use `removeEventListener()` with the same function reference.

```js
function sayHi() {
  alert("Hi!");
}

btn.addEventListener("click", sayHi);

// Later...
btn.removeEventListener("click", sayHi);
```

> ⚠️ You **must use the same function name** – anonymous functions won't work with `removeEventListener`.

---

## 🔹 10. **Once Option (Run Only One Time)**

```js
btn.addEventListener(
  "click",
  () => {
    console.log("Clicked only once!");
  },
  { once: true }
);
```

---

## 🔹 11. **Keyboard Events**

```js
document.addEventListener("keydown", (e) => {
  console.log(e.key); // Logs the key pressed (like "a", "Enter")
});
```

Useful for:

- Custom keyboard shortcuts
- Game controls
- Accessibility features

---

## 🔹 12. **Mouse Events**

```js
element.addEventListener("mousemove", (e) => {
  console.log(`X: ${e.clientX}, Y: ${e.clientY}`);
});
```

---

## 🧪 Mini Project Example: Toggle Dark Mode

```js
const toggleBtn = document.getElementById("toggleTheme");

toggleBtn.addEventListener("click", () => {
  document.body.classList.toggle("dark");
});
```

```css
.dark {
  background-color: black;
  color: white;
}
```

---

## 🧠 Summary

| Concept                 | Description                                    |
| ----------------------- | ---------------------------------------------- |
| `addEventListener()`    | Attach event handler                           |
| `event` object          | Info about the event                           |
| `preventDefault()`      | Stop default action (e.g., form submit reload) |
| `stopPropagation()`     | Stop event from bubbling up                    |
| Event Bubbling          | Child → Parent                                 |
| Event Delegation        | Listen on parent, handle child logic           |
| `removeEventListener()` | Remove previously attached event handler       |
| `{ once: true }`        | Run listener only once                         |

---

# 🧠 Chapter -16 Web Storage API Overview

JavaScript provides **Web Storage APIs** to store key-value pairs in the browser. The two main types are:

| Feature         | `localStorage`         | `sessionStorage`               |
| --------------- | ---------------------- | ------------------------------ |
| Lifespan        | Until manually deleted | Until tab/browser is closed    |
| Scope           | Per domain             | Per tab & per domain           |
| Storage Limit   | \~5-10 MB              | \~5 MB                         |
| Accessible From | Any tab on same origin | Only the tab it was created in |
| Persistent?     | Yes                    | No                             |

---

## 🔐 Syntax

Both storages use the same methods:

```javascript
// Set item
localStorage.setItem("key", "value");
sessionStorage.setItem("key", "value");

// Get item
let value = localStorage.getItem("key");

// Remove item
localStorage.removeItem("key");

// Clear all
localStorage.clear();

// Get key by index
let key = localStorage.key(0);
```

📝 All data is stored as **strings**.

---

## 📌 Example Use Case

```javascript
// Store user info in localStorage
localStorage.setItem("username", "john_doe");

// Retrieve it later
const name = localStorage.getItem("username"); // "john_doe"
```

```javascript
// SessionStorage example: tracking session state
sessionStorage.setItem("isLoggedIn", "true");

// Automatically removed when tab is closed
```

---

## 🔄 JSON with Storage

Since storage stores **only strings**, use `JSON.stringify()` and `JSON.parse()` for objects or arrays:

```javascript
const user = { name: "Alice", age: 25 };
localStorage.setItem("user", JSON.stringify(user));

const data = JSON.parse(localStorage.getItem("user"));
console.log(data.name); // Alice
```

---

## 🔒 Security & Best Practices

- ❗ **Never store sensitive data (passwords, tokens)** in localStorage/sessionStorage.
- 🕵️‍♂️ Data is accessible via JavaScript – vulnerable to **XSS attacks**.
- ✅ Always validate and sanitize user input.
- ✅ Clear data on logout (`localStorage.clear()`).
- 🔄 Use expiration logic manually if needed (e.g., save timestamp along with value).

---

## 📚 When to Use What?

| Use Case                              | Recommended Storage |
| ------------------------------------- | ------------------- |
| Persist user settings or theme        | `localStorage`      |
| Temporary state during a session/tab  | `sessionStorage`    |
| Cart items (persist between visits)   | `localStorage`      |
| Form data during a multi-step process | `sessionStorage`    |

---

## 🧪 Quick Debug Tip

You can inspect and modify localStorage/sessionStorage in:
**DevTools → Application Tab → Storage → Local/Session Storage**

---

## ✅ Summary

- `localStorage` = Long-term, persists across sessions.
- `sessionStorage` = Short-term, ends with tab/session.
- Stored as strings → use JSON for structured data.
- Don't store sensitive info.
- Easy to use for small client-side data tasks.

## 🧠 Chapter -17

## JavaScript Execution: Synchronous vs Asynchronous

---

### 📌 Synchronous JavaScript (Sync)

#### 🔍 What it Means:

- Code is executed **line by line, in order**.
- Each operation **blocks** the next one until it's completed.
- If a task takes time (like a heavy loop or API call), it **halts the whole program**.

#### 📄 Example:

```js
console.log("Start");
console.log("Middle");
console.log("End");
```

#### 🧠 Real-life Analogy:

> Imagine you’re in a queue at a bank. Each customer is served **one by one**. You have to **wait** until the person ahead is done.

---

### 📌 Asynchronous JavaScript (Async)

#### 🔍 What it Means:

- Allows **non-blocking** execution.
- Time-consuming tasks (like fetching data or waiting for user input) can happen **in the background**.
- JS doesn’t wait — it **delegates the task** and **moves on**.

#### 📄 Example:

```js
console.log("Start");

setTimeout(() => {
  console.log("Async Task");
}, 2000);

console.log("End");
```

📤 Output:

```
Start
End
Async Task
```

#### 🧠 Real-life Analogy:

> You order food at a restaurant. Instead of standing in the kitchen and waiting, you go back to your table. When the food is ready, the waiter brings it to you. ✅

---

## 🔁 Synchronous vs Asynchronous Comparison Table

| Feature           | Synchronous JS                   | Asynchronous JS                           |
| ----------------- | -------------------------------- | ----------------------------------------- |
| Execution Order   | Line-by-line, blocking           | Non-blocking, can run in the background   |
| Waits for Tasks?  | Yes                              | No                                        |
| Example Functions | `console.log()`, math operations | `setTimeout()`, `fetch()`, event handlers |
| Common Use Cases  | Calculations, DOM updates        | API calls, timers, animations             |
| Real-Life Analogy | Bank queue                       | Food order in a restaurant                |
| Problem           | Slow tasks block everything      | Requires understanding of async flow      |

---

## 📚 Topics to Cover in Async JavaScript

Here’s the full list in recommended order:

---

### 🔹 1. **The JavaScript Event Loop (Conceptual Foundation)**

- Call stack
- Web APIs
- Callback queue / Task queue
- Microtask queue (Promises)

🧠 _Explain how JS handles async tasks internally._

---

### 🔹 2. **Callbacks**

- Function passed as an argument
- Used in older async code (like event listeners or `setTimeout`)
- Problem: Callback Hell (nested structure, hard to read/debug)

---

### 🔹 3. **setTimeout & setInterval**

- Scheduling tasks
- Use with animations, timers, etc.
- Introduce clearTimeout / clearInterval

---

### 🔹 4. **Promises**

- Cleaner alternative to callbacks
- States: Pending, Fulfilled, Rejected
- `.then()`, `.catch()`, `.finally()`
- Creating your own Promises

---

### 🔹 5. **Fetch API**

- Make network requests using `fetch()`
- Returns a Promise
- Chain `.then()` and `.catch()` for response handling

---

### 🔹 6. **Async/Await**

- Syntactic sugar over Promises
- Cleaner, more readable async code
- Error handling with `try...catch`

---

### 🔹 7. **Error Handling in Async Code**

- `.catch()` in Promises
- `try...catch` in `async/await`
- Throwing custom errors
- Graceful fallback UI for failed requests

---

### 🔹 8. **Practical Projects & Mini Challenges**

- Fetch and render API data (e.g., users or posts)
- Search bar with debounce using setTimeout
- Countdown timer with setInterval
- Async form submission with loading spinner

---

## 🧠 Chapter - 18

## 📘 **What is a Callback in JavaScript?**

A **callback** is a **function passed as an argument to another function**, which is **invoked after some kind of action or task is completed**. It allows functions to be executed **asynchronously or after certain operations**, without blocking code execution.

---

## ✅ **Why Use Callbacks?**

JavaScript is **single-threaded** and **non-blocking**, so it uses callbacks to handle **asynchronous operations** like:

- Fetching data from an API
- Reading files
- User interactions (clicks, typing, etc.)
- Timers (`setTimeout`, `setInterval`)

---

## 🛠️ **Basic Syntax**

```javascript
function greet(name, callback) {
  console.log(`Hello, ${name}`);
  callback();
}

function sayBye() {
  console.log("Goodbye!");
}

greet("Alice", sayBye);
// Output:
// Hello, Alice
// Goodbye!
```

---

## 🎯 **Real-Life Analogy**

**Callback in Real Life:**

> You order food at a restaurant. The waiter (function) takes your order and promises to **call you back** (callback function) when your food is ready. Meanwhile, you (JavaScript) can do other things without waiting idly.

---

## 🧪 **Examples in Practice**

### 1. **Using setTimeout (Async Timer Callback)**

```javascript
console.log("Start");

setTimeout(() => {
  console.log("Callback after 2 seconds");
}, 2000);

console.log("End");
```

> Output:

```
Start
End
Callback after 2 seconds
```

---

### 2. **Using Callbacks with Event Listeners**

```javascript
document.getElementById("btn").addEventListener("click", function () {
  alert("Button clicked!");
});
```

Here, the `function()` is a **callback** that runs **when** the event (button click) occurs.

---

### 3. **Reading a File with Callback (Node.js)**

```javascript
const fs = require("fs");

fs.readFile("example.txt", "utf-8", function (err, data) {
  if (err) return console.error(err);
  console.log(data);
});
```

The last argument in `readFile` is a callback that is executed **after the file is read**.

---

## 🕸️ **Callback Hell (Pyramid of Doom)**

When callbacks are **nested inside each other**, it leads to **difficult-to-read and hard-to-maintain code**.

### ❌ Example:

```javascript
loginUser("alice", function (user) {
  getUserProfile(user.id, function (profile) {
    getUserPosts(profile.id, function (posts) {
      displayPosts(posts);
    });
  });
});
```

> This nested structure is hard to debug and scale – **Callback Hell**.

---

## 🧹 **Solutions to Callback Hell**

### ✅ 1. **Named Functions**

```javascript
function handlePosts(posts) {
  displayPosts(posts);
}

function handleProfile(profile) {
  getUserPosts(profile.id, handlePosts);
}

function handleUser(user) {
  getUserProfile(user.id, handleProfile);
}

loginUser("alice", handleUser);
```

### ✅ 2. **Promises (Modern Alternative)**

```javascript
loginUser("alice")
  .then((user) => getUserProfile(user.id))
  .then((profile) => getUserPosts(profile.id))
  .then((posts) => displayPosts(posts))
  .catch((err) => console.error(err));
```

### ✅ 3. **Async/Await (Cleaner Syntax)**

```javascript
async function showUserPosts() {
  try {
    const user = await loginUser("alice");
    const profile = await getUserProfile(user.id);
    const posts = await getUserPosts(profile.id);
    displayPosts(posts);
  } catch (err) {
    console.error(err);
  }
}
```

---

## 📌 Summary

| Feature      | Callback                                              |
| ------------ | ----------------------------------------------------- |
| Definition   | A function passed as an argument to be executed later |
| Usage        | Event handling, async operations, file I/O, timers    |
| Pros         | Flexible, powerful, allows async handling             |
| Cons         | Callback hell, hard to manage nested logic            |
| Alternatives | Promises, Async/Await                                 |

---

## 🧠 Final Tip

> Use callbacks **only when necessary**, and switch to **Promises or Async/Await** for complex async logic to improve code readability and maintainability.

---

## 🧠 Chapter - 19

## 🔹 3. **`setTimeout()` & `setInterval()` in JavaScript**

### 🧠 What Are They?

- `setTimeout()` and `setInterval()` are **asynchronous timer functions** used to **schedule code execution** after a delay or at regular intervals.
- They are part of the **Web APIs** provided by the browser (or Node.js).

---

## ✅ `setTimeout()`

### 🔹 Syntax:

```js
let timeoutId = setTimeout(callback, delay, arg1, arg2, ...);
```

| Parameter     | Description                                           |
| ------------- | ----------------------------------------------------- |
| `callback`    | Function to execute                                   |
| `delay`       | Delay in **milliseconds** before running the function |
| `arg1...argN` | Optional arguments passed to the callback             |
| `timeoutId`   | ID used to cancel it with `clearTimeout()`            |

### 📦 Example:

```js
setTimeout(() => {
  console.log("Executed after 2 seconds");
}, 2000);
```

### 📌 With Parameters:

```js
function greet(name) {
  console.log(`Hello, ${name}!`);
}
setTimeout(greet, 1000, "Alice"); // Hello, Alice!
```

### 🔄 Canceling with `clearTimeout()`:

```js
let id = setTimeout(() => console.log("Will not run"), 2000);
clearTimeout(id);
```

---

## ✅ `setInterval()`

### 🔹 Syntax:

```js
let intervalId = setInterval(callback, delay, arg1, arg2, ...);
```

- Executes the `callback` **repeatedly** at every `delay` interval.
- Returns an `intervalId` which can be cleared using `clearInterval()`.

### 📦 Example:

```js
let count = 0;
let id = setInterval(() => {
  console.log(`Count: ${++count}`);
  if (count === 5) clearInterval(id);
}, 1000);
```

---

## 🚫 `clearTimeout()` & `clearInterval()`

### 🔹 Usage:

```js
clearTimeout(timeoutId); // Cancels a timeout
clearInterval(intervalId); // Cancels an interval
```

Used to **prevent the execution** of a scheduled timeout or **stop a recurring interval**.

---

## ⚠️ Execution Timing Notes

- The `delay` is **minimum wait time** — actual execution depends on the event loop.
- If the call stack is busy, the execution is **delayed**.
- **Minimum delay is \~4ms** for nested timers (in some browsers like Chrome).

```js
console.log("Start");
setTimeout(() => console.log("Timer"), 0); // Will still run after the current call stack
console.log("End");
```

Output:

```
Start
End
Timer
```

---

## 🔍 Advanced Usage

### 1. **Recursive `setTimeout` (Better than `setInterval` for precision):**

```js
function tick() {
  console.log("Tick");
  setTimeout(tick, 1000);
}
tick();
```

✔ Keeps consistent delay between executions, unlike `setInterval`, which does not account for callback execution time.

---

### 2. **Clearing Timer After User Interaction**

```js
let timer = setTimeout(() => {
  alert("You were inactive!");
}, 5000);

document.addEventListener("mousemove", () => {
  clearTimeout(timer);
});
```

---

## 🧠 `setTimeout` vs `setInterval`

| Feature          | `setTimeout()`                         | `setInterval()`                       |
| ---------------- | -------------------------------------- | ------------------------------------- |
| Runs once        | ✅ Yes                                 | ❌ No (repeats)                       |
| Delay respected? | ✅ Starts after delay                  | ❌ May overlap if callback is slow    |
| Control          | ✅ More control via recursion          | ❌ Harder to pause/resume dynamically |
| Use case         | One-time delay, animations, debouncing | Repeated actions, polling, clocks     |

---

## 🛠️ Best Practices

- ❌ Avoid long intervals — prefer recursive `setTimeout` for control.
- ✅ Always store the ID to clear it when needed.
- ✅ Clean up timers on component unmount (e.g., in React):

```js
useEffect(() => {
  const id = setTimeout(() => {
    /* something */
  }, 1000);
  return () => clearTimeout(id);
}, []);
```

---

## 📚 Common Use Cases

- Showing/hiding notifications
- Debouncing or throttling events
- Polling APIs
- Countdown timers
- Animating step-by-step processes

---

## 🧪 Fun Challenge

```js
for (var i = 1; i <= 5; i++) {
  setTimeout(() => console.log(i), i * 1000);
}
```

**Output:**

```
6
6
6
6
6
```

Why? Because `var` is function-scoped. `i` becomes 6 before any timeout executes.
✅ Fix with `let` or IIFE:

```js
for (let i = 1; i <= 5; i++) {
  setTimeout(() => console.log(i), i * 1000);
}
```

---

## 🧠 Chapter - 20

## 🔹 **Promises in JavaScript**

A **Promise** is an object representing the eventual completion (or failure) of an asynchronous operation.

### 🔸 Why Promises?

- To avoid **callback hell**.
- To write **cleaner and more manageable async code**.

---

## 🔹 Promise States

A promise has 3 states:

1. **Pending**: Initial state, neither fulfilled nor rejected.
2. **Fulfilled**: The operation completed successfully.
3. **Rejected**: The operation failed.

---

## 🔹 Creating a Promise

```js
const myPromise = new Promise((resolve, reject) => {
  // Do some async task here...

  const success = true;

  if (success) {
    resolve("Task completed!");
  } else {
    reject("Something went wrong!");
  }
});
```

- `resolve()` — call this when the operation is successful.
- `reject()` — call this when the operation fails.

---

## 🔹 Consuming a Promise

### ✅ `.then()` — for success

### ❌ `.catch()` — for error

### 🔄 `.finally()` — always runs (optional)

```js
myPromise
  .then((result) => {
    console.log("Success:", result); // "Success: Task completed!"
  })
  .catch((error) => {
    console.log("Error:", error);
  });
```

---

## 🔹 Example 1: Simulating Async Task with `setTimeout`

```js
const fetchData = new Promise((resolve, reject) => {
  setTimeout(() => {
    const dataAvailable = true;

    if (dataAvailable) {
      resolve("Data loaded successfully");
    } else {
      reject("Failed to load data");
    }
  }, 2000);
});

fetchData
  .then((data) => {
    console.log("Result:", data);
  })
  .catch((err) => {
    console.error("Error:", err);
  });
```

---

## 🔹 Chaining `.then()` Calls

```js
const multiplyByTwo = new Promise((resolve) => {
  setTimeout(() => resolve(5), 1000);
});

multiplyByTwo
  .then((num) => {
    console.log("Step 1:", num); // 5
    return num * 2;
  })
  .then((num) => {
    console.log("Step 2:", num); // 10
    return num * 2;
  })
  .then((num) => {
    console.log("Step 3:", num); // 20
  })
  .catch((err) => {
    console.error("Error:", err);
  });
```

---

## 🔹 Error Handling in Chains

If any `.then()` throws an error or a `reject()` occurs:

```js
const brokenPromise = new Promise((resolve, reject) => {
  setTimeout(() => reject("Something broke!"), 1000);
});

brokenPromise
  .then((res) => {
    console.log(res);
  })
  .catch((err) => {
    console.error("Caught error:", err); // "Caught error: Something broke!"
  });
```

---

## 🔹 Summary

| Method       | Purpose                            |
| ------------ | ---------------------------------- |
| `.then()`    | Handle fulfilled result            |
| `.catch()`   | Handle rejected result             |
| `.finally()` | Runs after `.then()` or `.catch()` |

---

# 📘 Chapter - 21 JavaScript Fetch API – In-Depth Notes

---

## 🧠 What is the Fetch API?

The **Fetch API** provides a modern, promise-based way to make HTTP requests in the browser.

```js
fetch(url, options);
```

It replaces older approaches like `XMLHttpRequest` with a cleaner and more powerful API.

---

## 🔧 Syntax

```js
fetch(url, {
  method: "GET" | "POST" | "PUT" | "DELETE" | ...,
  headers: {
    "Content-Type": "application/json",
    ...
  },
  body: JSON.stringify(data), // for POST/PUT
  mode: "cors" | "no-cors" | "same-origin",
  credentials: "include" | "same-origin" | "omit",
})
```

---

## ✅ Making a Basic GET Request

```js
fetch("https://api.example.com/data")
  .then((response) => response.json())
  .then((data) => console.log(data))
  .catch((err) => console.error("Fetch error:", err));
```

---

## 🧾 Response Object – Properties

```js
fetch("https://api.example.com/data").then((res) => {
  console.log(res.status); // e.g., 200
  console.log(res.ok); // true if status is 200–299
  console.log(res.statusText); // e.g., "OK"
  console.log(res.headers); // Headers object
  return res.json(); // or res.text(), res.blob(), etc.
});
```

---

## 🛠 Common Methods on `Response`

- `res.json()` → Parse JSON body
- `res.text()` → Parse plain text
- `res.blob()` → Parse binary data
- `res.formData()` → Parse form data
- `res.arrayBuffer()` → Parse raw data

---

## 📤 Making a POST Request

```js
fetch("https://api.example.com/users", {
  method: "POST",
  headers: {
    "Content-Type": "application/json",
  },
  body: JSON.stringify({
    name: "John",
    email: "john@example.com",
  }),
})
  .then((res) => res.json())
  .then((data) => console.log("Created:", data))
  .catch((err) => console.error("Error:", err));
```

---

## 🔐 Handling Authentication

### Using Bearer Token

```js
fetch("https://api.example.com/private", {
  headers: {
    Authorization: "Bearer YOUR_TOKEN_HERE",
  },
});
```

### Sending Cookies

```js
fetch("https://example.com/api", {
  credentials: "include", // or "same-origin"
});
```

---

## ⚠️ Error Handling

Fetch only rejects the promise for **network errors**. Even a 404/500 returns a resolved promise!

```js
fetch("https://api.example.com/data")
  .then((res) => {
    if (!res.ok) {
      throw new Error(`HTTP error! Status: ${res.status}`);
    }
    return res.json();
  })
  .then((data) => console.log(data))
  .catch((err) => console.error("Caught error:", err));
```

---

## 🧪 AbortController – Canceling a Fetch Request

```js
const controller = new AbortController();
const signal = controller.signal;

fetch("https://api.example.com/data", { signal })
  .then((res) => res.json())
  .then((data) => console.log(data))
  .catch((err) => {
    if (err.name === "AbortError") {
      console.log("Request was aborted");
    } else {
      console.error(err);
    }
  });

setTimeout(() => controller.abort(), 1000); // Cancel after 1s
```

---

## 🧾 Headers Object

```js
const headers = new Headers();
headers.append("Content-Type", "application/json");
headers.append("Authorization", "Bearer xyz");

fetch(url, { headers });
```

You can also check or loop through headers:

```js
fetch(url).then((res) => {
  for (let [key, value] of res.headers.entries()) {
    console.log(`${key}: ${value}`);
  }
});
```

---

## 🌐 CORS – Cross-Origin Requests

If you're calling APIs from different origins, handle CORS properly:

### Server-Side Must Include:

```http
Access-Control-Allow-Origin: *
Access-Control-Allow-Methods: GET, POST
```

### In Fetch:

```js
fetch("https://another-origin.com/api", {
  mode: "cors",
});
```

---

## 📄 Uploading Files with `FormData`

```js
const formData = new FormData();
formData.append("avatar", fileInput.files[0]);

fetch("/upload", {
  method: "POST",
  body: formData,
});
```

⚠️ No need to set `Content-Type` manually; `FormData` sets it for you.

---

## 🧵 Sequential vs Parallel Fetch

### Sequential (waits for each one)

```js
const urls = ["url1", "url2"];
for (let url of urls) {
  const res = await fetch(url);
  const data = await res.json();
}
```

### Parallel (faster)

```js
const urls = ["url1", "url2"];
const responses = await Promise.all(urls.map((url) => fetch(url)));
const data = await Promise.all(responses.map((res) => res.json()));
```

---

## 🧰 Advanced: Custom Timeout Wrapper

```js
function fetchWithTimeout(url, options, timeout = 5000) {
  return Promise.race([
    fetch(url, options),
    new Promise((_, reject) =>
      setTimeout(() => reject(new Error("Timeout")), timeout)
    ),
  ]);
}
```

---

## 🧑‍🔬 Real World Use Case – Login

```js
async function login(email, password) {
  const res = await fetch("/api/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ email, password }),
  });

  if (!res.ok) {
    const errData = await res.json();
    throw new Error(errData.message || "Login failed");
  }

  return res.json();
}
```

---

## 🧠 Summary

| Concept                              | Key Point                      |
| ------------------------------------ | ------------------------------ |
| Fetch returns Promise                | Use `.then()` or `async/await` |
| `.ok` and `.status`                  | Check manually for 4xx/5xx     |
| `.json()`, `.text()`                 | Read different body types      |
| `POST` requires `headers` and `body` | JSON payload                   |
| AbortController                      | Cancel ongoing requests        |
| FormData                             | Upload files easily            |
| CORS                                 | Needs server-side setup        |
| Authentication                       | Use headers or credentials     |

---

## 📚 Related Topics to Learn Next

- Axios (Fetch alternative with more features)
- HTTP status codes
- CORS policies and browser security
- WebSockets (for real-time)
- GraphQL with fetch

---

# 🔄Chapter - 22 Async / Await in JavaScript

---

## 🧠 What is `async/await`?

- `async/await` is **syntactic sugar over Promises**.
- It helps write **asynchronous code** that looks and behaves more like synchronous code.
- Introduced in **ES2017 (ES8)**.

---

## ✅ Basics

### 1. `async` Function

- Declares a function that will always return a **Promise**.

```js
async function myFunc() {
  return "Hello";
}

myFunc().then(console.log); // Output: Hello
```

If you return a non-promise value, it's automatically wrapped in a resolved Promise.

### 2. `await` Keyword

- Can **only be used inside `async` functions**.
- Pauses execution of the function **until the Promise is resolved**.
- Returns the resolved value of the Promise.

```js
async function fetchData() {
  const res = await fetch("https://api.example.com/data");
  const data = await res.json();
  console.log(data);
}
```

---

## ⚙ How It Works Under the Hood

```js
async function getData() {
  try {
    const result = await fetchData(); // Pauses here until Promise resolves
    return result;
  } catch (err) {
    console.error(err);
  }
}
```

The above is equivalent to:

```js
function getData() {
  return fetchData()
    .then((result) => result)
    .catch((err) => console.error(err));
}
```

---

## ⏳ Awaiting Multiple Promises

### ✅ Sequential (slower)

```js
const user = await getUser();
const posts = await getPosts(user.id);
```

### ✅ Parallel (faster)

```js
const [user, posts] = await Promise.all([getUser(), getPosts()]);
```

---

## 🧨 Error Handling

### With `try/catch`

```js
async function getUserData() {
  try {
    const res = await fetch("/user");
    const data = await res.json();
    return data;
  } catch (error) {
    console.error("Failed to fetch user:", error);
  }
}
```

### For multiple awaits:

```js
try {
  const user = await getUser();
  const posts = await getPosts(user.id);
} catch (err) {
  console.error("Something went wrong", err);
}
```

---

## 🔁 Using `await` in Loops

Avoid using `await` inside `.forEach()` — it won’t wait!

### ❌ Wrong:

```js
[1, 2, 3].forEach(async (num) => {
  await doSomething(num);
});
```

### ✅ Correct:

```js
for (const num of [1, 2, 3]) {
  await doSomething(num);
}
```

---

## 🔄 Async IIFE (Immediately Invoked Function Expression)

Useful for top-level `await` before ES2022:

```js
(async () => {
  const data = await fetchData();
  console.log(data);
})();
```

---

## 🔝 Top-Level Await (ES2022+)

```js
const res = await fetch("/api"); // valid at module level
```

- Only available in **ES Modules**, not in CommonJS.

---

## 💡 Best Practices

- Use `async/await` for **readability** and **linear code flow**.
- Use `try/catch` to handle errors gracefully.
- Use `Promise.all()` for **concurrent tasks** when safe.
- Avoid blocking loops — use `map` with `Promise.all()` for parallel processing if needed.

---

## 🧪 Example: Full Flow

```js
async function getUserProfile(id) {
  try {
    const userRes = await fetch(`/api/users/${id}`);
    const user = await userRes.json();

    const postsRes = await fetch(`/api/users/${id}/posts`);
    const posts = await postsRes.json();

    return { user, posts };
  } catch (error) {
    console.error("Error fetching profile:", error);
  }
}
```

---

## ❓ Common Mistakes

| Mistake                                   | Why it's wrong               |
| ----------------------------------------- | ---------------------------- |
| Using `await` outside of `async`          | Throws SyntaxError           |
| Mixing `await` with `.then()` excessively | Redundant, loses readability |
| Not handling rejected Promises            | Will cause uncaught errors   |
| Using `await` in a loop unnecessarily     | Can lead to slow performance |

---

## 🔚 Summary

| Concept           | Description                                              |
| ----------------- | -------------------------------------------------------- |
| `async`           | Declares an async function that returns a Promise        |
| `await`           | Waits for the Promise to resolve before moving on        |
| `try/catch`       | Used for error handling inside async functions           |
| `Promise.all()`   | Allows concurrent execution of multiple async operations |
| Top-Level `await` | Available in ES Modules only                             |

---

## 📦 Chapter - 23 JavaScript Modules – Full Notes

### 🔹 What Are Modules?

- **Modules** in JavaScript are files that contain code which is **self-contained and reusable**.
- Help **encapsulate logic**, avoid polluting the global namespace, and manage dependencies efficiently.

---

## 1. 🔰 Why Use Modules?

- Promote **code reusability**.
- Enable **separation of concerns**.
- Help in **maintaining** and **scaling** codebases.
- Prevent **naming conflicts** (each module has its own scope).

---

## 2. 📁 Types of Modules in JavaScript

| Type                                 | Syntax                            | Environment                          |
| ------------------------------------ | --------------------------------- | ------------------------------------ |
| ES Modules (ESM)                     | `import` / `export`               | Modern Browsers, Node.js (from v14+) |
| CommonJS (CJS)                       | `require()` / `module.exports`    | Node.js (default pre-v14)            |
| UMD (Universal Module Definition)    | Works in both browser and Node.js | Libraries                            |
| AMD (Asynchronous Module Definition) | `define()`                        | Browser (e.g., RequireJS)            |

---

## 3. ✨ ES Modules (ESM)

### ➕ Exporting

```js
// utils.js
export const add = (a, b) => a + b;
export const multiply = (a, b) => a * b;
```

OR

```js
// utils.js
const subtract = (a, b) => a - b;
export default subtract;
```

### ➕ Export All at Once

```js
// utils.js
const divide = (a, b) => a / b;
const mod = (a, b) => a % b;
export { divide, mod };
```

### ➖ Importing

```js
// app.js
import { add, multiply } from "./utils.js";
import subtract from "./utils.js";
```

### 🔀 Rename While Importing

```js
import { add as addition } from "./utils.js";
```

---

## 4. 📦 CommonJS (Node.js)

### ➕ Export

```js
// utils.js
const add = (a, b) => a + b;
module.exports = { add };
```

### ➖ Import

```js
// app.js
const { add } = require("./utils");
```

> ⚠️ `require` is **synchronous** and only works in Node.js (unless bundled).

---

## 5. 🏗 Module Scope

- Variables/functions declared in a module are **not global**.
- Each module has its own **module scope**.

---

## 6. 📄 Default vs Named Exports

| Feature            | Named Export             | Default Export            |
| ------------------ | ------------------------ | ------------------------- |
| Syntax             | `export const foo = ...` | `export default foo`      |
| Import Syntax      | `import { foo }`         | `import foo`              |
| Multiple per file? | ✅                       | ❌                        |
| Use-case           | Multiple exports         | One main thing per module |

---

## 7. 🌍 Top-Level `await` (in ESM)

```js
// Only in modules
const data = await fetch("/api/data").then((res) => res.json());
```

> ✅ Works only in **ES Modules** and not in CommonJS.

---

## 8. ⚙ How to Use Modules in Browser

```html
<script type="module" src="main.js"></script>
```

> 🚨 Modules are **deferred by default** and follow **CORS rules**.

---

## 9. 🌐 Modules in Node.js

- Use `.mjs` extension **or**
- Set `"type": "module"` in `package.json`.

```json
{
  "type": "module"
}
```

---

## 10. 🔗 Dynamic Imports (Code Splitting)

```js
// Load a module dynamically
const module = await import("./math.js");
module.add(2, 3);
```

> ✅ Useful for **lazy loading**, **conditional loading**, etc.

---

## 11. 📦 Bundlers & Tools

| Tool            | Role                                   |
| --------------- | -------------------------------------- |
| **Webpack**     | Bundles multiple modules into one      |
| **Rollup**      | Tree-shaking + ES Modules              |
| **Parcel/Vite** | Fast bundling with ESM support         |
| **Babel**       | Transpiles modern JS to older versions |

---

## 12. 🔍 Tree Shaking

- **Eliminates unused exports** from final bundle.
- Only works with **ES Modules**, not CommonJS.

---

## 13. ✅ Best Practices

- Use **ES Modules** for new projects.
- Stick to **one default export** per file (if used).
- Use **descriptive filenames** (`mathUtils.js`, `authService.js`).
- Keep **modules small and focused**.

---

## 14. 🧠 Advanced Concepts

| Concept                    | Description                                                  |
| -------------------------- | ------------------------------------------------------------ |
| **Module Resolution**      | How the engine locates a module (`node_modules`, file paths) |
| **Circular Dependencies**  | Two modules depend on each other. Try to refactor to avoid.  |
| **Named Exports Conflict** | Same name used in multiple modules—can alias during import.  |
| **Side Effects**           | A module runs code when imported (e.g., global setup)        |

---

# 🟦Chapter - 24 ES6 (ECMAScript 2015) Features in JavaScript

## 1. `let` and `const`

### ✅ `let`

- Block-scoped (limited to `{}`)
- Can be reassigned
- Not hoisted like `var`

```js
let count = 10;
count = 15;
```

### ✅ `const`

- Block-scoped
- Cannot be reassigned
- Must be initialized during declaration

```js
const PI = 3.14;
// PI = 3.15 ❌ Error
```

---

## 2. Arrow Functions `()=>`

- Shorter syntax for writing functions
- `this` is lexically bound (no dynamic `this`)
- Cannot be used as constructors

```js
const add = (a, b) => a + b;
const square = (n) => n * n;
```

---

## 3. Template Literals

- Use backticks `` ` ``
- Multiline strings
- Embed expressions using `${}`

```js
const name = "John";
console.log(`Hello, ${name}!`);
```

---

## 4. Destructuring Assignment

### ✅ Array Destructuring

```js
const [a, b] = [10, 20];
```

### ✅ Object Destructuring

```js
const user = { name: "Alice", age: 25 };
const { name, age } = user;
```

---

## 5. Default Parameters

```js
function greet(name = "Guest") {
  console.log(`Hello, ${name}`);
}
greet(); // Hello, Guest
```

---

## 6. Rest and Spread Operators `...`

### ✅ Rest (collects values)

```js
function sum(...numbers) {
  return numbers.reduce((a, b) => a + b);
}
```

### ✅ Spread (expands values)

```js
const arr1 = [1, 2];
const arr2 = [...arr1, 3, 4];
```

---

## 7. Enhanced Object Literals

- Shorthand for properties and methods

```js
const name = "Max";
const user = {
  name,
  greet() {
    console.log(`Hi, I'm ${this.name}`);
  },
};
```

---

## 14. Map and Set

### ✅ Map

- Stores key-value pairs (any data type as key)

```js
const map = new Map();
map.set("name", "Alice");
console.log(map.get("name")); // Alice
```

### ✅ Set

- Stores unique values

```js
const set = new Set([1, 2, 2, 3]);
console.log(set); // Set {1, 2, 3}
```

---

## Chapter - 25

## 🔹 1. `this` in Global Scope

In the **global execution context**, `this` refers to the **global object**:

- In browsers: `window`
- In Node.js: `global`

### ✅ Example:

```js
console.log(this); // In browsers: window
```

In **strict mode**, `this` in the global scope is `undefined` inside a function (not methods).

---

## 🔹 2. `this` in Functions (Strict vs Non-Strict Mode)

### ⚙️ Non-Strict Mode:

```js
function show() {
  console.log(this);
}
show(); // window (in browsers)
```

### ⚙️ Strict Mode:

```js
"use strict";
function show() {
  console.log(this);
}
show(); // undefined
```

> ✅ In strict mode, functions called directly (not as a method) will have `this` as `undefined`.

---

## 🔹 3. `this` Substitution (Non-Strict Mode)

When `null` or `undefined` is passed as `this`, it's **substituted with the global object** (in non-strict mode).

```js
function foo() {
  console.log(this);
}

foo.call(null); // window (in browser)
foo.call(undefined); // window
```

In strict mode, `this` remains `null` or `undefined`.

```js
"use strict";
function foo() {
  console.log(this);
}
foo.call(null); // null
```

---

## 🔹 4. `this` Depends on How a Function is Called

```js
const person = {
  name: "Alice",
  greet() {
    console.log(this.name);
  },
};

person.greet(); // Alice

const greetFn = person.greet;
greetFn(); // undefined (or window.name if set)
```

> ✅ `this` depends on the **calling context**, not where the function is defined.

---

## 🔹 5. `this` in Object Methods

When a function is **called as a method** of an object, `this` refers to that object.

```js
const user = {
  name: "John",
  sayHi() {
    console.log(this.name);
  },
};
user.sayHi(); // John
```

But if you extract the method:

```js
const hi = user.sayHi;
hi(); // undefined (or window.name if set)
```

---

## 🔹 6. `this` with `call()`, `apply()`, `bind()`

### `call()` and `apply()` immediately invoke the function with explicit `this`.

```js
function greet() {
  console.log(`Hello, ${this.name}`);
}
const person = { name: "John" };

greet.call(person); // Hello, John
greet.apply(person); // Hello, John
```

### `bind()` returns a new function with `this` bound:

```js
const greetJohn = greet.bind(person);
greetJohn(); // Hello, John
```

---

## 🔹 7. `this` in Arrow Functions

Arrow functions **do not have their own `this`**. They inherit it **lexically** from their enclosing context.

```js
const user = {
  name: "Alice",
  greet: () => {
    console.log(this.name); // ❌ undefined, not "Alice"
  },
};
user.greet();
```

> Arrow functions should **not** be used as methods.

---

## 🔹 8. Lexical `this` (Enclosing Context)

```js
function outer() {
  const arrow = () => {
    console.log(this);
  };
  arrow();
}

const obj = { outer };
obj.outer(); // `this` is obj due to lexical scoping of arrow function
```

---

## 🔹 9. `this` in Nested Arrow Functions

Nested arrow functions **continue to inherit `this` from their outer (non-arrow) function**.

```js
const person = {
  name: "Bob",
  outer() {
    const inner = () => {
      const innerMost = () => {
        console.log(this.name);
      };
      innerMost();
    };
    inner();
  },
};

person.outer(); // Bob
```

---

## 🔹 10. `this` in DOM Elements

When used in DOM event handlers, `this` refers to the **element the event is bound to**.

```html
<button id="myBtn">Click Me</button>

<script>
  const btn = document.getElementById("myBtn");
  btn.addEventListener("click", function () {
    console.log(this); // <button> element
  });
</script>
```

> ⚠️ Using arrow functions here will not work as expected:

```js
btn.addEventListener("click", () => {
  console.log(this); // ❌ window, not button
});
```

---

## ✅ Summary Table

| Context                     | `this` Value                               |
| --------------------------- | ------------------------------------------ |
| Global scope                | Global object (`window`/`global`)          |
| Function (non-strict)       | Global object                              |
| Function (strict)           | `undefined`                                |
| Object method               | Object itself                              |
| `call` / `apply` / `bind`   | Explicitly set                             |
| Arrow function              | Lexical (inherited) `this`                 |
| DOM Event (normal function) | DOM element                                |
| DOM Event (arrow function)  | Lexical `this` (usually `window`)          |
| Nested arrow function       | Inherited from outermost non-arrow context |

---

# **Chapter - 26**

# **1. Classes in JavaScript**

JavaScript classes are templates for creating objects. They encapsulate data and behavior into reusable blueprints.

### **Example:**

```javascript
class User {
  constructor(username, email, password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }
}
```

Here, `User` is a class with properties (`username`, `email`, `password`) initialized inside a **constructor**.

---

# **2. Constructor Method**

The `constructor` is a special method in a class that initializes an object’s properties.

### **Example:**

```javascript
class Car {
  constructor(brand, model) {
    this.brand = brand;
    this.model = model;
  }
}

const myCar = new Car("Toyota", "Corolla");
console.log(myCar); // Car { brand: 'Toyota', model: 'Corolla' }
```

---

# **3. Instance Methods**

These are functions defined inside a class that operate on the object’s properties.

### **Example:**

```javascript
class User {
  constructor(username, email) {
    this.username = username;
    this.email = email;
  }

  login() {
    console.log(`${this.username} is logged in`);
  }
}

const user1 = new User("Alice", "alice@example.com");
user1.login(); // Output: Alice is logged in
```

---

# **4. Inheritance (Extending a Class)**

A class can inherit from another class using the `extends` keyword.

### **Example:**

```javascript
class Animal {
  constructor(name) {
    this.name = name;
  }

  makeSound() {
    console.log("Some generic sound...");
  }
}

class Dog extends Animal {
  constructor(name, breed) {
    super(name);
    this.breed = breed;
  }

  bark() {
    console.log("Woof! Woof!");
  }
}

const myDog = new Dog("Buddy", "Golden Retriever");
myDog.makeSound(); // Output: Some generic sound...
myDog.bark(); // Output: Woof! Woof!
```

- `Dog` extends `Animal`, inheriting its properties (`name`) and methods (`makeSound()`).
- The `super(name)` calls the parent constructor.

---

# **5. Method Overriding**

A subclass can redefine a method from the parent class.

### **Example:**

```javascript
class Animal {
  speak() {
    console.log("Animal speaks");
  }
}

class Cat extends Animal {
  speak() {
    console.log("Meow! Meow!");
  }
}

const kitty = new Cat();
kitty.speak(); // Output: Meow! Meow!
```

Here, the `speak()` method in `Cat` overrides the `speak()` method in `Animal`.

---

# **6. The `instanceof` Operator**

It checks if an object belongs to a class or its subclass.

### **Example:**

```javascript
console.log(myDog instanceof Dog); // true
console.log(myDog instanceof Animal); // true
console.log(myDog instanceof Object); // true
```

---

# **7. Static Properties & Methods**

Static properties and methods belong to the class itself, not instances.

### **Example:**

```javascript
class MathUtils {
  static PI = 3.1416;

  static add(a, b) {
    return a + b;
  }
}

console.log(MathUtils.PI); // 3.1416
console.log(MathUtils.add(10, 20)); // 30
```

- `PI` and `add()` are **static**, meaning they can be accessed directly using the class name.

---

# **8. Encapsulation (Private Properties)**

Private properties can only be accessed within the class.

### **Example:**

```javascript
class BankAccount {
  #balance;

  constructor(initialBalance) {
    this.#balance = initialBalance;
  }

  deposit(amount) {
    this.#balance += amount;
  }

  getBalance() {
    return this.#balance;
  }
}

const myAccount = new BankAccount(1000);
myAccount.deposit(500);
console.log(myAccount.getBalance()); // Output: 1500
console.log(myAccount.#balance); // Error: Private field cannot be accessed
```

- `#balance` is a **private property**, preventing direct access from outside.

---

# **9. Polymorphism**

Polymorphism allows a method to be used in different ways.

### **Example:**

```javascript
class Shape {
  draw() {
    console.log("Drawing a shape");
  }
}

class Circle extends Shape {
  draw() {
    console.log("Drawing a circle");
  }
}

class Square extends Shape {
  draw() {
    console.log("Drawing a square");
  }
}

const shapes = [new Circle(), new Square()];
shapes.forEach((shape) => shape.draw());
```

Each class implements its version of `draw()`.

---

# **10. Getter and Setter Methods**

`get` and `set` allow controlled access to properties.

### **Example:**

```javascript
class Person {
  constructor(name) {
    this._name = name;
  }

  get name() {
    return this._name;
  }

  set name(newName) {
    this._name = newName;
  }
}

const person = new Person("John");
console.log(person.name); // John
person.name = "Doe";
console.log(person.name); // Doe
```

---

# **Final Thoughts**

Your provided code utilizes:
✅ **Classes**  
✅ **Inheritance**  
✅ **Instance Methods**  
✅ **Method Overriding**  
✅ **Instanceof Operator**  
✅ **Static Properties & Methods**

---

# **`call`, `apply`, and `bind` in JavaScript**

## **1. Understanding `this` in JavaScript**

Before diving into `call`, `apply`, and `bind`, it’s essential to understand `this`.

- The `this` keyword refers to the object that is currently executing the function.
- The value of `this` depends on how a function is called.

## **2. `call()`, `apply()`, and `bind()` Overview**

These methods allow us to control the value of `this` in function execution.

| Method      | Usage                                    | Arguments                            | Returns         | When to Use                                                                                      |
| ----------- | ---------------------------------------- | ------------------------------------ | --------------- | ------------------------------------------------------------------------------------------------ |
| **`call`**  | Calls the function immediately           | `thisArg, arg1, arg2, ...`           | Function result | When you need to invoke a function with a specified `this` value and pass arguments individually |
| **`apply`** | Calls the function immediately           | `thisArg, [arg1, arg2, ...]` (array) | Function result | When you need to invoke a function with a specified `this` value and pass arguments as an array  |
| **`bind`**  | Returns a new function with `this` bound | `thisArg, arg1, arg2, ...`           | New function    | When you need to create a new function with a permanently bound `this` value                     |

---

## **3. `call()` Method**

The `call()` method is used to invoke a function with a specified `this` value and pass arguments individually.

### **Syntax:**

```js
functionName.call(thisArg, arg1, arg2, ...);
```

### **Example: Using `call()`**

```js
const person = {
  name: "Alice",
  greet: function (age) {
    console.log(`Hello, my name is ${this.name} and I am ${age} years old.`);
  },
};

const person2 = { name: "Bob" };

person.greet.call(person2, 25);
// Output: Hello, my name is Bob and I am 25 years old.
```

✅ Here, `call()` sets `this` to `person2`, so `greet()` uses `person2.name` instead of `person.name`.

---

## **4. `apply()` Method**

The `apply()` method works just like `call()`, except it takes arguments as an array.

### **Syntax:**

```js
functionName.apply(thisArg, [arg1, arg2, ...]);
```

### **Example: Using `apply()`**

```js
const numbers = [3, 5, 7, 9];

console.log(Math.max.apply(null, numbers));
// Output: 9
```

✅ Here, `apply()` is used to pass the array `numbers` to `Math.max`, which expects individual arguments.

### **Key Difference Between `call()` and `apply()`**

- `call()` passes arguments one by one.
- `apply()` passes arguments as an array.

```js
someFunction.call(thisArg, arg1, arg2, arg3); // Pass arguments individually
someFunction.apply(thisArg, [arg1, arg2, arg3]); // Pass arguments as an array
```

---

## **5. `bind()` Method**

The `bind()` method does **not** immediately execute the function. Instead, it returns a **new function** with `this` permanently bound to the specified object.

### **Syntax:**

```js
const newFunction = functionName.bind(thisArg, arg1, arg2, ...);
```

### **Example: Using `bind()`**

```js
const person = {
  name: "Charlie",
  introduce: function () {
    console.log(`Hi, I'm ${this.name}!`);
  },
};

const newIntro = person.introduce.bind(person);

newIntro();
// Output: Hi, I'm Charlie!
```

✅ Here, `bind()` creates a new function (`newIntro`) where `this` is permanently set to `person`.

### **Example with Pre-set Arguments**

```js
function multiply(a, b) {
  return a * b;
}

const double = multiply.bind(null, 2); // `a` is permanently set to 2

console.log(double(5));
// Output: 10
```

✅ The `double` function always multiplies by 2.

---

## **6. When to Use `call()`, `apply()`, and `bind()`**

| Scenario                                                                    | Method to Use |
| --------------------------------------------------------------------------- | ------------- |
| Invoke a function with a different `this` and arguments passed individually | `call()`      |
| Invoke a function with a different `this` and arguments passed as an array  | `apply()`     |
| Create a new function with a permanently bound `this` value                 | `bind()`      |

---

## **7. Real-world Examples**

### **1. Borrowing Methods**

Using `call()` to borrow methods from one object to another:

```js
const obj1 = {
  name: "John",
  sayName: function () {
    console.log(this.name);
  },
};

const obj2 = { name: "Doe" };

obj1.sayName.call(obj2);
// Output: Doe
```

✅ `call()` lets `obj2` use `sayName()` from `obj1`.

---

### **2. Using `apply()` for Function Arguments**

```js
function sum(a, b, c) {
  return a + b + c;
}

const numbers = [1, 2, 3];

console.log(sum.apply(null, numbers));
// Output: 6
```

✅ `apply()` passes an array as arguments.

---

### **3. Setting `this` in Event Listeners with `bind()`**

```js
const button = document.getElementById("myButton");

const user = {
  name: "Eve",
  handleClick: function () {
    console.log(`Clicked by ${this.name}`);
  },
};

button.addEventListener("click", user.handleClick.bind(user));
// Ensures `this` refers to `user` instead of `button`
```

✅ `bind()` makes sure `this` refers to `user` inside `handleClick()`.

---

## **8. Summary**

- `call()` and `apply()` invoke a function immediately with a different `this`.
- `call()` takes arguments **individually**, while `apply()` takes them **as an array**.
- `bind()` returns a new function with `this` **permanently bound**.
