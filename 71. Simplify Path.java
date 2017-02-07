/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
/*

/*
Method
Deque of strings (directories).
iterate path:
if "/", continue,
if ".", conitnue,
if "..", poll last,
else, add a new directory
in the end, build result from deque.
a,b in and b,a out
/*

/*
Time Complexity
时间上不会超过两次扫描（一次是进栈得到简化路径，一次是出栈获得最后结果），所以时间复杂度是O(n)，空间上是栈的大小，也是O(n)。
/*

/*
Basic Java
Interface Deque<E>
A linear collection that supports element insertion and removal at both ends. 

for(String split:splits) 前面的String split就和 int i = 0 一样

string.equals("");

deque.pollast()
deque.addLast();
deque.pollFirst()

sb.append("/").append(s);

sb.toString();

/*

public class Solution {
    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<String>();
        String[] splits = path.split("/");
        for(String split : splits){
            if(split.equals("")){
                continue;
            }
            if(split.equals(".")){
                continue;
            }
            if(split.equals("..")){
                deque.pollLast();
            }else{
                deque.addLast(split);
            }
        }
        
        StringBuilder sb = new StringBuilder();   //新建一个string,因为不知道长度，所以用stringbuilder
        while(!deque.isEmpty()){
            String s = deque.pollFirst();         //string要一个个再存进去
            sb.append("/").append(s);
        }
        
        if(sb.length() == 0){
            return "/";
        }
        
        return sb.toString();     //最后stringbuilder要变回string 固定了长度
        
    }
}
