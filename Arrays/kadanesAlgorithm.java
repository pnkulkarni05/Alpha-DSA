/*
Solving Maximum Subarray Sum Using Kadane's Algorithm

In kadanes algorithm we basically use a simple apprach by keeping in mind 1 thing.
if, 1) we add big poistive number+small negative no. => ans is positive no.
    2) we add 2 positive numbers => ans is positive
    3) if we add a big negative no. and small positive number => ans is negative. 

    for kadanes algorithm ,

    First we intialize two variable maxSum=Integer.MIN_VALUE and currSum=0
    Then we iterate through a single for loop from 0 to length of array
    At each iteration we calculate the currentSum as currentsum+=arr[i]
    Then we calculate the maxSum by comapring the valures of currSum and Maxsum. 
    Here the value of currSum means the value of sum of elemnets in the current subarray which we are iterating.
    After calculating the maxSum we check if the value of currSum is negative or positive. If it is negative then we maker currSum 0.

    The sequence of statements written in for loop is important.

    Note: the line maxSUm=Math.max(currSum,maxSum) is very important because due to this line even if all the elements in array are negative
    instead of getting 0 we will get the correct answer i.e. the smallest negative no in that array.


*/
public class kadanesAlgorithm {

    public static int findMaxSumbyKadanesAlgo(int arr[]){
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;
        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];
            maxSum=Math.max(currSum,maxSum);
            if(currSum<0) currSum=0;
            
        }
        
        return maxSum;
    }

    public static void main(String args[]){
        int arr[]={-2,-3,-1,-2,-3};
        System.out.println(findMaxSumbyKadanesAlgo(arr));
    }
    
}
