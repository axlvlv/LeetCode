/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
  */
  
  public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return -1;`
        }
        int a, b;
        Stack<Integer> stack = new Stack<Integer>();
        for(String s : tokens){
            if(s.equals("+")){
                stack.add(stack.pop() + stack.pop());
            }else if(s.equals("/")){
                a = stack.pop();
                b = stack.pop();
                stack.add(a/b);
            }else if(s.equals("*")){
                stack.add(stack.pop() * stack.pop());
            }else if(s.equals("-")){
                a = stack.pop();
                b = stack.pop();
                stack.add(b - a);
            }else{
                stack.add(Integer.parseInt(s));
            }
        }
        
        return stack.pop();
        
    }
}
