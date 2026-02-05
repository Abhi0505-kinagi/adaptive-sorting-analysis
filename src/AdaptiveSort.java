public class AdaptiveSort {
    public static String sort(int[] arr) {
        double disorder = Analyzer.disorderRatio(arr);
        double duplicates = Analyzer.duplicateRatio(arr);

        if (arr.length < 50 || Analyzer.isNearlySorted(arr)) {
            InsertionSort.sort(arr);
            return "InsertionSort";
        }
        else if (duplicates > 0.5) {
            MergeSort.sort(arr);
            return "MergeSort";
        }
        else {
            QuickSort.sort(arr);
            return "QuickSort";
        }
    }
}
