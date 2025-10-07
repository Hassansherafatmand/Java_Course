# 🌐 Case Study 1.6 – Random Web Surfer

## 📘 Overview

The **Random Web Surfer** case study models how users navigate the web through a process of random page visits and link clicks.  
It demonstrates the concepts of **probability distributions**, **Markov chains**, and **PageRank**, forming the mathematical foundation of how search engines evaluate webpage importance.

---

## 🧠 Core Concept: The Random Surfer Model

Imagine a web user (the “random surfer”) who:

1. Starts on any web page.
2. With **90% probability**, clicks a random hyperlink on the current page.
3. With **10% probability**, jumps to a random page on the web (by typing the address).

This model captures the stochastic (random) behavior of web browsing and serves as a simple yet powerful foundation for web ranking systems.

---

## 🧩 The 90–10 Rule

| Behavior | Probability | Description |
|-----------|--------------|--------------|
| Click a link on the current page | 0.9 | Choose one link uniformly at random |
| Jump to a random page | 0.1 | Teleport to any page, chosen uniformly |

### Why include teleportation?
Without teleportation, the surfer could become trapped in:
- Dead-end pages (with no outgoing links).
- Closed loops of connected pages.

Adding a small random-jump probability ensures the model is **ergodic** — meaning every page can eventually be reached.

---

## 🧮 Input Representation

We represent the web as a **directed graph**:

- **Nodes** = web pages  
- **Edges** = hyperlinks between pages

### Input format:

```
n
i j
i j
...
```

Where:
- `n` = number of pages  
- Each pair `(i, j)` represents a link **from page i → to page j**.

Example `tiny.txt`:

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

---

## 🧭 Step 1: Building the Transition Matrix

### What is a Transition Matrix?

An **n×n matrix** `P` that defines the probability of moving **from page i to page j**.

```
P[i][j] = probability(random surfer moves from i → j)
```

Each row is a probability distribution and must sum to 1.

---

### Formula

Using the 90–10 rule:

```
P[i][j] = α × (linkProbability) + (1−α) × (randomJump)
```

where:
- `α = 0.9`
- `linkProbability = 1 / outLinks[i]` if there’s a link from `i → j`, else 0
- `randomJump = 1 / n`

If a page has **no outgoing links**, we assign `1/n` to every destination.

---

### Example

| From\To | 0 | 1 | 2 | 3 | 4 |
|----------|---|---|---|---|---|
| **0** | 0.02 | 0.92 | 0.02 | 0.02 | 0.02 |
| **1** | 0.02 | 0.02 | 0.34 | 0.34 | 0.28 |
| **2** | 0.02 | 0.02 | 0.02 | 0.92 | 0.02 |
| **3** | 0.92 | 0.02 | 0.02 | 0.02 | 0.02 |
| **4** | 0.47 | 0.02 | 0.47 | 0.02 | 0.02 |

Each row sums to 1.00 ✅

---

## 💻 Program 1: Transition.java

```java
public class Transition {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] links = new int[n][n];
        int[] outdegree = new int[n];

        while (!StdIn.isEmpty()) {
            int i = StdIn.readInt();
            int j = StdIn.readInt();
            links[i][j] = 1;
            outdegree[i]++;
        }

        double alpha = 0.9;
        double[][] p = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (outdegree[i] == 0)
                    p[i][j] = 1.0 / n;
                else if (links[i][j] == 1)
                    p[i][j] = alpha / outdegree[i] + (1 - alpha) / n;
                else
                    p[i][j] = (1 - alpha) / n;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                StdOut.printf("%8.5f", p[i][j]);
            StdOut.println();
        }
    }
}
```

✅ Output: the full **transition probability matrix**.

---

## 🧭 Step 2: Random Surfer Simulation

Once we have `P`, we can simulate the surfer moving across pages randomly according to these probabilities.

Each random move is determined by:
- Generating a random number `r ∈ [0,1)`.
- Moving to the next page whose cumulative probability interval contains `r`.

---

## 💻 Program 2: RandomSurfer.java

```java
public class RandomSurfer {
    public static void main(String[] args) {
        int trials = Integer.parseInt(args[0]);
        int n = StdIn.readInt();
        StdIn.readInt();

        double[][] p = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                p[i][j] = StdIn.readDouble();

        int[] freq = new int[n];
        int page = 0;

        for (int t = 0; t < trials; t++) {
            double r = Math.random();
            double sum = 0.0;
            for (int j = 0; j < n; j++) {
                sum += p[page][j];
                if (r < sum) {
                    page = j;
                    break;
                }
            }
            freq[page]++;
        }

        for (int i = 0; i < n; i++) {
            StdOut.printf("%8.5f", (double) freq[i] / trials);
        }
        StdOut.println();
    }
}
```

✅ Output: estimated **PageRank probabilities** after `trials` random moves.

---

## 📊 Program 3: RandomSurferHistogram.java

This version **visualizes** the simulation as a histogram that evolves in real time.

```java
public class RandomSurferHistogram {
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();

        int trials = Integer.parseInt(args[0]);
        int n = StdIn.readInt();
        StdIn.readInt();

        double[][] p = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                p[i][j] = StdIn.readDouble();

        int[] freq = new int[n];
        int page = 0;

        for (int t = 0; t < trials; t++) {
            double r = Math.random();
            double sum = 0.0;
            for (int j = 0; j < n; j++) {
                sum += p[page][j];
                if (r < sum) {
                    page = j;
                    break;
                }
            }
            freq[page]++;

            StdDraw.clear();
            StdDraw.setXscale(-1, n);
            StdDraw.setYscale(0, trials);
            for (int k = 0; k < n; k++) {
                StdDraw.filledRectangle(k, freq[k]/2.0, 0.25, freq[k]/2.0);
            }
            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}
```

✅ Produces a **live bar chart** showing how frequencies stabilize into PageRanks.

---

## 📈 Program 4: Markov.java

Instead of running a random simulation, this version uses **matrix–vector multiplication** to directly compute the steady-state distribution.

```java
public class Markov {
    public static void main(String[] args) {
        int trials = Integer.parseInt(args[0]);
        int n = StdIn.readInt();
        StdIn.readInt();

        double[][] p = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                p[i][j] = StdIn.readDouble();

        double[] rank = new double[n];
        rank[0] = 1.0;

        for (int t = 0; t < trials; t++) {
            double[] newRank = new double[n];
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    newRank[j] += rank[k] * p[k][j];
            rank = newRank;
        }

        for (int i = 0; i < n; i++)
            StdOut.printf("%8.5f", rank[i]);
        StdOut.println();
    }
}
```

✅ Computes PageRanks using **the Power Method** — repeated multiplication until convergence.

---

## 🧮 Power Method

The **Power Method** finds the steady-state vector `v` such that:

```
v = v × P
```

After multiple multiplications, the vector stabilizes, and each value represents the PageRank of a page.

Convergence is guaranteed because the transition matrix is **stochastic** and **ergodic**.

---

## 🧾 Key Concepts Recap

| Concept | Description |
|----------|--------------|
| **Random Surfer** | A probabilistic model of user navigation |
| **Transition Matrix** | Defines movement probabilities between pages |
| **PageRank** | Probability that a surfer is on a given page |
| **Markov Chain** | Random process with memoryless transitions |
| **Power Method** | Efficient way to compute steady-state probabilities |
| **Histogram Simulation** | Visual representation of convergence |

---

## 📚 Insights & Takeaways

- The web can be modeled mathematically using **graphs and probabilities**.  
- Page importance (PageRank) naturally emerges from **random movement**.  
- Teleportation (random jumps) ensures convergence and fairness.  
- Simulations and matrix algebra give the same results — one random, one deterministic.  
- These ideas inspired the **Google PageRank algorithm** and modern **ranking systems** in search engines and AI.

---

## 🧩 Relationship Between All Programs

```
 tiny.txt ──► Transition.java ──► transition matrix
                   │
                   ├─► RandomSurfer.java ──► Simulated PageRank
                   ├─► RandomSurferHistogram.java ──► Visualization
                   └─► Markov.java ──► Analytical PageRank
```

All four methods converge to the same ranking — verifying the correctness of the model.

---

## 🧠 Example Output (Tiny Web)

```
PageRank Results:
Page 0: 0.273
Page 1: 0.266
Page 2: 0.146
Page 3: 0.247
Page 4: 0.068
```

✅ Both simulation (RandomSurfer) and analytical (Markov) methods match within 2 decimal points.

---

## 🏁 Final Summary

| Program | Approach | Purpose |
|----------|-----------|----------|
| **Transition.java** | Constructs probability matrix | Models random behavior of web links |
| **RandomSurfer.java** | Random simulation | Estimates PageRank experimentally |
| **RandomSurferHistogram.java** | Visual histogram | Shows convergence over time |
| **Markov.java** | Matrix–vector method | Computes PageRank deterministically |

---

### 🧩 Core Mathematical Principle

```
PageRank = steady-state distribution of a Markov Chain defined by P
```

or equivalently,

```
R = R × P
```

where R is the PageRank vector and P is the transition matrix.

---

## 🧠 Essential Understanding

- The **Random Web Surfer** is a **Markov Chain** — a random process where the next state depends only on the current state.  
- The **Transition Matrix** defines the rules of movement.  
- **Simulations** (RandomSurfer) and **Linear Algebra** (Markov) both lead to the same PageRank results.  
- This framework forms the mathematical basis for **Google’s PageRank algorithm**, and broadly for all ranking systems that depend on probabilistic transitions.

---
