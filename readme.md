# Adaptive Sorting Research

## Project Overview

This project compares adaptive sorting strategies using dataset analytics and a learned model.
It provides:
- `InsertionSort`, `QuickSort`, `MergeSort`, `HeapSort` implementations.
- `Analyzer` feature extraction (sortedness, inversion ratio, duplicate ratio, entropy).
- `predict_sort.py` Python model inference that chooses the best algorithm for a given array.
- `AdaptiveSort` Java class that routes to predicted sort and fallback to `MergeSort`.
- `ExperimentRunner` Java demo for a sample dataset using the full feature pipeline.

## Current Implementation (as of latest code)

### Analyzer metrics
- `sortedness(arr)` = fraction of non-decreasing adjacent pairs.
- `inversionRatio(arr)` = fraction of adjacent inversions.
- `duplicateRatio(arr)` = 1 - (#unique / n).
- `entropy(arr)` = Shannon entropy of value frequency distribution.

### Prediction pipeline
- `AdaptiveSort.sort(arr)` computes features via `Analyzer`.
- Calls `predictAlgorithm(...)` to run `python predict_sort.py n sortedness inversionRatio duplicateRatio entropy`.
- `predict_sort.py` loads `pairwise_scaler.pkl` and `pairwise_models.pkl` and returns one of: `Insertion`, `Merge`, `Quick`, `Heap`.
- `AdaptiveSort` executes the predicted algorithm.
- If prediction fails, falls back to `MergeSort`.

### ExperimentRunner sample
- Runs one hard-coded array in `ExperimentRunner.main(...)`.
- Prints predicted algorithm and selected sort outcome.
- Prints metrics:
  - `n`
  - `Sortedness`
  - `Inversion Ratio`
  - `Duplicate Ratio`
  - `Entropy`

## Running

Prerequisites:
- Java 17+ (or compatible JDK)
- Python 3.x and `joblib`, `pandas`
- `pairwise_scaler.pkl`, `pairwise_models.pkl` in the same directory as `predict_sort.py`

Build and run:

```bash
cd src
javac *.java
java ExperimentRunner
```

or use adaptive class directly:

```bash
java AdaptiveSort
```

## Notes and future improvements

- The current implementation does not yet contain a hybrid method (Merge+Insertion) per TIMSort pattern.
- `ExperimentRunner` does not yet benchmark multiple algorithms side-by-side or produce graphs.
- You may implement the recommended adaptive/hybrid behavior in `MergeSort` and/or `AdaptiveSort` and update this README accordingly.

## Recommended next steps

1. Add a dedicated `AdaptiveSort.bench(...)` for measuring actual runtime of predicted vs each candidate algorithm.
2. Add new `results/` CSV output and charting.
3. Add unit tests for model predictions and metric edge cases.
