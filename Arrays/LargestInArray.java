public class LargestInArray {

    public static int findLargestElement(int arr[]){
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest) largest=arr[i];
        }
        return largest;
    }
    public static void main(String args[]){
        int arr[] ={10,12,14,2,5,78};
        System.out.println("Largest element in the array is "+ findLargestElement(arr));
    }
}
