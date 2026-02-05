public class InsertionSort{
    //time complexity of the algoritm is n^2
    public static void sort(int[] res){
        for(int i=1;i<res.length;i++){
            int temp=res[i];
            int j=i-1;
            while(j>=0 && res[j]>temp){
                res[j+1]=res[j];
                j--;
            }
            res[j+1]=temp;
        }
    }
}