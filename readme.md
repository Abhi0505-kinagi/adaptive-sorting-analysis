![Project](https://img.shields.io/badge/Project-NeuroSort%3A%20Random%20Forest--Driven%20Adaptive%20Sorting-blue?style=for-the-badge) <br/>
![Focus](https://img.shields.io/badge/Focus-Adaptive%20Algorithms-blue)
![Category](https://img.shields.io/badge/Domain-Data%20Structures%20%26%20Algorithms-orange)

![Languages](https://img.shields.io/badge/Languages-Java%20%7C%20Python-yellow)
![ML](https://img.shields.io/badge/ML-Random%20Forest-green)
![Concept](https://img.shields.io/badge/Concept-Adaptive%20Sorting-purple)
---
# Project Overview
<br/><i>The system analyzes statistical properties of an input array and dynamically selects the most efficient sorting algorithm.<i/><br/>
NeuroSort is an intelligent meta-algorithm that solves the "optimal sorting" problem not through static thresholds, but through a trained Random Forest Classifier. By extracting high-dimensional features from a dataset, it predicts which sorting implementation will yield the lowest latency for that specific data distribution.
The system combines:

- Data structure algorithms
- Dataset analytics
- Machine learning prediction
to intelligently determine the best sorting strategy.

---
---

# Key Features

## 1. Intelligent Feature Extraction (Analyzer.java)

The system computes multiple dataset metrics in **O(n)** time.

Metrics include:

- **Sortedness**  
  Measures how close the array is to being already sorted.

- **Inversion Ratio**  
  Indicates the level of disorder in the dataset.

- **Duplicate Ratio**  
  Detects repetition-heavy datasets.

- **Shannon Entropy**  
  Measures information density and randomness.

These features form the **statistical fingerprint of the dataset**.

---

## 2. Polyglot Inference Bridge

The project integrates **Java and Python**:

- **Java**  
  Handles dataset processing and sorting execution.

- **Python**  
  Runs the trained ML model to predict the optimal algorithm.

The Python script `predict_sort.py` loads:

---

# Running the Project

### Requirements

- Java 17+
- Python 3.x
- Python libraries

---

# Future Improvements

Planned enhancements include:

- Hybrid Merge + Insertion sort (similar to TIMSort)
- Benchmark comparison between algorithms
- Runtime visualization and performance graphs
- Larger training dataset for the ML model
- Automatic dataset generation for testing

<h3 style="font-family: 'Times New Roman', Times, serif;"> Author</h3>

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Abhishek%20Kinagi-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/abhishek-kinagi-b61a47328/)

[![Email](https://img.shields.io/badge/Email-kinagiabhishek842%40gmail.com-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:kinagiabhishek842@gmail.com)
