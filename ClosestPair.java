/*
	Given two sorted arrays and a number x, find the pair whose sum is closest to x and the pair has an element from each array. 
	We are given two arrays ar1[0…m-1] and ar2[0..n-1] and a number x, we need to find the pair ar1[i] + ar2[j] such that absolute value of (ar1[i] + ar2[j] – x) is minimum.

Example-1: 
Input:  ar1[] = {1, 4, 5, 7};
            ar2[] = {10, 20, 30, 40};
		  x = 32      
Output:  1 and 30
Example-2: 
Input:  ar1[] = {1, 4, 5, 7};
                   ar2[] = {10, 20, 30, 40};
	          x = 50      
Output:  7 and 40

Solution:
A Simple Solution is to run two loops. The outer loop considers every element of first array and inner loop checks for the pair in second array. We keep track of minimum difference between ar1[i] + ar2[j] and x.

We can do it in O(n) time using following steps. 

1. Merge given two arrays into an auxiliary array of size m+n using merge process of merge sort. While merging keep another boolean array of size m+n to indicate whether the current element in merged array is from ar1[] or ar2[].

2. Consider the merged array and use the linear time algorithm to find the pair with sum closest to x. One extra thing we need to consider only those pairs which have one element from ar1[] and other from ar2[], we use the boolean array for this purpose.

APPROACH:
---------
The idea is to start from left side of one array and right side of another array, and use the algorithm same as step 2 of above approach. Following is detailed algorithm. 
1) Initialize a variable diff as infinite (Diff is used to store the difference between pair and x).  We need to find the minimum diff.
2) Initialize two index variables l and r in the given sorted array.
       (a) Initialize first to the leftmost index in ar1:  l = 0
       (b) Initialize second  the rightmost index in ar2:  r = n-1
3) Loop while  l< length.ar1 and r>=0
       (a) If  abs(ar1[l] + ar2[r] - sum) < diff  then 
           update diff and result 
       (b) If (ar1[l] + ar2[r] <  sum )  then l++
       (c) Else r--    
4) Print the result. 


case=1
input=
4
1 4 5 7
4
10 20 30 40
38
output=
[1,37]

case=2
input=
4
1 4 5 7
4
10 20 30 40
32
output=
[1,30]

case=3
4
1 4 5 7
4
10 20 30 40
50
output=
[7,40]
*/


import java.util.*;

class ClosestPair
{
	// ar1[0..m-1] and ar2[0..n-1] are two given sorted
	// arrays/ and x is given number. This function prints
	// the pair from both arrays such that the sum of the
	// pair is closest to x.

	void printClosest(int ar1[], int ar2[], int m, int n, int x)
	{
		
		int diff = Integer.MAX_VALUE;

		// res_l and res_r are result indexes from ar1[] and ar2[] respectively
		int res_l = 0, res_r = 0;

		// Start from left side of ar1[] and right side of ar2[]
		int l = 0, r = n-1;
		while (l<m && r>=0)
		{
		// If this pair is closer to x than the previously found closest, then update res_l, res_r and diff
		
		if (Math.abs(ar1[l] + ar2[r] - x) < diff)
		{
			res_l = l;
			res_r = r;
			diff = Math.abs(ar1[l] + ar2[r] - x);
		}

		// If sum of this pair is more than x, move to smaller side

		if (ar1[l] + ar2[r] > x)
			r--;
		else // move to the greater side
			l++;
		}

		// Print the result
		System.out.print("[" + ar1[res_l] +"," + ar2[res_r] + "]");
	}

	public static void main(String args[])
	{
		ClosestPair ob = new ClosestPair();
		Scanner sc=new Scanner(System.in);
            int n1=sc.nextInt();
         int arr1[]=new int[n1];
      
          for(int i=0;i<n1;i++)
          {
           arr1[i]=sc.nextInt();
          }
		 		  
        int n2=sc.nextInt();
         int arr2[]=new int[n2];
          for(int i=0;i<n2;i++)
          {
           arr2[i]=sc.nextInt();
          }
                      int x=sc.nextInt();
		
		ob.printClosest(arr1, arr2, n1, n2, x);
	}
}
/*
enter size of array_1
4
enter the values of array_1
1 4 5 7
enter size of array_2
4
enter the values of array_2
10 20 30 40
enter closest number
32
The closest pair is [1, 30]

*/