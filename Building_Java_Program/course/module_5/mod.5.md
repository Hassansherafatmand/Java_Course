# 📘 Java Character 5 Program Logic

## 🟢 Java Random Class Methods

This document summarizes useful methods of the **`Random`** class in Java for generating random values.

---

### Methods Overview

| Method          | Description                                                                   |
| --------------- | ----------------------------------------------------------------------------- |
| `nextInt()`     | Returns a random integer between `-2^31` and `(2^31 - 1)`.                    |
| `nextInt(max)`  | Returns a random integer between `0` and `(max - 1)`.                         |
| `nextDouble()`  | Returns a random real number between `0.0` (inclusive) and `1.0` (exclusive). |
| `nextBoolean()` | Returns a random logical value: `true` or `false`.                            |

---

### Example Usage

```java
import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random rand = new Random();

        // Random integer
        int anyInt = rand.nextInt();
        System.out.println("Random int: " + anyInt);

        // Random integer between 0 and 9
        int boundedInt = rand.nextInt(10);
        System.out.println("Random int (0–9): " + boundedInt);

        // Random double
        double randomDouble = rand.nextDouble();
        System.out.println("Random double: " + randomDouble);

        // Random boolean
        boolean randomBool = rand.nextBoolean();
        System.out.println("Random boolean: " + randomBool);
    }
}
```

---

## 🟢 Fencepost Algorithm

The **Fencepost Algorithm** (sometimes called the _Fencepost Problem_) is a programming pattern used to correctly place **separators** (such as commas, spaces, or dashes) between items in a sequence **without leaving an extra one** at the start or end.

The name comes from building a fence:

- A fence with 5 posts needs **4 wires between them**, not 5.
- Posts and separators don’t match 1-to-1.

---

### The Problem

If you write a loop like this:

```java
for (int i = 1; i <= 5; i++) {
    System.out.print(i + ", ");
}
```

The output will be:

```
1, 2, 3, 4, 5,
```

🚨 Notice the **extra comma at the end**.

---

### The Idea

Handle **one item as a special case** (usually the first or last). This prevents the trailing (or leading) separator.

---

### Approaches

### 1. Print the first item separately, then loop the rest

```java
System.out.print(1); // first fencepost
for (int i = 2; i <= 5; i++) {
    System.out.print(", " + i);
}
```

Output:

```
1, 2, 3, 4, 5
```

---

### 2. Loop normally but add a condition

```java
for (int i = 1; i <= 5; i++) {
    System.out.print(i);
    if (i < 5) {
        System.out.print(", ");
    }
}
```

Output:

```
1, 2, 3, 4, 5
```

---

### Example with Strings

```java
String[] names = {"Alice", "Bob", "Charlie"};

System.out.print(names[0]); // first fencepost
for (int i = 1; i < names.length; i++) {
    System.out.print(" - " + names[i]);
}
```

Output:

```
Alice - Bob - Charlie
```

---

### Summary

- Prevents **extra separators** when printing lists.
- Works by treating the **first or last element as special**.
- Commonly used in:
  - Printing arrays
  - Formatting SQL queries
  - Generating reports
