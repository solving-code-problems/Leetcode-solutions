package other.validanagram;

import java.util.HashMap;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.



Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false


Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        var characterCount = new HashMap<Character, Integer>();

        for(char c : s.toCharArray()) {
            characterCount.compute(c, (k,v) -> v == null ? 1 : v + 1);
        }

        for(char c : t.toCharArray()) {
            if(!characterCount.containsKey(c)) {
                return false;
            } else {
                var times = characterCount.get(c);
                if(times == 0)
                    return false;
                characterCount.put(c, times - 1);
            }
        }
        return true;
    }
}
