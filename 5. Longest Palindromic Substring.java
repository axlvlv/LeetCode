/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
/*

/*
Method 1: Manacher Algorithm 
将所有可能的奇数/偶数长度的回文子串都转换成了奇数长度，在每个字符的两边都插入一个特殊的符号。
比如 abba 变成 #a#b#b#a#， aba变成 #a#b#a#。为了进一步减少编码的复杂度，可以在字符串的开始加入另一个特殊字符，这样就不用特殊处理越界问题
比如$#a#b#a#

下面以字符串12212321为例，经过上一步，变成了 S[] = "$#1#2#2#1#2#3#2#1#";

因为我们这里插入了 # 符号，对于一个长度为偶数的回文串，他应该是以#做为中心的，然后向两边扩，对于长度是奇数的回文串，它应该是以一个普通字符作为中心的。
通过使用#，我们将无论是奇数还是偶数的回文串，都变成了一个以Ti为中心，d为半径两个方向扩展的问题。并且d就是回文串的长度。

例如 #a#b#a#, P = 0103010, 对于b而言P的值是3，是最左边的#，也是延伸的最左边。这个值和当前的回文串是一致的。


