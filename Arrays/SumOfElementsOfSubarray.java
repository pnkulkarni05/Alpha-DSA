/*Find out the maximum sum of elements of subarrays formed from the given array. Meaning=> We have given with an array arr. Find out the 
the sunarrays of that array arr. Then find the sum of elements of each subarray and return the maximum sum from all the sums obtained. */


public class SumOfElementsOfSubarray{

    public static int getSumOfSubarrayElements(int arr[]){
        int totalSum=0;

        for(int i=0;i<arr.length;i++){
            
            for(int j=i;j<arr.length;j++){
                int Currsum=0;
                for(int k=i;k<=j;k++){
                    Currsum+=arr[k];
                }
                if(Currsum>totalSum) totalSum=Currsum;
            }
        }

        return totalSum;
    }
    public static void main(String args[]){
        int arr[]={1,-2,6,-1,3};
        System.out.println(getSumOfSubarrayElements(arr));
    }
}


// The time complexity of above code if O(n) which is not good. This problrm can be optimized using 'prefix sum' method.