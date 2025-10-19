# 3.3 Designing Data Types

In this section, we explore key **object-oriented design principles** — encapsulation, immutability, and inheritance — and how they support modular programming, debugging, and writing clear, reliable code.

---

## 🔒 Encapsulation
Encapsulation is the process of **hiding implementation details** from clients. It allows developers to:
- Build modular systems
- Simplify debugging
- Prevent unintended interference with internal data

### Example: Complex Numbers in Polar Form
`Complex.java` can represent a complex number using **polar coordinates** (r, θ) rather than Cartesian (x, y):
\[ r(\cos\theta + i\sin\theta) \]

Encapsulation allows switching between representations **without changing client code**.

### Private Access Modifier
Declaring instance variables as `private` ensures they cannot be accessed directly by external code. This enforces encapsulation and prevents modification errors.

### Counter Example
`Counter.java` encapsulates a single integer that can only be incremented by 1.

#### Without encapsulation:
```java
Counter counter = new Counter("Volusia");
counter.count = -16022; // invalid modification
```
#### With encapsulation:
```java
private int count; // prevents direct modification
```
Such code will not compile, enforcing data integrity.

---

## 🧊 Immutability
An **immutable** data type is one where objects cannot change once created.

### Benefits
- Easier to reason about
- Safer to share between methods
- Prevents unintended side effects

### Cost
Every change requires **creating a new object**, which can increase memory usage.

### `final` Keyword
Declaring a variable as `final` ensures it is assigned only once, supporting immutability.

### Defensive Copying
If an instance variable holds a reference to a **mutable** object, the class should create a defensive copy to maintain immutability.

---

## 🧭 Spatial Vectors
A **vector** is a mathematical entity with both magnitude and direction. Represented as:
\[ x = (x_0, x_1, \dots, x_{n-1}) \]

### Operations
| Operation | Formula |
|------------|----------|
| Addition | \( x + y = (x_0+y_0, \dots, x_{n-1}+y_{n-1}) \) |
| Scaling | \( \alpha x = (\alpha x_0, \dots, \alpha x_{n-1}) \) |
| Dot Product | \( x \cdot y = x_0y_0 + \dots + x_{n-1}y_{n-1} \) |
| Magnitude | \( |x| = \sqrt{x_0^2 + \dots + x_{n-1}^2} \) |
| Direction | \( x/|x| \) |

### Vector API
| Method | Return Type | Description |
|---------|--------------|-------------|
| `Vector(double[] a)` | — | create a new vector |
| `Vector plus(Vector that)` | Vector | add this vector and `that` |
| `Vector scale(double alpha)` | Vector | scale this vector by `alpha` |
| `double dot(Vector that)` | double | compute the dot product |
| `double magnitude()` | double | compute the vector magnitude |
| `Vector direction()` | Vector | unit vector in the same direction |

### Example Implementation
```java
public double magnitude() {
    return Math.sqrt(this.dot(this));
}
```
The keyword `this` refers to the current object instance.

---

## 🧩 Interface Inheritance (Subtyping)
An **interface** defines a set of abstract methods that multiple classes can implement. It enables polymorphism and dynamic dispatch.

### Example: Function Interface
```java
public interface Function {
    public abstract double evaluate(double x);
}
```

### Implementations
```java
public class Square implements Function {
    public double evaluate(double x) {
        return x * x;
    }
}

public class GaussianPDF implements Function {
    public double evaluate(double x) {
        return Math.exp(-x*x / 2) / Math.sqrt(2 * Math.PI);
    }
}
```

### Using Interfaces
```java
Function f1 = new Square();
Function f2 = new GaussianPDF();
Function f3 = new Complex(1.0, 2.0); // compile-time error
```
When a method from an interface is invoked, Java calls the appropriate implementation — a process called **polymorphism**.

---

## 📈 Function Applications

### Plotting Functions
`FunctionGraph.java` plots a function `f` over an interval `[a, b]` by sampling `n + 1` points.

### Numerical Integration
`RectangleRule.java` estimates the integral of a function `f` using the rectangle rule.

---

## 🧮 Lambda Expressions
A **lambda expression** is a block of code that can be passed and executed later.

### Syntax
```java
(parameters) -> expression
```
Example:
```java
x -> x * x  // hypotenuse function: (x, y) -> Math.sqrt(x*x + y*y)
```
Lambda expressions are concise ways to implement **functional interfaces**:
```java
integrate(x -> x*x, 0, 10, 1000);
```
This eliminates the need for defining a separate `Square` class.

---

## 🧱 Implementation Inheritance (Subclassing)
Java allows one class to inherit from another using **subclassing**. A subclass inherits all state and behavior from its superclass and may override methods.

However, subclassing can break encapsulation and immutability. This book discourages subclassing except where unavoidable.

### Object Superclass
All classes inherit from `java.lang.Object`. Commonly overridden methods include:
| Method | Description |
|---------|-------------|
| `toString()` | convert object to a string |
| `equals(Object y)` | compare object values |
| `hashCode()` | compute hash code for hashing operations |

---

## 🔁 Object Equality and Hashing

### Equality
The `equals()` method checks if two objects have the same **value**, not just the same reference.

Rules for `equals()`:
- Reflexive: `x.equals(x)` is true
- Symmetric: `x.equals(y)` ⇔ `y.equals(x)`
- Transitive: if `x.equals(y)` and `y.equals(z)`, then `x.equals(z)`

### Hashing
Used to map objects to integers:
```java
private int hash(Object x) {
    return Math.abs(x.hashCode() % m);
}
```
If `x.equals(y)` is true, then `x.hashCode()` must equal `y.hashCode()`.

---

## 🧰 Wrapper Types
Java provides **wrapper classes** for primitive types, allowing them to behave as objects.

| Primitive | Wrapper |
|------------|----------|
| int | Integer |
| double | Double |
| boolean | Boolean |
| char | Character |

### Autoboxing & Unboxing
```java
Integer x = 17; // autoboxing (int → Integer)
int a = x;      // unboxing   (Integer → int)
```

---

## 🧠 Application: Data Mining with Sketches

A **sketch** represents a document as a vector summarizing its content. Two similar documents produce similar sketches.

### Sketch API
| Method | Return Type | Description |
|---------|--------------|-------------|
| `Sketch(String text, int k, int d)` | — | create sketch of text |
| `double similarTo(Sketch that)` | double | compare two sketches (0–1 scale) |

### Computing Sketches
Each `k`-gram (substring of length `k`) is hashed into one of `d` bins, and frequencies are counted. Cosine similarity measures how close two sketches are:
\[ x \cdot y = x_0y_0 + x_1y_1 + ... + x_{d-1}y_{d-1} \]

---

## ⚖️ Design by Contract
Use **exceptions** and **assertions** to ensure program correctness.

### Exceptions
An **exception** signals an error or unexpected event.
```java
if (this.length() != that.length())
    throw new IllegalArgumentException("Dimensions disagree.");
```

### Assertions
Used for internal debugging:
```java
assert count >= 0 : "Negative count detected in increment()";
```
Enable assertions using:
```
java -ea ClassName
```

#### Design by Contract Terminology
| Concept | Description |
|----------|-------------|
| **Precondition** | Client’s responsibility before calling a method |
| **Postcondition** | Method’s guarantee after completion |
| **Invariant** | Condition maintained throughout execution |

---

## 🧩 Exercises

### 1. Implementing `minus()` in Vector.java
```java
public Vector minus(Vector that) {
    return this.plus(that.scale(-1.0));
}
```

### 2. Adding `toString()` to Vector.java
```java
public String toString() {
    return Arrays.toString(this.coordinates);
}
```
This method returns the vector components separated by commas and enclosed in parentheses.

---

**Summary:**
Encapsulation, immutability, and inheritance together form the foundation for designing robust, modular, and maintainable data types in Java.

