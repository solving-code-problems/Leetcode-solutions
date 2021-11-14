package other.firstuniquecharacterinset;

import java.util.HashMap;

/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.



Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1


Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.
 */
class Solution {
    public int firstUniqChar(String s) {
        var count = new HashMap<Character, Integer>();


        for(var c : s.toCharArray()) {
            count.compute(c, (k,v) -> v == null ? 1 : v + 1);
        }

        for(int i = 0; i < s.length(); i++) {
            if(count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}