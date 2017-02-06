/*
Base case: n = 0 print "1"
for n = 1, look at previous string and write number of times a digit is seen and the digit itself. In this case,

digit 1 is seen 1 time in a row... so print "1 1"

for n = 2, digit 1 is seen two times in a row, so print "2 1"

for n = 3, digit 2 is seen 1 time and then digit 1 is seen 1 so print "1 2 1 1"

for n = 4 you will print "1 1 1 2 2 1"

Consider the numbers as integers for simplicity. 
e.g. if previous string is "10 1" then the next will be "1 10 1 1" and the next one will be "1 1 1 10 2 1"

規則則是對於連續字符串，表示為重複次數+數本身

1.     1
2.     11
3.     21
4.     1211
5.     111221 
6.     312211
7.     13112221
8.     1113213211
9.     31131211131221
 10.   13211311123113112211
/*

/*
Basic Java
Stringbuilder.append: Appends the specified string to this character sequence.
Stringbuilder.toString(): This method returns a string representation of this sequence of characters.
/*

/*
时间 O(N!) 空间 O(N) 字符长度
/*

/*
Follow up
Q：该序列有什么特点？A：该序列最大的数不超过3，除非初始的数字大于3

Q: 对于101这种数字如何解读？A：因为10后面只有1个（奇数）数字，所以不可能是1个0，肯定是10个1.

Q: 如果有三位数，比如200个1，表示成2001时怎么办？A: 其实我们可以发现，除了第一次生成的数以外，以后再也不可能有200个连续的同一个数，所以这种情况只可能发生在第一次count and say，特殊处理一下就好了。另外，比如初始数字9991999，第一次变成了391139，我们可以发现大于3的数都只会一个一个出现了。
/*

public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++){
            s = countidx(s);
        }
        return s;
    }
    
    private String countidx(String s){
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == c){
                count++;
            }else{
                sb.append(count);
                sb.append(c);
                c= s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }
}
