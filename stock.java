import java.util.*;

public class stock{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size:");
        int n = sc.nextInt();
        int prices[] = new int[n];

        System.out.println("Enter prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        // int minprice=prices[0];
        // int maxProfit=0;
        // for(int i=0;i<prices.length;i++)
        // {
        //     minprice=Math.min(minprice,prices[i]);
        //     maxProfit=Math.max(maxProfit,prices[i]-minprice);
        // }

        int maxProfit=0;

        // Calculate profit by summing up all increasing differences
        for (int i = 1; i < prices.length;i++)
        {
            if (prices[i] > prices[i - 1]) {
                maxProfit+=prices[i]-prices[i-1];
            }
        }

        System.out.println("Max Profit: " + maxProfit);
        sc.close();
    }
}