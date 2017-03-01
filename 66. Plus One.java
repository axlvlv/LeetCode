/*
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
*/

it's because the last part of code is only for the case that the whole input array is 9s 
and the output is first digit as 1 and rest of them equal to 0. When you initialize newNumber, 
array is initialized with all values 0, so only need to mark the first array index with value 1.

public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }
}
