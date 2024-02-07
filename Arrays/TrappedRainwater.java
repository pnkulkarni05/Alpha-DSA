public class TrappedRainwater {

    public static int getTrappedRainwater(int arr[]){
        int leftMax[]=new int[arr.length];
        int rightMax[]=new int[arr.length];

         leftMax[0]=arr[0];
        rightMax[arr.length-1]=arr[arr.length-1];

        for(int i=1;i<arr.length;i++){
            leftMax[i]=Math.max(leftMax[i-1], arr[i]);
        }

        for(int i=arr.length-2;i>0;i--){
            rightMax[i]=Math.max(rightMax[i+1],arr[i]);
        }

        int area=0;

        for(int i=1;i<arr.length-1;i++){
            int val=Math.min(leftMax[i],rightMax[i]);
            int level=val-arr[i];
            int currArea=level==0?0:level*1;
            area+=currArea;
        }

        return area;
    }
    public static void main(String args[]){
        int heights[]={4,2,0,6,3,2,5};
        System.err.println(getTrappedRainwater(heights));
    }
}
