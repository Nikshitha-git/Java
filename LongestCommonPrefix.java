public class LongestCommonPrefix {

    // Function to check if all strings have the same prefix of a given length
    private static boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) {
                return false; // If any string doesn't start with the prefix
            }
        }
        return true; // All strings have the same prefix
    }

    // Function to find the longest common prefix using binary search
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return ""; // Return empty string if input is null or empty
        }

        int minLength = Integer.MAX_VALUE;
        // Find the length of the shortest string
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        int low = 0;
        int high = minLength;
        String longestPrefix = "";

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isCommonPrefix(strs, mid)) {
                longestPrefix = strs[0].substring(0, mid); // Update longest prefix
                low = mid + 1; // Try for a longer prefix
            } else {
                high = mid - 1; // Try for a shorter prefix
            }
        }

        return longestPrefix; // Return the longest common prefix found
    }

    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs1)); // Output: "fl"

        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs2)); // Output: ""

        String[] strs3 = {"abc", "abcd", "abef"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs3)); // Output: "ab"

        String[] strs4 = {"a", "a", "a"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs4)); // Output: "a"

        String[] strs5 = {};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs5)); // Output: ""
    }
}
