public class longestrep {

    static int longest(String s)
    {
        int n=s.length();
        int dp[][]=new int [n+1][n+1];
        int result=0;
        for(int i=1;i<=n;i++)
        {
            for(int j=i+1;j<=n;j++)
            {
                if(s.charAt(i-1)==s.charAt(j-1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s="abbaba";
        System.out.println(longest(s));
    }
}
