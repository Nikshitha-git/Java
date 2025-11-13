/*A scientist is studying a long DNA strand and wants to identify unique genetic markers. A marker is a "valid sequence" if it consists of exactly K bases and all K are distinct. Given a DNA strand, count how many such valid sequences appear. Every occurrence, even if repeated at different positions, must be counted.

Example 1:
input: s = "xyzzaz", k=3
output: 1

Example 2:
Input: s = "aababcabc" k=4
Output: 0
*/

import java.util.HashMap;
import java.util.Scanner;

public class dnahashmap {
    public static int unique(String seq, int k) {
        int n = seq.length();
        int count = 0;
        HashMap<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // Add the current character to the map
            charCount.put(seq.charAt(i), charCount.getOrDefault(seq.charAt(i), 0) + 1);

            // Remove the character that is out of the current window
            if (i >= k) {
                charCount.put(seq.charAt(i - k), charCount.get(seq.charAt(i - k)) - 1);
                if (charCount.get(seq.charAt(i - k)) == 0) {
                    charCount.remove(seq.charAt(i - k));
                }
            }

            // Check if the current window has all unique characters
            if (i >= k - 1 && charCount.size() == k) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        int result = unique(s, k);
        System.out.println("Count of unique sequences: " + result);
        sc.close();
    }
}
