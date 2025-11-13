/*338. Counting Bits | Java Solution

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
Example 1:
Input: n = 2
Output: [0,1,1] 
Explanation:
0 --> 0
1 --> 1
2 --> 10

Example 2:
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101


case=1
input=
2
output=                                                                             
[0, 1, 1] 

case=2
input=
5
output=                                                                             
[0, 1, 1, 2, 1, 2]

case=1
input=
15
output=                                                                             
[0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4]                                
                                                     
*/

import java.util.*;
 class CountingBits
{
public static int[] countBits(int n)
{
  int r[]= new int[n+1];
     r[0]=0;

    for(int i=1; i<=n; i++)
	{
		int  count=0; 
		int x=i; 
		while(x>0)
		{
			count += (x & 1); 
			x= x >> 1;
		}
		r[i]= count;
	}
  return r;
}
public static void main(String[] args)
{
	Scanner s=new Scanner(System.in); 
	int n=s.nextInt();
     int[] result = countBits(n);
       
          System.out.print(Arrays.toString(result));
}
}
/*
class Solution 
{
    public int[] countBits(int num) 
	{
        // Create an array to store the number of 1s for each number from 0 to num
        int[] mem = new int[num + 1];

        // Base case: 0 has 0 ones in its binary representation
        mem[0] = 0;

        // Iterate through each number from 1 to num
        for (int i = 1; i <= num; i++)
		 {
            // The count of 1s is found using the previously computed values
            // mem[i / 2] gives the number of 1s in the right-shifted version of i
            // i % 2 gives the least significant bit (0 or 1)

            mem[i] = mem[i / 2] + (i % 2);
        }

        return mem;
    }
}
 */