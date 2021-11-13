package other.zigzagconversion;
/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);


Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"


Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        var rows = new ArrayList<List<Character>>();
        var r = numRows;
        while (r-- > 0) {
            rows.add(new ArrayList<>());
        }

        int indexToPlace = 0;
        boolean increment = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            rows.get(indexToPlace).add(c);

            if (indexToPlace == rows.size() - 1) {
                increment = false;
            } else if (indexToPlace == 0) {
                increment = true;
            }
            indexToPlace = increment ? indexToPlace + 1 : indexToPlace - 1;
        }
        return rows.stream().map(row -> {
                    StringBuilder sb = new StringBuilder();
                    row.forEach(sb::append);
                    return sb.toString();
                })
                .collect(Collectors.joining());
    }
}