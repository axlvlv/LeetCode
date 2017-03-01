/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minstack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        minstack = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(minstack.isEmpty()){
            minstack.push(x);
        }else{
            if(x <= minstack.peek()){
                minstack.push(x);
            }
        }
    }
    
    public void pop() {
        int x = stack.pop();
        if(minstack.size() != 0){
            if(x == minstack.peek()){
                minstack.pop();
            }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        if(minstack.isEmpty()){
            return 0;
        }
        return minstack.peek();
        
    }
}
