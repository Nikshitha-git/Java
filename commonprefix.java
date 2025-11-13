public class commonprefix{
    public static boolean IsCommon(String []strs,int n){
        String first=strs[0].substring(0,n);
        for(int i=1;i<strs.length;i++)
        {
            if(!strs[i].startsWith(first)){
                return false;
            }
        }
        return true;
    }
    public static String longestCommonPrefix(String [] strs)
    {
        if(strs==null || strs.length==0){
            return "";
        }
        int low=0;
        int high=strs[0].length();
        String longestprefix="";
        while(low<=high)
        {
            int mid=(low+high)/2; 
            if(IsCommon(strs,mid))
            {
                longestprefix=strs[0].substring(0,mid);
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return longestprefix;
    }
    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs1)); // Output: "fl"
    }
}