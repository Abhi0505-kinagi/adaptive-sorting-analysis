import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AdaptiveSort {

    public static String sort(int[] arr) {

        double sortedness = Analyzer.sortedness(arr);
        double inversion = Analyzer.inversionRatio(arr);
        double duplicates = Analyzer.duplicateRatio(arr);
        double entropy = Analyzer.entropy(arr);

        String predicted = predictAlgorithm(
                arr.length,
                sortedness,
                inversion,
                duplicates,
                entropy
        );

        switch (predicted) {

            case "Insertion":
                InsertionSort.sort(arr);
                return "InsertionSort";

            case "Merge":
                MergeSort.sort(arr);
                return "MergeSort";

            case "Quick":
                QuickSort.sort(arr);
                return "QuickSort";

            case "Heap":
                HeapSort.sort(arr);
                return "HeapSort";

            default:
                MergeSort.sort(arr);
                return "MergeSort (fallback)";
        }
    }

    private static String predictAlgorithm(int n,
                                           double sortedness,
                                           double inversion,
                                           double duplicateRatio,
                                           double entropy) {

        try {

            ProcessBuilder pb = new ProcessBuilder(
                    "python",
                    "predict_sort.py",
                    String.valueOf(n),
                    String.valueOf(sortedness),
                    String.valueOf(inversion),
                    String.valueOf(duplicateRatio),
                    String.valueOf(entropy)
            );

            pb.redirectErrorStream(true);

            Process process = pb.start();

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            String result = reader.readLine();

            process.waitFor();

            if (result != null) {
                return result.trim();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Merge";
    }
}