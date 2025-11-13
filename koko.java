public class koko{
    public static int calculatehour(int []piles,int speed)
    {
        int hours=0;
        for(int i=0;i<piles.length;i++)
        {
            hours=hours+(piles[i]+speed-1)/speed;
        }
        return hours;
    }
    public static int minEatingSpeed(int[]piles,int h)
    {
        int maxpile=piles[0];
        for(int i=1;i<piles.length;i++)
        {
            if(piles[i]>maxpile)
            {
                maxpile=piles[i];
            }
        }
        int low=0;
        int high=maxpile;
        int res=maxpile;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(calculatehour(piles,mid)<=h)
            {
                res=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;
        System.out.println("Minimum Speed: " + minEatingSpeed(piles1, h1)); // Output: 4
    }
}