# 3.1 Using Data Types

A **data type** is a set of values and a set of operations defined on those values. In Java, primitive data types are supplemented by extensive libraries of **reference types** designed for specific applications. This section focuses on **string processing** and **image processing** reference types.

---

## 🧩 Strings

### Overview
The **String** data type represents sequences of characters. It is not primitive but a **reference type**. Strings are objects, and Java provides an extensive API for operations on them.

A **String API** defines constructors and instance methods that can be used to create, modify, and analyze strings.

### String API Summary

| Method | Return Type | Description |
|--------|--------------|--------------|
| `String(String s)` | — | create a string with the same value as `s` |
| `String(char[] a)` | — | create a string that represents the same sequence of characters as in array `a[]` |
| `int length()` | int | number of characters |
| `char charAt(int i)` | char | the character at index `i` |
| `String substring(int i, int j)` | String | characters from index `i` through `(j-1)` |
| `boolean contains(String substring)` | boolean | does this string contain `substring`? |
| `boolean startsWith(String prefix)` | boolean | does this string start with `prefix`? |
| `boolean endsWith(String postfix)` | boolean | does this string end with `postfix`? |
| `int indexOf(String pattern)` | int | index of first occurrence of `pattern` |
| `int indexOf(String pattern, int i)` | int | index of first occurrence of `pattern` after index `i` |
| `String concat(String t)` | String | this string, with `t` appended |
| `int compareTo(String t)` | int | string comparison |
| `String toLowerCase()` | String | this string, with lowercase letters |
| `String toUpperCase()` | String | this string, with uppercase letters |
| `String replace(String a, String b)` | String | this string, with all `a`s replaced by `b`s |
| `String trim()` | String | this string, with leading and trailing whitespace removed |
| `boolean matches(String regexp)` | boolean | does this string match the regular expression? |
| `String[] split(String delimiter)` | String[] | substrings between occurrences of `delimiter` |
| `boolean equals(Object t)` | boolean | is this string's value the same as `t`'s? |
| `int hashCode()` | int | an integer hash code |

---

### Example Usage

```java
String a = new String("now is");
String b = new String("the time");
String c = new String(" the");
```

| Instance Method Call | Return Type | Return Value |
|----------------------|--------------|---------------|
| `a.length()` | int | `6` |
| `a.charAt(4)` | char | `'i'` |
| `a.substring(2, 5)` | String | `"w i"` |
| `b.startsWith("the")` | boolean | `true` |
| `a.indexOf("is")` | int | `4` |
| `a.concat(c)` | String | `"now is the"` |
| `b.replace("t", "T")` | String | `"The Time"` |
| `a.split(" ")` | String[] | `{ "now", "is" }` |
| `b.equals(c)` | boolean | `false` |

---

### Common String Operations

#### Extract File Name and Extension
```java
String s = args[0];
int dot = s.indexOf(".");
String base = s.substring(0, dot);
String extension = s.substring(dot + 1, s.length());
```

#### Search for Lines Containing a Query
```java
String query = args[0];
while (StdIn.hasNextLine()) {
    String line = StdIn.readLine();
    if (line.contains(query))
        StdOut.println(line);
}
```

#### Check for Palindrome
```java
public static boolean isPalindrome(String s) {
    int n = s.length();
    for (int i = 0; i < n / 2; i++)
        if (s.charAt(i) != s.charAt(n - 1 - i))
            return false;
    return true;
}
```

#### Translate DNA to mRNA
```java
public static String translate(String dna) {
    dna = dna.toUpperCase();
    String rna = dna.replaceAll("T", "U");
    return rna;
}
```

---

## 🎨 Color Data Type

### Overview
Java’s `Color` data type (in `java.awt.Color`) represents colors using the **RGB model**, where red, green, and blue intensities are integers between 0 and 255.

### Example
```java
Color red = new Color(255, 0, 0);
Color bookBlue = new Color(9, 90, 166);
```

### Color API Summary

| Method | Return Type | Description |
|---------|--------------|--------------|
| `Color(int r, int g, int b)` | — | constructor for RGB color |
| `int getRed()` | int | red intensity |
| `int getGreen()` | int | green intensity |
| `int getBlue()` | int | blue intensity |
| `Color brighter()` | Color | brighter version of this color |
| `Color darker()` | Color | darker version of this color |
| `String toString()` | String | string representation of this color |
| `boolean equals(Object c)` | boolean | is this color’s value the same as `c`? |

---

### Applications

#### Albers Squares
Displays two colors side by side using Josef Albers’ color interaction principles.

#### Luminance (Brightness)
Defined as:

\[ Y = 0.299r + 0.587g + 0.114b \]

Used to compute brightness and grayscale conversions.

#### Grayscale Conversion
Replace color `(r, g, b)` with `(Y, Y, Y)`.

#### Color Compatibility
Two colors are considered compatible if their luminance difference is **at least 128** for readability.

---

## 🖼️ Image Processing

A **digital image** is a rectangular grid of **pixels**, where each pixel stores a color value. The `Picture` data type represents this grid and provides methods to manipulate images.

### Picture API (Summary)
- Create images (blank or from a file)
- Set pixel color
- Get pixel color
- Display or modify the image

### Example Programs
- **Grayscale.java** – converts a color image to grayscale.
- **Scale.java** – resizes an image to new width and height.
- **Fade.java** – fades between two images using linear interpolation.

---

## 🔄 Input and Output Revisited

### Input Stream (`In`)
An object-oriented version of `StdIn`, supporting file and web input.

### Output Stream (`Out`)
An object-oriented version of `StdOut`, supporting output to files and consoles.

#### Examples
- **Cat.java** – concatenates several files into one.
- **StockQuote.java** – fetches live stock data using web scraping.
- **Split.java** – separates a CSV file into multiple files based on fields.

---

## 🧠 Properties of Reference Types

### Aliasing
When two variables reference the same object.
```java
Picture a = new Picture("mandrill.jpg");
Picture b = a;
a.set(col, row, color1);
b.set(col, row, color2); // modifies the same Picture
```

### Pass by Value
Java passes a copy of the **value** — for reference types, this means a copy of the **reference**, not the object.

### Arrays Are Objects
Arrays behave like reference types. Passing an array passes its reference, not a full copy.

### Arrays of Objects
Creating an array of objects involves two steps:
```java
Color[] a = new Color[2];
a[0] = new Color(255, 255, 0);
a[1] = new Color(160, 82, 45);
```

### Safe Pointers
In Java, references are always type-safe — you cannot access arbitrary memory.

### Orphaned Objects
When no references remain to an object:
```java
Color a, b;
a = new Color(160, 82, 45);
b = new Color(255, 255, 0);
b = a; // yellow is now orphaned
```

### Garbage Collection
Java automatically reclaims memory from orphaned objects via **garbage collection**.

---

**Summary:**
- **Strings** handle text manipulation.
- **Color** and **Picture** handle image and color processing.
- **Reference types** enable safe, flexible, and memory-managed object-oriented programming.

