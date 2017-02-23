/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
/*

/*
Basic Java
string.charAt() - '0' : string to int
string.charAt();
/*

public class Solution {
    public static String[] keys = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return res;
        }
        StringBuilder sb = new StringBuilder();
        combination(res, sb, digits, 0);
        return res;
    }
    
    private void combination(List<String> res, StringBuilder sb, String digits, int index){
        if(index == digits.length()){
            res.add(sb.toString());
            return;
        }
        
        String letters = keys[digits.charAt(index) - '0'];
        for(int i = 0; i < letters.length();i++){
            sb.append(letters.charAt(i));
            combination(res, sb, digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
}
