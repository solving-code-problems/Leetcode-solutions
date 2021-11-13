package other.arrayformationthroughconcatination;

import java.util.ArrayList;
import java.util.List;

/*
You are given an array of distinct integers arr and an array of integer arrays pieces, where the integers in pieces are distinct. Your goal is to form arr by concatenating the arrays in pieces in any order. However, you are not allowed to reorder the integers in each array pieces[i].

Return true if it is possible to form the array arr from pieces. Otherwise, return false.



Example 1:

Input: arr = [85], pieces = [[85]]
Output: true
Example 2:

Input: arr = [15,88], pieces = [[88],[15]]
Output: true
Explanation: Concatenate [15] then [88]
Example 3:

Input: arr = [49,18,16], pieces = [[16,18,49]]
Output: false
Explanation: Even though the numbers match, we cannot reorder pieces[0].
Example 4:

Input: arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
Output: true
Explanation: Concatenate [91] then [4,64] then [78]
Example 5:

Input: arr = [1,3,5,7], pieces = [[2,4,6,8]]
Output: false


Constraints:

1 <= pieces.length <= arr.length <= 100
sum(pieces[i].length) == arr.length
1 <= pieces[i].length <= arr.length
1 <= arr[i], pieces[i][j] <= 100
The integers in arr are distinct.
The integers in pieces are distinct (i.e., If we flatten pieces in a 1D array, all the integers in this array are distinct).
 */
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        return canForm(arr, 0, pieces);
    }


    private boolean canForm(int[] arr, int currentPosition, int[][] pieces) {
        if(currentPosition >= arr.length) {
            return true;
        }
        var value = arr[currentPosition];
        List<int[]> appliablePieces = new ArrayList<>();
        for(var piece : pieces) {
            if(canBeApplied(currentPosition, arr, piece)) {
                appliablePieces.add(piece);
            }
        }
        return appliablePieces
                .stream()
                .map(piece -> canForm(arr, currentPosition + piece.length, pieces))
                .filter(result -> result)
                .findAny()
                .orElse(false);
    }
    // 1
    // [1,2,3]
    // [[1],[2],[4]]
    private boolean canBeApplied(int currentPos, int[] arr, int[] piece) {
        if(piece.length > (arr.length - currentPos)) {
            return false;
        }
        int j = 0;
        for(int i = currentPos; j < piece.length; i++, j++) {
            if(piece[j] != arr[i]) {
                return false;
            }
        }
        return true;
    }

}