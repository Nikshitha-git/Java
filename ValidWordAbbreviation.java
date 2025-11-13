/*Valid Word Abbreviation:

A string can be abbreviated by replacing any number of non-adjacent, non-empty substrings with their lengths. 
The lengths should not have leading zeros.

For example, a string such as "substitution" could be abbreviated as (but not limited to):
"s10n" ("s ubstitutio n")
"sub4u4" ("sub stit u tion")
"12" ("substitution")
"su3i1u2on" ("su bst i t u ti on")
"substitution" (no substrings replaced)

The following are not valid abbreviations:

"s55n" ("s ubsti tutio n", the replaced substrings are adjacent)
"s010n" (has leading zeros)
"s0ubstitution" (replaces an empty substring)

Given a string word and an abbreviation abbr, return whether the string matches the given abbreviation.

A substring is a contiguous non-empty sequence of characters within a string.

 
Example 1:
Given s = "internationalization", abbr = "i12iz4n":
Return true.

Example 2:
Given s = "apple", abbr = "a2e":
Return false.

Time Complexity: O(n) where n=max(len(word),len(abbr))
Auxiliary Space:  O(1).


case =1
input =
internationalization 
i12iz4n
output =
true

case =2
input =
apple 
a2e
output =
false

case =3
input =
testcase 
t2t2se
output =
true

case =4
input =
testcase 
t2t3se
output =
false

case =5
input =
internationalization 
i12iz5n
output =
false

case =6
input =
apple 
a1p1e
output =
true

case =7
input =
problemisvalidwordabbreviation 
p2b10w11t2n
output =
true

case =8
input =problemisvalidwordabbreviation p2b10w10t2n
output =false

*/
import java.util.*;

public class ValidWordAbbreviation 
{
    public static boolean isValidWordAbbreviation(String word, String abbr) 
    {
        int i = 0, j = 0;
        int m = word.length(), n = abbr.length();
        
        while (i < m && j < n)
         {
            if (Character.isDigit(abbr.charAt(j)))
              {
                if (abbr.charAt(j) == '0') 
                return false; // no leading zeros
                
                int num = 0;
                while (j < n && Character.isDigit(abbr.charAt(j))) 
                {
                    /*
                     *abbr = "i12iz4n"
                    At j = 1, we find digit '1'.
                    num = 0 * 10 + (1 - 0) = 1.
                    At j = 2, we find digit '2'.
                    num = 1 * 10 + (2 - 0) = 12.
                    Now, num holds the value 12, meaning we skip 12 characters in the word!
                     */

                    num = num * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += num;
            } 
            else {
                if (word.charAt(i) != abbr.charAt(j)) 
                return false;
                
                i++;
                j++;
            }
        }
        
        return i == m && j == n;
    }
   	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String word=sc.next();
		String abbrivation=sc.next();
		System.out.println(new ValidWordAbbreviation().isValidWordAbbreviation(word,abbrivation));
	}
}