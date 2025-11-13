import java.util.Scanner;
public class mss {
    public static void main(String[] args) {
        int n,k;
        int maxx=0;
        int sum=0;
        // arr=[5,2,4,6,3,1];
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        k=sc.nextInt();
        //brute-force approach
        // for(int i=0;i<n-k+1;i++){
        //     int sum=0;
        //     for(int j=i;j<i+k;j++){
        //         sum=sum+arr[j];
        //     }
        //     maxx=Math.max(maxx, sum);
        // }
        // System.out.println(maxx);
        for(int i=0;i<k;i++){
            sum=sum+arr[i];
        }
        for(int i=k;i<n;i++){
            sum=(sum+arr[i])-arr[i-k];
            maxx=Math.max(maxx, sum);
        }
        System.out.println(maxx);
        sc.close();
    }
}
