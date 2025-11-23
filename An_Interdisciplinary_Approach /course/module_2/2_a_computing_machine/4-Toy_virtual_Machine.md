# 6.4 TOY Virtual Machine — Organized Notes

## 1. Overview

This chapter explores how a TOY simulator works, why simulators are built, how they relate to real machines, and how simulation connects to concepts such as translation, virtual machines, bootstrapping, and duality.

## 2. Why Simulators?

### Flexibility

- Simulators allow easy modification.
- Enable debugging tools.
- Allow experimentation with new ISAs.
- No hardware rebuild required.

### Cost

- Much cheaper than building new hardware prototypes.
- Physical redesigns cost more; software redesigns cost little.

### Example Scenario

If TOY becomes obsolete and replaced by NOTATOY, instead of rewriting thousands of programs:

- Build a TOY simulator on NOTATOY.
- Run old TOY programs through the simulator.
- Works but slower due to simulation layers.

### Historical Example

Old Apple IIe games (e.g., Lode Runner) still run on modern systems due to layered simulation.

## 3. A TOY Simulator in Java

The program **TOY.java**:

- Reads a TOY program.
- Simulates TOY machine behavior.
- Uses arrays for registers and memory.
- Maintains and updates the program counter.
- Executes instructions exactly as TOY hardware would.

### Inputs Needed

- **TOY program** (from a file)
- **TOY standard input** (from operating system input)

### Key Tools Used

- `In.java` library for file reading.
- Regular expressions to parse lines.
- Helper functions:
  - `toHex()` — integer → hex string
  - `fromHex()` — hex string → integer

## 4. Java Virtual Machine (JVM)

- Java programs are compiled to JVM bytecode.
- JVM is an **imaginary machine** with its own instruction set (229 opcodes).
- Running Java means **simulating** JVM behavior on your computer.

## 5. Translators

### Simulation vs Translation

- **Simulator:** mimics the original machine _line by line_.
- **Translator:** converts a program from one language to another (e.g., TOY → Java).

### TOY ↔ Java

- Any TOY program can be translated into Java.
- Translating Java → TOY is possible but tedious.

## 6. Bootstrapping

A powerful and mind-bending concept:

### Idea

1. TOY simulator is written in Java.
2. Translate the TOY simulator (Java) → **TOY language**.
3. Now the TOY machine can simulate **itself**.
4. We can modify our simulator to create “more powerful” machines.

### Why Important?

- This is how real CPUs are designed today.
- Self-hosting compilers and simulators rely on this idea.

### Famous Anecdote

Apple bought a Cray supercomputer to simulate computer design.  
Seymour Cray joked:

> “Funny, I am using an Apple to simulate the Cray-3.”

## 7. Duality: Code and Data

A core computer science concept:

- Code and data are stored the same way.
- What is “code” vs “data” depends on how it is interpreted.

### Examples

| Code              | Data              | Result                   |
| ----------------- | ----------------- | ------------------------ |
| Print this.       | Hello, World.     | Prints **Hello, World**  |
| Print this.       | Print this.       | Prints “Print this.”     |
| Print this twice. | Print this twice. | Prints instruction twice |

### Self-reproducing Program

- A program can output its own source code.
- Biological analogy:
  - **Gene** = signifier
  - **Protein** = signified
