/*Palindrome Permutation

Given a string, determine if a permutation of the string could form a palindrome.

Example 1:
Input: "code"
Output: false

Example 2:
Input: "aab"
Output: true

Example 3:
Input: "carerac"
Output: true

case =1
input =carrace
output =true

case =2
input =code
output =false

case =3
input =geeksgeeks
output =true

case =4
input =leetcode
output =false

case =5
input =redismurderrum
output =false

case =6
input =redmurdersrum
output =true

case =7
input =caniseebeesinaevacave
output =true

case =8
input =evacaniseebeesincave
output =false

*/
import java.util.*;
class Test
{
    static boolean canPermutePalindrome(String s)
    {
        int bitmask = 0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i); 
            bitmask ^= (1 << (ch - 'a'));
        }
      return (bitmask == 0 || (bitmask & (bitmask-1)) == 0 );
    }
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        
        String ps=s.next();
        System.out.println(canPermutePalindrome(ps));
    }
}
