/*
Write a function to find the longest common prefix string amongst an array of strings.
/*

/*
Method
一個陣列中有許多個字串，寫一個function找出這些字串最長的共同字首。
["abd", "abdggg", "acfn"]



public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        
        if(strs != null && strs.length > 0){
            Arrays.sort(strs);
            
            char[] a = strs[0].toCharArray();
            char[] b = strs[strs.length - 1].toCharArray();
            
            for(int i = 0; i < a.length; i++){
                if(b.length > i && b[i] == a[i]){
                    res.append(b[i]);
                }else{
                    return res.toString();
                }
            }
        }
        return res.toString();
    }
}
