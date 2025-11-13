public class abbreviation {
    public static boolean isValidAbbreviation(String word, String abbr) {
        int wordLength = word.length();
        int i = 0, j = 0;

        while (i < wordLength && j <=abbr.length()) {
            if (abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                int count = 0;
                while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                    count = count * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += count;
            } else {
                if (word.charAt(i) != abbr.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            }
        }

        return i == wordLength && j == abbr.length();
    }

    public static void main(String[] args) {
        String word = "apple";
        String abbreviation = "a2e ";

        if (isValidAbbreviation(word, abbreviation)) {
            System.out.println("The abbreviation is correct.");
        } else {
            System.out.println("The abbreviation is incorrect.");
        }
    }
}
