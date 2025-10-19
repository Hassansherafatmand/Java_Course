# 3.2 Creating Data Types

In this section, we explore how to create **user-defined data types** in Java using classes. This mechanism enables programmers to model real-world entities such as charged particles, complex numbers, graphical turtles, and stock accounts.

---

## ⚙️ Basic Elements of a Data Type

### Example: Coulomb’s Law

To illustrate, consider **Charge.java**, a class modeling charged particles. The electric potential \( V \) at a point \((x, y)\) due to a charge \( q \) located at \((r_x, r_y)\) is defined by **Coulomb’s law**:

\[
V = k \frac{q}{r}
\]

where:

- \( k = 8.99 \times 10^9 \) is the electrostatic constant
- \( r \) is the distance from the point \((x, y)\) to the charge’s location

---

### 📘 Charge API

| Method                                    | Return Type | Description                                                    |
| ----------------------------------------- | ----------- | -------------------------------------------------------------- |
| `Charge(double x0, double y0, double q0)` | —           | create a charge with position `(x0, y0)` and charge value `q0` |
| `double potentialAt(double x, double y)`  | double      | compute electric potential at `(x, y)`                         |
| `void draw()`                             | void        | draw the charge on a 2D canvas                                 |

---

### Class Structure in Java

- **Class**: The implementation of a data type is written in a class (e.g., `Charge.java`).
- **Access Modifiers**:
  - `public` — accessible by all clients.
  - `private` — accessible only within the class.
  - `final` — indicates that a variable’s value cannot change after initialization.
- **Instance Variables**: Hold the data-type values (e.g., position and charge value).
- **Constructors**: Special methods invoked with `new` to allocate memory and initialize instance variables.
- **Instance Methods**: Define operations for the object, acting on instance variables.

---

### 🧱 Anatomy of a Class

```java
public class Charge {
    private final double rx, ry;   // position
    private final double q;        // charge

    public Charge(double x0, double y0, double q0) {
        rx = x0;
        ry = y0;
        q = q0;
    }

    public double potentialAt(double x, double y) {
        double k = 8.99e9;
        double dx = x - rx;
        double dy = y - ry;
        return k * q / Math.sqrt(dx*dx + dy*dy);
    }

    public void draw() {
        StdDraw.point(rx, ry);
    }
}
```

Each object of `Charge` represents one charged particle, with instance variables unique to that object.

---

### 🧪 Test Client

Each data type can include its own `main()` method for **unit testing**:

```java
public static void main(String[] args) {
    Charge c = new Charge(0.51, 0.63, 21.3);
    StdOut.println(c.potentialAt(0.9, 0.8));
}
```

---

## ⏱️ Stopwatch Data Type

### API

| Method                 | Return Type | Description                              |
| ---------------------- | ----------- | ---------------------------------------- |
| `Stopwatch()`          | —           | create a new stopwatch and start timing  |
| `double elapsedTime()` | double      | time elapsed since creation (in seconds) |

### Example Usage

```java
Stopwatch timer = new Stopwatch();
// ... code to time ...
StdOut.println(timer.elapsedTime());
```

---

## 📊 Histogram Data Type

### Description

`Histogram.java` visualizes data by counting occurrences of integer values between `0` and `n−1`, then displaying bars of proportional height.

### API

| Method                     | Return Type | Description                           |
| -------------------------- | ----------- | ------------------------------------- |
| `Histogram(int n)`         | —           | create a histogram with `n` bins      |
| `void addDataPoint(int i)` | void        | increment the count for bin `i`       |
| `void draw()`              | void        | display the histogram using `StdDraw` |

---

## 🐢 Turtle Graphics

### Description

`Turtle.java` models **turtle graphics**, a system where a turtle moves forward or rotates based on commands, tracing geometric paths.

### API

| Method                                     | Return Type | Description                                        |
| ------------------------------------------ | ----------- | -------------------------------------------------- |
| `Turtle(double x, double y, double angle)` | —           | create a turtle at `(x, y)` facing `angle` degrees |
| `void turnLeft(double degrees)`            | void        | rotate counterclockwise                            |
| `void moveForward(double distance)`        | void        | move forward in the current direction              |
| `void draw()`                              | void        | draw the path                                      |

### Example Clients

- **Ngon.java**: Draws a regular `n`-gon.
- **Koch.java**: Draws a recursive Koch curve.
- **Spiral.java**: Creates a logarithmic spiral.
- **DrunkenTurtle.java**: Simulates Brownian motion.

---

## 🔢 Complex Numbers

### Definition

A **complex number** has the form `x + iy`, where:

- `x` is the **real part**
- `y` is the **imaginary part**
- `i` is the square root of −1

### Operations

| Operation      | Formula                          |
| -------------- | -------------------------------- |
| Addition       | `(x0 + x1) + i(y0 + y1)`         |
| Multiplication | `(x0x1 − y0y1) + i(x0y1 + y0x1)` |
| Magnitude      | `√(x² + y²)`                     |

### Complex API

| Method                          | Return Type | Description                          |
| ------------------------------- | ----------- | ------------------------------------ |
| `Complex(double re, double im)` | —           | create a new complex number          |
| `Complex plus(Complex b)`       | Complex     | add this complex number and `b`      |
| `Complex times(Complex b)`      | Complex     | multiply this complex number and `b` |
| `double abs()`                  | double      | magnitude of this complex number     |
| `double re()`                   | double      | real part                            |
| `double im()`                   | double      | imaginary part                       |

### Example

```java
Complex a = new Complex(2.0, 3.0);
Complex b = new Complex(-1.0, 2.0);
Complex c = a.plus(b);   // (1.0 + 5.0i)
Complex d = a.times(b);  // (-8.0 + 1.0i)
```

---

## 🌀 Mandelbrot Set

### Definition

Given a complex number \( z*0 \), define the sequence:
\[ z*{i+1} = z_i^2 + z_0 \]

If the magnitude \( |z_i| > 2 \) at any point, the sequence diverges and \( z_0 \) is **not** in the Mandelbrot set. Otherwise, it’s considered part of the set.

### Algorithm

1. Iterate up to 255 terms for each \( z_0 \).
2. Check whether the magnitude exceeds 2.
3. Draw a black pixel if bounded, white if not.

This generates the iconic **Mandelbrot fractal image**.

---

## 💼 Commercial Data Processing: Stock Account

### Description

`StockAccount.java` is a data type representing a customer’s stock portfolio, tracking transactions and total value.

### API

| Method                                               | Return Type | Description                          |
| ---------------------------------------------------- | ----------- | ------------------------------------ |
| `StockAccount(String name, double balance)`          | —           | create a new account                 |
| `void buy(String symbol, double price, int shares)`  | void        | buy shares                           |
| `void sell(String symbol, double price, int shares)` | void        | sell shares                          |
| `double valueOf()`                                   | double      | total account value                  |
| `String toString()`                                  | String      | string representation of the account |

---

## 🧩 Summary

To define a new data type in Java, include:

1. **Instance variables** — hold the state (data).
2. **Constructors** — initialize new objects.
3. **Instance methods** — define operations.
4. **Test client (`main`)** — unit test for correctness.

Together, these enable the creation of powerful, modular, and reusable components that model real-world systems.
