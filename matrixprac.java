public class matrixprac {
    static int matrixmulti(int[] dims,int i,int j)
    {
        if(i==j)
        {
            return 0;
        }
        int mincost=Integer.MAX_VALUE;
        for(int k=i;k<j;k++)
        {
            int cost=matrixmulti(dims, i, k)+matrixmulti(dims, k+1, j)+(dims[i-1]*dims[k]*dims[j]);
            mincost=Math.min(mincost, cost);
        }
        return mincost;
    }
    public static void main(String[] args)
    {
        int[]dims={10,20,30,40,30};
        int n=dims.length;
        int result=matrixmulti(dims,1,n-1);
        System.out.println(result);
    }
}
