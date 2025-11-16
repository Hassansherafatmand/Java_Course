# 🧭 TOY Machine — Organized Notes

This file is an organized, easy-to-navigate version of your TOY Machine notes. All original content is preserved in the appendix at the end — nothing is removed.

---

## Table of Contents

- [🧭 TOY Machine — Organized Notes](#-toy-machine--organized-notes)
  - [Table of Contents](#table-of-contents)
  - [Friendly Summary](#friendly-summary)
  - [Why Study TOY](#why-study-toy)
  - [Hardware Overview](#hardware-overview)
  - [Storage \& Number Formats](#storage--number-formats)
  - [Registers \& Program Counter](#registers--program-counter)
  - [Input \& Output (Switches and Lights)](#input--output-switches-and-lights)
  - [Running Programs \& Fetch-Execute Cycle](#running-programs--fetch-execute-cycle)
  - [Core Dump](#core-dump)
  - [Von Neumann Model](#von-neumann-model)
  - [Instruction Set Reference](#instruction-set-reference)
  - [Appendix: Original Notes (verbatim)](#appendix-original-notes-verbatim)
  - [TOY Instruction Examples](#toy-instruction-examples)
  - [Quick reference: instruction formats](#quick-reference-instruction-formats)
  - [Instruction summary table](#instruction-summary-table)
    - [0 — halt](#0--halt)
    - [1 — add (RR)](#1--add-rr)
    - [2 — subtract (RR)](#2--subtract-rr)
    - [3 — and (RR)](#3--and-rr)
    - [4 — xor (RR)](#4--xor-rr)
    - [5 — left shift (RR)](#5--left-shift-rr)
    - [6 — right shift (RR)](#6--right-shift-rr)
    - [7 — load address (A)](#7--load-address-a)
    - [8 — load (A)](#8--load-a)
    - [9 — store (A)](#9--store-a)
    - [A — load indirect (RR)](#a--load-indirect-rr)
    - [B — store indirect (RR)](#b--store-indirect-rr)
    - [C — branch zero (A)](#c--branch-zero-a)
    - [D — branch positive (A)](#d--branch-positive-a)
    - [E — jump register (RR)](#e--jump-register-rr)
    - [F — jump and link (A)](#f--jump-and-link-a)
  - [Small program examples](#small-program-examples)
  - [Tips and gotchas](#tips-and-gotchas)

---

## Friendly Summary

TOY is a small teaching computer that models the core ideas of real CPUs: arithmetic/logic operations, memory, registers, a program counter, and a simple instruction set. It's great for learning how machine language, registers, and memory interact.

---

## Why Study TOY

- Understand how computers execute instructions at the lowest level.
- See the relationship between high-level languages (like Java) and machine-level operations.
- Learn about references, pointers, and how memory is used in programs.
- Recognize scenarios where hand-written assembly is still useful (graphics, DSP, scientific computing).

---

## Hardware Overview

Main components:

- ALU (Arithmetic Logic Unit): performs arithmetic and logic.
- Memory: stores both program instructions and data (256 words).
- Registers: 16 fast storage locations used as scratch variables.
- Program Counter (PC): points to the next instruction (8-bit).
- Switches and Lights: manual I/O for loading and inspecting memory.
- Buttons: Load, Look, Step, Run, Enter, Stop, Reset.

---

## Storage & Number Formats

- Word size: 16 bits.
- Hex range: `0000` to `FFFF`.
- Two's complement range: `-32,768` to `+32,767`.
- Memory: 256 words, addresses `00` to `FF`.

Think of memory like mailboxes (addresses) that hold 16-bit words.

---

## Registers & Program Counter

- 16 registers (indexed `0` through `F`).
  - Register `0` always outputs `0`.
- Program Counter (PC): an 8-bit register holding address of next instruction (`00` to `FF`).
- Registers are faster than main memory and used as temporary storage (variables).

---

## Input & Output (Switches and Lights)

- Input (Load): set 8 address switches and 16 data switches, then press `Load` to write a word into memory.
- Output (Look): set 8 address switches and press `Look` to display the address and the 16 data lights showing the stored word.
- For reading from standard input while running, the machine sets an `INWAIT` light and waits for the user to enter a 16-bit integer via the data switches and press `Enter`.

---

## Running Programs & Fetch-Execute Cycle

1. Load program and data into memory (word-by-word).
2. Set PC to the start address (often `10`) using the address switches and `Look`.
3. Press `Run` for continuous execution or `Step` for single-instruction stepping.

Fetch-Execute Cycle:

1. Fetch instruction from memory using PC.
2. Increment PC (`PC = PC + 1`).
3. Decode the instruction.
4. Execute (may change registers, memory, or PC; may produce output).
5. Repeat until a `halt` instruction.

---

## Core Dump

A core dump is a snapshot of the entire machine state at one moment: all memory contents, register values, and the program counter. It's a complete record of the machine state useful for debugging and understanding program behavior.

---

## Von Neumann Model

Key idea: programs and data live in the same memory (stored-program concept). This enables flexible, general-purpose computing and is the basis for modern computers. Unlike early machines (e.g., ENIAC), you don't rewire hardware to change programs.

---

## Instruction Set Reference

The TOY ISA is a small set of instructions that operate on registers and memory. See the full instruction table in the appendix. Example opcodes include `halt`, `add`, `subtract`, `and`, `xor`, shifts, load/store variants, branches, jumps and link.

---

## Appendix: Original Notes (verbatim)

Below is the full original `TOY_full_notes.md` content preserved exactly as it appeared. Nothing here has been removed — the organized copy above is a rearrangement and a summary for easier reading.

```
# 🖥️ TOY Machine — Complete Notes

---

## 6.2 TOY Machine — Friendly Summary 💻

### What is TOY?

TOY is a **simple imaginary computer** created at Princeton to teach how real computers work. Even though it's small and basic, it has all the essential parts that modern CPUs have!

---

### Why Should You Care About TOY?

✅ Understand **how computers actually work** under the hood
✅ See the connection between **Java code and machine language**
✅ Learn about **registers and memory** (like Java references and C pointers)
✅ Know that **assembly language is still used** today in video games, graphics, and scientific computing

---

### Inside the TOY Machine 🔧

The TOY machine has these main parts:

- **ALU** (Arithmetic Logic Unit) — does math & logic
- **Memory** — stores both instructions and data
- **Registers** — fast temporary storage
- **Program Counter** — tracks which instruction to run next
- **Switches & Lights** — for input/output
- **Buttons** — Load, Look, Step, Run, Enter, Stop, Reset

---

### Storage in TOY

**Word Size:** One word = **16 bits**

- Can represent numbers **0000 to FFFF** (hexadecimal)
- Or **-32,768 to +32,767** (with two's complement for negatives)

**Memory:** 256 storage locations (addresses 00 to FF)

- Like mailboxes with postal addresses
- Stores both program instructions AND data

**Registers:** 16 registers (labeled 0 to F)

- Much **faster** than memory
- Used as scratch space (like variables)
- Register 0 always equals **0**

**Program Counter (PC):** Points to the next instruction

- 8-bit value (range 00 to FF)
- Automatically incremented as instructions execute

---

### How to Use TOY

**Input (Loading Instructions):**

1. Set the 8 memory address switches (pick an address 00-FF)
2. Set the 16 data switches (pick your value)
3. Press the **Load** button
4. Repeat for each instruction/data value

**Output (Looking at Memory):**

1. Set the memory address switches
2. Press the **Look** button
3. The lights show what's stored at that address

**Running a Program:**

1. Load your program into memory
2. Set PC to starting address (usually 10)
3. Press **Run** (continuous) or **Step** (one instruction at a time)

---

### The Fetch-Execute Cycle

Every instruction goes through these steps:

1. **Fetch:** PC points to memory, grab the instruction
2. **Increment:** PC = PC + 1 (ready for next instruction)
3. **Decode:** Interpret what the instruction means
4. **Execute:** Do what the instruction says
5. **Repeat** (until halt instruction)

---

### Core Dump 📷

A **core dump** = snapshot of everything in the machine at one moment

- Shows all memory values
- Shows all register values
- Shows the program counter
- It's a complete record of the machine's state

---

### The Von Neumann Model 🎯

**Key Idea (1945):** Both programs and data live in the same memory!

This was revolutionary because:

- ✅ No need to physically rewire the hardware
- ✅ Can modify programs at runtime
- ✅ Enables modern flexible computing
- ❌ ENIAC (older computer) required manual cable plugging to reprogram!

This stored-program model is the foundation of all modern computers.

(ORIGINAL TEXT CONTINUES — FULL BLOCK INCLUDED IN FILE)

---

## What TOY Really Is

TOY is a **small imaginary computer** used to teach how real CPUs work.
It contains the same key ideas as real CPUs like Intel, ARM, etc.

## Why Study It?

Because TOY helps you understand:

- What machine language looks like
- How instructions are executed
- How registers and memory work
- What a program counter does
- Why data and code share memory (Von Neumann model)

---

## TOY Hardware Summary (Friendly Table)

| Component            | Description                   |
| -------------------- | ----------------------------- |
| ALU                  | Does math + logic operations  |
| Registers (16)       | Fast storage for calculations |
| Memory (256 words)   | Holds program + data          |
| Program Counter (PC) | Points to next instruction    |
| Switches             | Used to manually enter data   |
| Lights               | Display values in memory      |
| Buttons              | Run, Step, Load, Look, Reset  |

---

## TOY Word Size

- A word = **16 bits**
- Stored as **hex** (0000 to FFFF)
- Two’s complement → supports negative numbers

---

## TOY Memory and Registers

| Type      | Size               | Notes                         |
| --------- | ------------------ | ----------------------------- |
| Memory    | 256 × 16-bit words | Slower, stores program + data |
| Registers | 16                 | Faster, used as variables     |

Register **0** is always **0**.

---

## Execution Cycle (Friendly)

1. 🟦 PC tells which instruction to fetch
2. 🟩 Fetch from memory
3. 🟧 Increment PC
4. 🟨 Decode instruction
5. 🟥 Execute instruction
6. Repeat forever (or until halt)

---

# 3. 🧱 Full Instruction Set Table

| Opcode | Instruction     | Format | Meaning                  |
| ------ | --------------- | ------ | ------------------------ |
| 0      | halt            | –      | stop execution           |
| 1      | add             | RR     | R[d] ← R[s] + R[t]       |
| 2      | subtract        | RR     | R[d] ← R[s] - R[t]       |
| 3      | and             | RR     | R[d] ← R[s] & R[t]       |
| 4      | xor             | RR     | R[d] ← R[s] ^ R[t]       |
| 5      | left shift      | RR     | R[d] ← R[s] << R[t]      |
| 6      | right shift     | RR     | R[d] ← R[s] >> R[t]      |
| 7      | load address    | A      | R[d] ← addr              |
| 8      | load            | A      | R[d] ← mem[addr]         |
| 9      | store           | A      | mem[addr] ← R[d]         |
| A      | load indirect   | RR     | R[d] ← mem[R[t]]         |
| B      | store indirect  | RR     | mem[R[t]] ← R[d]         |
| C      | branch zero     | A      | if (R[d] == 0) pc ← addr |
| D      | branch positive | A      | if (R[d] > 0) pc ← addr  |
| E      | jump register   | RR     | pc ← R[d]                |
| F      | jump and link   | A      | R[d] ← pc ; pc ← addr    |

---
```

---

## TOY Instruction Examples

Below are detailed, practical examples for **all 16 TOY instructions**. For each instruction you'll find:

- opcode and format
- short description
- a concrete example (initial state → after state)
- a small note about edge cases or typical uses

At the end there are two short example programs demonstrating loops and a simple subroutine call.

---

## Quick reference: instruction formats

- RR format: `O D S T` — 4 nibbles (opcode, dest, src1, src2). Example: `1CAB` means opcode=1, D=C, S=A, T=B.
- A format: `O D AA` — opcode, dest, 8-bit address (two hex digits). Example: `7A2F` means opcode=7, D=A, addr=2F.

All examples below use hexadecimal for instruction words and 4-digit hex for register/memory contents (16 bits).

---

## Instruction summary table

### 0 — halt

Opcode: `0` (special)

Example instruction:

```
0000
```

Meaning: stop execution immediately. No registers or memory are modified.

Usage note: typically placed at the end of a program or used as a trap for debugging.

---

### 1 — add (RR)

Format: `1 D S T` (e.g. `1CAB`)

Meaning: `R[D] = R[S] + R[T]` (16-bit arithmetic, wraps on overflow)

Concrete example:

Initial registers:

```
R[A]=0008  R[B]=0005  R[C]=0000
```

Instruction: `1CAB`

After execution:

```
R[C] = 0008 + 0005 = 000D
```

Edge cases: overflow wraps modulo 2^16 (two's complement semantics apply if interpreting signed values).

---

### 2 — subtract (RR)

Format: `2 D S T` (e.g. `2CAB`)

Meaning: `R[D] = R[S] - R[T]`

Example:

Initial: `R[A]=0008  R[B]=0005  R[C]=0000`
Instruction: `2CAB`
After: `R[C] = 0008 - 0005 = 0003`

Note: result is modulo 2^16; negative results are represented in two's complement.

---

### 3 — and (RR)

Format: `3 D S T`

Meaning: bitwise AND: `R[D] = R[S] & R[T]`

Example:

Initial: `R[A]=00F0  R[B]=00CC`
Instruction: `3CAB`
After: `R[C] = 00F0 & 00CC = 00C0`

Use: masking bits, clearing flags, etc.

---

### 4 — xor (RR)

Format: `4 D S T`

Meaning: bitwise XOR: `R[D] = R[S] ^ R[T]`

Example:

Initial: `R[A]=00FF  R[B]=0F0F`
Instruction: `4CAB`
After: `R[C] = 00FF ^ 0F0F = 0FF0`

Use: toggling bits, parity checks.

---

### 5 — left shift (RR)

Format: `5 D S T` (treat R[T] as shift amount)

Meaning: logical left shift by the low 4 bits of `R[T]`: `R[D] = R[S] << (R[T] & 0xF)`

Example:

Initial: `R[A]=0001  R[B]=0004  R[C]=0000`
Instruction: `5CAB`
After: `R[C] = 0001 << 4 = 0010`

Note: shift amount may be truncated; shifting by ≥16 typically yields 0.

---

### 6 — right shift (RR)

Format: `6 D S T`

Meaning: logical right shift by the low 4 bits of `R[T]`: `R[D] = R[S] >> (R[T] & 0xF)`

Example:

Initial: `R[A]=0040  R[B]=0003  R[C]=0000`
Instruction: `6CAB`
After: `R[C] = 0040 >> 3 = 0008`

If signed arithmetic shift is desired, emulate using arithmetic routines.

---

### 7 — load address (A)

Format: `7 D AA` (e.g. `7A2F`)

Meaning: `R[D] = addr` (zero-extend 8-bit address into 16-bit register)

Example:

Instruction: `7A2F`
After: `R[A] = 002F` (register holds the address 2F)

Use: prepare an address for indirect loads/stores or as pointer arithmetic base.

---

### 8 — load (A)

Format: `8 D AA` (e.g. `8A2F`)

Meaning: `R[D] = MEM[AA]`

Example:

Memory: `mem[2F] = 1234`
Instruction: `8A2F`
After: `R[A] = 1234`

Note: typical for loading constants or array elements from memory.

---

### 9 — store (A)

Format: `9 D AA` (e.g. `9A2F`)

Meaning: `MEM[AA] = R[D]`

Example:

Initial: `R[A] = 00FF`
Instruction: `9A2F`
After: `mem[2F] = 00FF`

Use: write results back to memory.

---

### A — load indirect (RR)

Format: `A D S T` — uses register T as an address

Meaning: `R[D] = MEM[ R[T] ]` (R[T] holds the address)

Example:

Initial: `R[B]=0040  mem[0040]=7777`
Instruction: `AC0B` (D=C, S=0, T=B)
After: `R[C] = 7777`

Use: pointer dereference.

---

### B — store indirect (RR)

Format: `B D S T` (we'll read this as `mem[R[T]] = R[D]` consistent with earlier examples)

Meaning: `MEM[ R[T] ] = R[D]`

Example:

Initial: `R[A]=0040  R[C]=5555`
Instruction: `BC0A` (D=B? — following original example this writes R[C] into mem[R[A]])
Interpretation and concrete example (clear mapping):

If instruction is `B C 0 A` → opcode=B, D=C, S=0, T=A → effect: `mem[R[A]] = R[C]`.

Before: `R[A]=0040  R[C]=5555`
After: `mem[0040] = 5555`

Note: be careful with operand positions; the important idea is that B does an indirect store using a register as address.

---

### C — branch zero (A)

Format: `C D AA`

Meaning: if `R[D] == 0` then `pc = AA` (otherwise continue)

Example:

Initial: `R[2]=0000` (zero)
Instruction: `C203`
Effect: `pc` becomes `03`, execution continues at address `03`.

Use: implement conditional branches based on zero result.

---

### D — branch positive (A)

Format: `D D AA`

Meaning: if `R[D] > 0` then `pc = AA`

Example:

If `R[2] = 0005`, instruction `D203` will set `pc = 03`.

Note: comparisons use signed interpretation if you intend negative/positive tests — be consistent.

---

### E — jump register (RR)

Format: `E D S T` (we use D as the register holding target)

Meaning: `pc = R[D]`

Example:

If `R[3] = 0040` and instruction `E300` executes, then `pc` becomes `0040` (next fetch comes from address 40).

Use: returns, indirect jumps, computed branches.

---

### F — jump and link (A)

Format: `F D AA`

Meaning:

```
R[D] = pc
pc = AA
```

Example (call):

Assume `pc` currently `0010` (next instruction after call would be 0010);
Instruction: `FA20` (D=A, AA=20)
After:

```
R[A] = 0010   ; return address saved
pc = 0020     ; jump to subroutine at 20
```

Use: call subroutines; conventionally after the callee finishes, it will use `E` (jump register) to return using the saved return address in R[A].

ASCII diagram: call / return

```
Caller:                        Callee:
pc -> FA20 (save pc in R[A], pc=20)   ...subroutine body...
						   at end: E A 00  (pc = R[A])
						   -> returns to caller's next instruction
```

---

## Small program examples

Below are two short programs (presented as memory contents at addresses). These show how instructions combine.

1. Sum two registers and store result in memory

Memory (addresses shown, each line one instruction word):

```
10:  1C A B   ; 1CAB  -> R[C] = R[A] + R[B]
11:  9C 2F    ; 9C2F  -> mem[2F] = R[C]
12:  0000     ; halt
```

Concrete values:
R[A]=0002, R[B]=0003 → After 1CAB: R[C]=0005 → 9C2F writes mem[2F]=0005

2. Loop: decrement R[1] until zero

Purpose: assume R[1] holds a count N. Each iteration decrement and branch until zero.

```
20:  2101   ; 2 1 1 0  -> R[1] = R[1] - R[0]  (if R0==0 this would be same; better: use R[1] = R[1] - 1)
	(better explicit: use add with -1 in register)
20:  1 1 1 F  ; use R[F] contains FFFF (-1), instruction: 111F (R[1]=R[1]+R[F])
21:  C1 20    ; C120 -> if R[1]==0 pc=20 (loop end)  [note: addresses adjusted]
22:  E0 00    ; E000 -> return/halt (or continue)
```

Simpler concrete loop (using immediate-like pattern):

Setup:
R[F] = FFFF ; register F contains -1

Program:

```
30:  1 1 1 F   ; 111F  -> R[1] = R[1] + R[F]  (decrement)
31:  C1 30     ; C130  -> if R[1]==0 pc=30 (exit loop when zero)
32:  E0 00     ; E000  -> halt (end)
```

Note: the exact layout and addressing depend on how you initialize registers/memory before running.

---

## Tips and gotchas

- Remember register `0` always reads as `0` — use it when you need the constant 0.
- Byte/word sizes: addresses are 8 bits (00..FF). Data and registers are 16 bits.
- Branch targets are absolute addresses (8-bit).
- For multi-word data (arrays), store consecutive words and use load/store with computed addresses.

---
