import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ExperimentRunner {

    public static int[] getReverseSorted(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
        return arr;
    }

    public static int[] getRandom(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        Random rand = new Random();
        for (int i = n - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    public static int[] getNearlySorted(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        Random rand = new Random();
        int swaps = Math.max(1, n / 20);
        for (int i = 0; i < swaps; i++) {
            int idx1 = rand.nextInt(n);
            int idx2 = rand.nextInt(n);
            int temp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = temp;
        }
        return arr;
    }

    public static String predictAlgorithmWithPython(int n, double sortedness,
                                                    double inversionRatio,
                                                    double duplicateRatio,
                                                    double entropy) {
        try {
            ProcessBuilder pb = new ProcessBuilder(
                "python",
                "predict_sort.py",
                String.valueOf(n),
                String.valueOf(sortedness),
                String.valueOf(inversionRatio),
                String.valueOf(duplicateRatio),
                String.valueOf(entropy)
            );

            pb.redirectErrorStream(true);
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream())
            );

            String result = reader.readLine();
            process.waitFor();

            if (result != null) {
                return result.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Merge"; // fallback
    }

    public static void main(String[] args) {

        int[] arr ={1, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 58, 56, 54, 52, 50, 48, 46, 44, 42, 40, 38, 36, 34, 32, 30, 28, 26, 24, 22, 20, 18, 16, 14, 12, 10, 8, 6, 4, 2, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35};

        double sortedness = Analyzer.sortedness(arr);
        double inversionRatio = Analyzer.inversionRatio(arr);
        double duplicateRatio = Analyzer.duplicateRatio(arr);
        double entropy = Analyzer.entropy(arr);

        String predictedAlgo = predictAlgorithmWithPython(
            arr.length,
            sortedness,
            inversionRatio,
            duplicateRatio,
            entropy
        );

        System.out.println("Predicted algorithm: " + predictedAlgo);

        switch (predictedAlgo) {
            case "Insertion":
                InsertionSort.sort(arr);
                System.out.println("Adaptive Sorting technique: Insertion Sort");
                break;

            case "Merge":
                MergeSort.sort(arr);
                System.out.println("Adaptive Sorting technique: Merge Sort");
                break;

            case "Quick":
                QuickSort.sort(arr);
                System.out.println("Adaptive Sorting technique: Quick Sort");
                break;

            case "Heap":
                HeapSort.sort(arr);
                System.out.println("Adaptive Sorting technique: Heap Sort");
                break;

            default:
                MergeSort.sort(arr);
                System.out.println("Fallback technique: Merge Sort");
        }

        System.out.println("n: " + arr.length);
        System.out.println("Sortedness: " + String.format("%.4f", sortedness));
        System.out.println("Inversion Ratio: " + String.format("%.4f", inversionRatio));
        System.out.println("Duplicate Ratio: " + String.format("%.4f", duplicateRatio));
        System.out.println("Entropy: " + String.format("%.4f", entropy));
    }
}