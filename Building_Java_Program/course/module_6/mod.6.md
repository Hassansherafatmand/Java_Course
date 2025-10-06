# 📘 Java Character 6 File Reading Basics

## 🟢 1. The `File` Class

- A `File` object in Java **represents** a file or directory on your computer.
- It doesn’t read the contents directly — it’s more like a “handle” to check things about the file.
- To access a file from inside a Java program, you need to construct an internal object that will represent the file. The Java class libraries include a class called File that performs this duty.

### Example

You construct a File object by passing in the name of a file, as in the following line of code:

```
File f = new File("hamlet.txt");
```

```java
import java.io.File;

public class FileBasics {
    public static void main(String[] args) {
        File f = new File("hamlet.txt");

        System.out.println("Exists? " + f.exists());
        System.out.println("Can read? " + f.canRead());
        System.out.println("Is a directory? " + f.isDirectory());
        System.out.println("Length (bytes)? " + f.length());
        System.out.println("Absolute path: " + f.getAbsolutePath());
    }
}
```

---

## 2. Creating a File Object

```java
File f = new File("hamlet.txt");
```

- `"hamlet.txt"` → relative path (file should be in the same folder as your program).
- You can also give an **absolute path**:

```java
File f = new File("C:/Users/Willamina/Documents/hamlet.txt");
```

---

## 3. Common Methods

| Method              | Description                                                    |
| ------------------- | -------------------------------------------------------------- |
| `canRead()`         | Whether or not this file exists and can be read                |
| `delete()`          | Deletes the given file                                         |
| `exists()`          | Whether or not this file exists on the system                  |
| `getAbsolutePath()` | The full path where this file is located                       |
| `getName()`         | The name of this file as a `String`, without any path attached |
| `isDirectory()`     | Whether this file represents a directory/folder on the system  |
| `isFile()`          | Whether this file represents a file (nonfolder) on the system  |
| `length()`          | The number of characters in this file                          |
| `renameTo(file)`    | Changes this file’s name to the given file’s name              |

---

## 4. Reading a File

To actually **read contents**, you pair `File` with another class like `Scanner`:

**Note:** When we want to read from a console window, we call _Scanner_ variable _console_. When we wanto read from an input file, we call the variable _input_.

```java
import java.io.*;
import java.util.*;

public class ReadFileDemo {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("hamlet.txt");
        Scanner input = new Scanner(f);
        // The variable (File f ) is not necessary, so we can shorten this
        // Scanner input = new Scanner (new File(halmet.txt))

        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);
        }

        input.close();
    }
}
```

---

## Summary

- **`File`**: describes the file (exists, length, path).
- **`Scanner` (or other streams)**: reads the actual contents.
- Always handle possible exceptions (`FileNotFoundException`) when working with files.

---

# 🟦 Exceptions in File Reading (Java)

## 🟢 1. Checked Exceptions (must handle or declare with `throws`)

These are the main ones you’ll encounter in the file I/O chapters:

| Exception                   | When It Happens                                                                                            |
| --------------------------- | ---------------------------------------------------------------------------------------------------------- |
| **`FileNotFoundException`** | When you try to open a file that does not exist, or the path is wrong.                                     |
| **`IOException`**           | General input/output error (e.g., problem reading the file, disk issues, file suddenly disappears).        |
| **`EOFException`**          | When the program unexpectedly reaches the **end of a file** while reading (common in binary file reading). |

---

## 2. Unchecked Exceptions (runtime errors you may hit)

These don’t require `throws`, but they still happen if you’re not careful:

| Exception                    | When It Happens                                                                        |
| ---------------------------- | -------------------------------------------------------------------------------------- |
| **`NoSuchElementException`** | Using `Scanner` and calling `nextLine()` or `nextInt()` when there is no more data.    |
| **`IllegalStateException`**  | If you try to use a `Scanner` or `Reader` **after closing** it.                        |
| **`NullPointerException`**   | If your `File` or `Scanner` object wasn’t created properly (like if you forgot `new`). |

---

## 3. Good Practice

When reading files, you often wrap code like this:

```java
import java.io.*;
import java.util.*;

public class ReadFileSafe {
    public static void main(String[] args) {
        try {
            File f = new File("hamlet.txt");
            Scanner input = new Scanner(f);

            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }

            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error: Problem reading file.");
        }
    }
}
```

---

## ✅ Main Takeaway

- Always handle **`FileNotFoundException`** and **`IOException`** in file reading chapters.
- Be aware of runtime errors like **`NoSuchElementException`** when looping through files with `Scanner`.

---

s

# 🟦 Approaches to Read a File in Java

There are several ways to read a file that already exists on your computer.  
Each approach has its own advantages depending on the use case.

---

## 🟢 1. Using `Scanner` (Simple, Beginner-Friendly)

- Good for reading text files line by line or token by token.
- Works well for structured input (like numbers, words, lines).

```java
import java.io.*;
import java.util.*;

public class ReadWithScanner {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("example.txt");
        Scanner input = new Scanner(file);

        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);
        }
        input.close();
    }
}
```

---

## 2. Using `BufferedReader` (Efficient Line Reading)

- Faster for large files compared to `Scanner`.
- Reads text line by line with efficient buffering.

```java
import java.io.*;

public class ReadWithBufferedReader {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
```

---

## 3. Using `Files.readAllLines` (Quick, Small Files)

- Reads the entire file into a `List<String>`.
- Best for small files that fit in memory.

```java
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ReadWithFiles {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("example.txt"));
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
```

---

## 4. Using `Files.lines` with Streams (Modern, Java 8+)

- Uses Java Streams for functional-style processing.
- Good for filtering and mapping data.

```java
import java.io.*;
import java.nio.file.*;

public class ReadWithStream {
    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("example.txt"))
             .filter(line -> !line.isEmpty())
             .forEach(System.out::println);
    }
}
```

---

## 5. Using `FileInputStream` (Byte-Oriented)

- Reads raw bytes from a file (not characters).
- Common for binary files like images or audio.

```java
import java.io.*;

public class ReadWithFileInputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("example.txt");
        int data;
        while ((data = fis.read()) != -1) {
            System.out.print((char) data);
        }
        fis.close();
    }
}
```

---

## ✅ Summary

- **Scanner** → Easy, good for text input.
- **BufferedReader** → Efficient for large text files.
- **Files.readAllLines** → Simple, but only for small files.
- **Files.lines (Streams)** → Modern, functional approach.
- **FileInputStream** → For binary/raw byte files.

---

# 🟦 Notes: Output Files with `PrintStream`

### 🔹 Key Idea

- Normally, Java programs print to the console using `System.out.print` or `System.out.println`.
- But instead of sending output to the console, you can send it to a **file**.
- This is useful for **storing results** rather than just displaying them.

---

### 🔹 `System.out` and `PrintStream`

- `System.out` is actually a **variable** that holds a reference to a `PrintStream` object.
- The methods `print` and `println` are methods of the `PrintStream` class.
- By default, `System.out` is tied to the console window.
- But you can create your **own `PrintStream` object** to send output to a file (or other destinations).

---

### 🔹 Example: Writing to a File

To send output to a file called `results.txt`, you can create a `PrintStream` object like this:

```java
import java.io.*;

public class Example {
    public static void main(String[] args) throws IOException {
        PrintStream output = new PrintStream(new File("results.txt"));

        // Write data to the file
        output.println("Hello, file!");
        output.println("This is a line of text.");

        // Always close the stream
        output.close();
    }
}
```

---

### 🔹 Important Notes

- **Don’t forget to close** the `PrintStream` with `output.close()`.  
  Otherwise, some data may not be saved (flushed).
- If the file does not exist, it will be **created automatically**.
- If the file already exists, the contents may be **overwritten**.
- Since file I/O can throw exceptions, you often need `throws IOException` or a `try-catch`.

---

✅ **Summary**:

- `System.out` is just a `PrintStream` tied to the console.
- You can create new `PrintStream` objects to redirect output into files.
- This allows you to use the same familiar `print` / `println` methods for **file output**.
