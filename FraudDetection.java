/* A bank's fraud detection system monitors recent transactions to identify suspicious duplicate payments. The system processes a list of N transactions, where each transaction has a unique ID.

To detect potential fraud, the system examines a sliding window of size X to check if any two transactions within that window have the same ID.

Your task is to determine whether any duplicate transaction IDs appear within any X-length window. If such a duplicate is found, return true; otherwise, return false.

Constraints:
X is always <= |i - j|, where i and j are distinct indices in the transaction list.
The transaction IDs are integers.

Example Test Cases:

Case 1 (Fraud Detected)
Input:  
10  
15 70 50 25 35 20 40 45 20 60  
4  

Output:  
true  
Explanation:
Within a window of size 4, the number 20 appears twice, indicating potential fraud.

Case 2 (No Fraud Detected)
Input:  
10  
15 70 50 25 35 20 40 45 30 60  
3  

Output:  
false  
Explanation:
No transaction ID is repeated within any 3-transaction window.
*/

/*
Testcases:
case=1
input=4
51 32 43 51
3
output=false

case=2
input=6
10 22 43 10 22 43
2
output=false

case=3
input=5
15 10 15 15 20
1
output=false

case=4
input=9
15 20 30 15 20 30 15 20 30
4
output=true

case=5
input=7
10 50 10 10 20 10 30
2
output=true

case=6
input=10
15 70 50 25 35 20 40 45 20 60
4
output=true

case=7
input=10
15 70 50 25 35 20 40 45 30 60
3
output=false

case=8
input=12
15 15 70 50 25 35 20 40 45 30 60 90
5
output=true
*/
import java.util.*;
public class FraudDetection 
{
	public static void detect(int[] arr, int k) 
	{
		int n = arr.length;
        HashSet<Integer> res = new HashSet<Integer>();
		
		// Slide the window over the array
		for (int i = 0; i < n; i++) 
		{
            if(i>=k){
			res.remove(arr[i-k]);
            }
            boolean ans=res.add(arr[i]); // Add next element, remove first element of previous window
            // System.out.println(res);
            if(ans==false){
                System.out.println("fruad detected");
            }
		}	
	}
	public static void main(String[] args) 
	{
        Scanner sc=new Scanner(System.in);	
        int n=sc.nextInt();
        int array[]=new int[n];

		for(int i=0;i<n;i++)
			array[i]=sc.nextInt();		
        int k=sc.nextInt();
        detect(array, k);
        sc.close();
    }
}
