# TOY Machine Language Programming - Complete Notes

## Table of Contents

1. [Overview](#overview)
2. [Instruction Set Summary](#instruction-set-summary)
3. [Memory & Registers](#memory--registers)
4. [Instruction Categories](#instruction-categories)
5. [Core Operations](#core-operations)
6. [Control Flow Examples](#control-flow-examples)
7. [Bit Operations](#bit-operations)
8. [Advanced Topics](#advanced-topics)
9. [TOY Programming Examples](#toy-programming-examples)

---

## Overview

**Key Facts:**

- TOY machine contains **16 different instruction types** (opcodes 0-15)
- All computations in Java can be performed in TOY
- Uses **16-bit two's complement integers**
- Limited memory: **256 memory locations** + registers
- Can process more information than fits in memory via I/O

---

## Instruction Set Summary

| Opcode | Name               | Purpose                  | Format  |
| ------ | ------------------ | ------------------------ | ------- |
| 0      | Halt               | Stop execution           | 0000    |
| 1      | Add                | R[d] ← R[s] + R[t]       | 1dst    |
| 2      | Subtract           | R[d] ← R[s] - R[t]       | 2dst    |
| 3      | Bitwise AND        | R[d] ← R[s] & R[t]       | 3dst    |
| 4      | Bitwise XOR        | R[d] ← R[s] ^ R[t]       | 4dst    |
| 5      | Left Shift         | R[d] ← R[s] << R[t]      | 5dst    |
| 6      | Right Shift        | R[d] ← R[s] >> R[t]      | 6dst    |
| 7      | Load Address       | R[d] ← addr (8-bit)      | 7d_addr |
| 8      | Load               | R[d] ← mem[addr]         | 8d_addr |
| 9      | Store              | mem[addr] ← R[d]         | 9d_addr |
| A      | Load Indirect      | R[d] ← mem[R[t]]         | Ad0t    |
| B      | Store Indirect     | mem[R[t]] ← R[d]         | Bd0t    |
| C      | Branch if Zero     | if (R[s] == 0) PC ← addr | Cs_addr |
| D      | Branch if Positive | if (R[s] > 0) PC ← addr  | Ds_addr |
| E      | Jump Register      | PC ← R[t]                | E000t   |
| F      | Jump and Link      | R[d] ← PC; PC ← addr     | Fd_addr |

---

## Memory & Registers

### Register Architecture

| Register        | Purpose         | Notes                               |
| --------------- | --------------- | ----------------------------------- |
| R[0]            | Always 0        | Cannot be modified; used for no-ops |
| R[1]-R[F]       | General Purpose | 16 total registers                  |
| Special Addr FF | I/O Port        | Read: stdin, Write: stdout          |

### Memory Layout

| Address Range | Purpose            |
| ------------- | ------------------ |
| 00-02         | Typically data     |
| 10-20         | Typically code     |
| 30-FF         | Array storage area |

---

## Instruction Categories

### 1. Memory-Register Transfer (Opcodes 8, 9, A, B)

**Load (8)** - Transfer from memory to register

```
8d_addr    R[d] ← mem[addr]
```

**Store (9)** - Transfer from register to memory

```
9d_addr    mem[addr] ← R[d]
```

**Load Indirect (A)** - Load using register as address

```
Ad0t       R[d] ← mem[R[t]]
```

**Store Indirect (B)** - Store using register as address

```
Bd0t       mem[R[t]] ← R[d]
```

### 2. Arithmetic Operations (Opcodes 1, 2)

| Operation | Opcode | Format | Example                  |
| --------- | ------ | ------ | ------------------------ |
| Add       | 1      | 1dst   | 1CAB: R[C] ← R[A] + R[B] |
| Subtract  | 2      | 2dst   | 2CAB: R[C] ← R[A] - R[B] |

**Key Points:**

- Overflow discards leading digits
- EFFF + 1005 = 0004 (16 bits only)
- Negative numbers use two's complement

### 3. Bitwise Operations (Opcodes 3, 4, 5, 6)

| Operation   | Opcode | Format | Purpose                               |
| ----------- | ------ | ------ | ------------------------------------- |
| AND         | 3      | 3dst   | R[d] ← R[s] & R[t]                    |
| XOR         | 4      | 4dst   | R[d] ← R[s] ^ R[t]                    |
| Left Shift  | 5      | 5dst   | R[d] ← R[s] << R[t] (multiply by 2^n) |
| Right Shift | 6      | 6dst   | R[d] ← R[s] >> R[t] (divide by 2^n)   |

**Shift Semantics:**

- Left shift: Pads 0s on right; a << 1 = a × 2
- Right shift: Arithmetic shift; preserves sign bit

### 4. Load Address (Opcode 7)

```
7d_addr    R[d] ← addr (8-bit constant)
```

- Loads small constants (00-FF) directly into register
- Useful for array base addresses (pointers in C terminology)

### 5. Branch/Jump Instructions (Opcodes C, D, E, F)

| Instruction        | Opcode | Format  | Condition                            |
| ------------------ | ------ | ------- | ------------------------------------ |
| Branch if Zero     | C      | Cs_addr | if R[s] == 0 → PC = addr             |
| Branch if Positive | D      | Ds_addr | if R[s] > 0 → PC = addr              |
| Jump Register      | E      | E000t   | PC = R[t]                            |
| Jump and Link      | F      | Fd_addr | R[d] = PC; PC = addr (function call) |

---

## Core Operations

### Program Structure Format

**Requirements for TOY.java:**

```
XX: YYYY  comments
```

Where:

- XX = 2 hex digits (memory address)
- YYYY = 4 hex digits (instruction)
- Comments are optional

### Addition Program (add.toy)

**Purpose:** Compute 5 + 8 = 13

| Address | Instruction | Meaning                |
| ------- | ----------- | ---------------------- |
| 00      | 0008        | Data: 8                |
| 01      | 0005        | Data: 5                |
| 02      | 0000        | Data: result (0)       |
| 10      | 8A00        | Load R[A] ← mem[00]    |
| 11      | 8B01        | Load R[B] ← mem[01]    |
| 12      | 1CAB        | Add R[C] ← R[A] + R[B] |
| 13      | 9C02        | Store mem[02] ← R[C]   |
| 14      | 0000        | Halt                   |

**Result:** R[C] = 000D (13 in hex)

### Subtraction Program (subtract.toy)

**Purpose:** Compute 5 - 8 = -3 (FFFD in two's complement)

| Address | Instruction | Meaning                     |
| ------- | ----------- | --------------------------- |
| 00      | 0005        | Data: 5                     |
| 01      | 0008        | Data: 8                     |
| 02      | 0000        | Result location             |
| 10      | 8A00        | Load R[A] ← mem[00]         |
| 11      | 8B01        | Load R[B] ← mem[01]         |
| 12      | 2CAB        | Subtract R[C] ← R[A] - R[B] |
| 13      | 9C02        | Store mem[02] ← R[C]        |
| 14      | 0000        | Halt                        |

---

## Control Flow Examples

### I/O Operations (Address FF)

**Special Address FF:**

- **Read:** 8dFF loads keyboard input into R[d]
- **Write:** 9dFF writes R[d] to screen

### Example 1: Sum Two Integers (stdin.toy)

```
10: 8AFF  read R[A]        // a = input
11: 8BFF  read R[B]        // b = input
12: 1CAB  add R[C]         // c = a + b
13: 9CFF  write R[C]       // output c
14: 0000  halt
```

### Example 2: Fibonacci Sequence (fibonacci.toy)

**Data:**
| Address | Value | Purpose |
|---------|-------|---------|
| 00 | 0000 | a = 0 |
| 01 | 0001 | b = 1 |

**Program:**

```
10: 8A00  R[A] ← mem[00]      // a = 0
11: 8B01  R[B] ← mem[01]      // b = 1
12: 9AFF  write R[A]          // print a
13: 1AAB  R[A] ← R[A] + R[B]  // a = a + b
14: 2BAB  R[B] ← R[A] - R[B]  // b = a - b
15: DA12  if (R[A] > 0) goto 12
16: 0000  halt
```

**Output:** 0, 1, 1, 2, 3, 5, 8, D, ...

### Example 3: Sum Sequence (sum.toy)

**Purpose:** Read integers until 0000, print sum

```
10: 7C00  R[C] ← 0000        // sum = 0
11: 8AFF  read R[A]          // read a
12: CA15  if (R[A] == 0) goto 15  // if a == 0 break
13: 1CCA  R[C] ← R[C] + R[A] // sum += a
14: C011  goto 11
15: 9CFF  write R[C]         // output sum
16: 0000  halt
```

### Example 4: Powers of 2 (powers2.toy)

**Data:**
| Address | Value |
|---------|-------|
| 00 | 0001 |

**Program:**

```
10: 8A00  R[A] ← mem[00]     // a = 1
11: 9AFF  write R[A]         // print a
12: 1AAA  R[A] ← R[A] + R[A] // a = a + a (multiply by 2)
13: DA11  if (R[A] > 0) goto 11
14: 0000  halt
```

**Output:** 1, 2, 4, 8, 10, 20, 40, 80, 100, 200, 400, 800, 1000, 2000, 4000, 8000

### Example 5: Infinite Loop (infinite_loop.toy)

```
10: 1000  no-op
11: 1000  no-op
12: C010  goto 10  // PC = 10 (infinite loop)
```

---

## Bit Operations

### Bitwise AND (Opcode 3)

**Example:** 00B5 & 00E3 = 00A1

```
R[1] = 0000 0000 1011 0101 (00B5)
R[2] = 0000 0000 1110 0011 (00E3)
R[3] = 0000 0000 1010 0001 (00A1)
       ↓    ↓    ↓    ↓    ↓
       AND operation on each bit
```

### Left Shift (Opcode 5)

**Example:** 00B5 << 2 = 02D4

| Value | Binary              | Decimal |
| ----- | ------------------- | ------- |
| 00B5  | 0000 0000 1011 0101 | 181     |
| << 2  | 0000 0010 1101 0100 | 724     |

**Property:** a << i = a × 2^i

### Right Shift (Opcode 6)

**Example 1 (Positive):** 00B5 >> 2 = 002D

| Value | Binary              | Decimal |
| ----- | ------------------- | ------- |
| 00B5  | 0000 0000 1011 0101 | 181     |
| >> 2  | 0000 0000 0010 1101 | 45      |

**Example 2 (Negative):** FF4B >> 2 = FFD2

| Value | Binary              | Decimal |
| ----- | ------------------- | ------- |
| FF4B  | 1111 1111 0100 1011 | -181    |
| >> 2  | 1111 1111 1101 0010 | -46     |

**Property:** Arithmetic shift preserves sign bit

---

## Advanced Topics

### 1. Efficient Multiplication (multiply.toy)

**Brute Force Approach:**

```
c = 0
while (a != 0) {
    c += b
    a -= 1
}
```

**Table View:**
| Address | Instruction | Pseudocode |
|---------|-------------|-----------|
| 10 | 8AFF | a = input |
| 11 | 8BFF | b = input |
| 12 | 7C00 | c = 0 |
| 13 | 7101 | R[1] = 1 |
| 14 | CA18 | if (a == 0) goto 18 |
| 15 | 1CCB | c += b |
| 16 | 2AA1 | a -= 1 |
| 17 | C014 | goto 14 |
| 18 | 9CFF | output c |
| 19 | 0000 | halt |

**Performance Issue:** Loop runs up to 32,767 times for 16-bit max

### 2. Efficient Multiplication Using Bit Shift

**Binary Decomposition:**
$$b = b_{15} \times 2^{15} + b_{14} \times 2^{14} + \ldots + b_1 \times 2^1 + b_0 \times 2^0$$

$$a \times b = \sum_{i=0}^{15} (a \times b_i \times 2^i)$$

**Algorithm:** For each bit of b, either add (a << i) or 0 to result

- Grade school multiplication applied to binary

### 3. TOY Idioms (Common Patterns)

| Idiom             | Purpose            | Code    | Notes                        |
| ----------------- | ------------------ | ------- | ---------------------------- |
| **No-op**         | Placeholder        | 1000    | R[0] is always 0             |
| **Register Copy** | Copy R[1] to R[2]  | 1201    | R[0] + R[1] = R[2]           |
| **Goto**          | Unconditional jump | C0F0    | if (R[0] == 0) PC = F0       |
| **Swap**          | Swap registers     | Complex | Use temp + XOR or arithmetic |

### 4. Load Address (Opcode 7) - Pointers

```
7A30    R[A] ← 0030  // A points to memory address 30
```

**Uses:**

- Store array base addresses
- Function as pointers (like in C)
- Load 8-bit constants into registers

### 5. Arrays & Indirect Addressing

**Array Access using Opcodes A & B:**

```
7A30    R[A] ← 0030              // base address
7101    R[1] ← 0001              // constant 1
16AB    R[6] ← R[A] + R[B]       // address = base + index
AC06    R[C] ← mem[R[6]]         // load: a[i]
BC06    mem[R[6]] ← R[C]         // store: a[i]
```

### 6. Reverse Array Program (reverse.toy)

**Purpose:** Read integers, store in array, print in reverse

| Phase       | Addresses | Purpose                               |
| ----------- | --------- | ------------------------------------- |
| Setup       | 10-12     | Initialize base address (30), counter |
| Input Loop  | 13-18     | Read integers, store sequentially     |
| Output Loop | 19-1F     | Print in reverse order                |

**Data Layout:**

- R[A]: Base address (30)
- R[B]: Element count
- R[6]: Current element address
- R[1]: Constant 1

### 7. Buffer Overflow Vulnerability

**Problem:** TOY has only 256 memory locations (00-FF)

**Scenario:**

```
Data stored at 30-FF (207 locations available)
After 207+ writes, program overwrites itself (10-2F area)
Input could be interpreted as instructions → virus potential
```

**Example:** Crazy 8 program

- Stores array at address 00 (program location!)
- After 16 inputs, overwrites program
- Malicious input sequence creates infinite loop

### 8. Functions & Call Conventions (Opcodes E, F)

**Jump and Link (F):** Store return address

```
FF30    R[F] ← PC; PC ← 30  // Call function at 30, save return address
```

**Jump Register (E):** Return from function

```
EF00    PC ← R[F]           // Jump to return address
```

**Convention Table:**
| Register | Role | Notes |
|----------|------|-------|
| R[A], R[B] | Input parameters | Passed by global assignment |
| R[C] | Output/result | Multiplication result stored here |
| R[F] | Return address | Set by jump and link instruction |
| R[1] | Temporary/constant | Often used for loop counters |

**No Local Variables:** All registers are global; must save/restore manually

### 9. Multiplication as Function

```
Function: Multiply R[A] × R[B] → R[C]

30: 7C00    R[C] ← 0        // c = 0
31: 7101    R[1] ← 1        // constant 1
32: CA36    if (R[A] == 0) goto 36
33: 1CCB    R[C] ← R[C] + R[B]  // c += b
34: 2AA1    R[A] ← R[A] - 1 // a -= 1
35: C032    goto 32
36: EF00    PC ← R[F]       // return
```

### 10. Horner's Method for Polynomial Evaluation

**Standard Form:** p(x) = a₃x³ + a₂x² + a₁x + a₀

**Horner's Form:** p(x) = (((a₃)x + a₂)x + a₁)x + a₀

**Advantage:** Only n multiplications needed (vs. 2n for brute force)

**Application:** Convert decimal 765 to hexadecimal

- Input: x=A, n=3, a₂=7, a₁=6, a₀=5
- Compute: 7×10² + 6×10 + 5 = 765₁₀ = 2FD₁₆
- **History:** Used by Newton (18th c.), published by Horner (19th c.)

### 11. Linked Lists

**Node Structure:**

```
mem[D0] = key (0001)
mem[D1] = next pointer (00D6)
mem[D2] = unused
mem[D3] = unused
```

**Traversal Code:**

```
10: 8101    R[1] ← mem[01]      // R[1] = 1
11: 8202    R[2] ← mem[02]      // R[2] = pointer to first node

Loop:
12: 1421    R[4] ← R[2] + 1
13: A302    R[3] ← mem[R[2]]    // Load key
14: 93FF    write R[3]          // Print key
15: A204    R[2] ← mem[R[2]+1]  // Load next pointer
16: D212    if (R[2] > 0) goto 12
17: 0000    halt
```

**Example Output:** Traverses chain, prints: 0001, 0002, 0003, 0004
**Termination:** When R[2] = 0000 (NULL equivalent in Java)

### 12. Recursion in TOY

**Challenges:**

- No built-in stack
- All variables are global
- Manual management of return addresses
- Can be implemented but requires careful planning

---

## Summary Table: When to Use Each Opcode

| Task             | Opcode     | Notes                       |
| ---------------- | ---------- | --------------------------- |
| Stop execution   | 0          | 0000 (halt)                 |
| Basic arithmetic | 1, 2       | Add, Subtract               |
| Bit manipulation | 3, 4, 5, 6 | AND, XOR, Shifts            |
| Load constant    | 7          | Only 8-bit values (00-FF)   |
| Memory access    | 8, 9       | Direct load/store           |
| Array access     | A, B       | Indirect load/store         |
| Conditional jump | C, D       | Branch if Zero/Positive     |
| Function calls   | E, F       | Jump register / Jump & Link |

---

## Key Takeaways

✓ **Turing Complete:** All Java computations possible in TOY  
✓ **Limited Resources:** 256 memory locations, 16 registers  
✓ **No Local Variables:** All registers are global; manual save/restore needed  
✓ **Hardware I/O:** Address FF connects to stdin/stdout  
✓ **Two's Complement:** Standard integer representation  
✓ **Array Support:** Via indirect addressing (opcodes A, B)  
✓ **Function Support:** Via jump & link (opcodes E, F)  
✓ **Security Risk:** Buffer overflow can lead to code injection

## TOY Programming Examples

## 1. Program: Add

```
program Add
// Input: Stored in memory location 00 and 01
// Output: Sum of two integers 5 + 8 = D saved in memory location 02.
// -----------------------------------------------------------------------------
00: 0008 (0000 0000 0000 1000, 8)
01: 0005 (0000 0000 0000 0101, 5)
02: 0000 (0000 0000 0000 0000, 0)

10: 8A00 R[A] <- mem[00]
11: 8B01 R[B] <- mem[01]
12: 1CAB R[C] <- R[A] + R[B]
13: 9C02 mem[02] <- R[C]
14: 0000 halt
```

---

## 2. Program: Subtract

```
program Subtract
// Input: Stored in memory location 00 and 01
// Output: Difference 5 - 8 = FFFD saved in memory location 02.
// -----------------------------------------------------------------------------
00: 0005
01: 0008
02: 0000

10: 8A00 R[A] <- mem[00]
11: 8B01 R[B] <- mem[01]
12: 2CAB R[C] <- R[A] - R[B]
13: 9C02 mem[02] <- R[C]
14: 0000 halt
```

---

## 3. Program: Stdin (Sum Two Inputs)

```
program Stdin
// Input: Two integers from standard input
// Output: Their sum
// -----------------------------------------------------------------------------
10: 8AFF read R[A] from stdin
11: 8BFF read R[B] from stdin
12: 1CAB R[C] <- R[A] + R[B]
13: 9CFF write R[C] to stdout
14: 0000 halt
```

---

## 4. Program: Fibonacci

```
program Fibonacci
// Input: None
// Output: Prints Fibonacci numbers
// -----------------------------------------------------------------------------
00: 0000
01: 0001

10: 8A00 RA <- mem[00]
11: 8B01 RB <- mem[01]
while(a > 0) {
12: 9AFF print RA
13: 1AAB RA <- RA + RB
14: 2BAB RB <- RA - RB
15: DA12 if (RA > 0) goto 12 }
16: 0000 halt
```

---

## 5. Program: Sum

```
program Sum
// Input: Sequence of non-zero integers, terminated by 0000
// Output: Sum of all integers
// -----------------------------------------------------------------------------
10: 7C00 RC <- 0000
11: 8AFF read RA
12: CA15 if (RA == 0) pc <- 15
13: 1CCA RC <- RC + RA
14: C011 pc <- 11
15: 9CFF write RC
16: 0000 halt
```

---

## 6. Program: Powers of 2

```
program Powers of 2
// Input: None
// Output: Prints positive powers of 2
// -----------------------------------------------------------------------------
00: 0001

10: 8A00 RA <- mem[00]
11: 9AFF write RA
12: 1AAA RA <- RA + RA
13: DA11 if (RA > 0) goto 11
14: 0000 halt
```

---

## 7. Program: Infinite Loop

```
program Infinite Loop
// Input: -
// Output: Infinite loop
// -----------------------------------------------------------------------------
10: 1000
11: 1000
12: C010 goto 10
```

---

## 8. Multiplication Pseudocode (Slow Multiply)

```
10: 8AFF read R[A]
11: 8BFF read R[B]
12: 7C00 R[C] <- 0000
13: 7101 R[1] <- 0001

14: CA18 if (R[A] == 0) goto 18
15: 1CCB R[C] <- R[C] + R[B]
16: 2AA1 R[A] <- R[A] - R[1]
17: C014 goto 14

18: 9CFF write R[C]
19: 0000 halt
```

---

## 9. Program: Reverse

```
program Reverse
// Input: Positive ints terminated by 0000
// Output: Reversed list
// -----------------------------------------------------------------------------
10: 7101 R[1] <- 0001
11: 7A30 R[A] <- 0030
12: 7B00 R[B] <- 0000

13: 8CFF read R[C]
14: CC19 if (R[C] == 0) goto 19
15: 16AB R[6] <- R[A] + R[B]
16: BC06 mem[R[6]] <- R[C]
17: 1BB1 R[B] <- R[B] + R[1]
18: C013 goto 13

19: CB20 if (R[B] == 0) goto 20
1A: 16AB R[6] <- R[A] + R[B]
1B: 2661 R[6] <- R[6] - R[1]
1C: AC06 R[C] <- mem[R[6]]
1D: 9CFF write R[C]
1E: 2BB1 R[B] <- R[B] - R[1]
1F: C019 goto 19
20: 0000 halt
```

---

## 10. Program: Crazy 8

```
program Crazy 8
// Input >16 numbers causes overwrite (virus demonstration)
// -----------------------------------------------------------------------------
10: 7101 R[1] <- 0001
11: 7A00 R[A] <- 0000
12: 7B00 R[B] <- 0000

13: 8CFF read R[C]
14: CC19 if (R[C] == 0) goto 19
15: 16AB R[6] <- R[A] + R[B]
16: BC06 mem[R[6]] <- R[C]
17: 1BB1 R[B] <- R[B] + R[1]
18: C013 goto 13

19: CB20 if (R[B] == 0) goto 20
1A: 16AB R[6] <- R[A] + R[B]
1B: 2661 R[6] <- R[6] - R[1]
1C: AC06 R[C] <- mem[R[6]]
1D: 9CFF write R[C]
1E: 2BB1 R[B] <- R[B] - R[1]
1F: C019 goto 19
20: 0000 halt
```

---

## 11. Program: Horner's Method + Multiply Function

```
program Horner's method
10: 7C00 R[C] <- 0000
11: 7101 R[1] <- 0001
12: 82FF read R[2]
13: 83FF read R[3]

14: 84FF read R[4]
15: 1A20 R[A] <- R[2]
16: 1BC0 R[B] <- R[C]
17: FF30 R[F] <- pc; goto 30
18: 1CC4 R[C] <- R[C] + R[4]
19: C31C if (R[3] == 0) goto 1C
1A: 2331 R[3] <- R[3] - R[1]
1B: C014 goto 14

1C: 9CFF write R[C]
1D: 0000 halt

function multiply
30: 7C00 R[C] <- 0000
31: 7101 R[1] <- 0001
32: CA36 if (R[A] == 0) goto 36
33: 1CCB R[C] <- R[C] + R[B]
34: 2AA1 R[A] <- R[A] - R[1]
35: C032 goto 32
36: EF00 goto R[F]
```

---

# END OF FILE
