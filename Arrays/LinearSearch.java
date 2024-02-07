public class LinearSearch{

    public static int findElement(int array[],int num){
        for(int i=0;i<array.length;i++){
            if(array[i]==num){
                return i;
            }
            
        }
        return -1;
    }

    public static void main(String srgs[]){
        int arr[]={10,48,13,20,5};
        int idx= findElement(arr,13);
        System.out.println("The element 13 is present at index "+ idx);

    }
}