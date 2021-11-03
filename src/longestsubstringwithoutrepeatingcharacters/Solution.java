package longestsubstringwithoutrepeatingcharacters;

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        var seen = new HashMap<Character, Integer>();
        var startOfSequence = 0;
        var max = 0;
        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (seen.containsKey(c)) {
                startOfSequence = Math.max(startOfSequence, seen.get(c) + 1);
            }
            max = Math.max(max, i - startOfSequence + 1);
            seen.put(c, i);
        }
        return max;
    }
}