package longestpalindromicsubstring;

class Solution {
    public String longestPalindrome(String s) {
        var longestPalindrom = "";
        var lengthOfLongest = 0;

        var palindromes = new String[3];
        for (int i = 0; i < s.length(); i++) {
            var character = s.substring(i, i + 1);
            palindromes[0] = expandPalindrome(i - 1, i, s, character);
            palindromes[1] = expandPalindrome(i, i + 1, s, character);
            palindromes[2] = expandPalindrome(i - 1, i + 1, s, character);
            for (String p : palindromes) {
                if (p.length() > lengthOfLongest) {
                    longestPalindrom = p;
                    lengthOfLongest = p.length();
                }
            }
        }
        return longestPalindrom;
    }


    public String expandPalindrome(int left, int right, String text, String longestSoFar) {
        if (inBoundsOfString(left, right, text) && text.charAt(left) == text.charAt(right)) {
            return expandPalindrome(left - 1, right + 1, text, text.substring(left, right + 1));
        } else {
            return longestSoFar;
        }
    }

    public boolean inBoundsOfString(int left, int right, String text) {
        return left >= 0 && left < text.length() && right >= 0 && right < text.length();
    }

}