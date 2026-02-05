import java.util.*;
public class Analyzer {
    /*
    Disorder Ratio - Count how many adjacent elements are out of order.
    | Ratio | Meaning        |
    | ----- | -------------- |
    | ~0    | Nearly sorted  |
    | ~0.5  | Random         |
    | High  | Reverse sorted | */

    public static double disorderRatio(int[] arr){
        int count=0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                count++;
            }
        }
        return (double)count/(arr.length-1);
    }
    
    
    
    
    //Duplicate Ratio -Measures how many repeated elements exist.
    //duplicateRatio = 1 - (uniqueCount / n)
    public static double duplicateRatio(int[] arr){
        Set<Integer> set=new HashSet<>();
        for(int num:arr){
            set.add(num);
        }
        return 1.0-(double)set.size()/arr.length;
    }

    public static boolean isNearlySorted(int[] arr) {
        return disorderRatio(arr) < 0.05;
    }
    

}
