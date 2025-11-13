public class commonele {
    public static boolean binarysearch(int []array,int n){
        int low =0;
        int high=array.length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(array[mid]==n)
            {   
                return true;
            }
            if(array[mid]>n)
            {
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
    public static int findcommon(int[][]arr)
    {
        int smallestvalue=-1;
        int firstarray[]=arr[0];
        for(int i=0;i<firstarray.length;i++)
        {
            int common=firstarray[i];
            boolean isCommon=true;
            for(int j=1;j<arr.length;j++)
            {
                if(!binarysearch(arr[j], common))
                {
                    isCommon=false;
                    break;
                }
            }
            if (isCommon) {
                // if (smallestvalue == -1 || common < smallestvalue) {
                    smallestvalue = common;
                    System.out.println(smallestvalue);
                // }
            }
        }
        return smallestvalue;
    }
    public static void main(String[] args) {
        int[][] arrays = {
            {1, 2, 3, 4},
            {2, 1, 4, 6},
            {0, 2, 4, 8},
            {2, 4, 6, 8}
        };
        int result = findcommon(arrays);
        if (result != -1) {
            System.out.println("Smallest Common Element: " + result);
        } else {
            System.out.println("No common element found.");
        }
    }
}