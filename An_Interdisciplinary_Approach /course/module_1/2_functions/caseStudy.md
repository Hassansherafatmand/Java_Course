# Chapter 2.4 – Case Study: Percolation

_Computer Science: An Interdisciplinary Approach_  
by **Robert Sedgewick & Kevin Wayne**

---

## 🔹 Overview

This case study demonstrates how to apply **functions and modular programming** to simulate a scientific phenomenon — **percolation** — using **Monte Carlo methods**.

---

## 🌐 Percolation Model

We model a system as an **n-by-n grid** of sites:

- Each site is **blocked** or **open**.
- **Open sites** can connect to adjacent open sites (up, down, left, right).
- A **full site** is an open site connected to the top row through other open sites.
- The system **percolates** if any site in the **bottom row** becomes full.

If each site is open with probability **p**, the question becomes:

> “What is the probability that the system percolates?”

This probability has **no exact mathematical solution**, so simulation is required.

---

## 🧮 Data Representation

We use two Boolean matrices:

- `isOpen[][]` → represents which sites are open.
- `isFull[][]` → represents which sites are full (connected to the top).

---

## 🧩 Vertical Percolation

To simplify, we first test **vertical percolation** — where only vertical connections are considered.

- **Program:** `VerticalPercolation.java`
- **Task:** Determine whether open sites are connected from the top to the bottom **vertically**.

Visualization and testing are done using **`PercolationVisualizer.java`**, which generates random boolean grids and displays them graphically.

---

## 📊 Estimating Probabilities

- **Program:** `PercolationProbability.java`
- Estimates the probability that an n×n grid with vacancy probability p percolates.
- Repeats many trials to compute the **percolation probability** (Monte Carlo simulation).

---

## 🔁 Recursive Solution (General Percolation)

For general percolation (not just vertical), we allow paths in **any direction**.

- **Program:** `Percolation.java`
- Uses a **recursive depth-first search (DFS)** to explore connected open sites.
- The recursion continues spreading fullness until no further connections exist.

---

## 📈 Adaptive Plot

- **Program:** `PercolationPlot.java`
- Plots **percolation probability vs. vacancy probability (p)**.
- Uses recursion to refine the curve efficiently.

As **n** grows, the plot converges toward a **step function** with a threshold around **p ≈ 0.593**:

- If **p > 0.593**, the system **almost surely percolates**.
- If **p < 0.593**, the system **almost surely does not**.

This sharp transition is called a **phase transition**, a phenomenon seen in many physical systems.

---

## 🧠 Exercises

### 1. Directed Percolation

Create **`PercolationDirected.java`** to test for **directed percolation** by removing the final recursive call in `flow()` from `Percolation.java`.  
Use **`PercolationPlot.java`** to visualize the directed percolation probability as a function of **p**.

---

## 💡 Creative Exercises

### 🧩 Nonrecursive Directed Percolation

Implement **`PercolationDirectedNonrecursive.java`** — a **nonrecursive** version of directed percolation.

Approach:

- Move row by row from top to bottom.
- If any site in a contiguous subrow of open sites connects to a full site in the previous row, mark all those sites as full.

---

## 🌍 Web Exercises

### 1. 2×2 Percolation Probability

Verify that for a 2×2 system, the probability of percolation is:

p² (2 − p²)

where **p** = probability that a site is open.

---

### 2. Cubic Curves

Use **recursive subdivision** to plot **cubic curves**.

---

### 3. Random Walk (1D)

Originates from **George Pólya’s** 1921 paper.

- Start at position 0.
- Move **left or right** with probability ½.
- Reflecting barrier at 0 → must reverse direction upon reaching 0.
- Absorbing barrier at n → stop when reaching n.

Estimate expected number of steps until absorption.  
**Analytic solution:** approximately _n²_.

---

### 4. Random Walk in 3D / 4D

Write **`Polya.java`** to simulate a **3D random walk** starting at (0,0,0).

- Estimate the probability of returning to the origin within 1,000 steps.
  - In 1D/2D → always return.
  - In 3D → < 50% chance.
  - In 4D → even smaller chance.

Known constants:

- 3D → slightly above **1/3**
- 4D → slightly below **1/5**

---

### 5. Self-Avoiding Random Walk (SAW)

Simulate **self-avoiding walks** on a lattice: the path cannot intersect itself.

- Write **`SelfAvoidingWalk.java`** to simulate and animate a 2D SAW.
- SAWs are useful for modeling **polymer folding** and **molecular motion**.

Goals:

- Measure average distance from origin for length _n_.
- Explore half-life of a SAW (average duration before self-intersection).
- Advanced optimization: allow steps only into unoccupied cells.

---

### 🧬 Scientific Context

- SAW problems are inspired by **Paul Flory’s 1949 research** (Nobel Prize in Chemistry).
- Conjectured exponents:
  - 2D → ¾
  - 3D → ³⁄₅

---

**End of Chapter 2.4 Notes – Percolation Case Study**
