# Java Setup on VS Code (macOS)

## 1. Install VS Code
- Download from [https://code.visualstudio.com](https://code.visualstudio.com)  
- Install and open it.

---

## 2. Install the Java Extension Pack
1. Open VS Code.  
2. Go to **Extensions** (`⇧⌘X`).  
3. Search for **Extension Pack for Java**.  
4. Click **Install**.  

This installs:
- Language Support for Java™ by Red Hat  
- Debugger for Java  
- Maven for Java  
- Java Test Runner  

---

## 3. Install a JDK
### Option A: Oracle JDK 25 (Latest)
1. Download from [Oracle JDK Downloads](https://www.oracle.com/java/technologies/downloads/#jdk25-mac).  
2. Open the `.dmg` and run the `.pkg` installer.  
3. This installs Java under:  
   ```
   /Library/Java/JavaVirtualMachines/jdk-25.jdk/Contents/Home
   ```

### Option B: Temurin JDK (Recommended LTS)
```bash
brew install --cask temurin@21
```

---

## 4. Verify Installation
In Terminal, run:
```bash
java -version
javac -version
/usr/libexec/java_home -V
```

Expected output (for Oracle JDK 25):
```
java version "25"
javac 25
/Library/Java/JavaVirtualMachines/jdk-25.jdk/Contents/Home
```

---

## 5. Configure Environment Variables
Edit your `~/.zshrc`:

```bash
nano ~/.zshrc
```

Add:
```bash
# Java JDK 25
export JAVA_HOME=$(/usr/libexec/java_home -v 25)
export PATH=$JAVA_HOME/bin:$PATH
```

Save & reload:
```bash
source ~/.zshrc
```

Check:
```bash
echo $JAVA_HOME
java -version
```

---

## 6. Configure VS Code to Use JDK
Open **Command Palette** (`⇧⌘P`) → **Preferences: Open User Settings (JSON)**  
Add:

```json
"java.jdt.ls.java.home": "/Library/Java/JavaVirtualMachines/jdk-25.jdk/Contents/Home",
"java.configuration.runtimes": [
  {
    "name": "JavaSE-25",
    "path": "/Library/Java/JavaVirtualMachines/jdk-25.jdk/Contents/Home",
    "default": true
  }
]
```

Reload VS Code:
- `⇧⌘P` → **Developer: Reload Window**  
- `⇧⌘P` → **Java: Clean Java Language Server Workspace**  

---

## 7. Create and Run a Java Program
1. Create a folder (e.g., `~/Desktop/JavaProject`).  
2. Inside, create `Hello.java`:

```java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, Java " + System.getProperty("java.version"));
    }
}
```

3. Open the folder in VS Code.  
4. Click **Run | Debug** above `main`.  
5. Output should show:
```
Hello, Java 25
```

---

✅ You’re now fully set up to write, run, and debug Java in VS Code on macOS.
