import java.util.*;
public class closest {
    public static void Closest(int[]arr1,int[]arr2,int m,int n,int x){
        int diff=Integer.MAX_VALUE;
        int res_l=0;
        int res_r=0;
        int l=0,r=n-1;
        while(l<m&&r>=0){
            if(Math.abs(arr1[l]+arr2[r]-x)<diff){
                res_l=l;
                res_r=r;
                diff=Math.abs(arr1[l]+arr2[r]-x);
            }
            if(arr1[l]+arr2[r]>x){
                r--;
            }
            else{
                l++;
            }
        }
        System.out.println(arr1[res_l]+" "+arr2[res_r]+" ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size of array_1");
        int n1 = sc.nextInt();
        int arr1[] = new int[n1];
        System.out.println("enter the values of array_1");
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }
        System.out.println("enter size of array_2");
        int n2 = sc.nextInt();
        int arr2[] = new int[n2];
        System.out.println("enter the values of array_2");
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }
        System.out.println("enter closest number");
        int x = sc.nextInt();
        Closest(arr1, arr2, n1, n2, x);
    }
}