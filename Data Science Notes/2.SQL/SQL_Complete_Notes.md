# SQL Notes

## What is a Database?
A **Database** is an organized collection of information that is stored and accessed electronically. Think of it like a digital filing cabinet, where you can store data such as customer records, product details, or student information. Databases help us manage large volumes of data efficiently.

## What is DBMS?
**DBMS (Database Management System)** is software that helps users interact with databases. It allows us to store, retrieve, update, and manage data easily. Examples include MySQL, PostgreSQL, Oracle, and SQL Server.

## Difference Between SQL & MySQL
| Feature        | SQL (Structured Query Language)       | MySQL (Database Software)         |
|----------------|----------------------------------------|----------------------------------|
| Purpose        | Used to interact with databases        | Used to store and manage databases |
| Type           | Language                               | Software/Application             |
| Developed By   | ANSI (American Standards)              | Oracle (previously MySQL AB)     |
| Use            | Writing commands like SELECT, INSERT   | Running and managing databases   |

## Analogy
A **Database** is like a **Library**:
- **Database** = Library
- **Table** = Bookshelf
- **Row** = Book
- **Column** = Book properties like title, author

## Real World Analogy
A **School** Database:
- Database = School
- Table = Class
- Row = Student
- Column = Student's name, roll number, age, etc.

## Amazing Setup Tools
To practice SQL locally:
- **XAMPP / WAMP** – for MySQL server
- **MySQL Workbench** – GUI for MySQL
- **SQLite Browser** – Lightweight local DB

---

## CRUD in Databases (Theory)
CRUD = Create, Read, Update, Delete
These are the 4 basic operations in any database system.

## CRUD Commands (Simplified)
```sql
-- Create a new database
CREATE DATABASE School;

-- Use the database
USE School;

-- Create a table
CREATE TABLE Students (
  id INT,
  name VARCHAR(100),
  age INT
);

-- Insert data
INSERT INTO Students (id, name, age) VALUES (1, 'John', 20);

-- Read data
SELECT * FROM Students;

-- Update data
UPDATE Students SET age = 21 WHERE id = 1;

-- Delete data
DELETE FROM Students WHERE id = 1;
```

---

## Tables in SQL (Theory)
Tables are like spreadsheets where data is organized in rows and columns. Each table stores data about a specific topic.

## Data Types in SQL (Theory)
Data types define what kind of data a column can store:
- **INT** – Whole numbers (e.g. 1, 2, 100)
- **VARCHAR(n)** – Text with length limit
- **TEXT** – Large blocks of text
- **DATE** – Date values (e.g. '2024-01-01')
- **BOOLEAN** – TRUE or FALSE

## Creating Tables & Default Values
```sql
CREATE TABLE Students (
  id INT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  age INT DEFAULT 18
);
```

---

## Inserting and Retrieving Data
### Theory:
Use `INSERT INTO` to add new rows and `SELECT` to retrieve them.

### Code:
```sql
INSERT INTO Students (id, name, age) VALUES (2, 'Alice', 22);
SELECT * FROM Students;
```

---

## Primary Keys (Theory)
A **Primary Key** uniquely identifies each record in a table. It prevents duplicates and ensures data integrity.

### Code:
```sql
CREATE TABLE Teachers (
  teacher_id INT PRIMARY KEY,
  name VARCHAR(100)
);
```

---

## WHERE Clause (Theory)
The `WHERE` clause is used to filter records based on a condition.

### Code:
```sql
SELECT * FROM Students WHERE age > 18;
```

---

## Updating Data
### Theory:
`UPDATE` is used to change values in existing rows.

### Code:
```sql
UPDATE Students SET name = 'Johnny' WHERE id = 2;
```

---

## Deleting Data
### Remove Specific Column:
```sql
ALTER TABLE Students DROP COLUMN age;
```

### Delete All Rows:
```sql
DELETE FROM Students;
```

---

## Functions in SQL (Theory)
Functions perform operations on data:
- `UPPER()` – Converts text to uppercase
- `LENGTH()` – Finds the length of text

### Code:
```sql
SELECT UPPER(name), LENGTH(name) FROM Students;
```

---

## ORDER BY and LIMIT
### Theory:
Used to sort results and limit how many records to show.

### Code:
```sql
SELECT * FROM Students ORDER BY name ASC LIMIT 5;
```

---

## LIKE Clause
### Theory:
Used to search for a pattern.

### Code:
```sql
SELECT * FROM Students WHERE name LIKE 'A%';
```

---

## Aggregate Functions
### Theory:
Used to calculate values from multiple rows.
- `COUNT()` – Count rows
- `AVG()` – Average
- `SUM()` – Total sum
- `MAX()` / `MIN()` – Highest / Lowest value

### Code:
```sql
SELECT COUNT(*) FROM Students;
```

---

## GROUP BY Clause
### Theory:
Groups rows that have the same values in columns.

### Code:
```sql
SELECT age, COUNT(*) FROM Students GROUP BY age;
```

---

## SQL Operators
### Theory:
Used in conditions:
- Comparison: =, !=, >, <
- Logical: AND, OR, NOT

### Code:
```sql
SELECT * FROM Students WHERE age > 18 AND name LIKE 'A%';
```

---

## CASE Statement
### Theory:
Used to implement conditional logic.

### Code:
```sql
SELECT name,
  CASE
    WHEN age < 18 THEN 'Minor'
    ELSE 'Adult'
  END AS status
FROM Students;
```

---

## UNIQUE Constraint
### Theory:
Ensures all values in a column are different.

### Code:
```sql
CREATE TABLE Users (
  email VARCHAR(100) UNIQUE
);
```

---

## CHECK Constraint
### Theory:
Limits the values in a column.

### Code:
```sql
CREATE TABLE Products (
  price INT CHECK (price > 0)
);
```

---

## Altering Tables
### Theory:
Change table structure using `ALTER TABLE`

### Code:
```sql
ALTER TABLE Students ADD email VARCHAR(100);
```

---

## Relationships in SQL
### One-to-One:
Each row in one table has only one matching row in another.

### Foreign Keys:
Used to create a relationship between two tables.

### One-to-Many:
One record in a table is related to many in another.

```sql
CREATE TABLE Departments (
  id INT PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE Employees (
  id INT,
  dept_id INT,
  FOREIGN KEY (dept_id) REFERENCES Departments(id)
);
```

---

## Joins in SQL
### Cross Join:
```sql
SELECT * FROM A CROSS JOIN B;
```
### Inner Join:
```sql
SELECT * FROM A INNER JOIN B ON A.id = B.a_id;
```
### Left Join:
```sql
SELECT * FROM A LEFT JOIN B ON A.id = B.a_id;
```
### Right Join:
```sql
SELECT * FROM A RIGHT JOIN B ON A.id = B.a_id;
```

---

## Many-to-Many Relationship
### Theory:
Requires a junction table.

### Code:
```sql
CREATE TABLE StudentCourses (
  student_id INT,
  course_id INT,
  PRIMARY KEY (student_id, course_id),
  FOREIGN KEY (student_id) REFERENCES Students(id),
  FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);
```

---

## Views in SQL
### Theory:
A virtual table created using a query.

### Code:
```sql
CREATE VIEW StudentDetails AS
SELECT name, age FROM Students;
```

---

## Outro
SQL is a powerful language that helps us work with data stored in relational databases. From creating tables to writing complex queries with joins and functions, SQL is essential for backend development and data analysis.