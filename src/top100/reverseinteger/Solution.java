package top100.reverseinteger;

import java.math.BigInteger;

class Solution {
    public int reverse(int x) {
        if (x == 0) {
            return x;
        }
        var minVal = BigInteger.valueOf(Integer.MIN_VALUE);
        var maxInt = BigInteger.valueOf(Integer.MAX_VALUE);

        if (x > 0) {
            var reversedNumber = new StringBuilder(String.valueOf(x)).reverse().toString();
            var newNumber = new BigInteger(reversedNumber);

            var result = maxInt.compareTo(newNumber);
            return result == -1 ? 0 : Integer.parseInt(reversedNumber);
        } else {

            var stringNumber = String.valueOf(x);

            var justTheNumbers = stringNumber.substring(1, stringNumber.length());

            var reversedNumber = new StringBuilder(justTheNumbers).reverse().toString();

            var newNumber = new BigInteger("-" + reversedNumber);
            var result = minVal.compareTo(newNumber);
            return result == 1 ? 0 : Integer.parseInt("-" + reversedNumber);
        }
    }
}