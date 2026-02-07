public class BenchmarkRunner {

    private static long measure(Runnable sort) {
        long start = System.nanoTime();
        sort.run();
        return System.nanoTime() - start;
    }

    private static int[] copy(int[] arr) {
        return arr.clone();
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000,100000,1000000};
        System.out.println("------------------------------");
        for (int n : sizes) {
            int[] base = ExperimentRunner.getRandom(n);

            int[] a1 = copy(base);
            long t1 = measure(() -> InsertionSort.sort(a1));

            int[] a2 = copy(base);
            long t2 = measure(() -> MergeSort.sort(a2));

            int[] a3 = copy(base);
            long t3 = measure(() -> QuickSort.sort(a3));

            int[] a4 = copy(base);
            long t4 = measure(() -> AdaptiveSort.sort(a4));

            System.out.println("n = " + n);
            System.out.println("Insertion: " + t1+" ns");
            System.out.println("Merge    : " + t2+" ns");
            System.out.println("Quick    : " + t3+" ns");
            System.out.println("Adaptive : " + t4+" ns");
            System.out.println("------------------------------");
        }
    }
}
