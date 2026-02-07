# Performance Analysis of an Adaptive Sorting Algorithm Based on Input Characteristics

[![Language: Java](https://img.shields.io/badge/Language-Java-orange.svg)](https://www.oracle.com/java/)
[![Field: Computer Science](https://img.shields.io/badge/Field-CS%20Research-blue.svg)]()

This repository contains the implementation and experimental evaluation of an **Adaptive Sorting Algorithm** designed to dynamically select optimal sorting strategies based on real-time data metrics. This project was developed as part of a formal research study at **PES University**.

---

## 🧠 Abstract & Motivation
Traditional sorting algorithms like Quick Sort or Insertion Sort have specific "blind spots" where their performance degrades significantly (e.g., Quick Sort's $O(n^2)$ worst-case or Insertion Sort's inefficiency with large datasets). 

This research explores a **Meta-Algorithm** that pre-analyzes input arrays to identify:
* **Disorder Ratio:** The degree of unsortedness.
* **Duplicate Ratio:** The frequency of repeated elements.
* **Input Size ($n$):** The scale of the dataset.

By selecting the algorithm at runtime, we aim to achieve **robustness**—ensuring that the system never falls into a worst-case performance trap.

---

## 🛠️ Adaptive Strategy Logic

The `Analyzer.java` component evaluates the input and applies the following heuristic:

| Condition | Selected Algorithm | Complexity |
| :--- | :--- | :--- |
| $n < 50$ OR Nearly Sorted | **Insertion Sort** | $O(n)$ to $O(n^2)$ |
| High Duplicate Ratio (> 30%) | **Merge Sort** | $O(n \log n)$ |
| General / Random Distribution | **Quick Sort** | $O(n \log n)$ avg |

---

## 📊 Performance Benchmarks

Below is a comparison of execution times (in nanoseconds) across varying input sizes. 

### 1. Comparative Growth (Log-Log Plot)
To visualize the difference between $O(n^2)$ and $O(n \log n)$ growth, we use a logarithmic scale. 
![Insert your Log Plot here]

### 2. Large Scale Comparison ($n = 1,000,000$)
At peak load, the Adaptive Sort avoids the quadratic explosion seen in Insertion Sort.
![Insert your Bar Graph here]

---

## 📂 Project Structure

```text
Adaptive_sorting_research/
├── Analyzer.java           # Calculates disorder & duplicate ratios
├── InsertionSort.java      # Optimized Insertion Sort
├── MergeSort.java          # Standard Merge Sort (Stable)
├── QuickSort.java          # Randomized Pivot Quick Sort
├── ExperimentRunner.java    # The Adaptive Logic Implementation
├── BenchmarkRunner.java     # Automated Data Collection Utility
└── README.md               # Documentation

##clone repo
git clone [https://github.com/Abhi0505-kinagi/adaptive-sorting-analysis.git](https://github.com/Abhi0505-kinagi/adaptive-sorting-analysis.git)
