import java.util.Random;

public class ExperimentRunner {
    
    //Generates a Reverse Sorted Array: [n, n-1, ..., 1]
     
    public static int[] getReverseSorted(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
        return arr;
    }

    // Generates a Random Array using Fisher-Yates shuffle
     
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

    //Generates a Nearly Sorted Array:Starts sorted, then swaps a small number of random pairs.
    public static int[] getNearlySorted(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        Random rand = new Random();
        // Swapping roughly 5% of the elements creates a "nearly sorted" state
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
    public static void main(String[] args){
        int[] arr=getNearlySorted(1000);
        /*int[] arr= {
    5, 12, 7, 5, 9, 12, 7, 5, 3, 9, 12, 7, 5, 3, 9, 12, 7, 5, 3, 9,
    8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
    15, 15, 15, 15, 15, 15, 15, 15, 15, 15,
    21, 21, 21, 21, 21, 21, 21, 21, 21, 21,
    33, 33, 33, 33, 33, 33, 33, 33, 33, 33,
    42, 42, 42, 42, 42, 42, 42, 42, 42, 42,
    99, 99, 99, 99, 99, 99, 99, 99, 99, 99,
    77, 77, 77, 77, 77, 77, 77, 77, 77, 77,
    64, 64, 64, 64, 64, 64, 64, 64, 64, 64,
    18, 18, 18, 18, 18, 18, 18, 18, 18, 18,
    50, 50, 50, 50, 50, 50, 50, 50, 50, 50,
    27, 27, 27, 27, 27, 27, 27, 27, 27, 27,
    11, 11, 11, 11, 11, 11, 11, 11, 11, 11,
    6, 6, 6, 6, 6, 6, 6, 6, 6, 6
        };*/
        double disorder = Analyzer.disorderRatio(arr);
        double duplicates = Analyzer.duplicateRatio(arr);
        if (arr.length < 50 || disorder<0.05) {
            InsertionSort.sort(arr);
            System.out.println("Adaptive Sorting technique: Insertion Sort");
        }
        else if (duplicates > 0.5) {
            MergeSort.sort(arr);
            System.out.println("Adaptive Sorting technique:Mergesort");
        }
        else {
            QuickSort.sort(arr);
            System.out.println("Adaptive Sorting technique:Quick sort");
        }
        /*for(int num:arr){
                System.out.print(num+" ");
            }*/
        
        System.out.println("Disorder ratio: " + String.format("%.3f", disorder));
        System.out.println("Duplicate ratio: " + String.format("%.3f", duplicates));

        
    }

}
