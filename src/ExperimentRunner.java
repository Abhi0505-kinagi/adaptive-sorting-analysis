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
        int[] arr=getRandom(100);
        double disorder = Analyzer.disorderRatio(arr);
        double duplicates = Analyzer.duplicateRatio(arr);
        if (arr.length < 50 || disorder<0.05) {
            InsertionSort.sort(arr);
            System.out.println("Insertionsort is used for sorting..");
        }
        else if (duplicates > 0.5) {
            MergeSort.sort(arr);
            System.out.println("Mergesort is used for sorting..");
        }
        else {
            QuickSort.sort(arr);
            System.out.println("Quick sort is used for sorting..");
        }
        /*for(int num:arr){
                System.out.print(num+" ");
            }*/
        
        System.out.println("\nDisorder ratio: " + String.format("%.3f", disorder));
        System.out.println("Duplicate ratio: " + String.format("%.3f", duplicates));

        
    }

}
