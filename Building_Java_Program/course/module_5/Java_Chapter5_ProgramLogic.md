# 📘 Java Chapter 5 — Program Logic & Randomization

This chapter introduces **program logic** using loops, conditionals, and randomization in Java.  
It demonstrates key techniques such as generating random numbers, validating input, and handling strings.

---

## 🟢 Java Random Class Methods

### 📦 Package
```java
package module_5_ProgramLogic;
import java.util.*;
```

---

### 🎯 Overview

Java offers two main ways to generate random numbers:

1. **`Math.random()`** — built-in static method that returns a value between `0.0` and `1.0`.
2. **`Random` class (`java.util.Random`)** — provides more control and supports integers, doubles, and booleans.

---

### 🧩 Example — `randomNumber()`
```java
public static void randomNumber() {

    // Option 1: Using Math.random()
    double ranNumber = Math.random();
    System.out.printf("Generated a random number using Math.random(): %.0f%n", ranNumber * 10);

    // Option 2: Using Random class
    Random r = new Random();
    System.out.printf("Generated a random number using Random class: %d%n", r.nextInt(10));
}
```

#### 🧠 Explanation
- `Math.random()` → Returns a random double between `0.0` and `1.0`.  
  Multiplying by 10 scales it to [0 … 10).  
- `r.nextInt(10)` → Returns an integer from 0 to 9.  

`Random` is preferred when you need repeatability or several types of random values.

---

## 🎲 Random Application — `randomApp()`

Simulates repeatedly drawing random numbers until a chosen number appears.

```java
public static void randomApp() {
    System.out.println("This program picks numbers from 1–10 until your number comes up.");
    Scanner console = new Scanner(System.in);
    Random r = new Random();

    int result = -1;
    int count = 0;

    System.out.print("Please pick a number between 1 and 10: ");
    int number = console.nextInt();

    while (number != result) {
        result = r.nextInt(10) + 1;      // 1–10
        System.out.println("Next number = " + result);
        count++;
    }

    System.out.printf("Your number came after %d tries.%n", count);
}
```

### 💡 Concepts
- **While loop** → Repeats until condition is met.  
- **Counter variable** → Tracks the number of attempts.  
- **Random + Scanner** → Demonstrates user interaction.

---

## 🪜 Fence-Post Problem — `fencePostProblem()`

Used to print a sequence separated by commas without trailing punctuation.

```java
public static void fencePostProblem(String s, int times) {
    System.out.print("[" + s);
    for (int i = 1; i < times; i++) {
        System.out.print(", " + s);
    }
    System.out.println("]");
}
```

### 💡 Concept
In loops that print lists, one “post” (separator) is always missing or extra.  
To fix that, handle the **first element separately** — print it before the loop, then start the loop at 1.

---

## ✂️ Extracting the First Word — `firstWordCase1()` & `firstWordCase2()`

### Case 1 — No leading spaces
```java
public static String firstWordCase1(String word) {
    int start = 0;
    int stop = 0;
    while (word.charAt(stop) != ' ') stop++;
    return word.substring(start, stop);
}
```

### Case 2 — Skipping leading spaces
```java
public static String firstWordCase2(String word) {
    int start = 0;
    int stop = 0;
    while (start < word.length() && word.charAt(start) == ' ') start++;
    stop = start;
    while (stop < word.length() && word.charAt(stop) != ' ') stop++;
    return word.substring(start, stop);
}
```

### 💡 Concept
- `charAt(index)` reads each character in the string.  
- `substring(start, stop)` extracts the portion between two indices.  
- Useful for parsing user input or trimming words.

---

## 🔢 Validating Integer Input — `getInt()`

Ensures the user enters a valid integer.

```java
public static int getInt(Scanner console, String prompt) {
    System.out.print(prompt);
    while (!console.hasNextInt()) {
        console.next(); // discard invalid input
        System.out.println("Not an integer; try again.");
        System.out.print(prompt);
    }
    return console.nextInt();
}
```

### 💡 Concept
`hasNextInt()` checks if the next token is an integer.  
If not, the invalid input is skipped, and the prompt repeats.

---

## 🎯 Guess Number Game — `GuessNumberGame.java`

An interactive guessing game where the user must find a random number between 1–10.

```java
package module_5_ProgramLogic;

import java.util.*;

public class GuessNumberGame {

    public static int getInt(Scanner console, String prompt) {
        System.out.print(prompt);
        while (!console.hasNextInt()) {
            console.next();
            System.out.println("Not an integer; try again.");
            System.out.print(prompt);
        }
        return console.nextInt();
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Random randNumber = new Random();
        int num = randNumber.nextInt(10) + 1;
        int guessedNumber = getInt(console, "Please guess a number between 1 to 10: ");
        int count = 1;

        while (guessedNumber != num) {
            System.out.println("That is incorrect.");
            guessedNumber = getInt(console, "Try again: ");
            count++;
        }

        System.out.printf("The number was %d, and you got it in %d guesses.%n", num, count);
        console.close();
    }
}
```

### 💡 Concept Summary
- **Random.nextInt(10) + 1** → Generates a number between 1–10.  
- **While loop** → Continues until the user guesses correctly.  
- **Input validation** → Prevents crashes from non-integer input.  
- **Counters** → Track attempts.

---

## 🧾 Summary of Key Concepts

| Concept | Description |
|----------|--------------|
| `Math.random()` | Quick way to get doubles between 0.0–1.0 |
| `Random.nextInt(n)` | Generates integers from 0 to n−1 |
| `Scanner` | Reads user input from console |
| `while` loop | Repeats a block until a condition becomes false |
| `charAt()` | Reads characters individually from a string |
| `substring()` | Extracts part of a string |
| `hasNextInt()` | Checks if input is an integer |
| Fence-post pattern | Handles formatting between loop outputs |
| Input validation | Ensures correct data type entry |

---

✨ **End of Chapter 5 Notes**
