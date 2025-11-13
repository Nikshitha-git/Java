/*
You are an explorer on the Mystic Isles, where you have discovered an ancient map leading to a hidden treasure. The map contains N marked locations, each with a certain amount of treasure. However, due to mystical energy fluctuations, you can only collect treasure from a sequence of exactly L consecutive locations at a time.

To claim a valid treasure haul, you must ensure that the treasures collected in that sequence are all distinct - if any treasure amount is repeated in the chosen sequence, the mystical forces nullify the collection.

Your goal is to determine the maximum possible sum of treasure that can be collected in a single valid haul. If no valid sequence of locations exists, return 0.

Input Format:
Line 1: Two space-separated integers, N (total number of treasure locations) and L (length of the sequence you must pick).

Line 2: N space-separated integers representing the treasure values at each location.

Output Format:
Print an integer representing the maximum valid treasure haul.


Sample Input-1:
---------------
7				//N (total number of treasure locations)
3				//L (length of the sequence you must pick)
7 7 7 1 5 4 2	//N space-separated integers representing the treasure values															at each location
Sample Output-1:
----------------
13

Explanation:
The possible sequences of length 3 from the treasure locations are:

[7,7,7]  Invalid (7 is repeated).
[7,7,1]  Invalid (7 is repeated).
[7,1,5]  Valid (All distinct, sum = 13).
[1,5,4]  Valid (All distinct, sum = 10).
[5,4,2]  Valid (All distinct, sum = 11).
The maximum valid treasure haul is 13.


Sample Input-2:
---------------
3 3
7 7 7

Sample Output-2:
----------------
0

*/

/*
=== testcases ===
case =1
input =7 3
1 5 4 2 9 9 9
output =15

case=2
input=3 3
4 4 4
output=0

case=3

input=7 3
1 2 3 4 5 6 7
output=18

case=4
input=30 5
18 3 16 9 18 17 8 8 9 13 9 7 5 7 9 9 8 10 19 15 7 5 20 11 5 4 15 11 3 12
output=68

case=5
input=50 8
37 35 22 4 46 22 2 48 44 18 31 31 42 36 21 14 9 28 43 29 34 43 9 9 31 48 23 10 29 39 41 12 25 17 40 28 10 39 19 26 3 34 42 23 22 33 33 31 7 27
output=233

case=6
input=15 5
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
output=65

case=7
input=14 4
11 22 33 44 55 66 77 88 99 100 111 123 145 156
output=535

case=8
input=100 9
174 193 71 71 60 182 77 41 110 7 110 98 172 123 40 196 33 69 19 36 36 30 180 49 106 7 48 89 155 130 102 148 19 195 154 21 80 115 112 168 124 43 178 42 53 142 151 108 155 140 20 122 105 138 58 26 107 39 152 34 60 36 191 70 47 123 140 200 159 22 59 78 62 4 44 131 13 29 35 38 80 175 89 130 31 174 187 4 117 49 108 160 29 109 173 87 174 91 156 25
output=1087

*/
import java.util.HashMap;
// import java.util.Map;
import java.util.Scanner;
class treasurehunt
{
    
    public static void findDistinctNumbersCount(int[] A, int k)
    {
        int sum=0;
        int max=0;
        HashMap<Integer, Integer> freq = new HashMap<>();
 
        // int distinct = 0;
 
        // loop through the array
        for (int i = 0; i < A.length; i++)
        {
            // ignore the first `k` elements
            if (i >= k)
            {
                // remove the first element from the subarray by reducing its
                // frequency in the map
                freq.put(A[i-k], freq.getOrDefault(A[i-k], 0) - 1);
                // sum=sum+A[i];
                // System.out.println(sum);
                if (freq.get(A[i - k]) == 0) {
                    // distinct--;
                }
            }
 
            freq.put(A[i], freq.getOrDefault(A[i], 0) + 1);
            
 
            if (freq.get(A[i]) == 1) {
                sum=sum+A[i];
                max=Math.max(max, sum);
            }
            System.out.println(max);
            // if (i >= k - 1)
            // {
            //     System.out.println(max);
            // }
        }
    }
 
    public static void main(String[] args)
    {
		Scanner sc=new Scanner(System.in);	
        int n=sc.nextInt();
        int array[]=new int[n];
		int k=sc.nextInt();

		for(int i=0;i<n;i++)
			array[i]=sc.nextInt();		
     
        findDistinctNumbersCount(array, k);
        sc.close();
    }
}