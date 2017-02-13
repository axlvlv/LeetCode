/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
/*

public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.add(s.charAt(i));
            }else if(s.charAt(i) == ')' && ! stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }else if(s.charAt(i) == ']' && ! stack.isEmpty() &&stack.peek() == '['){
                stack.pop();
            }else if(s.charAt(i) == '}' && ! stack.isEmpty() && stack.peek() == '{'){
                stack.pop();
            }else{
                return false;
            }
        }
        
        return stack.isEmpty();
        
    }
}
