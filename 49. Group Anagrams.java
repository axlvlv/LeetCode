/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
/*

/*
Method
我们将每个词排序后，根据这个键值，找到哈希表中相应的列表，并添加进去。
/*

/*
时间复杂度
假设我们有n个字符串，字符串最大长度是k，那么该算法的时间复杂度是O(nklogk)，
其中O(klogk)是对每一个字符串排序（如果用线性算法也可以提高）。空间复杂度则是O(nk)，即hashmap的大小。
/*

/*
Basic Java

数组.length
String[]

string.toCharArray() Converts this string to a new character array.

string.valueOf() if the argument is null, then a string equal to "null"; otherwise, the value of obj.toString() is returned.

hashmap.get(key)
Parameters:
key - the key whose associated value is to be returned
Returns:
the value to which the specified key is mapped, or null if this map contains no mapping for the key

map.get(keyStr).add(s);

map.values()
Returns:
a view of the values contained in this map
这里一定要用string.valueOf()因为它会返回一个string， 如果用了toString()返回的则是一个新的Object会报错
/*

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0 || strs == null){
            return new ArrayList<List<String>>();
        }
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String s: strs){
            char[] c = s.toCharArray();               //先把str变成char了才能排序
            Arrays.sort(c);                           //排序
            String keystr = String.valueOf(c);        //让char变回str
            if(!map.containsKey(keystr)){
                map.put(keystr, new ArrayList<String>());
            }
            map.get(keystr).add(s);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
}

