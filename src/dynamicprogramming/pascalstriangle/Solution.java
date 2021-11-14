package dynamicprogramming.pascalstriangle;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1


Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]

 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int i = 1; i <= numRows; i++) {

            var row = new ArrayList<Integer>();
            for(int j = 0; j < i; j++) {

                // last row value
                if(j == i - 1) {
                    row.add(1);
                    continue;
                }
                if(j == 0) {
                    row.add(1);
                    continue;
                }

                if(i-1 > 0) {
                    var previous = result.get(i-2);
                    row.add( previous.get(j) + previous.get(j-1));
                }
            }
            result.add(row);
        }
        return result;
    }
}