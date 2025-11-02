# Formal Languages, DFA, NFA, and Turing Machines

---

## 1. **Formal Languages**

A **formal language** is a set of strings formed from a specific alphabet.

### Basic Terms

- **Symbol** – A basic character (letter, digit, etc.)
- **Alphabet (Σ)** – A finite set of symbols
- **String** – A finite sequence of symbols from an alphabet
- **Language (L)** – A set of strings over an alphabet

### Examples

- Binary alphabet: `{0, 1}` → examples: `010`, `111`, `1001`
- DNA alphabet: `{A, T, C, G}`

### Core Problems

- **Specification Problem** – How to precisely define a language
- **Recognition Problem** – Given a string `x`, determine whether `x ∈ L`

---

## 2. **Regular Languages**

Languages that can be represented using **regular expressions (REs)** or **finite automata**.

### Regular Operations

| Operation             | Symbol | Meaning                      | Example                     |
| --------------------- | ------ | ---------------------------- | --------------------------- | -------- | ------------------------- | ---- |
| Union                 | `R     | S`                           | Strings in either R or S    | `{a, ba} | {ab, b} = {a, ba, ab, b}` |
| Concatenation         | `RS`   | Strings from R followed by S | `{a, ab}{ba} = {aba, abba}` |
| Closure (Kleene Star) | `R*`   | Zero or more concatenations  | `R\* = ε                    | R        | RR                        | ...` |

---

### Regular Expressions (RE)

A **regular expression** is a formula that defines a formal language using:

- **Union (`|`)**
- **Concatenation**
- **Closure (`*`)**
- **Parentheses (`( )`)**

A language is **regular** if it can be described by some RE.

---

### Generalized Regular Expressions

Extended syntax in modern programming (e.g., Java):

- **`.`** → Matches any symbol
- **`^`**, **`$`** → Match beginning or end of line
- **`[abc]`** → Match any listed symbol
- **`[^abc]`** → Match any symbol _not_ in the list
- **`+`** → One or more repetitions
- **`?`** → Zero or one repetition
- **`{n}`**, **`{m,n}`** → Specific number or range of repetitions

Example: `^[A-Za-z0-9_]+$` → Matches valid variable names

---

### Regular Expressions in Java

- **Recognition**: `s.matches(re)` returns `true` if string `s` matches regex `re`.
- **Validation**: `Validate.java` checks strings against regex patterns.
- **Searching**: `Grep.java` prints all lines containing substrings matching regex.

---

## 3. **Finite Automata**

Abstract machines used to **recognize patterns** in strings.

### Components of Finite Automata

- A finite set of **states (Q)**
- An **input alphabet (Σ)**
- A **transition function (δ)**: defines next state based on current state and input symbol
- A **start state (q₀)**
- A set of **accept (final) states (F)**

Formally: **FA = {Q, Σ, q₀, F, δ}**

---

## 4. **Deterministic Finite Automata (DFA)**

### Properties

- Exactly **one** transition for each symbol in every state.
- **No null transitions (ε-moves)**.
- Accepts if final state ∈ F after reading input.

### Example — Strings ending with 'a'

```
Σ = {a, b}
Q = {q0, q1}
F = {q1}
Transitions:
q0 -a-> q1
q0 -b-> q0
q1 -a-> q1
q1 -b-> q0
```

✅ Accepts: `a`, `ba`, `bba`  
❌ Rejects: `b`, `abb`

---

## 5. **Nondeterministic Finite Automata (NFA)**

### Properties

- Multiple transitions for same input allowed.
- **Null transitions (ε-moves)** allowed.
- A string is **accepted** if _any_ path reaches an accept state.

### Example — Strings ending in 'a'

```
Σ = {a, b}
Q = {q0, q1}
F = {q1}
Transitions:
q0 -a-> {q0, q1}
q0 -b-> {q0}
```

✅ Accepts: `a`, `ba`, `bba`

---

### DFA vs NFA

| Feature               | DFA                                     | NFA                            |
| --------------------- | --------------------------------------- | ------------------------------ |
| Transitions per input | Exactly 1                               | 0, 1, or many                  |
| Null (ε) transitions  | Not allowed                             | Allowed                        |
| Determinism           | Deterministic                           | Nondeterministic               |
| Power                 | Same (both recognize regular languages) |
| Conversion            | Every NFA → DFA                         | Possible but may expand states |

---

## 6. **Kleene’s Theorem**

States that **REs, DFAs, and NFAs are equivalent** — they all describe the same class of **regular languages**.

### Implications

- Any RE → equivalent NFA → equivalent DFA.
- RE recognition (Java’s `matches()` method) works by building and simulating an NFA.
- Not all languages are regular (e.g., equal number of `a`s and `b`s cannot be represented by RE or DFA).

---

## 7. **Pushdown Automata (PDA)**

A **PDA** extends a DFA with a **stack** → gives more computational power.

- Can recognize **context-free languages** (like balanced parentheses).

---

## 8. **Turing Machines**

The most powerful abstract model — the foundation of computation.

### Key Characteristics

- Infinite tape divided into cells.
- Read/write head that can move left or right.
- Finite set of states.
- Transition rules that dictate: read symbol → write symbol → move direction → next state.

### Capabilities

- Can simulate any algorithmic process.
- Recognizes all **recursively enumerable languages**.

---

## 9. **Finite Automata Summary Table**

| Type | Memory        | Null Moves | Deterministic | Power                    |
| ---- | ------------- | ---------- | ------------- | ------------------------ |
| DFA  | No            | No         | Yes           | Regular languages        |
| NFA  | No            | Yes        | No            | Regular languages        |
| PDA  | Stack         | Yes        | No            | Context-free languages   |
| TM   | Infinite tape | Yes        | No            | All computable languages |

---

## 10. **Key Takeaways for Exams**

- **Formal Language** → defined by rules over alphabets.
- **Regular Expression** ↔ **DFA/NFA** ↔ **Regular Language** (Kleene’s theorem).
- **DFA**: One transition per input; no ε-moves.
- **NFA**: Many possible transitions; accepts if _any_ path works.
- **PDA**: Adds stack → handles nested structures.
- **Turing Machine**: Adds full read/write memory → basis of modern computing.

---
