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
    private static final String[] KEYS = {"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        
        if(digits.isEmpty()){
            return res;
        }
        
        combination(res, "", digits, 0);
        return res;
    }
        
        private void combination(List<String> res, String list, String digits, int offset){
            if(list.length() == digits.length()){
                res.add(list);
                return;
            }
            
            String letters = KEYS[digits.charAt(offset) - '0'];
            for(int i = 0; i < letters.length(); i++){
                combination(res, list + letters.charAt(i), digits, offset + 1);
            }
        }
}
