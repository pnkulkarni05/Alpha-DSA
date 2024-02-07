public class BinarySearch {

    public static int findElement(int arr[], int key){
        int start=0;
        int end=arr.length-1;

        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]==key) return mid;

            if(arr[mid]<key){
                start=mid+1;
            }
            else{
                end=mid;
            }
                     
        }
        return -1;
    }
    public static void main(String args[]){
        int arr[]={12,15,14,18,52,14,16,15};
        int key=19;
        System.out.println("The element is found at index "+ findElement(arr, key));
    }
}
