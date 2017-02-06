/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
/*

/*
Method
Approach #1 (Sorting) 
An anagram is produced by rearranging the letters of ss into tt. 
Therefore, if tt is an anagram of ss, sorting both strings will result in two identical strings. 
Furthermore, if ss and tt have different lengths, tt must not be an anagram of ss and we can return early.
/*

/*
Complexity analysis

Time complexity : O(n \log n)O(nlogn). 
Assume that n is the length of s, sorting costs O(nlogn) and comparing two strings costs O(n). 
Sorting time dominates and the overall time complexity is O(n \log n)O(nlogn).

Space complexity : O(1). Space depends on the sorting implementation which, usually, costs O(1) auxiliary space 
if heapsort is used. Note that in Java, toCharArray() makes a copy of the string so it costs O(n) extra space, 
but we ignore this for complexity analysis because:

It is a language dependent detail.
It depends on how the function is designed. For example, the function parameter types can be changed to char[].
/*

public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    char[] str1 = s.toCharArray();
    char[] str2 = t.toCharArray();
    Arrays.sort(str1);
    Arrays.sort(str2);
    return Arrays.equals(str1, str2);
}


/*
Method
Approach #2 (Hash Table)
To examine if tt is a rearrangement of s, we can count occurrences of each letter in the two strings and compare them. 
Since both ss and tt contain only letters from a-z, a simple counter table of size 26 is suffice.

Do we need two counter tables for comparison? 
Actually no, because we could increment the counter for each letter in ss and decrement the counter for each letter in t, 
then check if the counter reaches back to zero.
/*

/*
Complexity analysis

Time complexity : O(n). Time complexity is O(n) because accessing the counter table is a constant time operation.

Space complexity : O(1). Although we do use extra space, the space complexity is O(1) 
because the table's size stays constant no matter how large n is.

/*

public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
        counter[s.charAt(i) - 'a']++;
        counter[t.charAt(i) - 'a']--;
    }
    for (int count : counter) {
        if (count != 0) {
            return false;
        }
    }
    return true;
}

/*
Follow up

What if the inputs contain unicode characters? How would you adapt your solution to such case?

Answer

Use a hash table instead of a fixed size counter. 
Imagine allocating a large size array to fit the entire range of unicode characters, which could go up to more than 1 million. 
A hash table is a more generic solution and could adapt to any range of characters.
/*



