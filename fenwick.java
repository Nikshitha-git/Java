import java.util.Scanner;
class fen {
    int n;
    int[]tree;
    fen(int[]nums){
        n=nums.length;
        tree=new int[n+1];
        for(int i=0;i<n;i++){
            update(i,nums[i]);
        }
    }
    void update(int i,int val){
        i++;
        while(i<=n){
            tree[i]=tree[i]+val;
            i=i+(i&(-i));
        }
    }
    int prefixsum(int i){
        i++;
        int sum=0;
        while(i>0){
            sum=sum+tree[i];
            i=i-(i&(-i));
        }
        return sum;
    }
    int rangesum(int r,int l){
        return (prefixsum(l)-prefixsum(r-1));
    }
}
public class fenwick{
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        fen f=new fen(nums);
        System.out.println("for sum enter level");
        int r=sc.nextInt();
        int l=sc.nextInt();
        System.out.println(f.rangesum(r, l));
    }

}
