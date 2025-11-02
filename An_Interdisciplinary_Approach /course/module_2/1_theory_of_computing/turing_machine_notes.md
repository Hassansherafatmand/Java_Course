# Turing Machines

---

## 1. **Overview**

A **Turing Machine (TM)** is a simple, powerful abstract model of computation that can simulate any computer program or algorithm. It was introduced by **Alan Turing** in 1936.

### Why It Matters

- Forms the **foundation of theoretical computer science**.
- Used to study **what can and cannot be computed**.
- Demonstrates that some problems are **unsolvable**, regardless of computational power.

---

## 2. **Key Components**

A Turing Machine consists of:

### 🧾 1. **Tape**

- Infinite in both directions.
- Divided into **cells**, each containing a symbol from a **finite alphabet** (e.g., {0, 1, #, A, X}).
- Stores the input, intermediate results, and output.

### ⚙️ 2. **Tape Head**

- Reads and writes one cell at a time.
- Can move **left** or **right** by one cell after each operation.
- The **active cell** (currently scanned) determines the next action.

### 🧠 3. **Control Unit (Finite-State Machine)**

- Like a **CPU**.
- Contains a **state transition diagram** — a table or graph specifying what to do for each combination of **state** and **input symbol**.

Each transition rule has the form:

```
(current_state, read_symbol) → (new_symbol, move_direction, next_state)
```

### Example of state labels

- **L** → move left
- **R** → move right
- **Y** → accept (Yes)
- **N** → reject (No)
- **H** → halt

---

## 3. **Execution Process**

When running a Turing Machine:

1. Start in the **initial state**.
2. Read the **current symbol** on the tape.
3. Use the **transition rule** to determine:
   - The new symbol to write
   - The direction to move (L/R)
   - The next state to enter
4. Repeat until the machine reaches a **halting (H)**, **accepting (Y)**, or **rejecting (N)** state.

If no rule applies for a given state/symbol, the machine stops.

---

## 4. **Computation Concepts**

### Repetition (Loops)

- TM can perform repetitive tasks by looping through states until a condition is met.

### Conditional Branching

- TM can make decisions (like _if/else_ statements) using transitions that depend on the current symbol.

### Non-Termination

- Some TMs never halt — they continue forever. Examples:
  - Operating systems
  - Infinite sequence generators (e.g., computing digits of π)

---

## 5. **Example — Unary to Binary Conversion**

This example demonstrates a TM that **converts a unary number (AAAAAA)** to its **binary equivalent**.

### Input Alphabet

`{0, 1, A, X, #}`

### Description

- Each `A` represents one unit in unary.
- The TM overwrites each `A` with `X`, counting how many have been seen.
- It writes the binary equivalent of that count to the **left** of the A’s.

### Process Overview

1. Start scanning right until an `A` is found.
2. Overwrite the `A` with an `X` and **move left** to increment the binary counter.
3. Increment the binary number by 1:
   - Scan from right to left, flipping 1s to 0s until a 0 or `#` is found.
   - Change that symbol to 1.
4. Move back to find the next `A` and repeat.
5. When all A’s are replaced with X’s, change X’s to `#` (cleanup) and halt.

### Example Trace

**Input:** `AAAAAA`  
**Output:** Binary `110` written to the left of `#`, then all `A` → `X` → `#`.

✅ Result: the TM writes `110` (6 in binary).

---

## 6. **Algorithm Logic (Increment by 1)**

To increment a binary number by 1:

1. Scan bits from **right to left**.
2. Change every `1` to `0` until a `0` is found.
3. Change that `0` to a `1`.
4. If no `0` is found, prepend a new `1`.

This logic is applied repeatedly to convert a unary count into binary form.

---

## 7. **Java Implementation Notes**

Each major Turing Machine component is implemented as an **object**:

### `Tape.java`

- Models the infinite tape using **two stacks**.
- Operations:
  - `moveLeft()` and `moveRight()`
  - `read()` and `write()`
  - `toString()` prints reversed left stack + current + right stack

### `State.java`

- Represents each state: name + type (`Halt`, `Left`, `Right`, `Yes`, `No`).

### `Transition.java`

- Represents state changes: current state → new state + symbol to write.

### `TuringMachine.java`

- Combines:
  - A **tape**
  - A **symbol table** of states
  - A **symbol table** of transitions

---

## 8. **Non-Terminating Turing Machines**

- Some TMs run infinitely without halting.
- Useful for modeling continuous systems like:
  - Operating systems
  - Control systems (nuclear reactor, air traffic)
  - Infinite data generators

Even though the machine doesn’t stop, its structure still defines a valid computational model.

---

## 9. **Philosophical Significance**

- The TM bridges **mathematics and physics** — part of Turing’s original goal.
- Demonstrates that **computation is a physical process**.
- Leads to key discoveries such as the **Halting Problem** (some problems can’t be solved by any algorithm).

---

## 10. **Summary Table**

| Component            | Function                                  |
| -------------------- | ----------------------------------------- |
| **Tape**             | Infinite memory storage for symbols       |
| **Tape Head**        | Reads/writes one symbol, moves left/right |
| **Control Unit**     | Manages states and transitions            |
| **Transition Table** | Defines TM behavior                       |
| **Halting State**    | Stops computation                         |

---

## 11. **Key Takeaways for Exams**

- **Turing Machine** = foundation of computation theory.
- Works step-by-step via **state transitions**.
- Simulates **any algorithm** — “machine that can compute anything computable.”
- Can model **non-halting systems**.
- Key concepts: **tape, head, states, transitions, halting condition**.
- Important example: **Unary → Binary converter**.
- Supports **increment algorithm** via repetitive state transitions.

---
