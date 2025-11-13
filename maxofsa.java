import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class maxofsa {
    public static int[] maxofAllSubarray(int[]arr,int k){
        int i=0;
        int n=arr.length;
        int[]maxarr=new int[n-k+1];
        int x=0;
        PriorityQueue<Integer>pq=new PriorityQueue<>(Comparator.reverseOrder());
        for(int j=0;j<n;j++){
            pq.add(arr[j]);
            if(j-i+1==k){
                int maxele=pq.peek();
                maxarr[x++]=maxele;
                if(maxele==arr[i]){
                    pq.remove();
                }
                i++;
            }
        }
        return maxarr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter array elements size");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("enter the elements");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("enter the subarray size");
        int k = sc.nextInt();
        sc.close();
        int[] result = maxofAllSubarray(a, k);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
