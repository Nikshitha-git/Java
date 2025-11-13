import java.util.Scanner;
public class calorie {
    public static void main(String[] args) {
        int n,k;
        int points=0;
        int sum=0;
        int low,up;
        // arr=[5,2,4,6,3,1];
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        k=sc.nextInt();
        low=sc.nextInt();
        up=sc.nextInt();
        for(int i=0;i<k;i++){
            sum=sum+arr[i];
        }
        if(sum<low){
            points--;
        }
        else if(sum>up){
            points++;
        }
        for(int i=k;i<n;i++){
            sum=(sum+arr[i])-arr[i-k];
            if(sum<low){
                points--;
            }
            else if(sum>up){
                points++;
            }
        }
        System.out.println(points);
        sc.close();
    }
}
