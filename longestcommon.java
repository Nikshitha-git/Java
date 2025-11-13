public class longestcommon {
    static int common(char[]X,char[]Y,int m,int n){
        int[][]dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }else if(X[i-1]==Y[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }   
            }
        }return dp[m][n];
    }
    public static void main(String[] args) {
        String s1="abcde";
        String s2="ace";
        char[]X=s1.toCharArray();
        char[]Y=s2.toCharArray();
        int m=X.length;
        int n=Y.length;
        System.out.println(common(X,Y,m,n));
    }
}