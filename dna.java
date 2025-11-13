/*A scientist is studying a long DNA strand and wants to identify unique genetic markers. A marker is a "valid sequence" if it consists of exactly K bases and all K are distinct. Given a DNA strand, count how many such valid sequences appear. Every occurrence, even if repeated at different positions, must be counted.

Example 1:
input: s = "xyzzaz", k=3
output: 1

Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
The only good substring of length 3 is "xyz".


Example 2:
Input: s = "aababcabc" k=4
Output: 0
Explanation: There are no substrings of size 4: "aaba", "abab", "babc", "abca", "bcab", and "cabc".


*/

/*
Test cases
==========
case = 1
input= abcdefg 
3
output= 5

case = 2
input= aabbccddeeffgghhii
4
output= 0

case = 3
input= wertderfdtresgs
5
ouput= 6

case = 4 
input= terryterry
4
output= 2

case = 5
input= google
3
output= 2

case = 6
input= malayalam
4
ouput= 0
*/
import java.util.*;
public class dna {
    public static int unique(String seq,int k){

        int n = seq.length();
        int count = 0;
        for (int i = 0; i <= n - k; i++) {
            HashSet<Character> res = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                res.add(seq.charAt(j));
            }
            if (res.size() == k) {
                count++;
            }
        }
        return count;

    }
    public static void main(String[] args) 
	{
        Scanner sc=new Scanner(System.in);
        String s;
        s=sc.next();		
        int k=sc.nextInt();
        int result = unique(s, k);
        System.out.println("Count of unique sequences: " + result);

        sc.close();
    }

    
}
