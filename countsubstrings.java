public class countsubstrings{
    public static int substrings(String s)
    {
        int n = s.length();
        int d=0;
        int total=0;
        if(s == null||n==0){
            return 0;
        }
        for(int i=0;i<n;i++)
        {
            if(i>0 && s.charAt(i)==s.charAt(i-1))
            {
                d=d+1;
            }
            else{
                d=1;
            }
            total=total+d;
        }
        return total;
    }
    public static void main(String[] args) {
        String str="aaaba";
        System.out.println(substrings(str));
    }
}