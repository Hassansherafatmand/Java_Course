# 🧠 Transition Matrix – Random Surfer Model (Complete Notes)

## 🌐 Overview

The **Transition Matrix** represents the probability that a **random surfer** (user) moves from one web page to another.

It’s a core part of the **Random Surfer Model** — the foundation of Google’s **PageRank algorithm**.

In this model, each web page is a **node**, and each hyperlink is a **directed edge** that connects one page to another.

---

## 🧭 The Random Surfer Model

The model assumes a web user behaves as follows:

- **90% of the time (α = 0.9)** → clicks on a **random link** on the current page
- **10% of the time (1 − α = 0.1)** → **teleports** (goes to a completely random page)

This is called the **90–10 rule** and combines:

1. **Link-following behavior**
2. **Random teleportation**

This ensures the surfer never gets “stuck” on a page with no outgoing links.

---

## 📊 What Is the Transition Matrix?

It’s an **n × n matrix** (square table) where:

- `n` = number of pages
- Each **row** represents the _current page (from)_
- Each **column** represents the _next page (to)_
- Each entry `p[i][j]` = probability that the surfer moves **from page i → to page j**

All rows must **sum to 1.0**, meaning the surfer _must_ go somewhere next.

---

## 🧩 Example

### Input Links (Adjacency)

```
5
0 1
1 2
1 3
1 4
2 3
3 0
4 0
4 2
```

This means:

- Page 0 → 1
- Page 1 → 2, 3, 4
- Page 2 → 3
- Page 3 → 0
- Page 4 → 0, 2

### Outgoing Links (outLinks)

| Page | Outlinks |
| ---- | -------- |
| 0    | 1        |
| 1    | 3        |
| 2    | 1        |
| 3    | 1        |
| 4    | 2        |

---

## 🧮 Transition Probability Formula

Each entry in the transition matrix is computed using the **90–10 rule**:

\[
p[i][j] = α × \text{linkProbability} + (1−α) × \text{randomJump}
\]

Where:

- **α (alpha)** = probability of clicking a link (usually 0.9)
- **linkProbability** = 1 / outLinks[i] (if a link exists)
- **randomJump** = 1 / n (teleportation chance)

### Expanded Logic (in Java terms)

```java
if (outLinks[i] == 0)
    p[i][j] = 1.0 / n;                                  // No outgoing links
else if (links[i][j] == 1)
    p[i][j] = α / outLinks[i] + (1 - α) / n;            // Has a link to j
else
    p[i][j] = (1 - α) / n;                              // No link, teleport chance
```

---

## 📘 Explanation of Each Case

### 1️⃣ Page with No Outgoing Links

If a page has no links (`outLinks[i] == 0`),  
then every destination (including itself) is equally likely:

\[
p[i][j] = \frac{1}{n}
\]

➡ Example: If `n = 5`, each page has a probability of `1/5 = 0.20`.

---

### 2️⃣ Page _Has_ a Link to `j`

If a link exists (`links[i][j] == 1`),  
then there’s a combination of two probabilities:

- **Clicking** the link (weighted by α)
- **Teleporting** (weighted by 1−α)

\[
p[i][j] = \frac{α}{\text{outLinks}[i]} + \frac{(1−α)}{n}
\]

➡ Example:  
α = 0.9, outLinks[i] = 3, n = 5  
\[
p[i][j] = 0.9/3 + 0.1/5 = 0.3 + 0.02 = 0.32
\]

---

### 3️⃣ Page with _No_ Link to `j`

If there’s no direct link,  
the surfer can only arrive via teleportation:

\[
p[i][j] = \frac{(1−α)}{n}
\]

➡ Example:  
α = 0.9, n = 5  
\[
p[i][j] = 0.02
\]

---

## 📊 Example Output Matrix

| From\To | 0     | 1     | 2     | 3     | 4     |
| ------- | ----- | ----- | ----- | ----- | ----- |
| **0**   | 0.020 | 0.920 | 0.020 | 0.020 | 0.020 |
| **1**   | 0.020 | 0.020 | 0.338 | 0.338 | 0.283 |
| **2**   | 0.020 | 0.020 | 0.020 | 0.920 | 0.020 |
| **3**   | 0.920 | 0.020 | 0.020 | 0.020 | 0.020 |
| **4**   | 0.470 | 0.020 | 0.470 | 0.020 | 0.020 |

✅ Each row sums to 1.000  
✅ Each value represents the surfer’s probability of moving to that destination

---

## 🧠 Why We Add Teleportation (Random Jump)

Without teleportation:

- The surfer might get **stuck** in pages with no outlinks
- Or trapped in a **loop** of linked pages

Adding a small teleportation factor (1−α) ensures:

- Every page has some chance of being reached
- The matrix becomes **ergodic** (mathematically stable)
- The simulation always converges to a steady state

---

## 💻 Code Reference (Core Loop)

```java
double alpha = 0.9;
double[][] transition = new double[n][n];

for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        if (outLinks[i] == 0)
            transition[i][j] = 1.0 / n;
        else if (links[i][j] == 1)
            transition[i][j] = alpha / outLinks[i] + (1 - alpha) / n;
        else
            transition[i][j] = (1 - alpha) / n;
    }
}
```

---

## 🧾 Summary Table

| Concept               | Description                                             |
| --------------------- | ------------------------------------------------------- |
| **Transition Matrix** | Probability model showing where the surfer goes next    |
| **α (alpha)**         | Probability of clicking a random link (usually 0.9)     |
| **1 − α**             | Probability of teleporting to a random page             |
| **links[i][j]**       | 1 if a link exists, 0 otherwise                         |
| **outLinks[i]**       | Number of outgoing links from page i                    |
| **p[i][j]**           | Probability of going from i → j                         |
| **Stochastic Matrix** | Each row sums to 1.0                                    |
| **Purpose**           | Used to simulate the random surfer and compute PageRank |

---

## 📘 Example Java Output

```
Transition Matrix (probabilities):
0.020 0.920 0.020 0.020 0.020
0.020 0.020 0.338 0.338 0.283
0.020 0.020 0.020 0.920 0.020
0.920 0.020 0.020 0.020 0.020
0.470 0.020 0.470 0.020 0.020

Row sums (should all be ≈ 1.0):
Page 0 → 1.000
Page 1 → 1.000
Page 2 → 1.000
Page 3 → 1.000
Page 4 → 1.000
```

---

## 📚 Key Takeaways

- The **transition matrix** defines how the surfer moves.
- It combines **real user behavior** (clicking links) and **randomness** (teleportation).
- Every page has a small chance of being visited, keeping the model stable.
- It’s the **mathematical foundation** for PageRank and Markov chain analysis.
