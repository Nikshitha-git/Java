public class minimum {
    public static long minimumprod(int[]arr){
        // { -1, -1, -2, 4, 3 }s
        long product=1;
        int negcount=0;
        int maxneg=Integer.MIN_VALUE;
        boolean hasPositive = false; // Check if there's any positive number
        boolean hasZero = false;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                negcount++;
                maxneg=Math.max(maxneg,arr[i]);
            }
            else if(arr[i]>0)
            {
                product=product*arr[i];
                hasPositive = true;
            }
        }
        if (negcount == 0) {
            return hasZero ? 0 : maxneg; // Return 0 if zero exists, else maxNeg
        }
        if (negcount % 2 == 1) {
            product /= maxneg;
        }
        return hasPositive ? product : maxneg;

    }
    public static void main(String[] args) {
        int arr[]={ -1, -1, -2, 4, 3 };
        System.out.println(minimumprod(arr));
    }

    
}
