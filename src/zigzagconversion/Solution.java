package zigzagconversion;

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
            rows.add(new ArrayList<Character>());
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
        String joinedString = rows.stream().map(row -> {
                    StringBuilder sb = new StringBuilder();
                    row.forEach(c -> sb.append(c));
                    return sb.toString();
                })
                .collect(Collectors.joining());

        return joinedString;
    }
}