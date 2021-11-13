package dividenconquer.longestnicesubstring;

import java.util.HashSet;

/*
A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.

Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.



Example 1:

Input: s = "YazaAay"
Output: "aAa"
Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
"aAa" is the longest nice substring.
Example 2:

Input: s = "Bb"
Output: "Bb"
Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.
Example 3:

Input: s = "c"
Output: ""
Explanation: There are no nice substrings.
Example 4:

Input: s = "dDzeE"
Output: "dD"
Explanation: Both "dD" and "eE" are the longest nice substrings.
As there are multiple longest nice substrings, return "dD" since it occurs earlier.


Constraints:

1 <= s.length <= 100
s consists of uppercase and lowercase English letters.
 */
class Solution {
    public String longestNiceSubstring(String s) {
        return nicest(s);
    }

    private String nicest(String s) {
        if(s.length() < 2) {
            return "";
        }

        var seen = new HashSet<Character>();
        for(char c : s.toCharArray()) {
            seen.add(c);
        }

        // We split string on non-nice characters
        // For each substring, we check if its nice or else we split again
        // At each split we check which is the longest.
        /// consider nicest(String s, int start, int end) instead of substring but whatever
        for(int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if(seen.contains(Character.toUpperCase(c)) && seen.contains(Character.toLowerCase(c)))              {
                continue;
            }
            var s1 = nicest(s.substring(0,i));
            var s2 = nicest(s.substring(i+1));
            return s1.length() >= s2.length() ? s1 : s2;
        }
        return s;
    }
}