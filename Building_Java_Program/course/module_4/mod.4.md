# 📘 Java Character 4 Conditional Execution

This document summarizes some of the most useful methods of the **`Character`** class in Java for text processing.

---

## 🟢 Methods Overview TextProcessing

| Method                          | Description                                                       | Example                          | Result  |
| ------------------------------- | ----------------------------------------------------------------- | -------------------------------- | ------- |
| `Character.getNumericValue(ch)` | Converts a character that looks like a number into that number.   | `Character.getNumericValue('6')` | `6`     |
| `Character.isDigit(ch)`         | Checks if the character is one of the digits `'0'` through `'9'`. | `Character.isDigit('X')`         | `false` |
| `Character.isLetter(ch)`        | Checks if the character is a letter (`a-z` or `A-Z`).             | `Character.isLetter('f')`        | `true`  |
| `Character.isLowerCase(ch)`     | Checks if the character is a lowercase letter.                    | `Character.isLowerCase('Q')`     | `false` |
| `Character.isUpperCase(ch)`     | Checks if the character is an uppercase letter.                   | `Character.isUpperCase('Q')`     | `true`  |
| `Character.toLowerCase(ch)`     | Returns the lowercase version of the given character.             | `Character.toLowerCase('Q')`     | `'q'`   |
| `Character.toUpperCase(ch)`     | Returns the uppercase version of the given character.             | `Character.toUpperCase('x')`     | `'X'`   |

---

### Notes

- These methods are **static** methods of the `Character` class.
- They are often used in loops when processing strings character by character.
- Combining them with `String` methods (like `charAt`) allows powerful text manipulation.

---

### Example Usage

````java
public class CharacterDemo {
    public static void main(String[] args) {
        char ch1 = 'a';
        char ch2 = '7';

        // Check type
        System.out.println(Character.isLetter(ch1)); // true
        System.out.println(Character.isDigit(ch2));  // true

        // Change case
        System.out.println(Character.toUpperCase(ch1)); // A
        System.out.println(Character.toLowerCase('Q')); // q

        // Numeric value
        System.out.println(Character.getNumericValue(ch2)); // 7
    }
}

---

## 🟢 Java Common Format Specifiers

This document summarizes commonly used **format specifiers** with `System.out.printf` and `String.format` in Java.

---

### Specifiers Overview

| Specifier | Result |
|-----------|---------|
| `%d`      | Integer |
| `%8d`     | Integer, right-aligned, 8-space-wide field |
| `%-6d`    | Integer, left-aligned, 6-space-wide field |
| `%f`      | Floating-point number |
| `%12f`    | Floating-point number, right-aligned, 12-space-wide field |
| `%.2f`    | Floating-point number, rounded to nearest hundredth |
| `%16.3f`  | Floating-point number, rounded to nearest thousandth, 16-space-wide field |
| `%s`      | String |
| `%8s`     | String, right-aligned, 8-space-wide field |
| `%-9s`    | String, left-aligned, 9-space-wide field |

---

### Example Usage
```java
public class FormatDemo {
    public static void main(String[] args) {
        int score = 87;
        double gpa = 3.6789;
        String name = "Will";

        System.out.printf("Score: %d%n", score);          // Score: 87
        System.out.printf("Score padded: %8d%n", score);  // Score padded:       87
        System.out.printf("Left align: %-6d%n", score);   // Left align: 87

        System.out.printf("GPA: %.2f%n", gpa);            // GPA: 3.68
        System.out.printf("Wide GPA: %12f%n", gpa);       // Wide GPA:     3.678900
        System.out.printf("Rounded: %16.3f%n", gpa);      // Rounded:           3.679

        System.out.printf("Name: %s%n", name);            // Name: Will
        System.out.printf("Right: %8s%n", name);          // Right:     Will
        System.out.printf("Left: %-9s%n", name);          // Left: Will
    }
}


````

---
