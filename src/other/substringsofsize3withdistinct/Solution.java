package other.substringsofsize3withdistinct;
/*
A string is good if there are no repeated characters.

Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.

Note that if there are multiple occurrences of the same substring, every occurrence should be counted.

A substring is a contiguous sequence of characters in a string.



Example 1:

Input: s = "xyzzaz"
Output: 1
Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
The only good substring of length 3 is "xyz".
Example 2:

Input: s = "aababcabc"
Output: 4
Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
The good substrings are "abc", "bca", "cab", and "abc".


Constraints:

1 <= s.length <= 100
s​​​​​​ consists of lowercase English letters.
 */
class Solution {
    public int countGoodSubstrings(String s) {
        if(s.length() < 3) {
            return 0;
        }

        var left = 0;
        var right = 2;
        var charFrequency = new int[26];
        var resultCounter = 0;

        while(right < s.length()) {

            for(int i = left; i <= right; i++) {
                charFrequency[s.charAt(i) - 'a']++;
            }


            var isValid = true;
            for(int i = left; i <= right; i++) {
                if(charFrequency[s.charAt(i) - 'a'] != 1) {
                    isValid = false;
                    break;
                }
            }
            if(isValid)
                resultCounter++;

            for(int i = left; i <= right; i++) {
                charFrequency[s.charAt(i) - 'a'] = 0;
            }
            right++;
            left++;
        }
        return resultCounter;
    }
}
