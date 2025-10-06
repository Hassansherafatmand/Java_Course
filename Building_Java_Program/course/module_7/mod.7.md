# 📘 Java Chapter 7 — Array Basics

This chapter introduces the concept of **arrays** in Java — how to declare, initialize, traverse, and manipulate arrays. It also covers key methods from the `Arrays` utility class.

---

## 🟢 ArraysBasics.java

### 🔹 Overview

This program demonstrates how to create arrays dynamically, collect input from users, and compute average values.

```java
package module_7;

import java.util.*;

public class ArraysBasics {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        // Get how many temperature readings user wants to process
        System.out.print("How many days’ temperature: ");
        int numDays = console.nextInt();

        int[] tempDays = new int[numDays];
        int averageTemp = sumOfTemperatures(tempDays);

        System.out.println("Average Temperature = " + averageTemp);

        console.close();
    }

    // -------------------- sumOfTemperatures Function --------------------
    public static int sumOfTemperatures(int[] temperatures) {
        int sum = 0;
        int average = temperatures.length;
        Scanner console = new Scanner(System.in);

        for (int i = 0; i < temperatures.length; i++) {
            System.out.print("Day " + (i + 1) + " high temperature: ");
            temperatures[i] = console.nextInt();
            sum += temperatures[i];
        }
        console.close();

        average = sum / average;
        return average;
    }
}
```

---

## 🧩 ArraysAndMethods.java

Demonstrates creating, modifying, and returning arrays from methods.

Key topics:

- Passing arrays as parameters
- Copying arrays
- Using `Arrays.copyOf` and `Arrays.copyOfRange`
- For-each loops
`
```java
package module_7;

import java.util.*;

public class ArraysAndMethods {

    public static void main(String[] args) {

        int[] list1 = new int[4];
        initializeOddNumbers(list1);
        incrementArray(list1);

        int[] list2 = initializeEvenNumbers(5);
        System.out.println(Arrays.toString(list2));

        char[] list4 = {'A', 'B', 'C', 'D', 'E'};
        char[] list5 = Arrays.copyOf(list4, 2 * list4.length);
        System.out.println(Arrays.toString(list5));

        char[] list6 = Arrays.copyOfRange(list4, 0, 2);
        System.out.println(Arrays.toString(list6));
    }

    public static void initializeOddNumbers(int[] list) {
        for (int i = 0; i < list.length; i++) list[i] = i * 2 + 1;
        System.out.println("Odd numbers: " + Arrays.toString(list));
    }

    public static void incrementArray(int[] list) {
        for (int i = 0; i < list.length; i++) list[i]++;
        System.out.println("Incremented: " + Arrays.toString(list));
    }

    public static int[] initializeEvenNumbers(int size) {
        int[] list = new int[size];
        for (int i = 0; i < size; i++) list[i] = i * 2;
        return list;
    }
}
```

---

## 🔍 ArrayTraversal.java

Teaches multiple techniques to display, search, replace, reverse, and compare arrays.

Highlights:

- `Arrays.toString()` for printing
- For-loops and enhanced for-loops
- `Arrays.equals()`
- Manual reversing logic

```java
package module_7;

import java.util.*;

public class ArrayTraversal {

    public static void main(String[] args) {
        int[] list = {1, 5, 6, 2, 9, 4, 3};
        System.out.println(Arrays.toString(list));

        reverseArray(list);

        String s = "Mississippi";
        String result = "";
        for (int i = 0; i < s.length(); i++) result = s.charAt(i) + result;
        System.out.println(result);
    }

    public static void reverseArray(int[] list) {
        int mid = list.length / 2;
        int last = list.length - 1;
        for (int i = 0; i < mid; i++) {
            int temp = list[i];
            list[i] = list[last - i];
            list[last - i] = temp;
        }
        System.out.println("Reversed: " + Arrays.toString(list));
    }
}
```

---

## 🧠 ReferenceType.java

Explains how arrays behave as **reference types**, unlike primitive types which are **value types**.

```java
package module_7;

import java.util.*;

public class ReferenceType {

    public static void main(String[] args) {
        int[] list1 = {1, 2, 3, 4, 5};
        int[] list2 = {1, 2, 3, 4, 5};
        int[] list3 = list2;

        System.out.println(Arrays.equals(list1, list2)); // true
        System.out.println(list1 == list2);              // false
        System.out.println(list2 == list3);              // true

        String s = null;
        int[] list4 = null;
        System.out.println(s);       // null
        System.out.println(list4);   // null
    }
}
```

---

## 🧭 Summary

| Concept                | Description                                     |
| ---------------------- | ----------------------------------------------- |
| **Array Declaration**  | `int[] list = new int[5];`                      |
| **Accessing Elements** | Use index notation `list[i]`                    |
| **Copying Arrays**     | `Arrays.copyOf()` and `Arrays.copyOfRange()`    |
| **Equality**           | `Arrays.equals(arr1, arr2)` compares content    |
| **References**         | Arrays are objects → passed by reference        |
| **Reversing**          | Swap elements from both ends towards the middle |
| **Printing**           | `Arrays.toString(arr)` shows contents           |

---

📘 _Arrays are foundational in Java — understanding how they work helps with algorithms, data manipulation, and memory concepts that come later in programming._
