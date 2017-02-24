/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
/*

/*
Method
模拟题，循环过程中用set记录每次得到的平方和

当出现非1的重复平方和时，返回False

否则，返回True
/*

/*
public class Solution {
    public boolean isHappy(int n) {
        if(n <= 0){
            return false;
        }
        
        Set<Integer> set = new HashSet<>();
        while(set.add(n)){
            int squaresum = 0;
            while(n > 0){
                int remain = n%10;
                squaresum += remain*remain;
                n /= 10;
            }
            if(squaresum == 1){
                return true;
            }else{
                n = squaresum;
                }
        }
        return false;
    }   
}
