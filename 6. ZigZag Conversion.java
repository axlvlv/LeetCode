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
P(1)         | A(5)         | H(9)   | N(13)
A(2) P(4)    | L(6) S(8)    | I I    | G
Y(3)         | I(7)         | R      |

The size of every period is defined as "cycle"
cycle = (2*nRows - 2), except nRows == 1.

cycle = 2 * 3 - 2 = 4

In every period, every row has 2 elements, except the first row and the last row.

Suppose the current row is i, the index of the first element is j:

j = i + cycle*k, k = 0, 1, 2, ...

P = 1 + 4*0 = 1 A = 1 + 4*1 = 5 H = 1 + 4*2 = 9 N = 1 + 4*3 = 13 A = 2 + 4*0 = 2 Y = 3 + 4*0 = 3 L = 2 + 4*1 = 6

The index of the second element is secondJ:

secondJ = (j - i) + cycle - i

(j-i) is the start of current period. (j-i) + cycle is the start of next period.
j - i : 1-1 = 0; 5-1 = 4; 9 - 1= 8
j - i + cycyle: 

P = 2 - 2 + 4 - 2 = 2



