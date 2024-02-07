/* 

Instead of utilizing three nested for loops with a resulting time complexity of O(n^3),
 this approach optimizes the solution by eliminating one inner loop, reducing the time complexity to O(n^2).

To implement this solution, we begin by creating an array named 'prefix' that stores the cumulative sum of elements up to each index.
For example, prefix[2] holds the sum of elements from index 0 to index 2.

After obtaining the prefix array, we can compute the sum of elements in any subarray using the formula:
sum = prefix[end] - prefix[start-1];

Here, 'start' represents the index at which our subarray begins in the original array,
and 'end' is the index up to which we calculate the sum of that subarray.

A crucial boundary condition must be considered: when calculating the sum of any subarray, ensure that 'start' is greater than 0,
as we need to calculate start-1 in the formula.
To address this, a conditional statement can be added: if start == 0, then the sum is simply prefix[end].

While the time complexity of this approach is O(n^2), it can be further optimized using 'Kadane's algorithm'. 

*/

public class prefixArray {

    public static int findSumByPrefixArrayMethod(int arr[]){
        int maxSum=Integer.MIN_VALUE;
        int prefix[]=new int [arr.length];
        prefix[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefix[i]=arr[i]+prefix[i-1];
        }
        
        for(int i=0;i<prefix.length;i++){
            for(int j=i;j<prefix.length;j++){
                
                int currSum = i==0 ? prefix[j]:prefix[j]-prefix[i-1];
                
                if(currSum>maxSum) maxSum=currSum;
                
            }
        }
        return maxSum;
    }
    public static void main(String args[]){
        int arr[]={1,-2,6,-1,3};
        System.out.println(findSumByPrefixArrayMethod(arr));
    }
}




