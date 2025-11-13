/*Encode Number
Given a non-negative integer num, Return its encoding string.
The encoding is done by converting the integer to a string using a secret function that you 
should deduce from the following table:

N	f(n)
0	" "
1	"0"
2	"1"
3	"00"
4	"01"
5	"10"
6	"11"
7	"000"

Example 1:
Input: num = 23
Output: "1000"

Example 2:
Input: num = 107
Output: "101100"

If n is 0, then f(n) is "". If 1 <= n < 3, then f(n) is a binary string with length 1. If 3
<= n < 7, then f(n) is a binary string with length 2. If 7 <= n < 15, then `f(n) is a binary string with length 3.


case=1
input=
1
output=
0

case=2
input=
107
output=
101100

case=3
input=
24
output=
1001

case=4
input=
7
output=
000
case=5
input=
23
output=
1000


*/

import java.util.*; 
class Test 
{
    public static String encode(int num) 
    {
        StringBuilder encoded = new StringBuilder();
        
        // Process each bit of (num + 1) from right to left

        num += 1; // Work with num + 1

        while (num > 1) // Stop when num becomes 1 (leading '1' is ignored)

         {  
           encoded.append(num & 1); // Extract the last bit
            num >>= 1;  // Right shift to process next bit
        }
        
        return encoded.reverse().toString(); // Reverse to get correct order
    }

   public static void main(String[] args)
     {
	Scanner s=new Scanner(System.in); 
	System.out.println("Enter a number"); 
	int n=s.nextInt();
	System.out.println(encode(n));
    }
}

