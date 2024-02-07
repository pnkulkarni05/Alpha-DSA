public class FindSubarrays {

    public static void chotu(int[]arr,int start,int end){
        System.out.print("(");
        for(int i=start;i<=end;i++){
            if(i==end){
                System.out.print(arr[i]+")"+" ");
            }
            else{
            System.out.print(arr[i]+",");
            }
        }
    }
    public static void printSubarrays(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print("("+arr[i]+")"+" ");

            for(int j=i+1;j<arr.length;j++){
                chotu(arr, i, j);
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int arr[]={1,2,3,4,5,6};
        printSubarrays(arr);
    }
}

//Total no. of subarrays = n(n+1)/2;
