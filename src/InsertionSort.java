public class InsertionSort{
    //time complexity of the algoritm is n^2
    public static void sortData(int[] res){
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
    public static void main(String[] args){
        System.out.println("Insertion Sort :");
        int[] arr={1,3,2,6,5,4};
        sortData(arr);
        for(int num:arr){
            System.out.print(num+" ");
        }
    }
}