/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

字符串“PAYPALISHIRING”的Z字形（zigzag)
一行一行的读取：“PAHNAPLSIIGYIR”
编写代码读入字符串以及行数，将字符串转化为其Z字形式：

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3)应当返回“PAHNAPLSIIGYIR”。
/*

/*
Method
n=2时，字符串坐标变成zigzag的走法就是：（0，1）

 0 2 4 6

 1 3 5 7
 
 n=3时的走法是：（0，1，2，3）

 0   4   8
 1 3 5 7 9
 2   6   10 
 
 n=4时的走法是：（0，1，2，3，4，5）

 0    6     12
 1  5 7  11 13
 2 4  8 10  14
 3    9     15 
发现长度永远是2n - 2;第一行和最后一行都只需要加一个字符。斜着的那条线的位置永远是当前列j + (2n - 2) - 2i (i 是行的Index从0开始）
