import java.util.Scanner;
public class naiveapproach{
    public static void main(String[] args) {
        int n,k,max=0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n-k+1;i++)
        {
           int sum=0;
        //    System.out.println("the sum is");
           for(int j=i;j<i+k;j++)
           {
                sum=sum+arr[j];
                // System.out.println(sum);
           }
           max=Math.max(max, sum);
        //    System.out.println(max);
        }
        System.out.println("the max sum in the array of range "+k+" is "+max);
        sc.close();
    }
}