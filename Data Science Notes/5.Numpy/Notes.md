# 📘 NumPy Notes

## 📌 Introduction

NumPy (Numerical Python) is a Python library used for working with arrays. It also has functions for working in domain of linear algebra, Fourier transform, and matrices.

## 🔧 Installation

```bash
pip install numpy
```

## 📚 Importing NumPy

```python
import numpy as np
```

## 📏 NumPy Arrays

### Creating Arrays

```python
arr = np.array([1, 2, 3])
print(arr)
# Output: [1 2 3]
```

### Array Dimensions

```python
# 0-D array
arr0 = np.array(42)
print(arr0)
# Output: 42

# 1-D array
arr1 = np.array([1, 2, 3, 4])
print(arr1)
# Output: [1 2 3 4]

# 2-D array
arr2 = np.array([[1, 2, 3], [4, 5, 6]])
print(arr2)
# Output:
# [[1 2 3]
#  [4 5 6]]

# 3-D array
arr3 = np.array([[[1, 2], [3, 4]], [[5, 6], [7, 8]]])
print(arr3)
# Output:
# [[[1 2]
#   [3 4]]
#  [[5 6]
#   [7 8]]]
```

## 🔄 Array Operations

### Array Indexing

```python
print(arr1[0])  # Accessing first element
# Output: 1
```

### Array Slicing

```python
print(arr1[1:3])  # Elements from index 1 to 2
# Output: [2 3]
```

### Array Shape and Reshape

```python
arr = np.array([[1, 2, 3], [4, 5, 6]])
print(arr.shape)
# Output: (2, 3)

reshaped = arr.reshape(3, 2)
print(reshaped)
# Output:
# [[1 2]
#  [3 4]
#  [5 6]]
```

## ➕ Arithmetic Operations

```python
arr1 = np.array([1, 2, 3])
arr2 = np.array([4, 5, 6])

print(arr1 + arr2)
# Output: [5 7 9]

print(arr1 * arr2)
# Output: [ 4 10 18]
```

## 🎯 Useful NumPy Functions

```python
print(np.zeros((2, 3)))
# Output:
# [[0. 0. 0.]
#  [0. 0. 0.]]

print(np.ones((2, 3)))
# Output:
# [[1. 1. 1.]
#  [1. 1. 1.]]

print(np.eye(3))
# Output:
# [[1. 0. 0.]
#  [0. 1. 0.]
#  [0. 0. 1.]]

print(np.arange(0, 10, 2))
# Output: [0 2 4 6 8]

print(np.linspace(0, 1, 5))
# Output: [0.   0.25 0.5  0.75 1.  ]
```

## 📈 Statistical Operations

```python
arr = np.array([1, 2, 3, 4, 5])

print(np.mean(arr))
# Output: 3.0

print(np.median(arr))
# Output: 3.0

print(np.std(arr))
# Output: 1.4142135623730951
```

## 🔍 Boolean Indexing

```python
arr = np.array([1, 2, 3, 4, 5])
print(arr[arr > 2])
# Output: [3 4 5]
```

## 🔁 Iterating Over Arrays

```python
arr2 = np.array([[1, 2, 3], [4, 5, 6]])
for x in np.nditer(arr2):
    print(x)
# Output:
# 1
# 2
# 3
# 4
# 5
# 6
```

## 📤 Saving and Loading

```python
arr = np.array([1, 2, 3])
np.save('my_array', arr)
arr_loaded = np.load('my_array.npy')
print(arr_loaded)
# Output: [1 2 3]
```

## 🧠 Advanced Concepts

### Broadcasting

Broadcasting allows NumPy to perform operations on arrays of different shapes.

```python
a = np.array([1, 2, 3])
b = 2
print(a + b)
# Output: [3 4 5]
```

### Matrix Multiplication

```python
A = np.array([[1, 2], [3, 4]])
B = np.array([[5, 6], [7, 8]])
result = np.dot(A, B)
print(result)
# Output:
# [[19 22]
#  [43 50]]
```

### Transpose

```python
A = np.array([[1, 2], [3, 4]])
print(A.T)
# Output:
# [[1 3]
#  [2 4]]
```

### Random Numbers

```python
print(np.random.rand(2, 3))  # 2x3 matrix of random floats in [0.0, 1.0)
```

### Copy vs View

```python
arr = np.array([1, 2, 3])
copy = arr.copy()
view = arr.view()

arr[0] = 100
print(copy)  # Copy is not affected
print(view)  # View reflects changes
# Output:
# [1 2 3] (copy)
# [100 2 3] (view)
```

## 📚 References

- [NumPy Official Docs](https://numpy.org/doc/)
