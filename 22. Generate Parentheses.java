/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
/*

/*
Method
http://stackoverflow.com/questions/23413881/understanding-function-to-generate-parentheses/23414519
通过向string插入"("和")"直到两者的数量都为n，则一个combination构建完成。如何保证这个combination是well-formed？在插入过程中的任何时候：

1. 只要"("的数量没有超过n，都可以插入"("。
2. 而可以插入")"的前提则是当前的"("数量必须要多余当前的")"数量。

backtrack(list: size = 0, str: "", open: 0, close: 0, max: 2

if(open < max) open: 0, max : 2
backtrack(list: size = 0, str: "(", open: 1, close: 0, max: 2
backtrack(list: size = 0, str: "((", open : 2, close: 0, max: 2  //因为已经到2了，所以open < max 这块 也已经做不下去了
backtrack(list:size = 0, str: "(()", open: 2, close: 1, max: 2
backtrack(list:size = 0, str:"(())", open: 2, close: 2, max: 2
到这里str.length() = 2 * 2了
直接return 到前面backtrack(list: size = 0, str: "(", open: 1, close: 0, max: 2 接下去做 但 list已经加1
backtrack(list:size = 1, str:"(）", open: 1, close: 1, max: 2
backtrack(list:size = 1, str:"()(", open: 2, close: 1, max: 2
backtrack(list:size = 1, str:"()()", open: 2, close: 2, max: 2
/*

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        backtrack(res, "", 0, 0, n);
        return res;
    }
    
    private void backtrack(List<String> res, String s, int open, int end, int max){
        if(s.length() == max*2){
            res.add(s);
            return;
        }
        
        if(open < max){
            backtrack(res, s + "(", open + 1, end, max);
        }
        
        if(end < open){
            backtrack(res, s + ")", open, end + 1, max);
        }
    }
}
