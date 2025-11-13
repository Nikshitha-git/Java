class bit{
public static void main(String[] args) {
    String s="X++ --X";
    int count = 0;
    // System.out.println(s);
    char[] CA=s.toCharArray();
    // System.out.println(CA[1]);
    for(int i=0;i<CA.length-1;i++)
    {
        char f=CA[i];
        char n=CA[i+1];
        if(f=='+' && n=='+')
        {
            count+=1;
        }
        if(f=='-' && n=='-')
        {
            count-=1;
        }
    }
    System.out.println(count);
}}