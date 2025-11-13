/*In a high-security research facility, guards patrol the corridors to ensure safety. The facility has N checkpoints, each requiring a certain amount of security effort to monitor.

To maintain efficiency, a patrol team is assigned to monitor K consecutive checkpoints at a time. If the total security effort of a patrol exceeds a critical threshold X, it means extra security measures are required.

Your task is to determine the number of patrol routes (i.e., K - length consecutive checkpoint sequences) where the total security effort strictly exceeds X.

Constraints
The checkpoints may require positive, negative, or zero security effort.
The number of checkpoints assigned for each patrol (K) is guaranteed to be <= N.
The total security effort of each patrol is calculated as the sum of effort values over K consecutive checkpoints.

Example Test Case
case=1  
input=6			// Number of checkpoints
1 2 3 4 5 6		// security Efforts at each check point 
3				// Length of the patrol route
10				// Security effort threshold
output=Count of patrol routes with security effort > 10: 2  

Explanation:
The security efforts of 3 consecutive checkpoints are calculated as follows:

[1, 2, 3]  Sum = 6 (Not greater than 10)
[2, 3, 4]  Sum = 9 (Not greater than 10)
[3, 4, 5]  Sum = 12 (Valid)
[4, 5, 6]  Sum = 15 (Valid)
Since two patrol routes exceed the threshold, the output is 2.
*/




/*
case=1  
input=6  
1 2 3 4 5 6  
3  
10  
output=Count of patrol routes with security effort > 10: 2  

case=2  
input=5  
-1 -2 -3 -4 -5  
2  
-3  
output=Count of patrol routes with security effort > -3: 4  

case=3  
input=8  
0 0 0 0 0 0 0 0  
4  
0  
output=Count of patrol routes with security effort > 0: 0  

case=4  
input=10  
5 10 15 20 25 30 35 40 45 50  
5  
100  
output=Count of patrol routes with security effort > 100: 5  

case=5  
input=7  
3 1 4 1 5 9 2  
3  
15  
output=Count of patrol routes with security effort > 15: 1  

case=6  
input=6  
-5 -10 -15 -20 -25 -30  
3  
-40  
output=Count of patrol routes with security effort > -40: 4  

case=7  
input=9  
7 -2 3 -4 5 -6 7 -8 9  
4  
5  
output=Count of patrol routes with security effort > 5: 4  

case=8  
input=4  
100 200 300 400  
2  
500  
output=Count of patrol routes with security effort > 500: 1  

case=9  
input=5  
1 1 1 1 1  
3  
3  
output=Count of patrol routes with security effort > 3: 2  

case=10  
input=6  
10 20 30 40 50 60  
4  
80  
output=Count of patrol routes with security effort > 80: 3  
*/
import java.util.*;
class GuardPatrol
{ 
public static int GuardPat(int[] checkpoints, int k, int x) { 
    int n = checkpoints.length; 
    int count = 0; 
    int sum = 0;

    // Calculate the sum of the first 'k' elements
    for (int i = 0; i < k; i++) {
        sum += checkpoints[i];
    }

    // Check if the first sum exceeds x
    if (sum > x) {
        count++;
    }

    // Use sliding window to calculate the sum of the next 'k' elements
    for (int i = k; i < n; i++) {
        sum += checkpoints[i] - checkpoints[i - k]; // Slide the window
        if (sum > x) {
            count++;
        }
    }
		// System.out.println("Count is "+count);
		return count; 
	} 
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] checkpoints = new int[n];//1 2 3 4 5 6	 
		for(int i=0;i<n;i++)
			checkpoints[i]=sc.nextInt();
		int k = sc.nextInt();
		int x=sc.nextInt();
		int res=GuardPat(checkpoints, k,x);
		System.out.println(res);
		sc.close();
	} 
}
