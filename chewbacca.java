public class chewbacca {
    public static void main(String[] args) {
        int x=4545;
        int[]arr={x};
        int count=0;
        while(x>0)
        {
            // int n=x%10;
            count+=1;
            // System.out.println(n);
            x=x/10;
        }
        if(count%2==0)
        {
            // int[]arr={x};
            System.out.println(arr[0]); 
        }
        else{
            System.out.println("odd digits");
        }
    }
    
}
