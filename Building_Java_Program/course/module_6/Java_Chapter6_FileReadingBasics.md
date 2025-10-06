# 📘 Java Chapter 6 — File Reading Basics

This chapter introduces **file input/output (I/O)** in Java.  
It covers reading from and writing to files, handling errors, validating file paths, and processing file content line by line or word by word.

---

## 🟢 Java File Reading and Writing Overview

To work with files, Java provides tools from the `java.io` package, such as:

| Class | Description |
|--------|-------------|
| `File` | Represents file and directory paths. |
| `Scanner` | Reads text input (from files, console, or strings). |
| `PrintStream` | Writes formatted text to files. |
| `FileNotFoundException` | Handles missing files safely. |

---

## 🧩 File Information and Properties — `FileReadingBasics.java`

### Example
```java
public static void commonFileReadMethods(File file) {
    System.out.println("canRead method: " + file.canRead());
    System.out.println("Absolute path: " + file.getAbsolutePath());
    System.out.println("Exists? " + file.exists());
    System.out.println("Is directory? " + file.isDirectory());

    // Rename file
    File newFile = new File("resources/hamlet.txt");
    boolean success = file.renameTo(newFile);
    System.out.println("renameTo method: " + success);
}
```
### 💡 Concepts
- `canRead()` → Checks if file can be read.
- `exists()` → Verifies file existence.
- `isDirectory()` → Detects if path is a directory.
- `renameTo()` → Renames the file.

### Example Usage
```java
File file = new File("resources/hamlet.txt");
if (!file.exists()) {
    System.out.println("File not found at: " + file.getAbsolutePath());
    return;
}

Scanner input = new Scanner(file);
int count = 0;
while (input.hasNext()) {
    String word = input.next();
    count++;
}
System.out.println("Total words: " + count);
input.close();
```

---

## ✂️ Fixing Spacing in Text Files — `FixingSpaceFile.java`

### Example
```java
public static void readFile() throws FileNotFoundException {
    String fileAddress = "resources/spacedText.txt";
    String newFileAddress = "resources/fixedSpacedText.txt";

    PrintStream output = new PrintStream(new File(newFileAddress));
    Scanner input = new Scanner(new File(fileAddress));

    while (input.hasNextLine()) {
        String textLine = input.nextLine();
        producingOutputOnFileAndScreen(textLine, output);
        producingOutputOnFileAndScreen(textLine, System.out);
    }
    input.close();
}
```
### Supporting Method
```java
public static void producingOutputOnFileAndScreen(String text, PrintStream output) {
    Scanner data = new Scanner(text);
    if (data.hasNext()) output.print(data.next());
    while (data.hasNext()) output.print(" " + data.next());
    output.println();
}
```

### 💡 Concepts
- **`Scanner`** — reads one line or word at a time.
- **`PrintStream`** — writes formatted text to files or console.
- **Data cleanup** — removes irregular spacing.

---

## 🧾 Line-Based Processing — `LineBasedProcessing.java`

### Example
```java
public static void lineBasedProcess(String text) {
    Scanner data = new Scanner(text);
    int id = data.nextInt();
    String name = data.next();
    double sum = 0;

    while (data.hasNextDouble()) {
        sum += data.nextDouble();
    }
    System.out.printf("Total hours worked by %-5s (#%d) = %.2f%n", name, id, sum);
    data.close();
}
```

### 💡 Concepts
- `nextInt()` / `nextDouble()` → extract numerical data.
- **Line-based approach** → processes one record at a time.
- **`printf()` formatting** → improves display readability.

---

## 💾 Producing Output Files — `ProducingOutputFile.java`

### Example
```java
public static void producingOutput() throws FileNotFoundException {
    PrintStream output = new PrintStream(new File("resources/outputFile1.txt"));
    output.println("Hello Java!");
    output.println();
    output.println("Java is my favorite programming language.");
}
```
### 💡 Concepts
- Creates a new text file if it doesn’t exist.
- Overwrites file by default (can append using `FileWriter` for advanced cases).
- `PrintStream` is useful for simple text output.

---

## 👩‍💼 Employee Hours — `employeeHours.java`

### Example
```java
public static void processEmployeeHours(Scanner input) {
    System.out.println("Total Employee Hours:");
    while (input.hasNext()) {
        String name = input.next();
        double sum = 0.0;
        while (input.hasNextDouble()) {
            sum += input.nextDouble();
        }
        System.out.printf("Total Hours worked by %s is = %.1f%n", name, sum);
    }
}
```

### 💡 Concepts
- Uses **nested while loops** to read names and associated hours.
- Handles mixed data (string + double).
- Displays cumulative totals for each employee.

---

## ➕ Summing Numbers from Files — `SumOfNumbers.java`

### Example
```java
public static int sumApp(File file) {
    int sum = 0;
    String status;

    if (!file.exists()) status = "NOT_EXIST";
    else if (!file.isFile()) status = "NOT_FILE";
    else if (!file.canRead()) status = "NOT_READABLE";
    else status = "OK";

    switch (status) {
        case "NOT_EXIST":
            System.out.println("Error: File does not exist."); return 0;
        case "NOT_FILE":
            System.out.println("Error: Path is not a file."); return 0;
        case "NOT_READABLE":
            System.out.println("Error: File cannot be read."); return 0;
        case "OK":
            System.out.println("File check passed. Ready to read."); break;
    }

    try (Scanner input = new Scanner(file)) {
        while (input.hasNextInt()) sum += input.nextInt();
    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + e.getMessage());
    }
    return sum;
}
```
### 💡 Concepts
- Uses **switch statements** for file validation.
- Reads integers and calculates sum.
- Demonstrates **try-with-resources** for automatic file closure.

---

## 🧠 Summary of Key Concepts

| Concept | Description |
|----------|--------------|
| `File.exists()` | Checks whether the file path is valid |
| `Scanner(File)` | Reads file content token by token |
| `PrintStream(File)` | Writes text data to file |
| `try-with-resources` | Ensures file closure automatically |
| Line-based processing | Reads file line-by-line for structured data |
| Word-based processing | Reads word-by-word for flexibility |
| `FileNotFoundException` | Prevents crashes when file missing |
| File validation | Uses conditional checks before reading |

---

✨ **End of Chapter 6 Notes**
