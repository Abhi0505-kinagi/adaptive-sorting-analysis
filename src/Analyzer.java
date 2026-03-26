import java.util.HashMap;
import java.util.Map;

public class Analyzer {

    public static double sortedness(int[] arr) {
        if (arr.length <= 1) return 1.0;

        int orderedPairs = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                orderedPairs++;
            }
        }
        return (double) orderedPairs / (arr.length - 1);
    }

    public static double inversionRatio(int[] arr) {
        if (arr.length <= 1) return 0.0;

        int inversions = 0;
        int totalPairs = arr.length - 1;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                inversions++;
            }
        }

        return (double) inversions / totalPairs;
    }

    public static double duplicateRatio(int[] arr) {
        if (arr.length == 0) return 0.0;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int uniqueCount = freq.size();
        return 1.0 - ((double) uniqueCount / arr.length);
    }

    public static double entropy(int[] arr) {
        if (arr.length == 0) return 0.0;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        double entropy = 0.0;
        int n = arr.length;

        for (int count : freq.values()) {
            double p = (double) count / n;
            entropy -= p * (Math.log(p) / Math.log(2));
        }

        return entropy;
    }

    // If you still want old disorder ratio
    public static double disorderRatio(int[] arr) {
        return inversionRatio(arr);
    }
}