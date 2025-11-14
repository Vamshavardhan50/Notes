## 🔰 HTML 📄 Intro

HTML (🌐HyperText Markup Language) is the standard 🗣️ used to make 🧱 web pages. It's not a 👨‍💻 language but a 📑 language that defines layout & structure. It uses 🏷️ (tags) to describe parts of a web page.

```html
<!DOCTYPE html>
<html>
  <head>
    <title>🖼️ My First Page</title>
  </head>
  <body>
    👋 Hello, World!
  </body>
</html>
```

---

## 🏷️ HTML 🔠 Elements

Each HTML 🔠 consists of a ⬅️ start tag, 📦 content, and ➡️ end tag. Elements can be nested 🔁.

```html
<p>📄 This is a paragraph.</p>
<b>🔡 This is bold text</b>
```

---

## 🧱 HTML Structure

A typical 🏗️ document includes:

<<<<<<< HEAD
- `<!DOCTYPE html>`: Declares 🏷️ type
- `<html>`: 🌳 Root
- `<head>`: 💭 Metadata
- `<body>`: 👀 Visible content
=======
* `<!DOCTYPE html>`: Declares 🏷️ type
* `<html>`: 🌳 Root
* `<head>`: 💭 Metadata
* `<body>`: 👀 Visible content
>>>>>>> dca083a95e5e9ee3ee7e4ccedcc6ffc0e824669b

```html
<!DOCTYPE html>
<html>
  <head>
    <title>📄 Page Title</title>
  </head>
  <body>
    <h1>🔝 Main Heading</h1>
    <p>📝 This is content.</p>
  </body>
</html>
```

---

## 🔤 Headings

📢 Headings define content structure. Six levels exist:

```html
<h1>🔊 Heading 1</h1>
<h2>🔉 Heading 2</h2>
<h3>🔈 Heading 3</h3>
```

---

## 📝 Paragraphs

Used to define ✍️ blocks.

```html
<p>📃 This is a paragraph.</p>
```

---

## 🔧 Attributes

🧩 Attributes add extra info about elements, placed in opening tag.

```html
<<<<<<< HEAD
<img src="logo.png" alt="🏢 Company Logo" />
=======
<img src="logo.png" alt="🏢 Company Logo">
>>>>>>> dca083a95e5e9ee3ee7e4ccedcc6ffc0e824669b
<a href="https://example.com" target="_blank">🔗 Visit Site</a>
```

---

## 🎨 HTML Styles

HTML supports 🎨 using `style`. CSS is usually better.

```html
<p style="color:blue; font-size:16px;">💅 Styled Text</p>
```

---

## 📦 Box Model

📐 CSS box model =

<<<<<<< HEAD
- 📄 Content
- 📏 Padding
- 🧱 Border
- 🌌 Margin
=======
* 📄 Content
* 📏 Padding
* 🧱 Border
* 🌌 Margin
>>>>>>> dca083a95e5e9ee3ee7e4ccedcc6ffc0e824669b

```css
.box {
  width: 200px;
  padding: 10px;
  border: 2px solid black;
  margin: 20px;
}
```

```html
<div class="box">📦 Box Model Example</div>
```

---

## 🌈 Colors in HTML

Set 🎨 using names, HEX, RGB, HSL.

```html
<p style="color:red;">🔴 Red Text</p>
<p style="background-color:#00ff00;">🟢 Green Background</p>
```

---

## 🔗 Connecting HTML & CSS

To link 🔗 external styles:

```html
<<<<<<< HEAD
<link rel="stylesheet" href="styles.css" />
=======
<link rel="stylesheet" href="styles.css">
>>>>>>> dca083a95e5e9ee3ee7e4ccedcc6ffc0e824669b
```

---

## 🖼️ Images

Add 🖼️ using `<img>` tag (self-closing).

```html
<<<<<<< HEAD
<img src="photo.jpg" alt="📸 Description" width="300" height="200" />
=======
<img src="photo.jpg" alt="📸 Description" width="300" height="200">
>>>>>>> dca083a95e5e9ee3ee7e4ccedcc6ffc0e824669b
```

---

## 🔗 Links

Use `<a>` to link 🔗 pages/sites.

```html
<a href="https://www.google.com" target="_blank">🔍 Google</a>
```

---

## 📊 Tables

Show 📈 data in table format.

```html
<table border="1">
  <tr>
    <th>👤 Name</th>
    <th>🎂 Age</th>
  </tr>
  <tr>
    <td>John</td>
    <td>30</td>
  </tr>
</table>
```

---

## ✅ Formatted Text

Use 🏷️ to format:

```html
<b>💪 Bold</b>
<i>✨ Italic</i>
<u>📏 Underline</u>
<mark>📌 Highlight</mark>
<code>💻 Code</code>
```

---

## 📋 Lists

**🔢 Ordered List:**

```html
<ol>
  <li>1️⃣ Item One</li>
  <li>2️⃣ Item Two</li>
</ol>
```

**🔘 Unordered List:**

```html
<ul>
  <li>🔹 Item A</li>
  <li>🔸 Item B</li>
</ul>
```

---

## 📄 Forms

Collect 🧍‍♀️ user input.

```html
<form action="/submit" method="post">
  <label for="name">👤 Name:</label>
<<<<<<< HEAD
  <input type="text" id="name" name="name" /><br />

  <label for="email">📧 Email:</label>
  <input type="email" id="email" name="email" /><br />

  <input type="submit" value="📨 Submit" />
=======
  <input type="text" id="name" name="name"><br>

  <label for="email">📧 Email:</label>
  <input type="email" id="email" name="email"><br>

  <input type="submit" value="📨 Submit">
>>>>>>> dca083a95e5e9ee3ee7e4ccedcc6ffc0e824669b
</form>
```

---

## 🎨 CSS Basics

🎨 CSS = styles for 🧱 HTML.

**Inline:**

```html
<p style="color:blue;">🔵 Blue Text</p>
```

**Internal:**

```html
<style>
<<<<<<< HEAD
  p {
    color: green;
  }
=======
  p { color: green; }
>>>>>>> dca083a95e5e9ee3ee7e4ccedcc6ffc0e824669b
</style>
```

**External:**

```html
<<<<<<< HEAD
<link rel="stylesheet" href="styles.css" />
=======
<link rel="stylesheet" href="styles.css">
>>>>>>> dca083a95e5e9ee3ee7e4ccedcc6ffc0e824669b
```

---

## 🧑‍💻 Editors

Popular ✍️ tools:

<<<<<<< HEAD
- 🧠 VS Code
- 💡 Sublime
- ⚛️ Atom
- 📝 Notepad++
=======
* 🧠 VS Code
* 💡 Sublime
* ⚛️ Atom
* 📝 Notepad++
>>>>>>> dca083a95e5e9ee3ee7e4ccedcc6ffc0e824669b

---

## 🕰️ HTML History

<<<<<<< HEAD
- 🗓️ 1991: Tim Berners-Lee ➡️ HTML
- 🔁 HTML 4.01 (1999)
- 🆕 HTML5 (2014+)
=======
* 🗓️ 1991: Tim Berners-Lee ➡️ HTML
* 🔁 HTML 4.01 (1999)
* 🆕 HTML5 (2014+)
>>>>>>> dca083a95e5e9ee3ee7e4ccedcc6ffc0e824669b

---

## 🌐 Internet Navigation

HTML uses 🔗 `<a>` tags for browsing 🌍 pages.

---

## 📱 Responsive Design

For 📱 & 💻 layouts:

```html
<<<<<<< HEAD
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
=======
<meta name="viewport" content="width=device-width, initial-scale=1.0">
>>>>>>> dca083a95e5e9ee3ee7e4ccedcc6ffc0e824669b
```

```css
@media (max-width: 600px) {
  body {
    background-color: lightgray;
  }
}
```

---

## ✅ HTML Advantages

<<<<<<< HEAD
- 🧠 Easy to learn
- 🆓 Free & open
- 🌐 Universal
- 🤝 CSS/JS friendly
- 🔍 SEO-ready
=======
* 🧠 Easy to learn
* 🆓 Free & open
* 🌐 Universal
* 🤝 CSS/JS friendly
* 🔍 SEO-ready
>>>>>>> dca083a95e5e9ee3ee7e4ccedcc6ffc0e824669b
