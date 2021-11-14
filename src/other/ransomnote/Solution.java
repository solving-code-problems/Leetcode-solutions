package other.ransomnote;

import java.util.HashMap;

/*
Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true


Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        var magazineCharacterCount = new HashMap<Character, Integer>();
        for(var c : magazine.toCharArray()) {
            magazineCharacterCount.compute(c, (k,v) -> v == null ?  1 : v + 1);
        }


        for(var c : ransomNote.toCharArray()) {
            if(!magazineCharacterCount.containsKey(c)) {
                return false;
            } else {
                var count = magazineCharacterCount.get(c);
                if(count == 0) {
                    return false;
                }
                magazineCharacterCount.put(c, count - 1);
            }
        }
        return true;
    }
}