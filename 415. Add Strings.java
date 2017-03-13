Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

public class Solution {
    public String addStrings(String num1, String num2) {
        if(num1 == null || num1.length() == 0){
            return num1;
        }
        if(num2 == null || num2.length() == 0){
            return num2;
        }
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int sum = 0, carry = 0;
        while(i >= 0 || j >= 0){
            int m = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int n = j >= 0 ? num2.charAt(j--) - '0' : 0;
            sum = m + n + carry;
            sb.append(sum%10);
            carry = sum/10;
        }
        if(carry > 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
